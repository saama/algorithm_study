package algoritmExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Exam12_Gragh_Kruskal_Algorithm {
	
//7
//11
//0 4 3
//0 5 10
//0 1 7
//4 1 2
//1 5 6
//1 2 4
//2 3 2
//1 3 10
//5 3 9
//4 6 5
//6 3 4
//결과값 : 21
			
//			↓이모양이됨
			
//			 ───    10    ───    9     ─── 
//			│ 0 │ ────── │ 5 │ ────── │ 3 │ ── 
//			 ─── \        ───        / ─── 	  │
//			3 │    \ 7     │6    10/    │ 2   │
//			  │      \     │     /      │     │
//		     ───    2  \  ───  /  4    ───    │
//		    │ 4 │ ────── │ 1 │ ────── │ 2 │   │
//		     ─── \        ───          ───    │
//				   \                         /
//				  5  \		               /  
//			 		   \  ───      4     /
//			 		     │ 6 │ ─────────         
//			 		      ───       
	
	static int N; //정점의 개수
	static int E; //간선의 개수
	static PriorityQueue<A> pq; //간선 값을 Min Heap으로 하는 우선순위 큐
	static int[] parent; //disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
	static boolean[] visit; //방문 여부 배열
	static int result; //결과저장
	
	public static int find(int a) {
		if(a==parent[a])  return a; //초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
		parent[a] = find(parent[a]); //find 할 때마다 부모는 최상위부모로 설정 (성능 향상)
		return parent[a]; //return find(parent[a]); <- 최상위 부모를 저장하지 않고 매번 여러 단계를 올라가 찾으면 시간 초과 발생
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parent[bRoot] = a; //b의 루트에 a를 넣는다
		}else{
			return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
//		parent = new int[5];
//		
//		for (int i = 0; i < parent.length; i++) {
//			parent[i] = i;
//		}
//		union(0,1);
//		union(2,3);
//		//[0, 0, 2, 2, 4] -> 0번째, 1번째중 0번째가 1의 부모, 2번째와 3번째중 2가 3의 부모 4는 부모가 자기자신
//		System.out.println(Arrays.toString(parent));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine()); //노드의 갯수
		E = Integer.valueOf(br.readLine()); //간선의 갯수
		
		parent = new int[N+1]; //Disjoint-set
		visit = new boolean[N+1];
		result = 0;
		
		pq = new PriorityQueue<A>();
		String [] tempStr;
		for (int i = 0; i < E; i++) {
			tempStr = br.readLine().split(" ");
			int s = Integer.valueOf(tempStr[0]);
			int e = Integer.valueOf(tempStr[1]);
			int v = Integer.valueOf(tempStr[2]);
			pq.add(new A(s,e,v));
		}//모든 간선에 대해  [시작, 끝, 비용]을 가진 클래스로 우선순위 큐에 add
		
//		Iterator<A> pqe = pq.iterator();
//		while(pqe.hasNext()) {
//			System.out.println(pqe.next().toString()); //0을 시작으로 4 1 2 3 6 5순서로 방문 
//		}
		
		for (int i = 0; i < N; i++) {
			parent[i]=i;
		} // union-find의 초기화는 일단 자기 자신의 부모노드는 자기 자신으로 설정
		
		for (int i = 0; i < E; i++) { //모든 간선에 대해서 확인
			A oneNode = pq.poll(); //무조건 가장작은 간선이 poll됨(큐안에 들어있는 순서는 상관없음)
			System.out.println(oneNode+" was polled");
			int start = oneNode.s;
			int end = oneNode.e;
			int a = find(start);
			int b = find(end);
			//※※※연결직전 두정점의 최상위 부모가 같다는것은 연결되면 cycle이 된다는 것을 의미※※※
			if(a==b) continue;
			
			union(start,end); //두개의 루트노드가 달랐다면 한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
			System.out.println("start : "+start+" end : "+end+" 연결됨"); //실제 연결되는 간선
			System.out.println("start의 루트: "+a);
			System.out.println("end의 루트: "+b);
			System.out.println("parent "+Arrays.toString(parent));
			result += oneNode.v; //선택된 간선이므로 간선의 비용을 더한다.
			
		}
		System.out.println(result);
	}
}

class A implements Comparable<A>{

	int s;
	int e;
	int v;
	
	public A(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	@Override
	public int compareTo(A o) { //min Heap을 만들기 위한 우선순위 큐용 Comparable 메서드
		// TODO Auto-generated method stub
		return o.v >= this.v ? -1 : 1;
	}
	
	@Override
	public String toString() {
		return "Node [s=" + s + ", e=" + e + ", v=" + v + "]";
	}
}


