package com.hexaware.crud;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hexaware.crud.Entity.User;
import com.hexaware.crud.UserRepo.UserRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        UserRepository rep = context.getBean(UserRepository.class);

        Iterable<User> users = rep.findAll();
        users.forEach(temp -> System.out.println(temp.toString()));
        
        User user1 = new User();
        user1.setUserId(106);
        user1.setName("Lee");
        user1.setFee(10000.9);
        rep.save(user1);
        
        //Optional<User> u = rep.findById(105);
        //System.out.println(u);
        //if(u.isPresent()) {
        //	rep.deleteById(105);
        //}else {
        //	System.out.println("Not Found");
        	
        //}
        
        //Optional<User> u1=	rep.findById(100);
    	
		//   	 if(u1.isPresent())
		//   	 {
		   		
		 //  		    User temp=u1.get();
		   		    
		  // 		   temp.setName("jatin");
		 //  		   rep.save(temp);
		 //  		
		 //  	 }
		  // 	 else
		  // 	 {
		  // 		 System.out.println("Not Found");
		  // 	 }
        
        
        
    }
}
