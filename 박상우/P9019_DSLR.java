package ����Ž��;

import java.io.*;
import java.util.*;

public class P9019_DSLR {
	static boolean[] visited;
	static String[] result;
	static int A,B;
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(A);
		visited[A] = true;
		result[A] = "";
		while(!q.isEmpty()) {
			int now = q.remove();
			if(now == B) return;
			for(int i = 0; i < 4; i++) {
				
				int next;
				if(i == 0) {//D
					next = (now * 2) % 10000;
				}else if(i == 1) {//S
					if(now == 0) next = 9999;
					else next = now -1;
				}else {//R
					int d1 = now / 1000;
					int d2 = (now - d1 * 1000) / 100;
					int d3 = ((now - d1 * 1000) - (d2 * 100)) / 10;
					int d4 = now % 10;
					if(i == 2) {//L
						next = 1000 * d2 + 100 * d3 + 10 * d4 + d1; 
					}else {
						next = 1000 * d4 + 100 * d1 + 10 * d2 + d3;
					}
				}
				if(visited[next]) continue;
				StringBuilder sb = new StringBuilder(result[now]);
				if(i == 0) {
					sb.append("D");
				}else if(i == 1) {
					sb.append("S");
				}else if(i == 2) {
					sb.append("L");
				}else {
					sb.append("R");
				}
				q.add(next);
				visited[next] = true;
				result[next] = sb.toString();
				
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A =  Integer.parseInt(st.nextToken());
			B =  Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			result = new String[10000];
			bfs();
			bw.write(result[B]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
