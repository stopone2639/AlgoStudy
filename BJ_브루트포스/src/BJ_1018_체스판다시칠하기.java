import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 왼쪽 맨위를 바꿀지 안바꿀지 기준으로 해서 안바꾸면 왼쪽위와 홀수 거리면 다른거 짝수거리면 같은 거로 change 바꾸면 홀수 거리 같은거 짝수 거리 다른거 해서 change2 둘이 비교해서 최솟값으로
 */
public class BJ_1018_체스판다시칠하기 {
	static int N, M, min;
	static char[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] c = s.toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = c[j];
			}
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				chess(i,j);
			}
		}
		System.out.println(min);
	}
	public static void chess(int r, int c) {
		if(r+7 >= N || c+7 >= M) {
			return;
		}
		int change = 0;
		int change2 = 0;
		for (int i = r; i < r+8; i++) {
			for (int j = c; j < c+8; j++) {
				int sum = (i-r) + (j-c);
				if(sum%2 == 0) {
					if(arr[r][c] != arr[i][j]) {
						change +=1;
					} else {
						change2 +=1;
					}
				} else {
					if(arr[r][c] == arr[i][j]) {
						change +=1;
					} else {
						change2 +=1;
					}
				}
			}
		}
		int result = Math.min(change, change2);
		min = Math.min(min, result);
	}
}
