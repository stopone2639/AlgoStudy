import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	static int[] nanJang, choice ,realNanJang;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nanJang = new int[9];
		realNanJang = new int[7];
		choice = new int[7];
		for (int i = 0; i < 9; i++) {
			nanJang[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
		Arrays.sort(realNanJang);
		for (int i = 0; i < 7; i++) {
			System.out.println(realNanJang[i]);
		}
	}
	public static void comb(int r, int start) {
		if(r == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += choice[i];
			}
			if(sum == 100) {
				realNanJang = choice.clone();
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			choice[r] = nanJang[i];
			comb(r+1, i + 1);
		}
	}
}
