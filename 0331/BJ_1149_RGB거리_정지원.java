package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리_정지원 {
	/*
	 * 광주 5반 정지원
	 * 1번집은 2번 집과 달라야 
	 * N번 집은 N-1번 집과 달라야
	 * i(2<=i<=N-1)번 집은 i-1과, i+1과 달라야함
	 * 자기랑 양쪽에 붙어 있는 집이랑 색이 다르면 됨
	 * 
	 * DP로 arr 배열에 데이터를 담고 i번째까지 합을 result에 
	 * result[1][x] 에 초기값인 arr[1][x]를 넣어주고  
	 * 2부터는 ex: result[i][0]이면 i에서 빨강을 선택하니 앞에 결과 result[i-1][1], result[i-1][2] 둘 중 최솟값과 arr[i][0]을 더해줘서 담아준다. 
	 * */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][3]; // 0 : 빨  1 : 초  2 : 파
		int result[][] = new int[n+1][3];
		for (int i = 1; i <=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result[1][0] = arr[1][0];
		result[1][1] = arr[1][1];
		result[1][2] = arr[1][2];
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			result[i][0] = Math.min(result[i-1][1], result[i-1][2]) + arr[i][0];
			result[i][1] = Math.min(result[i-1][0], result[i-1][2]) + arr[i][1];
			result[i][2] = Math.min(result[i-1][1], result[i-1][0]) + arr[i][2];
		}
		answer = Math.min(Math.min(result[n][0], result[n][1]), result[n][2]);
		System.out.println(answer);
		
		
	}

}