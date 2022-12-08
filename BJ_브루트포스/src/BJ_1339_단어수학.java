import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
/*
 * 시간 초과가 난다.
 */
public class BJ_1339_단어수학 {
	static String[] eng = {"A", "B", "C", "D", "E", "F", "G", 
	     	                     "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	static int[] number, pemu_number;
	static int N, cnt, max;
	static boolean[] visit;
	static String[] input_eng;
	static ArrayList<String> use_eng;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input_eng = new String[N];
		use_eng = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			input_eng[i] = br.readLine();
		}
		for (int i = 0; i < N; i++) {
				for (int k = 0; k < 26; k++) {
					if(input_eng[i].contains(eng[k]) && !use_eng.contains(eng[k])) {
						use_eng.add(eng[k]);
					}
				}
		}
		cnt = use_eng.size();
		number = new int[cnt];
		pemu_number = new int[cnt];
		visit = new boolean[cnt];
		int input_num = 9;
		for (int i = 0; i < cnt; i++) {
			number[i] = input_num;
			input_num--;
		}
		max = Integer.MIN_VALUE;
		pemu(0);
		System.out.println(max);
	}
	public static void pemu(int r) {
		if(r == cnt) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String change_num = input_eng[i];
				for (int j = 0; j < cnt; j++) {
					if(change_num.contains(use_eng.get(j))) {
						change_num = change_num.replaceAll(use_eng.get(j), Integer.toString(pemu_number[j]));
					}
				}
				sum += Integer.parseInt(change_num);
			}
			if(sum > max) {
				max = sum;
			}
			return;
		}
		for (int i = 0; i < cnt; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			pemu_number[r] = number[i]; 
			pemu(r+1);
			visit[i] = false;
		}
		
	}
}
