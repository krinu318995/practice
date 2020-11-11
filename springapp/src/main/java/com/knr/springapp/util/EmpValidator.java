package com.knr.springapp.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.knr.springapp.vo.EmpVO;

public class EmpValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmpVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO form = (EmpVO)target;
		if (form.getEmployeeId() <= 206) {
			errors.rejectValue("employeeId", "emp.employeeId", "사원 번호는 207번 이상");
		}

	}

}
