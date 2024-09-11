package com.hexaware.school.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.school.Entity.Student;
import com.hexaware.school.Service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studSer;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student s) {
        return studSer.saveSt(s);
    }
    
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
    	List<Student> users = studSer.getStuds();
    	return users;
    }
    
    @DeleteMapping("/removeStudent/{rno}")
	public Student removeStudent(@PathVariable int rno) {
		Student s2=studSer.removeStuds(rno);
		return s2;
	}
    
    @PutMapping("/updateName/{rn}/{nm}")
    public String updateName(@PathVariable String nm, @PathVariable int rn) {
    	String r = studSer.updateNM(nm,rn);
    	return r;
    	
    }
    
    @GetMapping("/getrollno/{rno}")
	public String getRollno(@PathVariable int rno) {
		String r=studSer.getRoll(rno);
		return r;
	}

}
