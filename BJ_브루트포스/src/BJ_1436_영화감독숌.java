import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/*
 * 숫자를 문자열로 : Integer.toString
 * 
 */
public class BJ_1436_영화감독숌 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int index = 666;
		while(true) {
			String s = Integer.toString(index);
			if(s.contains("666")) {
				cnt++;
				if(cnt == N) {
					System.out.println(index);
					break;
				}
			}
			index++;
		}
		
		
	}
}
