package com.urong.boot.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.urong.boot.dto.Member;

public interface SampleMapper {

	@Insert("insert into app.member (email, name) values(#{email}, #{name})")
	public void addUser(Member member);
	
	@Select("SELECT * FROM app.member WHERE id = #{idx}")
	public Member getUser(int idx);
	
	@Select("select * from app.member")
	public List<Member> findAll();
}

