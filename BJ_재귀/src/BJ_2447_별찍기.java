import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
 * 시간 초과 발생하면 스트링 빌더 이용해서 한번에 출력하기
 */
public class BJ_2447_별찍기 {
	static String[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(star(N, i, j)) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean star(int n, int x, int y) {
		if(n == 1) {
			return true;
		}
		if(x/(n/3) == 1 && y/(n/3) == 1) {
			return false;
		} else if(x >= (n/3) && y>=(n/3)) {
			return star(n/3, x%(n/3), y%(n/3));
		} else if(x >= (n/3)) {
			return star(n/3, x%(n/3), y);
		} else if(y >= (n/3)) {
			return star(n/3, x, y%(n/3));
		} else {
			return star(n/3, x, y);
		}
			
	}
	
	/*public static String emptyArea(int n) {
		sbE= new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sbE.append(" ");
			}
			if(i != n-1) {
				sbE.append("\n");
			}
		}
		String empS = sbE.toString(); 
		return empS;
	}*/
}
