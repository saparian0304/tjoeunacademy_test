package kr.co.project.board;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardPageDTO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private BoardVO vo;
	private int totalCount;
	
	public BoardPageDTO(BoardVO vo, int totalCount) {
		this.vo = vo;
		this.totalCount = totalCount;
		
		// endPage
		
		this.endPage = (int) (Math.ceil(vo.getPage() / 10.0)) * 10;
		this.startPage = this.endPage -9;
		int realEnd =(int)(Math.ceil((totalCount * 1.0) / vo.getRowPerPage())); 
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
}
