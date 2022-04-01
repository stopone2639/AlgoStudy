package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동_정지원 {
	/*
	 * bfs 0,0부터 인접한 부분이 열릴지 안열리지 판단
	 * 
	 */
	static int N, R, L;
	static int[][] arr;
	static boolean[][] visit; // 방문 처리 배열
	static ArrayList<Pos> list; // 유니온 될 Pos 담을 배열

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static boolean arrayArea(int r, int c) { // 배열 안 인지 체크

		return r >= 0 && r < N && c >= 0 && c < N;

	}

	public static int bfs(int i, int j) {

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i, j)); // 큐에 i,j 값넣고
		visit[i][j] = true; // 방문처리
		int sum = arr[i][j]; // 유니온의 합에 넣어주기
		list.add(new Pos(i, j)); // 유니온 리스트에도 넣어주기
		while (!q.isEmpty()) {

			Pos cur = q.poll(); // 초기값 꺼내와서
			int x = cur.x;
			int y = cur.y;

			for (int k = 0; k < 4; k++) {

				int nx = x + dir[k][0]; // 이동
				int ny = y + dir[k][1];

				if (arrayArea(nx, ny) && Math.abs(arr[x][y] - arr[nx][ny]) >= L
						&& Math.abs(arr[x][y] - arr[nx][ny]) <= R && !visit[nx][ny]) { //차이가 레프트와 라이트 사이이고 배열의 범위 안에 있고 방문하지 않았으면
					q.add(new Pos(nx, ny)); //큐에 넣어주고
					sum += arr[nx][ny]; //총 값에 더해주고
					visit[nx][ny] = true; //방문처리
					list.add(new Pos(nx, ny)); //리스트에도 추가
				}

			}
		}

		return sum;

	}

	public static boolean canmove() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int k = 0; k < 4; k++) {

					int nr = i + dir[k][0];
					int nc = j + dir[k][1];

					if (arrayArea(nr, nc) && Math.abs(arr[i][j] - arr[nr][nc]) >= L
							&& Math.abs(arr[i][j] - arr[nr][nc]) <= R) {
						return true;
					}
				}

			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		int cnt = 0;
		while (canmove()) {
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (visit[i][j] != true) {
						list = new ArrayList<>();
						int sum = bfs(i, j);

						int unionNum = list.size();
						int avgNum = sum / unionNum;
						for (int k = 0; k < list.size(); k++) {

							Pos pa = list.get(k);
							arr[pa.x][pa.y] = avgNum;

						}

					}
				}
			}

			cnt++;
		}

		System.out.println(cnt);

	}
}
