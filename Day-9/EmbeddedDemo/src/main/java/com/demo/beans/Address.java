package com.demo.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int addrid;
    private String state;
    private String city;
    private String pin;
	public Address() {
		super();
	}
	public Address(int addrid, String state, String city, String pin) {
		super();
		this.addrid = addrid;
		this.state = state;
		this.city = city;
		this.pin = pin;
	}
	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [addrid=" + addrid + ", state=" + state + ", city=" + city + ", pin=" + pin + "]";
	}
    
    
}
