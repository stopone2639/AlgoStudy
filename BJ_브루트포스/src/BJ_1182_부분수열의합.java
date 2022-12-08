import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {
	static int[] num;
	static int N,S, cnt;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		subSet(0);
		if(S == 0) {
			cnt--;
		}
	}
	public static void subSet(int r) {
		if(r == N) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				if(selected[i]) {
					result += num[i];
				}
			}
			System.out.println(result);
			if(result == S) {
				cnt++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			selected[i] = true;
			subSet(r+1);
			selected[i] = false;
			subSet(r+1);
		}
	}
}
