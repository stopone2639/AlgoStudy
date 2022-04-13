

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2960_에라토스테네스의체_정지원 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[] = new int[n+1];
		int result[] = new int[n+1];
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		int cnt = 1;
		for (int i = 2; i <=n; i++) {
			for (int j = i; j <=n; j+=i) {
				if(arr[j] == 0)continue;
				result[cnt] = arr[j];
				arr[j] = 0;
				cnt++;
			}
		}
		System.out.println(result[k]);
		

	}

}
