import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 카운트를 먼저 출력하고 하노이 순서를 출력하기 위해 스트링 빌더를 사용해서 insert로 첫번째에 cnt를 넣어주기
 */
public class BJ_11729_하노이탑 {
	static int cnt = 0;
	static int[] from, to;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(N, 1, 2, 3);
		sb.insert(0, cnt  +"\n");
		System.out.println(sb.toString());
		
	}
	public static void hanoi(int n, int from, int temp, int to) {
		if(n == 0) {
			return;
		}	
		//n-1까지 temp로 이동
		hanoi(n-1, from, to, temp);
		//n을 to로 이동
		sb.append(from + " " + to + "\n");
		cnt++;
		//n-1까지 to로 이동
		hanoi(n-1, temp, from, to);
	}
	
}
