package com.myapp.entity;

import java.util.Objects;

public class Address {

	private int id;
	private String city;
	private String state;
	private String pin;
	
	public void Address() {}

	public Address(int id, String city, String state, String pin) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, id, pin, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(pin, other.pin)
				&& Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}
	
	
}
