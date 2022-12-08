import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_10872_팩토리얼 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = fac(N);
		System.out.println(result);
	}
	public static int fac(int N) {
		if(N == 0) {
			return 1;
		}
		return N * fac(N-1);
	}
}
