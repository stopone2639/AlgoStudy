package com.ssafy.hw;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class D4_5643_키순서_정지원 {
	/*
	 * 밑에서 숫자에 대해 올라오는 방향들과 숫자에서 올라가는 방향 들을 모두 더해서 n-1과 같으면 
	 * 순위가 결정되는 학생이고 그 학생의 수를 출력
	 * 
	 * 
	 * */
	static int n, m;
	static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {
			n = Integer.parseInt(br.readLine()); //학생수
			m = Integer.parseInt(br.readLine()); //비교 횟수
			arr = new int[n+1][n+1];
			StringTokenizer st = null;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); //from
				int b = Integer.parseInt(st.nextToken()); //to
				arr[a][b] = 1;
			}
			int result= 0;
			for (int i = 1; i <= n; i++) {
				int total = down(i) + up(i); //위 아래 방향의 갯수가
				if(total == n-1) { // n-1개면 순위를 알수 있음 
					result++; //더해주기
				}
			}
			System.out.printf("#%d %d\n", tc, result);
		}
		
		
	}
	
	
	public static int down(int num) { //아래에서 숫자를 향해 오는 것들 갯수 세기
		int cnt = 0;
		boolean visit[] = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if(arr[i][cur] ==1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	public static int up(int num) { //숫자에서 위로 향하는 갯수 세기
		int cnt = 0;
		boolean visit[] = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		visit[num] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if(arr[cur][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

}
