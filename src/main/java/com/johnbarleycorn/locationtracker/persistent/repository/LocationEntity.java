package com.johnbarleycorn.locationtracker.persistent.repository;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "LOCATION")
public class LocationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_ID")
	private String locationId;

	@Column(name = "LATITUDE")
	private double latitude;

	@Column(name = "LONGITUDE")
	private double longitude;

	@Column(name = "CLIENT_TS")
	private Timestamp clientTs;

	@Column(name = "SERVER_TS")
	private Timestamp serverTs;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private UserEntity user;

	
	public LocationEntity() {
		super();
	}

	public LocationEntity(double latitude, double longitude, Timestamp clientTs, UserEntity user) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.clientTs = clientTs;
		this.user = user;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getClientTs() {
		return clientTs;
	}

	public void setClientTs(Timestamp clientTs) {
		this.clientTs = clientTs;
	}

	public Timestamp getServerTs() {
		return serverTs;
	}

	public void setServerTs(Timestamp serverTs) {
		this.serverTs = serverTs;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LocationEntity [locationId=" + locationId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", clientTs=" + clientTs + ", serverTs=" + serverTs + ", userId=" + user + "]";
	}
}
