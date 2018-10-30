package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmployeeImpl implements EmployeeDAO {
	
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		try {
			con = DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.INSERTQRY3);
			pst.setInt(1, ee.getEmpId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3, ee.getEmpSal());
			int data = pst.executeUpdate();
			if(data == 1){
				return ee.getEmpId();
			}
			else{
				return 0;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		} 
		finally{
			
		}
		
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {
		HashSet<Employee> empSet = new HashSet<Employee>();
		try{
			con= DBUtil.getCon();
			st = con.createStatement();
			rs = st.executeQuery(QueryMapper.SELECTQRY1);
			while(rs.next()){
				int eid = rs.getInt("emp_id");
				String enm = rs.getString("emp_name");
				float sl = rs.getFloat("emp_sal");
				empSet.add(new Employee(eid,enm,sl));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return empSet;
		// TODO Auto-generated method stub
		
	}

    public Employee getEmpById(int empId)
    {   
		//HashSet<Employee> empSet = new HashSet<Employee>();
		try{
			con= DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.SELECTQRY2);
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getInt("emp_id")+"\t"+rs.getString("emp_name")+"\t"+rs.getFloat("emp_sal")+"\t"+rs.getDate("emp_dob"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
        return null;
        
    }


	@Override
	public HashSet<Employee> searchEmpByName(String reqname) {
		// TODO Auto-generated method stub
		try{
			con= DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.SELECTQRY3);
			pst.setString(1, reqname);
			rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getInt("emp_id")+"\t"+rs.getString("emp_name")+"\t"+rs.getFloat("emp_sal")+"\t"+rs.getDate("emp_dob"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		try{
			con= DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.DELETEQRY1);
			pst.setInt(1, empId);
			int data = pst.executeUpdate();
			if(data > 0){
				System.out.println("Record Deleted");
			}
			else{
				System.out.println("Record Not Found");
			}
		}
	catch(Exception e){
		e.printStackTrace();
	}
        
        return 0;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		// TODO Auto-generated method stub
		try {
			con = DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.UPDATEQRY1);
			pst.setString(1, newName);
			pst.setFloat(2, newSal);
			pst.setInt(3, empId);
			int data = pst.executeUpdate();
			if(data == 1){
				System.out.println("Updated Successfully");
			}
			else{
				System.out.println("No record found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			
		}
		
		return null;
	}

}
