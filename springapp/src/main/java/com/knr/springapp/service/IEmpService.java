package com.knr.springapp.service;

import java.util.List;
import java.util.Map;

import com.knr.springapp.vo.EmpVO;
import com.knr.springapp.vo.JobVO;

public interface IEmpService {

	int getEmpCount();

	int getEmpCount(int deptId);

	List<EmpVO> getEmpList();

	EmpVO getEmpInfo(int empId);

	void updateEmp(EmpVO emp);

	void insertEmp(EmpVO emp);

	void deleteEmp(int empId);

	void deleteJobHistory(int empId);

	List<Map<String, Object>> getAllDeptId();

	List<JobVO> getAllJobId();

	List<Map<String, Object>> getAllManager();

	List<EmpVO> getDeptList(int deptId);

	List<EmpVO> searchName(String keyword);

	void modifyManager(int empId);

	int checkId(int empId);

}
