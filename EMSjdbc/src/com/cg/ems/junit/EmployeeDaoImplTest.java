package com.cg.ems.junit;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoImplTest {

	static EmployeeDAO empdao = null;
	
	@BeforeClass
	public static void setUp(){
		empdao = new EmployeeImpl();
	}
	@Test
	public void addEmpTest(){
		try {
			Assert.assertEquals(161741,empdao.addEmployee(new Employee(161741,"swetha",7000.0F,LocalDate.now())));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
