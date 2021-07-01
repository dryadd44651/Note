package com.example.demo;



import com.example.jpa.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

//Controller
@CrossOrigin(origins="*")
@RestController
public class HelloWorldController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/acc", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	public String  getLicense(@PathVariable ("user") String user) throws IOException, SQLException {
		var users = userRepository.findAll();
		return users.toString();
	}


	@PostMapping(path = "/license", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	public String postData(@RequestBody Map<String,Object> body) throws IOException {
		ObjectNode node =  new ObjectMapper().createObjectNode().put("hello","world");
		return node.toString();
	}



}
