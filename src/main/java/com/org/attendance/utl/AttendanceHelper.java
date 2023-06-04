package com.org.attendance.utl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.org.attendance.model.Attendance;


public class AttendanceHelper {

	public static Attendance updateObject(Attendance oldA , Attendance newA)
	{
		if(newA.getDate()!=null)
			oldA.setDate(newA.getDate());
		
		if(newA.getRemarks()!=null)
			oldA.setRemarks(newA.getRemarks());
		
		if(newA.getSigninTime()!=null)
			oldA.setSigninTime(newA.getSigninTime());
		
		if(newA.getSignOfTime()!=null)
			oldA.setSignOfTime(newA.getSignOfTime());
		
		return oldA;
	}
}
