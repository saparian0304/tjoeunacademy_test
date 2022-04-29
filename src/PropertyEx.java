
public class PropertyEx {

	public static void main(String[] args) {
		// System 클래스 : 모든 멤버가 static이라 객체를 생성할 수 없도록 한 클래스
		// System.in : 표준 입력 객체
		// System.out : 표준 출력 객체
		// getProperty() : JVM이 시작될때 자동으로 읽어와 설정되는 속성값
		
		// 자바 버전
		System.out.println(System.getProperty("java.version"));
		// JDK 경로
		System.out.println(System.getProperty("java.home"));
		// OS
		System.out.println(System.getProperty("os.name"));
		// 파일 구분자 (리눅스, 유닉스는 /)
		System.out.println(System.getProperty("file.separator"));
		// 사용자명
		System.out.println(System.getProperty("user.name"));
		// 사용자 홈 디렉토리
		System.out.println(System.getProperty("user.home"));
		// 현재 워크스페이스 디렉토리 위치
		System.out.println(System.getProperty("user.dir"));
		
	}

}
