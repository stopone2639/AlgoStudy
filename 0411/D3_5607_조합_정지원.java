package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5607_조합_정지원 {
	static int P = 1234567891;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= Tc; tc++) {
			st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long[] fac = new long[n+1];
			fac[1] = 1;
			for (int i = 2; i <= n; i++) {
				fac[i] = (fac[i-1] * i) % P;
			}
			long under = (fac[r] * fac[n-r]) % P;
			under = pow(under, P-2);
			System.out.printf("#%d %d\n", tc, fac[n] * under % P);
		}
	}
	public static long pow(long a, int b) {
		if(b ==0) {
			return 1;
		} else if(b == 1) {
			return a;
		} 
		if(b % 2 == 0) {
			long temp = pow(a, b/2);
			return (temp * temp) % P;
		}
		
		long temp = pow(a, b-1) % P;
		return (temp * a) % P;
		
		
	}

}
