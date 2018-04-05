package com.lmig.ci.superhero.superherosightings.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

@Entity
@Table(schema = "SUPERHERO", name = "ORG")

public class Org {
    @Id
    @GeneratedValue
    int orgId;

    @Column(name = "ORG_NAME")
    String orgName;

    @Column(name = "ORG_DESCRIPTION")
    String orgDescription;

    @Column(name = "ORG_ALIGNMENT")
    String orgAlignment;

    @Column(name = "ORG_ADDRESS_1")
    String orgAddress1;

    @Column(name = "ORG_ADDRESS_2")
    String orgAddress2;

    @Column(name = "ORG_CITY")
    String orgCity;

    @Column(name = "ORG_STATE")
    String orgState;

    @Column(name = "ORG_POST_CODE")
    String orgPostCode;

    @Column(name = "ORG_COUNTRY")
    String orgCountry;

    @Column(name = "ORG_EMAIL")
    String orgEmail;

    @Column(name = "ORG_PHONE")
    String orgPhone;

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgAlignment() {
        return orgAlignment;
    }

    public void setOrgAlignment(String orgAlignment) {
        this.orgAlignment = orgAlignment;
    }

    public String getOrgAddress1() {
        return orgAddress1;
    }

    public void setOrgAddress1(String orgAddress1) {
        this.orgAddress1 = orgAddress1;
    }

    public String getOrgAddress2() {
        return orgAddress2;
    }

    public void setOrgAddress2(String orgAddress2) {
        this.orgAddress2 = orgAddress2;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgState() {
        return orgState;
    }

    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    public String getOrgPostCode() {
        return orgPostCode;
    }

    public void setOrgPostCode(String orgPostCode) {
        this.orgPostCode = orgPostCode;
    }

    public String getOrgCountry() {
        return orgCountry;
    }

    public void setOrgCountry(String orgCountry) {
        this.orgCountry = orgCountry;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
