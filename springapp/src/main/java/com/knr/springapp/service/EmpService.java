package com.knr.springapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.knr.springapp.dao.IEmpRepository;
import com.knr.springapp.vo.EmpVO;
import com.knr.springapp.vo.JobVO;

@Service
public class EmpService implements IEmpService {

	@Autowired
	@Qualifier("IEmpRepository")
	IEmpRepository empRepository;



	@Override
	public int getEmpCount() {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount();
	}

	@Override
	public int getEmpCount(int deptId) {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount(deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {
		// TODO Auto-generated method stub
		return empRepository.getEmpList();
	}

	@Override
	public EmpVO getEmpInfo(int empId) {
		// TODO Auto-generated method stub
		return empRepository.getEmpInfo(empId);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		empRepository.insertEmp(emp);

	}

	@Override
	public void updateEmp(EmpVO emp) {
		
		empRepository.deleteJobHistory(emp.getEmployeeId());
		empRepository.updateEmp(emp);

	}

	@Override
	public void deleteEmp(int empId) {
		empRepository.deleteJobHistory(empId);
		empRepository.modifyManager(empId);
		empRepository.deleteEmp(empId);

	}

	@Override
	public void deleteJobHistory(int empId) {
		empRepository.deleteJobHistory(empId);

	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		// TODO Auto-generated method stub
		return empRepository.getAllDeptId();
	}

	@Override
	public List<JobVO> getAllJobId() {
		// TODO Auto-generated method stub
		return empRepository.getAllJobId();
	}

	@Override
	public List<Map<String, Object>> getAllManager() {
		// TODO Auto-generated method stub
		return empRepository.getAllManager();
	}

	@Override
	public List<EmpVO> getDeptList(int deptId) {
		// TODO Auto-generated method stub
		return empRepository.getDeptList(deptId);
	}

	@Override
	public List<EmpVO> searchName(String keyword) {
		// TODO Auto-generated method stub
		return empRepository.searchName(keyword);
	}

	@Override
	public void modifyManager(int empId) {
		empRepository.modifyManager(empId);
		
	}

	@Override
	public int checkId(int empId) {
		// TODO Auto-generated method stub
		return empRepository.checkId(empId);
	}




}
