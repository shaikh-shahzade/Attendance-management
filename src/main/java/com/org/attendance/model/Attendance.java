package com.org.attendance.model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long aid;
	private Date date;
	private Date SigninTime;
	private Date SignOfTime;
	
	
	
}
