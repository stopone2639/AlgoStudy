package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범검거_정지원 {
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};//상하 좌우
	static Queue<Pos> q;
	static int N, M, R, C, L;
	static int[][] arr, result;
	static boolean[][] visit;
	/*
	 * 소요시간만큼 bfs 돌리고 멈춘뒤 갯수 세어주고 출력
	 * 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 세로
			C = Integer.parseInt(st.nextToken()); //맨홀뚜껑 가로
			L = Integer.parseInt(st.nextToken()); //소요시간
			arr = new int[N][M];
			result = new int[N][M];
			visit = new boolean[N][M];
			q = new LinkedList<Pos>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q.add(new Pos(R, C, arr[R][C])); //큐에 1시간 때 있는 맨홀 구멍 위치 넣기
			result[R][C] = 1; //1시간에 위치했으니 결과 배열에 넣고 
			visit[R][C] = true; //방문처리
			int time = 1; // 1시간부터
			int cnt = 1; //cnt 1로
			if(L == 1) {
				System.out.printf("#%d %d\n", tc, cnt); //소요시간이 1이면 바로 출력
			} else {
				while(!q.isEmpty()) {
					time++; //시간 증가
					int size = q.size(); //큐 사이즈 
					for (int i = 0; i < size; i++) { //큐 사이즈만큼 반복
						Pos cur = q.poll();
						int r = cur.r;
						int c = cur.c;
						int num = cur.num;
						switch (num) {
						case 1:
							up(r,c,time);
							down(r,c,time);
							left(r,c,time);
							right(r,c,time);
							break;
						case 2:
							up(r,c,time);
							down(r,c,time);
							break;
						case 3:
							left(r,c,time);
							right(r,c,time);
							break;
						case 4:
							up(r,c,time);
							right(r,c,time);
							break;
						case 5:
							down(r,c,time);
							right(r,c,time);
							break;
						case 6:
							down(r,c,time);
							left(r,c,time);
							break;
						case 7:
							up(r,c,time);
							left(r,c,time);
							break;
						}
					}
					if(time == L) {
						break;
					}
					
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(result[i][j] > 1) {
							cnt++;
						}
					}
				}
				System.out.printf("#%d %d\n", tc, cnt);
			}
			
			
			
		}
		

	}
	public static class Pos {
		int r, c ,num;

		public Pos(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
	}
	public static void up(int r , int c, int time) { //위로 가는 메소드
		r += dir[0][0];
		c += dir[0][1];
		if(arrayArea(r, c) && arr[r][c] != 3 && arr[r][c] !=4 && arr[r][c] != 7 && !visit[r][c] && arr[r][c] !=0) {
			q.add(new Pos(r,c,arr[r][c]));
			visit[r][c] = true;
			result[r][c] = time;
		}
	}
	public static void down(int r , int c, int time) { //아래로 가는 메소드
		r += dir[1][0];
		c += dir[1][1];
		if(arrayArea(r, c) && arr[r][c] != 3 && arr[r][c] !=5 && arr[r][c] != 6 && !visit[r][c] && arr[r][c] !=0) {
			q.add(new Pos(r,c,arr[r][c]));
			visit[r][c] = true;
			result[r][c] = time;
		}
	}
	public static void left(int r , int c, int time) { //왼쪽으로 가는 메소드
		r += dir[2][0];
		c += dir[2][1];
		if(arrayArea(r, c) && arr[r][c] != 2 && arr[r][c] !=6 && arr[r][c] != 7 && !visit[r][c] && arr[r][c] !=0) {
			q.add(new Pos(r,c,arr[r][c]));
			visit[r][c] = true;
			result[r][c] = time;
		}
	}
	public static void right(int r , int c, int time) { //오른쪽으로 가는 메소드
		r += dir[3][0];
		c += dir[3][1];
		if(arrayArea(r, c) && arr[r][c] != 2 && arr[r][c] !=4 && arr[r][c] != 5 && !visit[r][c] && arr[r][c] !=0) {
			q.add(new Pos(r,c,arr[r][c]));
			visit[r][c] = true;
			result[r][c] = time;
		}
	}
	public static boolean arrayArea(int r, int c) { //배열 안인지 체크해주는 메소드
		return r >=0 && r<N && c>=0 && c<M;
	}

}
