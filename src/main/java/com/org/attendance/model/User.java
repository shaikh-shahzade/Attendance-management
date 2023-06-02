package com.org.attendance.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;
	private String type;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MANAGER_ID")
    private User manager;

    @OneToMany(fetch = FetchType.LAZY , mappedBy="manager",cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<User> employeeList;
	
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Attendance> attendance;
    
}
