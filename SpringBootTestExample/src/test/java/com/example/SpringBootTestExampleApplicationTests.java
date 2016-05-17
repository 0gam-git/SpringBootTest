package com.example;

import java.lang.management.MemoryManagerMXBean;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.urong.boot.application.SpringBootTestExampleApplication;
import com.urong.boot.dto.Member;
import com.urong.boot.persistence.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootTestExampleApplication.class)
@WebAppConfiguration
public class SpringBootTestExampleApplicationTests {

	@Autowired
	private SampleMapper sampleMapper;

	@Test
	public void insert() {
		System.out.println("Adding User");
		Member member = new Member("urong@urong123.com", "urong");

		sampleMapper.addUser(member);
	}
	
	@Test
	public void findAll() {
		List<Member> members = sampleMapper.findAll();
		
		for (Member member : members) {
			System.out.println(member.getName());
		}
	}

}
