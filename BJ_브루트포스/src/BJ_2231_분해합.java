import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2231_분해합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int num = i;
			int sum = i;
			while(num >= 1) {
				sum += num%10;
				num = num/10;
			}
			if(sum == N && min > i) {
				min = i;
			}
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
		
	}
}
