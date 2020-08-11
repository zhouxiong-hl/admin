package com.fangchuang.haolinbao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "express", schema = "haolinbao", catalog = "")
public class ExpressEntity {
    private String expressId;
    private String expressIdnumber;
    private String expressType;
    private Date expressBegintime;
    private Date expressEndtime;
    private String expressCourier;
    private String expressCabinetposition;
    private String expressCabinetnumber;
    private String expressSms;
    private String expressState;

    @Id
    @Column(name = "express_id")
    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "express_idnumber")
    public String getExpressIdnumber() {
        return expressIdnumber;
    }

    public void setExpressIdnumber(String expressIdnumber) {
        this.expressIdnumber = expressIdnumber;
    }

    @Basic
    @Column(name = "express_type")
    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    @Basic
    @Column(name = "express_begintime")
    public Date getExpressBegintime() {
        return expressBegintime;
    }

    public void setExpressBegintime(Date expressBegintime) {
        this.expressBegintime = expressBegintime;
    }

    @Basic
    @Column(name = "express_endtime")
    public Date getExpressEndtime() {
        return expressEndtime;
    }

    public void setExpressEndtime(Date expressEndtime) {
        this.expressEndtime = expressEndtime;
    }

    @Basic
    @Column(name = "express_courier")
    public String getExpressCourier() {
        return expressCourier;
    }

    public void setExpressCourier(String expressCourier) {
        this.expressCourier = expressCourier;
    }

    @Basic
    @Column(name = "express_cabinetposition")
    public String getExpressCabinetposition() {
        return expressCabinetposition;
    }

    public void setExpressCabinetposition(String expressCabinetposition) {
        this.expressCabinetposition = expressCabinetposition;
    }

    @Basic
    @Column(name = "express_cabinetnumber")
    public String getExpressCabinetnumber() {
        return expressCabinetnumber;
    }

    public void setExpressCabinetnumber(String expressCabinetnumber) {
        this.expressCabinetnumber = expressCabinetnumber;
    }

    @Basic
    @Column(name = "express_sms")
    public String getExpressSms() {
        return expressSms;
    }

    public void setExpressSms(String expressSms) {
        this.expressSms = expressSms;
    }

    @Basic
    @Column(name = "express_state")
    public String getExpressState() {
        return expressState;
    }

    public void setExpressState(String expressState) {
        this.expressState = expressState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressEntity that = (ExpressEntity) o;
        return Objects.equals(expressId, that.expressId) &&
                Objects.equals(expressIdnumber, that.expressIdnumber) &&
                Objects.equals(expressType, that.expressType) &&
                Objects.equals(expressBegintime, that.expressBegintime) &&
                Objects.equals(expressEndtime, that.expressEndtime) &&
                Objects.equals(expressCourier, that.expressCourier) &&
                Objects.equals(expressCabinetposition, that.expressCabinetposition) &&
                Objects.equals(expressCabinetnumber, that.expressCabinetnumber) &&
                Objects.equals(expressSms, that.expressSms) &&
                Objects.equals(expressState, that.expressState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressId, expressIdnumber, expressType, expressBegintime, expressEndtime, expressCourier, expressCabinetposition, expressCabinetnumber, expressSms, expressState);
    }
}
