package kr.co.pet.recommend;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommendMapper {

	/**
	 * 게시글 / 댓글 좋아요 통합.
	 * 게시글 좋아요는 reply_no값 0으로 구분(기본값)
	 * @param vo RecommendVO
	 * @return int
	 */
	int insertRec(RecommendVO vo);		

	/**
	 * 게시글 / 댓글 좋아요 해제기능 통합.
	 * 게시글 좋아요는 reply_no값 0으로 구분(기본값)
	 * @param vo RecommendVO
	 * @return int
	 */
	int cancleRec(RecommendVO vo);
	
	/**
	 * 게시글 / 댓글이 좋아요를 받은 개수.
	 * reply_no 파라미터 값이 0이면 게시글을 뜻함
	 * @param vo RecommendVO
	 * @return int
	 */
	int getRecCnt(RecommendVO vo);
	
	/**
	 * (통계)각 회원이 좋아요를 누른 총 횟수
	 * @param vo RecommendVO
	 * @return int
	 */
	int getMemberRecTotalCnt(RecommendVO vo); // 통계용
	
	/**
	 * (통계)각 회원이 좋아요를 누른 리스트
	 * @param vo RecommendVO
	 * @return List<RecommendVO>
	 */
	List<RecommendVO> getMemberRecList(RecommendVO vo); // 통계용
	
}
