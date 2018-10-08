package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.User;
import com.example.demo.jpa.UserRepository;

@RestController
public class SampleController {

	@Autowired
	private UserRepository jpaDao;

	@RequestMapping(value = "/custom", method = RequestMethod.GET)
	public @ResponseBody String custom() {
		return "custom";
	}

	@GetMapping(value = { "/a", "b", "c" })
	public @ResponseBody String ab() {
		return "abc";
	}

	@PostMapping(value = "jpa")
	public @ResponseBody String testJpa(@RequestBody User model) {
		jpaDao.save(model);

		return "success";
	}

}
