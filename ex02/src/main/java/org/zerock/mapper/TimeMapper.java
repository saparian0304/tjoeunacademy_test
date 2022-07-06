package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	// XML 형식으로 SQL 매핑
	public String getTime2();
}
