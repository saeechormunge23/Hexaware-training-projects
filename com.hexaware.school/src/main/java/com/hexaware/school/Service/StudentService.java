package com.hexaware.school.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.school.Dao.RepStudent;
import com.hexaware.school.Entity.Student;

@Service
public class StudentService {
	@Autowired
   RepStudent RepSt;

	public Student saveSt(Student s) {
		Student s2=RepSt.save(s);
		return s2;
	}

	public List<Student> getStuds() {
		List<Student> l = (List)RepSt.findAll(); 
		return l;
	}
	
	public Student removeStuds(int rno) {
		Student s=	RepSt.findById(rno).orElse(null);
			if(s==null) {
				return null;
			}
			else {
				RepSt.delete(s);
			}
			return s;
		}

	public String updateNM(String nm, int rn) {
		Student s = RepSt.findById(rn).orElse(null);
		if(s == null){
			return "Not Found";
		}else {
			s.setName(nm);
			RepSt.save(s);
			return "Name Updated";
			
		}
	}
	
	public String getRoll(int rno) {
		Student s=	RepSt.findById(rno).orElse(null);
		if(s==null) {
			return "not found";
		}
		else {
			
			return s.getName();
		}
		
	}
}
