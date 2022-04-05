package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2577_회전초밥_정지원 {
	/*
	 * 
	 * 
	 * */
	static int n, d,k, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] seleted = new int[d+1];
		int cnt = 1;
		seleted[c]++;
		for (int i = 0; i < k; i++) {
			if(seleted[arr[i]] == 0) {
				cnt++;
			}
			seleted[arr[i]]++;
		}
		int result = cnt;
	
		for (int i = k; i < n+k; i++) {
			if(seleted[arr[i-k]] == 1) {
				cnt--;
				seleted[arr[i-k]]--;
			}
			if(seleted[arr[i%n]] == 0) {
				cnt++;
				seleted[arr[i%n]]++;
			}
			if(cnt > result) {
				result = cnt;
			}
		}
		System.out.println(result);
	}
}
