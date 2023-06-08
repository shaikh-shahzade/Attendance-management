package com.org.attendance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	public List<Attendance> findAllByUser(User user);
	
	public Page<Attendance> findAllByUser(User user , Pageable pageable);
	
	public Page<Attendance> findAllByDate(LocalDate date, Pageable pageable);
	
	public Page<Attendance> findByDateAndUser(LocalDate date, User user ,Pageable pageable);
	
}
