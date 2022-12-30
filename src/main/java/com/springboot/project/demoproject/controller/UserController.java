package com.springboot.project.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.demoproject.dto.GenericResponse;
import com.springboot.project.demoproject.dto.User;
import com.springboot.project.demoproject.repository.UserRepository;
import com.springboot.project.demoproject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/create")
		
		public GenericResponse<User> create(@RequestBody User data) throws Exception {
			userService.save(data);
			GenericResponse<User> responce = new GenericResponse<User>();
			responce.setStatus("value save success");
			responce.setData(data);
			responce.setDataList(null);
			responce.setMessage("Store successfully");
			return responce;
	}
	@GetMapping(value ="/getall")
	 
		public GenericResponse<User> getvalue() throws Exception {

			List<User> obj = userService.getAllUsers();
			GenericResponse<User> responce = new GenericResponse<User>();
			responce.setStatus("value GET success");
			responce.setData(null);
			responce.setDataList(obj);
			responce.setMessage("Get successfully");
			return responce;
			
			}

	@PutMapping(value = "/update")
	public GenericResponse<User> updatevalue(@RequestBody User data) throws Exception {
		
		userService.Update(data);

	GenericResponse<User> responce = new GenericResponse<User>();
		responce.setStatus("value Update success");
		responce.setData(data);
		responce.setDataList(null);
		responce.setMessage("Updated successfully");
		return responce;

	}
	@DeleteMapping(value = "/delete/{bookingId}")
	public GenericResponse<User> delete(@PathVariable Integer bookingId) throws Exception {
		
		userService.deletevalue(bookingId);

		GenericResponse<User> responce = new GenericResponse<User>();
		responce.setStatus("value delete success");
		responce.setData(null);
		responce.setDataList(null);
		responce.setMessage("deletd successfully");
		return responce;

	}

	@GetMapping(value = "/getbyId/{bookingId}")
	private GenericResponse<User> getbyId(@PathVariable Integer bookingId) throws Exception {
		
		User user= userService.getById(bookingId);
        GenericResponse<User> response = new GenericResponse<User>();
		response.setData(user);
		response.setDataList(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");
		return response;

	}

	 
 }
		
	

