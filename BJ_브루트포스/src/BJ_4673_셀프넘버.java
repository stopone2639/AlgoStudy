import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4673_셀프넘버 {
	static boolean[] self;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		self = new boolean[99999];
		for (int i = 1; i < 10001; i++) {
			int sum = i;
			int index = i;
			while(true) {
				int a = index%10;
				index = index/10;
				sum += a;
				if(index < 1) {
					break;
				}
			}
			self[sum] = true;
		}
		for (int i = 1; i < 10001; i++) {
			if(!self[i]) {
				System.out.println(i);
			}
		}
		
	}
}
