package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data

public class Restaurant {
	
	private String name;
	
	@Setter(onMethod_ = @Autowired)
//	@Autowired
	private Chef chef;
	
	
}
