package com.xworkz.seadetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="seadetails")
@NamedQuery(name="findByName", query ="select entity from SeaEntity entity where entity.name='samudra' ")
public class SeaEntity {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="place")
	private String place;
	@Column(name="type")
	private String type;
	@Column(name="area")
	private double area;
	
	public SeaEntity(String name, String place, String type, double area) {
		super();
		this.name = name;
		this.place = place;
		this.type = type;
		this.area = area;
	}
}
