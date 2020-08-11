package com.fangchuang.haolinbao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cabinet", schema = "haolinbao", catalog = "")
public class CabinetEntity {
    private String cabinetId;
    private String cabinetIdnumber;
    private String cabinetType;
    private String cabinetDrawer;
    private String cabinetDrawersize;
    private Integer cabinetPrice;
    private String cabinetState;

    @Id
    @Column(name = "cabinet_id")
    public String getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(String cabinetId) {
        this.cabinetId = cabinetId;
    }

    @Basic
    @Column(name = "cabinet_idnumber")
    public String getCabinetIdnumber() {
        return cabinetIdnumber;
    }

    public void setCabinetIdnumber(String cabinetIdnumber) {
        this.cabinetIdnumber = cabinetIdnumber;
    }

    @Basic
    @Column(name = "cabinet_type")
    public String getCabinetType() {
        return cabinetType;
    }

    public void setCabinetType(String cabinetType) {
        this.cabinetType = cabinetType;
    }

    @Basic
    @Column(name = "cabinet_drawer")
    public String getCabinetDrawer() {
        return cabinetDrawer;
    }

    public void setCabinetDrawer(String cabinetDrawer) {
        this.cabinetDrawer = cabinetDrawer;
    }

    @Basic
    @Column(name = "cabinet_drawersize")
    public String getCabinetDrawersize() {
        return cabinetDrawersize;
    }

    public void setCabinetDrawersize(String cabinetDrawersize) {
        this.cabinetDrawersize = cabinetDrawersize;
    }

    @Basic
    @Column(name = "cabinet_price")
    public Integer getCabinetPrice() {
        return cabinetPrice;
    }

    public void setCabinetPrice(Integer cabinetPrice) {
        this.cabinetPrice = cabinetPrice;
    }

    @Basic
    @Column(name = "cabinet_state")
    public String getCabinetState() {
        return cabinetState;
    }

    public void setCabinetState(String cabinetState) {
        this.cabinetState = cabinetState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CabinetEntity that = (CabinetEntity) o;
        return Objects.equals(cabinetId, that.cabinetId) &&
                Objects.equals(cabinetIdnumber, that.cabinetIdnumber) &&
                Objects.equals(cabinetType, that.cabinetType) &&
                Objects.equals(cabinetDrawer, that.cabinetDrawer) &&
                Objects.equals(cabinetDrawersize, that.cabinetDrawersize) &&
                Objects.equals(cabinetPrice, that.cabinetPrice) &&
                Objects.equals(cabinetState, that.cabinetState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cabinetId, cabinetIdnumber, cabinetType, cabinetDrawer, cabinetDrawersize, cabinetPrice, cabinetState);
    }
}
