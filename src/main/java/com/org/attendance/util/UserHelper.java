package com.org.attendance.util;

import com.org.attendance.model.User;

public class UserHelper {

	public static User mapUser(User oldU , User newU)
	{
		if(newU.getEmail()!=null)
			oldU.setEmail(newU.getEmail());
		if(newU.getManager()!=null)
			oldU.setManager(newU.getManager());
		if(newU.getPassword()!=null)
			oldU.setPassword(newU.getPassword());		
		return oldU;
		
	}
}
