import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10974_모든순열 {
	static int N;
	static int choice[];
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		choice = new int[N];
		pemu(0);
	}
	public static void pemu(int r) {
		if(r == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(choice[i] +  " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			choice[r] = i + 1;
			pemu(r+1);
			visit[i] = false;
		}
	}
}
