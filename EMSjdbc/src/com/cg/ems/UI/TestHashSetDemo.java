package com.cg.ems.UI;

import java.util.HashSet;
import java.util.TreeSet;

import com.cg.ems.dto.Employee;

public class TestHashSetDemo {
	public static void main(String[] args){
		HashSet<Employee> emps = new HashSet<Employee>();
		emps.add(new Employee(111, "swetha",7000.0F));
		emps.add(new Employee(222, "Hyndhavi",5000.0F));
		emps.add(new Employee(333, "shiva",3000.0F));
		emps.add(new Employee(111, "swetha",1000.0F));
		System.out.println(emps);
		
		System.out.println("*******************");
		TreeSet<String> cities = new TreeSet<String>();
		cities.add("Pune");
		cities.add("Mumbai");
		cities.add("Hyderabad");
		cities.add("Bangalore");
		cities.add("Noida");
		cities.add("Pune");
		System.out.println(cities);

		
		System.out.println("*******************");
		TreeSet<Employee> emps2 = new TreeSet<Employee>();
		emps2.add(new Employee(111, "swetha",7000.0F));
		emps2.add(new Employee(222, "Hyndhavi",5000.0F));
		emps2.add(new Employee(333, "shiva",3000.0F));
		emps2.add(new Employee(111, "swetha",1000.0F));
		System.out.println(emps2);
		

	}

}
