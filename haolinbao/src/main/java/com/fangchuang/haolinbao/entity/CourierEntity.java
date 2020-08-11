package com.fangchuang.haolinbao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "courier", schema = "haolinbao", catalog = "")
public class CourierEntity {
    private String courierId;
    private String courierName;
    private Integer courierGender;
    private String courierAddress;
    private String courierPhone;
    private String courierPassword;
    private Date courierBirth;
    private String courierIdnumber;
    private Integer courierAvailable;
    private String courierCompany;
    private String courierExpress;
    private String courierIcon;
    private BigDecimal courierMoney;
    private BigDecimal courierEcharge;
    private BigDecimal courierWithdrawal;
    private BigDecimal courierConsumption;
    private String courierCode;

    @Id
    @Column(name = "courier_id")
    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    @Basic
    @Column(name = "courier_name")
    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    @Basic
    @Column(name = "courier_gender")
    public Integer getCourierGender() {
        return courierGender;
    }

    public void setCourierGender(Integer courierGender) {
        this.courierGender = courierGender;
    }

    @Basic
    @Column(name = "courier_address")
    public String getCourierAddress() {
        return courierAddress;
    }

    public void setCourierAddress(String courierAddress) {
        this.courierAddress = courierAddress;
    }

    @Basic
    @Column(name = "courier_phone")
    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    @Basic
    @Column(name = "courier_password")
    public String getCourierPassword() {
        return courierPassword;
    }

    public void setCourierPassword(String courierPassword) {
        this.courierPassword = courierPassword;
    }

    @Basic
    @Column(name = "courier_ birth")
    public Date getCourierBirth() {
        return courierBirth;
    }

    public void setCourierBirth(Date courierBirth) {
        this.courierBirth = courierBirth;
    }

    @Basic
    @Column(name = "courier_idnumber")
    public String getCourierIdnumber() {
        return courierIdnumber;
    }

    public void setCourierIdnumber(String courierIdnumber) {
        this.courierIdnumber = courierIdnumber;
    }

    @Basic
    @Column(name = "courier_available")
    public Integer getCourierAvailable() {
        return courierAvailable;
    }

    public void setCourierAvailable(Integer courierAvailable) {
        this.courierAvailable = courierAvailable;
    }

    @Basic
    @Column(name = "courier_company")
    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany;
    }

    @Basic
    @Column(name = "courier_express")
    public String getCourierExpress() {
        return courierExpress;
    }

    public void setCourierExpress(String courierExpress) {
        this.courierExpress = courierExpress;
    }

    @Basic
    @Column(name = "courier_icon")
    public String getCourierIcon() {
        return courierIcon;
    }

    public void setCourierIcon(String courierIcon) {
        this.courierIcon = courierIcon;
    }

    @Basic
    @Column(name = "courier_moneyr")
    public BigDecimal getCourierMoney() {
        return courierMoney;
    }

    public void setCourierMoney(BigDecimal courierMoneyr) {
        this.courierMoney = courierMoneyr;
    }

    @Basic
    @Column(name = "courier_echarge")
    public BigDecimal getCourierEcharge() {
        return courierEcharge;
    }

    public void setCourierEcharge(BigDecimal courierEcharge) {
        this.courierEcharge = courierEcharge;
    }

    @Basic
    @Column(name = "courier_withdrawal")
    public BigDecimal getCourierWithdrawal() {
        return courierWithdrawal;
    }

    public void setCourierWithdrawal(BigDecimal courierWithdrawal) {
        this.courierWithdrawal = courierWithdrawal;
    }

    @Basic
    @Column(name = "courier_consumption")
    public BigDecimal getCourierConsumption() {
        return courierConsumption;
    }

    public void setCourierConsumption(BigDecimal courierConsumption) {
        this.courierConsumption = courierConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourierEntity that = (CourierEntity) o;
        return Objects.equals(courierId, that.courierId) &&
                Objects.equals(courierName, that.courierName) &&
                Objects.equals(courierGender, that.courierGender) &&
                Objects.equals(courierAddress, that.courierAddress) &&
                Objects.equals(courierPhone, that.courierPhone) &&
                Objects.equals(courierPassword, that.courierPassword) &&
                Objects.equals(courierBirth, that.courierBirth) &&
                Objects.equals(courierIdnumber, that.courierIdnumber) &&
                Objects.equals(courierAvailable, that.courierAvailable) &&
                Objects.equals(courierCompany, that.courierCompany) &&
                Objects.equals(courierExpress, that.courierExpress) &&
                Objects.equals(courierIcon, that.courierIcon) &&
                Objects.equals(courierMoney, that.courierMoney) &&
                Objects.equals(courierEcharge, that.courierEcharge) &&
                Objects.equals(courierWithdrawal, that.courierWithdrawal) &&
                Objects.equals(courierConsumption, that.courierConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courierId, courierName, courierGender, courierAddress, courierPhone, courierPassword, courierBirth, courierIdnumber, courierAvailable, courierCompany, courierExpress, courierIcon, courierMoney, courierEcharge, courierWithdrawal, courierConsumption);
    }

    @Basic
    @Column(name = "courier_code")
    public String getCourierCode() {
        return courierCode;
    }

    public void setCourierCode(String courierCode) {
        this.courierCode = courierCode;
    }
}
