import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10870_피보나치수5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = fib(n);
		System.out.println(result);
	}
	
	public static int fib(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
}
