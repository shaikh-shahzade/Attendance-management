package com.org.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	public List<Attendance> findAllByUser(User user);
}
