package com.knr.springapp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.knr.springapp.service.EmpService;
import com.knr.springapp.service.IEmpService;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
		
		IEmpService empService = context.getBean("empService",IEmpService.class);

		/* System.out.println(empService.selectEmployee(100)); */
		/*
		 * List<EmpVO> empList = empService.empList(); for (EmpVO emp : empList) {
		 * System.out.println(emp); }
		 */
		/*
		 * System.out.println(empService.getEmpCount());
		 * System.out.println(empService.getEmpCount(30));
		 * System.out.println(empService.getEmpList());
		 * System.out.println(empService.getAllManager());
		 */
		empService.deleteEmp(100);

	}

}
