package com.emp.dao;

import java.util.List;

import com.emp.model.Employee;

public interface IEmployeeDao extends IAbstractDao<Employee> {

//	public List<Employee> viewAllEmployeeList();
//	public void saveEmployeeRecord(Employee employee);
//	public Employee  viewEmployeeById(int employeeId);
	public List<Employee>  viewEmployeeByName(String employeeName);
//    public void updateEmployee(Employee employee);	
//    public void deleteEmployee(int id);	
	public double sum(String employee);
    
}
