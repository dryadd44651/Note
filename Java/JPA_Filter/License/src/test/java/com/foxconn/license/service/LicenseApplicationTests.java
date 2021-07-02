package com.foxconn.license.service;

import com.foxconn.license.entity.User;
import com.foxconn.license.entity.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LicenseApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		User acc = new User("howard1","boot",1);
		try{
			userRepository.save(acc);
			System.out.println("\n\nFinished\n\n");
		}catch (Exception e){
			System.err.println(e);
		}

	}

}
