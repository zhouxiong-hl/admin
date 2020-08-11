package com.fangchuang.haolinbao.service.impl;

import com.fangchuang.haolinbao.Util.MD5Util;
import com.fangchuang.haolinbao.entity.CabinetEntity;
import com.fangchuang.haolinbao.entity.ExpressEntity;
import com.fangchuang.haolinbao.mapper.CabinetMapper;
import com.fangchuang.haolinbao.mapper.ExpressMapper;
import com.fangchuang.haolinbao.model.Courier.SMS.req.CourierSMSReqDTO;
import com.fangchuang.haolinbao.model.Courier.SMS.res.CourierSMSResDTO;
import com.fangchuang.haolinbao.model.Express.Insert.req.InsertExpressReqDTO;
import com.fangchuang.haolinbao.model.Express.Insert.res.InsertExpressResDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.req.UserQuJianReqDTO;
import com.fangchuang.haolinbao.model.Express.UserQuJian.res.UserQuJianResDTO;
import com.fangchuang.haolinbao.model.SMS.req.SMSReqDTO;
import com.fangchuang.haolinbao.model.SMS.res.SMSResDTO;
import com.fangchuang.haolinbao.model.common.res.CommonResHeaderDTO;
import com.fangchuang.haolinbao.service.ExpressService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private ExpressMapper experssMapper;
    @Resource
    private CabinetMapper cabinetMapper;
    /*
    20200806 zhao
    扫描快递编号
 */
    @Override
    public InsertExpressResDTO saomiaoExperssService(InsertExpressReqDTO insertExpressReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","派件错误");
        InsertExpressResDTO insertExpressResDTO = new InsertExpressResDTO();
        try{
            Map<String, Object> saomiaoMap = new HashMap<String, Object>();
            saomiaoMap.put("cabinetDrawersize",insertExpressReqDTO.getBody().getCabinetDrawersize());
            saomiaoMap.put("cabinetIdnumber",insertExpressReqDTO.getBody().getExpressCabinetnumber());
            CabinetEntity cabinetEntity = cabinetMapper.selectCabinetByType(saomiaoMap);
            if(cabinetEntity==null||cabinetEntity.equals(null)){
                header.setMessage("柜子已满");
                header.setCode("400");
            }else{
                String s = (cabinetEntity.getCabinetType() +","+ cabinetEntity.getCabinetDrawer() +"," +cabinetEntity.getCabinetDrawersize()).toString();

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                saomiaoMap.put("expressId", UUID.randomUUID().toString());
                saomiaoMap.put("expressidnumber",insertExpressReqDTO.getBody().getExpressIdnumber() );
                saomiaoMap.put("expresstype", insertExpressReqDTO.getBody().getExpressType());
                saomiaoMap.put("expressbegintime",df.format(new Date()));
                saomiaoMap.put("expresscourier",insertExpressReqDTO.getBody().getExpressCourier());
                saomiaoMap.put("expresscabinetnumber", insertExpressReqDTO.getBody().getExpressCabinetnumber());
                saomiaoMap.put("expresscabinetposition",s);

                insertExpressReqDTO.getBody().getUserPhone();
                experssMapper.saomiaoExpress(saomiaoMap);
                header.setMessage("派件成功");
                header.setCode("200");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        insertExpressResDTO.setHeader(header);
        return insertExpressResDTO;
    }
       /*
           20200806 zhao
             短信验证
          */
    @Override
    public SMSResDTO smsCheckService(SMSReqDTO smsReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","发送失败");
        SMSResDTO smsResDTO = new SMSResDTO();
        String Url = "http://sms.51yixun.com:8200/sms/sendBatch";

        try{
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(Url);

            //client.getParams().setContentCharset("GBK");
            client.getParams().setContentCharset("UTF-8");
            method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
            int code = (int) (Math.random() * (9999 - 1000 + 1)) + 100000;//产生6位随机数

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String inStr = "LHW-SMS-0RLPG" + "F6324B8F4C7CF9CE" + df.format(new Date());
            MD5Util md5Util = new MD5Util();

                String s = md5Util.MD5(inStr);
                NameValuePair[] data = {//提交短信
                        new NameValuePair("appId", "LHW-SMS-0RLPG"),
                        new NameValuePair("timestamp", df.format(new Date())),
                        new NameValuePair("sign", s),
                        new NameValuePair("mobiles", smsReqDTO.getBody().getUserPhone()),
                        new NameValuePair("content", "【方仓智能柜】凭取件码"+code+""+smsReqDTO.getBody().getCabinetAddress()+"方仓快递柜领取包裹，快递员电话"+smsReqDTO.getBody().getCourierPhone()),
                        new NameValuePair("schTime", null),
                        new NameValuePair("addserial", null),
                        new NameValuePair("batchId", "2")
                };
                method.setRequestBody(data);


            client.executeMethod(method);
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while((str = reader.readLine())!=null){
                stringBuffer.append(str);
            }
            String 	html=stringBuffer.toString();
            System.out.println(html);
            //System.out.println(method.getResponseBodyAsString());
            //System.out.println(method.getResponseBodyAsStream());
            if(html.equals("{\"code\":\"SUCCESS\",\"data\":0}")){//有问题
                header.setCode("200");
                header.setMessage("发送成功");
                 /*
                  20200808 zhao
                  将短信验证码存入数据库
                 */
                Map<String, Object> smsMap = new HashMap<>();
                smsMap.put("express_sms",code);
                smsMap.put("express_idnumber",smsReqDTO.getBody().getExpressIdnumber());
                experssMapper.updateSMS(smsMap);
            }else{
                header.setCode("400");
                header.setMessage("发送失败");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        smsResDTO.setHeader(header);
        return smsResDTO;
    }
      /*
    20200808 zhao
    用户通过取件码取件
     */
    @Override
    public UserQuJianResDTO userqujianService(UserQuJianReqDTO userQuJianReqDTO) {
        CommonResHeaderDTO header = new CommonResHeaderDTO("","400","取件失败");
        UserQuJianResDTO userQuJianResDTO = new UserQuJianResDTO();
        try{
            Map<String, Object> expressSmsCodeMap = new HashMap<>();
            expressSmsCodeMap.put("expressCabinetnumber",userQuJianReqDTO.getBody().getCabinetIdnumber());
            expressSmsCodeMap.put("expressSms",userQuJianReqDTO.getBody().getExpressSms());
            ExpressEntity expressEntity = experssMapper.SelectExpressSmsCode(expressSmsCodeMap);
            if(expressEntity==null||expressEntity.equals("")){
                header.setCode("400");
                header.setMessage("取件失败");
            }else{
                //判断时间
                SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                long time= date.getTime();//当前时间
                long begintime = expressEntity.getExpressBegintime().getTime();
                long bs=time-begintime;
                if(bs>86400000){
                    header.setCode("200");
                    header.setMessage("您的快件已超时，请扫码付款");
                }else{
                    header.setCode("200");
                    header.setMessage("取件成功");
                     /*  20200808 zhao
                 用户成功取件后修改endtime
                  */
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Map<String, Object> expressMap = new HashMap<>();
                    expressMap.put("expressEndtime",df.format(new Date()));
                    expressMap.put("expressCabinetnumber",userQuJianReqDTO.getBody().getCabinetIdnumber());
                    expressMap.put("expressSms",userQuJianReqDTO.getBody().getExpressSms());
                    experssMapper.updateExpress(expressMap);
                /*
                分钟后删除数据
                 */
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            /*expressMap.put("expressCabinetnumber",userQuJianReqDTO.getBody().getCabinetIdnumber());
                            expressMap.put("expressSms",userQuJianReqDTO.getBody().getExpressSms());*/
                            experssMapper.deleteRxpress(expressMap);
                        }
                    }, 999999999);// 设定指定的时间time,此处为2000毫秒
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }

        userQuJianResDTO.setHeader(header);
        return userQuJianResDTO;
    }




}
