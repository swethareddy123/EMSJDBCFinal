package com.cg.ems.UI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class TestEmployeeClient {

	static Scanner sc = null;
	static EmployeeService empSer = null; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		empSer = new EmployeeServiceImpl();
		int choice = 0;
		while(true){
			System.out.println("What do you want to do?");
			System.out.println("1:Add emp\t2:Fetch all emp\n");
			System.out.println("3:delete emp\t4:Search emp by ID\n");
			System.out.println("5:search emp by Name\t6:Update emp\n");
			System.out.println("7.EXIT\n");
			System.out.println("Enter Your Choice\n");
			choice = sc.nextInt();
			switch(choice){
			case 1 : addEmp();
			break;
			case 2 : showEmpInfo();
			break;
			case 3: deleteEmp();
			break;
			case 4: getEmpById();
			break;
			case 5: searchByName();
			break;
			case 6: updateEmp();
			break;
			default: System.exit(0);
			}

		}

	}
	private static void updateEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter id of employee to be updated");
		int uid = sc.nextInt();
		System.out.println("Enter new employee name");
		String nm = sc.next();
		System.out.println("Enter sal to be updated");
		float f = sc.nextFloat();
		empSer.updateEmp(uid, nm, f);
		
	}
	private static void searchByName() {
		// TODO Auto-generated method stub
		System.out.println("Enter the employee Name");
		String reqName = sc.next();
		empSer.searchEmpByName(reqName);
		
	}
	 private static void getEmpById() 
	    {
	        System.out.println("Enter the Employee Id");
	        int reqId=sc.nextInt();
	        empSer.getEmpById(reqId);
	                    
	    }

	private static void deleteEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter Employee Id to delete");
		int rem = sc.nextInt();
		empSer.deleteEmp(rem);

	}
	private static void showEmpInfo() {
		// TODO Auto-generated method stub
		HashSet<Employee> empSet = empSer.fetchAllEmp();
		System.out.println("***********************");
		System.out.println("EMPID\t\tEMPNAME\t\tEMPSAL\t\tEMPDOJ");
		Iterator<Employee> it = empSet.iterator();
		while(it.hasNext()){
			Employee ee = it.next();
			System.out.println(ee.getEmpId()+"\t\t"+ee.getEmpName()+"\t\t"+ee.getEmpSal()+"\t\t"+ee.getEmpDOJ());
		}
		System.out.println("***********************");
	}
	private static void addEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter emp Id:");
		int eid = sc.nextInt();
		try {
			if(empSer.validateDigit(eid)){
				System.out.println("Enter emp name:");
				String nm = sc.next();
				if(empSer.validateName(nm)){
					System.out.println("Enter Salary:");
					float sal = sc.nextFloat();
					System.out.println("Enter DOJ(dd-MM-yyyy)");
					String empDOJStr = sc.next();
					Employee ee = new Employee(eid,nm,sal,empSer.convertFromStrToLoaclDate(empDOJStr));
					int empId = empSer.addEmployee(ee);
					System.out.println(empId+" Added Successfully");
				}

			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
