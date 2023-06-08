package com.org.attendance.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.attendance.exceptions.ResourceNotFoundException;
import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;
import com.org.attendance.repository.AttendanceRepository;
import com.org.attendance.repository.UserRepository;
import com.org.attendance.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User assignManager(Long userId, Long managerId)  {
		// TODO Auto-generated method stub
		
			if(userId==null||managerId==null) 
			throw new ResourceNotFoundException("Manager or User Invalid", "User",userId);
			
			User u = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("(Manager or User)", "Manager: %d or User".formatted(managerId),userId));
			User manager = userRepository.findById(managerId).get();
			u.setManager(manager);

			return userRepository.save(u);
		
	}


	@Override
	public List<Attendance> getAttendanceByUserId(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User id:" , id));
		return attendanceRepository.findAllByUser(user);
	}


	@Override
	public List<Attendance> searchAttendance(LocalDate date, String username, int page, int pagesize, String sortby) {
		// TODO Auto-generated method stub
		List<Attendance> att=null;
		//default -1  |  10
		if(page==-1)
		{
			page=0;
			pagesize=Integer.MAX_VALUE;
		}
		
		Pageable pageable = PageRequest.of(page, pagesize,Sort.by(sortby));
		
		if(date!=null&&username!=null)
		{
			User u = userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException(" User", "User:"+username,0));
			att =  attendanceRepository.findByDateAndUser(date, u,pageable).toList();
		}
		else
		if(date!=null) att = attendanceRepository.findAllByDate(date, pageable).toList();
		else
		if(username!=null)
		{
			User u = userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException(" User", "User:"+username,0));
			att =  attendanceRepository.findAllByUser(u,pageable).toList();
		}
		else
		att=attendanceRepository.findAll(pageable).toList();
		 
		return att;
	}

}
