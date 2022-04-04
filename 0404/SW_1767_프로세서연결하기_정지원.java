package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767_프로세서연결하기_정지원 {
	static int[][] dir = {{-1, 0}, {1,0}, {0, -1},{0,1}}; // 상하 좌우
	static int coreMax, lineMin, N;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {
			N  = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			List<Pos> coreList = new ArrayList<Pos>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1 && i != 0 && i!=N-1 && j!=0 && j!=N-1) {
						coreList.add(new Pos(i, j));
					}
				} 
			}
			coreMax = Integer.MIN_VALUE;
			lineMin = Integer.MAX_VALUE;
			dfs(coreList, 0, 0, 0);
			System.out.printf("#%d %d\n", tc, lineMin);
			
		}	
	}
	public static void dfs(List<Pos> coreList, int idx, int coreCnt, int lineCnt) {
		if(idx == coreList.size()) {
			if(coreMax < coreCnt) {
				coreMax = coreCnt;
				lineMin = lineCnt;
			} else if(coreMax == coreCnt) {
				if(lineMin > lineCnt) {
					coreMax = coreCnt;
					lineMin = lineCnt;
				}
			}
			return;
		}
		Pos p = coreList.get(idx);
		for (int i = 0; i <4; i++) {
			int linePlus = check(p, i);
			if(linePlus != -1) {
				dfs(coreList, idx+1, coreCnt +1, lineCnt+linePlus);
				int r = p.r;
				int c = p.c;
				int d = i;
				while(true) {
					r += dir[d][0];
					c += dir[d][1];
					if(arrayArea(r, c)) {
						arr[r][c] = 0;
					} else {
						break;
					}
				}
			}
		}
		dfs(coreList, idx+1, coreCnt, lineCnt);
	}
	
	public static int check(Pos p, int d) {
		int r = p.r;
		int c = p.c;
		boolean flag = false;
		while(true) {
			r += dir[d][0];
			c += dir[d][1];
			if(r>= 0 && r< N && c>=0 && c< N) {
				if((r ==0 || r == N-1 || c == 0 || c == N-1) && arr[r][c] ==0) {
					flag = true;
					break;
				} else if(arr[r][c] !=0) {
					flag = false;
					break;
				}
			}
		}
		r = p.r;
		c = p.c;
		int linePlus = 0;
		if(flag) {
			while(true) {
				r += dir[d][0];
				c += dir[d][1];
				if(arrayArea(r, c)) {
					linePlus++;
					arr[r][c] = 2;
				} else {
					break;
				}
			}
			return linePlus;
		}
		return -1;
	}
	public static boolean arrayArea(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	static public class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
