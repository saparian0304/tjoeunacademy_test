package chap06;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // 전체속성 일괄 적용
@JsonInclude(value = Include.NON_NULL)		// null이 아닌 값들만 json에 포함시킴
public class MemberVO {

	private String id;
	private String name;
	private String email;
	private String password;
	@JsonProperty("nick_name")
	private String nickName;	// 카멜표기법
	
}
