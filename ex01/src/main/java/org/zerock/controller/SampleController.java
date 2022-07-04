package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample")
@Slf4j 
public class SampleController {
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String basic() {
		log.info("basic............");
		return "home";
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic2() {
		log.info("basic get onlt get.......");
	}
	
	@GetMapping("/ex01")
//	public String ex01(@ModelAttribute("dto") SampleDTO dto) {
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "sample";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam(value="nickname", required = false) String name, @RequestParam(value="age", required = false, defaultValue = "0") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(HttpServletRequest req, Model model, @RequestParam String id) {
		model.addAttribute("idid", id);
		req.setAttribute("didi", id);
		log.info("여기는 ex03");
		
//		return "ex03";
		return "redirect:basic";	// 요청은 ex03으로 받지만 주소가 basic으로 이동되어서 응답한다.
	}

	@GetMapping("/ex06")
	@ResponseBody
	public List<SampleDTO> ex06() {
//	public SampleDTO ex06() {
//	public @ResponseBody SampleDTO ex06() {
		log.info("ex06...........");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		return list;
	}
}
