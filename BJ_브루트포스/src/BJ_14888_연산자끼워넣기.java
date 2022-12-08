import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	static int[] num, calc,use_calc, pemu_calc;
	static boolean[] visit;
	static int N, min, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		calc = new int[4];
		use_calc = new int[N-1];
		pemu_calc = new int[N-1];
		visit = new boolean[N-1];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		int cnt= 0;
		for (int i = 0; i < 4; i++) {
			if(calc[i] != 0) {
				for (int j = 0; j < calc[i]; j++) {
					use_calc[cnt] = i;
					cnt++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		pemu(0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void pemu(int r) {
		if(r == N-1) {
			int result = 0;
			for (int i = 0; i < N-1; i++) {
				if(i == 0) {
					if(pemu_calc[i] == 0) {
						result = num[i] + num[i+1];
					} else if(pemu_calc[i] ==1) {
						result = num[i] - num[i+1];
					} else if(pemu_calc[i] == 2) {
						result = num[i] * num[i+1];
					} else {
						result = num[i]/num[i+1];
					}
				} else {
					if(pemu_calc[i] == 0) {
						result += num[i+1];
					} else if(pemu_calc[i] ==1) {
						result -= num[i+1];
					} else if(pemu_calc[i] == 2) {
						result *=  num[i+1];
					} else {
						result /= num[i+1];
					}
				}
			}
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			return;
		}
		for (int i = 0; i < N-1; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			pemu_calc[r] = use_calc[i];
			pemu(r+1);
			visit[i] = false;
		}
	}
}
