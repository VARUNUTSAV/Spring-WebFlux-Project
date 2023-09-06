package com.Varun.webFluxProject.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "Author")
public class Address {
    @NotNull
    @NotBlank
    private String hno;
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String state;

    public Address(String hno, String city, String state){
        this.hno=hno;
        this.city=city;
        this.state=state;
    }

    public String getHno(){ return hno; }
    public void setHno(String hno){ this.hno = hno; }
    public String getCity(){ return city; }
    public void setCity(String city){ this.city = city; }
    public String getState(){ return state; }
    public void setState(String state){ this.state = state; }


}
