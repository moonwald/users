package net.digitary.users.entities;

import net.digitary.users.entities.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Entity User maps the table users
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String eMail;

    @Column(name = "ADDRESS_LINE_ONE", nullable = false)
    private String addressLine1;

    @Column(name = "ADDRESS_LINE_TWO")
    private String addressLine2;


    @Column(name = "TOWN_CITY", nullable = false)
    private String townCity;

    @Column(name = "POSTAL_CODE")
    private String postalCode;


    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "PHONE_NUMBER_1")
    String phoneNumber1;

    @Column(name = "PHONE_NUMBER_2")
    String phoneNumber2;

    @Column(name = "PHONE_NUMBER_3")
    String phoneNumber3;

    @Column(name = "DATE_LAST_VIEW")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dateLastView;

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


}
