import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 조합에서 뽑는 갯수가 정해져있으면 for문으로도 가능하지만 재귀를 통해 구현이 가변적일 경우도 가능해서 재귀로 구현
 */
public class BJ_2798_블랙잭 {
	static int N, M, max;
	static int[] input, choice;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		choice = new int[3];
		for (int i = 0; i <N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
//		for (int i = 0; i < N; i++) {
//			for (int j = i+1; j < N; j++) {
//				for (int k = j+1; k < N; k++) {
//					int sum = arr[i] + arr[j] + arr[k];
//					if(sum > max && sum <= M) {
//						max = sum;
//					}
//				}
//			}
//		}
		comb(0, 0);
		System.out.println(max);
	}
	public static void comb(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += choice[i];
			}
			if(sum > max && sum <= M) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = input[i];
			comb(cnt + 1, i+1);
		}
	}
	
	
}
