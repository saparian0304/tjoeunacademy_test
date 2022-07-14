package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	int register(ReplyVO vo);
	ReplyVO get(Long rno);
	int modify(ReplyVO vo);
	int remove(Long rno);
	
	List<ReplyVO> getList(Criteria cri, Long bno);
	List<ReplyVO> getListWithPaging( Criteria cri, Long bno);
}
