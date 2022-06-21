package utils;

public class BoardPage {
	public static String pagingStr(int totalCount, int pageSize, 
						int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";	// 마지막에 리턴할 문자열 (페이징 처리가 된)
		
		// 전체 페이지수 계산
		int totalPages = (int)(Math.ceil((double) totalCount / pageSize));
		
		// 이전 페이지 블록 바로가기 출력 
		int pageTemp = (((pageNum-1) / blockPage) * blockPage) + 1;
		if (pageTemp != 1) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=1'>[첫 페이지]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) 
						+ "'>[이전 블록]</a>";
		}
		// 현재 블럭의 시작 페이지
		int blockCount = 1;
		while (blockCount <= blockPage && pageTemp <= totalPages) {
			if (pageTemp == pageNum) {
				// 현재 페이지는 링크를 걸지 않음
				pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
			} else {
				pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" +pageTemp
							+ "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		// 현재 블럭의 마지막 페이지가 총 페이지 수 이하이면
		if (pageTemp <= totalPages) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp
						+ "'>[다음 블록]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages 
						+ "'>[마지막 페이지]</a>";
		}
		
		return pagingStr;
	}
}
