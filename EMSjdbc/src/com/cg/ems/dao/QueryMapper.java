package com.cg.ems.dao;

public interface QueryMapper {

	public static final String SELECTQRY1 = "SELECT * FROM emp161741";
	public static final String SELECTQRY2 = "SELECT * FROM emp161741 WHERE emp_id = ?";
	public static final String INSERTQRY1 = "INSERT INTO emp161741 VALUES(111, 'bhuvana',24000,'25-aug-1997')";
	public static final String INSERTQRY2 = "INSERT INTO emp161741(emp_id,emp_name,emp_sal)" + "VALUES(222, 'psr', 25000)";
	public static final String INSERTQRY3 = "INSERT INTO emp161741(emp_id,emp_name,emp_sal)" + "VALUES(?,?,?)";
	public static final String DELETEQRY1 = "DELETE FROM emp161741 WHERE emp_id = ?";
	public static final String UPDATEQRY1 = "UPDATE emp161741 SET emp_name = ?, emp_sal = ? WHERE emp_id = ?";
	public static final String SELECTQRY3 = "SELECT * FROM emp161741 WHERE emp_name = ?";
}
