package chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	@Autowired
	BoardMapper mapper;
}
