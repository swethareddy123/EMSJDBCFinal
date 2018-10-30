package com.cg.ems.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO empDao = null;
	public EmployeeServiceImpl() {
		empDao = new EmployeeImpl();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		// TODO Auto-generated method stub
		return empDao.addEmployee(ee);
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {
		// TODO Auto-generated method stub
		return empDao.fetchAllEmp();
	}

	@Override
    public Employee getEmpById(int empId) 
    {
        return empDao.getEmpById(empId);
    }


	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		// TODO Auto-generated method stub
		return empDao.searchEmpByName(name);
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(empId);
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(empId, newName, newSal);
	}

	@Override
	public boolean validateDigit(int num) throws EmployeeException {
		// TODO Auto-generated method stub
		Integer input = new Integer(num);
		String inputStr = input.toString();
		String digitPattern = "[0-9]+";
		if(Pattern.matches(digitPattern, inputStr)){
			return true;
		}
		else{
			throw new EmployeeException("Invalid Input"+ "Only digits are allowed");
		}
	}

	@Override
	public boolean validateName(String name) throws EmployeeException {
		// TODO Auto-generated method stub
		String namePattern = "[A-Z][a-z]+";
		if(Pattern.matches(namePattern, name)){
			return true;
		}
		else{
			throw new EmployeeException("Invalid Input"+ "Only chars are allowed");
		}
	}
	@Override
	public LocalDate convertFromStrToLoaclDate(String dtStr) {
		// TODO Auto-generated method stub
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dtStr, myFormat);
		return date;
	}
	

}
