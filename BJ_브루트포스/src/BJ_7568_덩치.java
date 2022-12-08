import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568_덩치 {
	static int N;
	static int[] W, H, choice, rank;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		W = new int[N];
		H = new int[N];
		rank = new int[N];
		choice = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
			rank[i] = 1;
		}
		comb(0, 0);
		for (int i = 0; i < N; i++) {
			System.out.print(rank[i] + " ");
		}
		
		
	}

	public static void comb(int cnt, int start) {
		if(cnt == 2) {
			if(W[choice[0]] > W[choice[1]] && H[choice[0]] > H[choice[1]]) {
				rank[choice[1]] += 1;
			} else if(W[choice[0]] < W[choice[1]] && H[choice[0]] < H[choice[1]]) {
				rank[choice[0]] += 1;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			choice[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
