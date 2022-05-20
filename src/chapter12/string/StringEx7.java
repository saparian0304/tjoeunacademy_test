package chapter12.string;

import util.FileUtil;

public class StringEx7 {
	// java.lang.String 클래스
	public static void main(String[] args) {
		
		String str = "Hello My Name is Hong Gil Dong";
		
		System.out.println(str.charAt(6));	// 6번 인덱스의 문자
		System.out.println(str.equals("Hello My Name is Hong Gil Dong"));	// 문자열 값 비교
		System.out.println(str.indexOf("Hong"));	// "Hong" 문자열의 위치
		System.out.println(str.indexOf('H'));		// 'H' 문자의 우치
		System.out.println(str.substring(17));		// 17번 인덱스부터 끝까지 잘라냄
		System.out.println(str.substring(6, 13));	// 6번 인덱스부터 13번전(12번 인덱스)까지 문자열
		System.out.println(str.toLowerCase());		// 소문자로 변경
		System.out.println(str.toUpperCase());		// 대문자로 변경
		System.out.println(str.length());			// 문자열의 길이
		System.out.println(str.startsWith("Hello"));// "Hello"로 시작하는지 여부
		System.out.println(str.endsWith("Dong"));	// "Dong"으로 끝나는지 여부
		System.out.println(str.replace("Hong", "Kim"));	// "Hong"을 "Kim"으로 치환
		System.out.println(str.replaceAll("Name", "NickName"));	// "Name"을 "NickName"으로 치환
		System.out.println(str.toString());
		
		str = "   안녕 하세요,       반갑습니다.      ";
		System.out.println(str.trim());	// 앞뒤 공백 제거
		// 모든 공백을 제거하는 방법
		System.out.println(str.replace(" ", ""));
		
		str = String.valueOf(10);
		str = String.valueOf(10.5);
		
		str = "홍길동,이순신,유관순,안중근";
		String[] arr = str.split(",");
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+"번 인덱스 값 = " + arr[i]);
		}
		
		// indexOf() : ~의 인덱스 -> 활용해서 특정 단어를 포함됐는지 확인이 가능함
		String text = "너는 어떻고 저떻고 바보구나";
		if (text.indexOf("바보")>-1) {
			System.out.println("당신은 욕을 사용했습니다.");
		}
				
		text = "      서울시 종로구     ";
		String text2 = "서울시 종로구";
		System.out.println(text.equals(text2));
		System.out.println(text.trim().equals(text2));
		
		text = "2,000";
		int price = Integer.parseInt(text.replace(",", ""));
		System.out.println(price);
		
		text = "    서  울    시 종  로 구     ";
		System.out.println(text.trim());
		System.out.println(text.replace(" ", ""));
		
		String param = "낚시,게임,영화,독서";
		System.out.println(param.split(",").length);
		System.out.println(param.split(",")[0]);
		
		
		/*
		 파일 업로드에서 서버에 저장 시나리오
		 파일명 : 내사진.jpg
		 서버파일명 : 밀리세컨초(System.currentTimeMillis())
		 -> 예시) 내사진.jpg -> 1652944810458.jpg
		          워크샵.hwp -> 1652944810458.hwp
		 */
		String fileName = "내사진.hwp";
		// 출력
		String serverName = "";

		// 1번째 방법
		// System.out.println(fileName.indexOf("."));
		// 파일명 System.currentTimeMillis()을 문자열로 변환
		// 인덱스를 찾아서 이후까지 잘라서 붙이기
		serverName = System.currentTimeMillis()+fileName.substring(fileName.indexOf("."));
		System.out.println(serverName);
				
		// 두번째 방법
		fileName = "내사진.hwp";
		String serverName2 = "";

		// 파일명 System.currentTimeMillis()을 문자열로 변환
		// split()에서 "."을 인식하지 못해서 "@@"로 변환한뒤 "@@"로 자름
		fileName = fileName.replace(".", "@@");
		serverName2 = System.currentTimeMillis()+"."+fileName.split("@@")[1];
		System.out.println(serverName2);
		
		// 강사님 풀이
		fileName = "내사진.hwp";
		serverName = "";
		int idx = fileName.indexOf(".");
		String ext = fileName.substring(idx);
		serverName = System.currentTimeMillis() + ext;
		System.out.println("강사님 풀이 : " + serverName);
		
		
		
		// 다른문제
		String fileName2 = "내사진2022.05.19.jpg";
		
		// 첫번째 방법
		// 파일명 System.currentTimeMillis()을 문자열로 변환
		// "."을 기준으로 다 자른다음 배열[배열의 길이-1]를 사용
		// split() 매서드 이용시 "."을 기준으로 자르려면 "[.]" 로 표현해야함 -> 정규식이기 때문
		// 어차피 문자열에 + 연산을 하기때문에 String.valueOf() 연산을 할 필요가 없었음...
		serverName2 = System.currentTimeMillis()+"."+fileName2.split("[.]")[fileName2.split("[.]").length-1];
		System.out.println(serverName2);
		
		// 두번째 방법
		// lastIndexOf() 메서드 사용 
		fileName2 = "내사진2022.05.19.jpg";
		serverName2 = System.currentTimeMillis()+"."+fileName2.substring(fileName2.lastIndexOf(".")+1);
		System.out.println(serverName2);
		
		// 강사님 풀이
		fileName2 = "내사진2022.05.19.jpg";

		idx = fileName2.lastIndexOf(".");
		String ext2 = fileName2.substring(idx);
		serverName2 = System.currentTimeMillis() + ext2;
		System.out.println("강사님 풀이 : " + serverName2);
		
//		여러파일을 동시에 올릴 경우 파일명이 겹칠 수 있음
//		1. nano초 단위로 파일명 올리기
//		serverName2 = System.nanoTime() + ext2;
//		2. for문을 이용해서 파일명마다 카운트 올리기
		String[] fileName3 = {"내사진2022.05.19.jpg", "내사진2022.05.19.jpg", "내사진2022.05.19.jpg",
				"내사진2022.ppt", "내사진2022.jpg", "내사진2022.png"};
		String serverName3 = "";
		int cnt = 0;
		for (int i=0; i<fileName3.length; i++) {
			idx = fileName3[i].lastIndexOf(".");
			String ext3 = fileName3[i].substring(idx);
			serverName3 = System.currentTimeMillis()+"_"+cnt + ext3;	// 카운트방식
			System.out.println(serverName3);
			serverName3 = System.currentTimeMillis()+"_"+(int)(Math.random()*1000)+ ext3; // 랜덤방식
			System.out.println(serverName3);
			cnt++;
		}
		
		System.out.println("메서드 실행");
		upLoad("실행하자.jpg");
		
		
		// 다른 패키지(util)에서 만든 메서드 실행
		System.out.println("다른 패키지(util)에서 만든 메서드 실행");
		System.out.println(FileUtil.getFileRename("우리처음만난날.jpg"));
	}
	
	// 메서드 만들기
	static void upLoad(String[] fileName) {
		String serverName3 = "";
		int idx;
		int cnt = 0;
		for (int i=0; i<fileName.length; i++) {
			idx = fileName[i].lastIndexOf(".");
			String ext3 = fileName[i].substring(idx);
			serverName3 = System.currentTimeMillis()+"_"+cnt + ext3;	// 카운트방식
			System.out.println(serverName3);
	//			serverName3 = System.currentTimeMillis()+"_"+(int)(Math.random()*1000)+ ext3; // 랜덤방식
	//			System.out.println(serverName3);
			cnt++;
		}
	}
	// 만든 메서드 오버로딩
	static void upLoad(String fileName) {
		String serverName3 = "";
		int idx = fileName.lastIndexOf(".");
		String ext3 = fileName.substring(idx);
		serverName3 = System.currentTimeMillis()+"_"+(int)(Math.random()*1000)+ ext3; // 랜덤방식
		System.out.println(serverName3);
	}
}
