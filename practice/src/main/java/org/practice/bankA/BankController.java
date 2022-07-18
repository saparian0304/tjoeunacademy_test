package org.practice.bankA;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bank")
public class BankController {

	@RequestMapping("/list")
	public String aaa() {
		return "bankAjax/list";
	}
	
	@PostMapping(value="/html", 
			consumes = "application/json",
			produces = MediaType.TEXT_HTML_VALUE)
	public String getHtml(@RequestBody BankDTO dto) {
		System.out.println(dto.getData());
		return "bankAjax/" + dto.getData();
		
	}
}
