package com.example.mvc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpModel {
	private String EmpName;
	 private String  EmpAddress;
	 private String EmpEmail;
	 private String EmpPas;
	 private String EmpDesignation;
	 private double EmpSalary;
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpAddress() {
		return EmpAddress;
	}
	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getEmpPas() {
		return EmpPas;
	}
	public void setEmpPas(String empPas) {
		EmpPas = empPas;
	}
	public String getEmpDesignation() {
		return EmpDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		EmpDesignation = empDesignation;
	}
	public double getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(double empSalary) {
		EmpSalary = empSalary;
	}
	 
	 
}