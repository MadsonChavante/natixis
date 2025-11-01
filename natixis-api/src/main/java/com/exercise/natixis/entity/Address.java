package com.exercise.natixis.entity;

import com.exercise.natixis.dto.AddressDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    
    private String number;

    private String city;
    
    private String postalCode;
    
    private String district;

    private String complement;

    @OneToOne(mappedBy = "address")
    private Client client;

    public Address() {}

    public Address(AddressDTO dto){
        this.street = dto.street();
        this.number = dto.number();
        this.city = dto.city();
        this.postalCode = dto.postalCode();
        this.district = dto.district();
        this.complement = dto.complement();
    }

    public AddressDTO toDTO() {
        return new AddressDTO(this.street, this.number, this.complement, this.postalCode, this.district, this.complement);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
