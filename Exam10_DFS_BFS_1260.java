package algoritmExam;

import java.util.*;


public class Exam10_DFS_BFS_1260 {
	static boolean visited[];
	static ArrayList<Integer>[] adj; //ArrayList<Integer>를 담는 배열을 선언한것
	static Queue<Integer> Q; //큐는 FIFO, 동그라미로 생각
	public static void main(String[] args) {
//	입력값
//		4 5 1
//		1 2
//		1 3
//		1 4
//		2 4
//		3 4
		
//		↓이모양이됨
//		 ───          ─── 
//		│ 1 │ ────── │ 2 │
//		 ─── \        ─── 
//		  │    \       │  
//		  │      \     │  
//	     ───       \  ─── 
//	    │ 3 │ ────── │ 4 │
//	     ───          ─── 
		 
		
		Scanner sc = new Scanner(System.in);
		//N 정점의 갯수 , M 간선의 갯수 V 시작지점
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		//인접리스트배열 초기화
		//계산하기 쉽도록 1부터
		adj = new ArrayList[N + 1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		//인접리스트 초기화
		/*
		 * [2, 3, 4] 
		 * [1, 4] 
		 * [1, 4] 
		 * [1, 2, 3]
		 */
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		for (int i = 0; i < M; i++) {
			System.out.println(adj[i]);
		}
		//인접리스트 정렬
		for(int i=1; i<N; i++) Collections.sort(adj[i]);
		visited = new boolean[N + 1];
		Q = new LinkedList<Integer>();
		//V는 시작점 (현재 1)
		DFS(V);
		System.out.println();
		reset(N);
		BFS(V);
		System.out.println();
		sc.close();
	}
	
	//visited배열 초기화
	public static void reset(int N) {
		for(int i=1; i<=N; i++) visited[i] = false;
	}
	
	public static void DFS(int x) {
		visited[x] = true; //방문함~
		System.out.print(x + " "); //현재 정점 출력~
		//adj가 솔팅되어있으므로 visited y는 작은숫자부터 동작
		for(int y : adj[x]) {
			//visited가 false일때 -> 즉 방문하지 않았을때 재귀호출
			if(!visited[y]) {
				DFS(y);
			}
		}
	}
	
	public static void BFS(int sx) {
		Q.add(sx);
		visited[sx] = true;
		while(!Q.isEmpty()) {
//			System.out.println("Q = "+Q);
			int x = Q.poll();
//			System.out.print(x + " ");
			for(int y : adj[x]) {
				//해당 인접리스트에서 방문하지 않은 애들은 다 방문할려고함
				if(!visited[y]) {
					visited[y] = true;
					Q.add(y);//Q에는 이제 x의 방문안했던 인접리스트들이 전부 들어간다
					//-> 그러나 이전 x의 아직 방문안했던 인접리스트들이 남아있을수 있으나 FIFO구조 이므로 먼저 들어왔던 정점이 먼저 poll됨
				}
			}
		}
	}
}

