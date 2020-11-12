package com.knr.springapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.knr.springapp.service.IEmpService;
import com.knr.springapp.vo.EmpVO;

@Controller
@RequestMapping("/emp")
public class EmpController {
//requestMapping 사용

	@Autowired
	IEmpService empService;

	@GetMapping()
	public String mainPage(Model model) {
		model.addAttribute("message", "Hello Welcome to EmpApp");
		return "home";
	}

	@GetMapping(value = "/count")
	public String empCount(Model model,
			@RequestParam(value = "deptId", required = false, defaultValue = "0") int deptId) {
// required = false :  deptId 가 없어도 실행 , 들어오는 값이 없을 경우 defaultValue에 설정된 0이 들어감

		if (deptId == 0) {
			model.addAttribute("count", empService.getEmpCount());
		} else {
			model.addAttribute("count", empService.getEmpCount(deptId));
		}
		return "emp/count";

	}

	@GetMapping(value = "/list")
	public void empList(Model model) {

		// void로 설정하면 요청이 들어온 곳으로 갈거임
		model.addAttribute("empList", empService.getEmpList());
	}

	@GetMapping(value = "/{employeeId}") // 경로로 보냄
	public String empView(@PathVariable int employeeId, Model model) {

		model.addAttribute("emp", empService.getEmpInfo(employeeId));
		return "emp/view";

	}

	@GetMapping(value = "/search") // parameter로 보냄
	public String empSearch(Model model, int deptId) {
		model.addAttribute("deptList", empService.getDeptList(deptId));
		return "emp/search";
	}

	@GetMapping(value = "/name")
	public String empSearch(Model model, String keyword) {
		keyword = "%" + keyword + "%";
		model.addAttribute("deptList", empService.searchName(keyword));
		return "emp/search";
	}

	@GetMapping(value = "/insert")
	public String empInsert(Model model) {
		model.addAttribute("emp", new EmpVO());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("manList", empService.getAllManager());
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("message", "insert");
		return "emp/insert";

	}

	@PostMapping(value = "/insert")
	public String empInsert(@ModelAttribute("emp") @Valid EmpVO emp, BindingResult result,
			@RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes redirectAtt,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("jobList", empService.getAllJobId());
			model.addAttribute("manList", empService.getAllManager());
			model.addAttribute("deptList", empService.getAllDeptId());
			model.addAttribute("message", "insert");
			return "emp/insert";
		}
		if ((file != null) && (!file.isEmpty())) {
			try {
				emp.setEmpPic(file.getBytes());
				emp.setFileSize(file.getSize());
			} catch (IOException e) {
				e.printStackTrace();
				redirectAtt.addFlashAttribute("message", e.getMessage());
				redirectAtt.addFlashAttribute("exception", e.getMessage());
				throw new RuntimeException();
			}
		}
		empService.insertEmp(emp);
		redirectAtt.addFlashAttribute("message", "회원 저장 완료");
		return "redirect:/emp/list";
//command 객체 __ parameter 이름이랑 변수 이름이 같으면 됨 
	}

	@GetMapping("/update/{empId}")
	public String empUpdate(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManager());
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("message", "update");
		return "emp/insert";

	}

	@PostMapping(value = "/update")
	public String empUpdate(EmpVO emp) {
		empService.updateEmp(emp);
		return "redirect:/emp/" + emp.getEmployeeId();

	}

	@GetMapping(value = "/delete")
	public String modifyManager(int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		/* model.addAttribute("count", empService.get) */
		return "emp/delete";

	}

	@PostMapping(value = "/delete")
	public String deleteEmp(Model model, int empId) {
		empService.deleteEmp(empId);
		return "redirect:/emp/list";
	}

	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionString(Exception e, HttpServletRequest request, Model model) {
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("exception", e);
		return "error/runtime";

	}

	@GetMapping("/pic/{empId}")
	public ResponseEntity<byte[]> getPicture(@PathVariable int empId) {
		EmpVO emp = empService.getEmpInfo(empId);
		final HttpHeaders headers = new HttpHeaders();
		if (emp.getEmpPic() != null) {
			headers.setContentType(new MediaType("image", "jpg"));
			headers.setContentDispositionFormData("attachment", "프로필 사진");
			headers.setContentLength(emp.getFileSize());
			return new ResponseEntity<byte[]>(emp.getEmpPic(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/check")
	@ResponseBody
	public String idCheck(int empId) {
		return empService.checkId(empId) == 0 ? "true" : null;

	}
	
	@RequestMapping(value = "/json/list")
	public @ResponseBody List<EmpVO> getAllEmp(){
		List<EmpVO> empList = empService.getEmpList();
		return empList;
	}
	
	@RequestMapping(value = "/json/{employeeId}")
	public @ResponseBody EmpVO getEmployees(@PathVariable int employeeId) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		return emp;
	}
	
}