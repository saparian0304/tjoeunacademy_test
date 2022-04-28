package cloud;

public class Main2 {

	public static void main(String[] args) {
		// 속도(m/s) = 거리(m) / 시간(s)
	    double meter = 100;
	    double sec = 18;
	    double km = meter / 1000;
	    double hour = sec / 3600;
	    // 속도(km/h) = 거리(km) / 시간(h)
	    double sisok = km /hour;

	    // 결과 출력
	    System.out.println(sisok + " km/h");

	}

}
