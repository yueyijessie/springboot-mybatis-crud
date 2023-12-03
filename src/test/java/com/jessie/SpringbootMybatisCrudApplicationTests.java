package com.jessie;

import com.jessie.mapper.EmpMapper;
import com.jessie.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

	@Autowired
	private EmpMapper empMapper;

	@Test
	public void deleteById() {
		empMapper.deleteById(17);
	}

	@Test
	public void insert(){
		Emp emp = new Emp();
		emp.setUsername("Tom111");
		emp.setName("Tom111");
		emp.setImage("1.jpg");
		emp.setGender((short)1);
		emp.setJob((short)1);
		emp.setEntrydate(LocalDate.of(2000,1,1));
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		emp.setDeptId(1);
		empMapper.insert(emp);
		// 打印出新增的id
		System.out.println(emp.getId());
	}

	@Test
	public void update(){
		Emp emp = new Emp();
		emp.setId(18);
		emp.setUsername("songdaxia");
		emp.setName("老宋666");
		empMapper.update(emp);
	}

	@Test
	public void getById(){
		Emp emp = empMapper.getById(18);
		System.out.println(emp);
	}

	@Test
	public void getByCondition(){
//		List<Emp> empList = empMapper.getByCondition("张", (short)1, LocalDate.of(2010,1,1), LocalDate.of(2020,1,1));
//		List<Emp> empList = empMapper.getByCondition("张", null, null, null);
//		List<Emp> empList = empMapper.getByCondition("张",(short)1 , null, null);
//		List<Emp> empList = empMapper.getByCondition(null,(short)1 , null, null);
		List<Emp> empList = empMapper.getByCondition(null,null , null, null);
		System.out.println(empList);
	}

	@Test
	public void deleteByIds(){
		List<Integer> ids = Arrays.asList(19,20,21);
		empMapper.deleteByIds(ids);
	}

}
