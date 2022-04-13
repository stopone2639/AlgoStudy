package ws_04_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기_정지원 {
	static Pos[] pos;
	static int n;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine()); 
		StringTokenizer st = null;
		for (int tc = 1; tc <= Tc; tc++) {
			n = Integer.parseInt(br.readLine()); //편의점 갯수
			pos = new Pos[n+2];
			visit = new boolean[n+2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pos[i] = new Pos(a,b);
			}
			bfs();
			if(visit[n+1]) {
				System.out.println("happy");
			} else if(!visit[n+1]){
				System.out.println("sad");
			}
		}
	}
	
	public static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(pos[0].getR(), pos[0].getC()));
		visit[0] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i <n+2; i++) {
				if(!visit[i] && (Math.abs(cur.r - pos[i].r) + Math.abs(cur.c - pos[i].c)) <= 1000) {
					q.add(new Pos(pos[i].r, pos[i].c));
					visit[i] = true;
				}
			}
		}
	}
	public static class Pos{
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}
		
		
	}

}
