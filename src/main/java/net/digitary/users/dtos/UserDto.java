package net.digitary.users.dtos;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.digitary.users.utils.JsonLocalDateTimeDeserializer;
import net.digitary.users.utils.JsonLocalDateTimeSerializer;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {


    private Long id;

    private String name;

    private String eMail;

    private String addressLine1;

    private String addressLine2;

    private String townCity;

    private String postalCode;

    private String country;

    private String phoneNumber1;

    private String phoneNumber2;

    private String phoneNumber3;


    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
    private LocalDateTime dateLastView;

    public UserDto() {
        super();
    }

    public UserDto(Long id, String name, String eMail,
                   String addressLine1, String addressLine2, String townCity,
                   String postalCode, String country,String phoneNumber1,
                           String phoneNumber2,

                           String phoneNumber3,

                           LocalDateTime dateLastView) {
        this();
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townCity=townCity;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber1=phoneNumber1;
        this.phoneNumber2=phoneNumber2;
        this.phoneNumber3=phoneNumber3;
        this.dateLastView = dateLastView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getPhoneNumber3() {
        return phoneNumber3;
    }

    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }

    public LocalDateTime getDateLastView() {
        return dateLastView;
    }

    public void setDateLastView(LocalDateTime dateLastView) {
        this.dateLastView = dateLastView;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", townCity='" + townCity + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", phoneNumber3='" + phoneNumber3 + '\'' +
                ", dateLastView=" + dateLastView +
                '}';
    }
}
