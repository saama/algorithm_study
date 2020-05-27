package algorithm;

import java.util.PriorityQueue;

public class Exam32_Programers_level3_5 {
// 	https://programmers.co.kr/learn/courses/30/lessons/42861
	public int solution(int n, int[][] costs) {
        int answer = 0;
        int E = costs.length;
        PriorityQueue<Node> pq; //간선 값을 Min Heap으로 하는 우선순위 큐
		int[] parent; //disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
		int result; //결과저장
		
		parent = new int[n+1]; //Disjoint-set
		result = 0;
		
		pq = new PriorityQueue<Node>();
		for (int i = 0; i < E; i++) {
			int s = costs[i][0];
			int e = costs[i][1];
			int v = costs[i][2];
			pq.add(new Node(s,e,v));
		}//모든 간선에 대해  [시작, 끝, 비용]을 가진 클래스로 우선순위 큐에 add
		
		for (int i = 0; i < n; i++) {
			parent[i]=i;
		} // union-find의 초기화는 일단 자기 자신의 부모노드는 자기 자신으로 설정
		
		for (int i = 0; i < E; i++) { //모든 간선에 대해서 확인
			Node oneNode = pq.poll(); //무조건 가장작은 간선이 poll됨(큐안에 들어있는 순서는 상관없음)
//			System.out.println(oneNode+" was polled");
			int start = oneNode.s;
			int end = oneNode.e;
			int a = find(parent,start);
			int b = find(parent,end);
			//※※※연결직전 두정점의 최상위 부모가 같다는것은 연결되면 cycle이 된다는 것을 의미※※※
			if(a==b) continue;
			
			union(parent,start,end); //두개의 루트노드가 달랐다면 한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
//			System.out.println("start : "+start+" end : "+end+" 연결됨"); //실제 연결되는 간선
//			System.out.println("start의 루트: "+a);
//			System.out.println("end의 루트: "+b);
//			System.out.println("parent "+Arrays.toString(parent));
			result += oneNode.v; //선택된 간선이므로 간선의 비용을 더한다.
			
		}
		answer = result;
        return answer;
    }
	
	public int find(int []parent,int a) {
		if(a==parent[a])  return a; //초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
		parent[a] = find(parent,parent[a]); //find 할 때마다 부모는 최상위부모로 설정 (성능 향상)
		return parent[a]; //return find(parent[a]); <- 최상위 부모를 저장하지 않고 매번 여러 단계를 올라가 찾으면 시간 초과 발생
	}
	
	public void union(int []parent,int a, int b) {
		int aRoot = find(parent,a);
		int bRoot = find(parent,b);
		if(aRoot != bRoot) {
			parent[bRoot] = a; //b의 루트에 a를 넣는다
		}else{
			return;
		}
	}
	
	public static void main(String[] args) {
		Exam32_Programers_level3_5 e = new Exam32_Programers_level3_5();
		int n=4;
		int [][] costs = {
							{0,1,1},
							{0,2,2},
							{1,2,5},
							{1,3,1},
							{2,3,8}
						};
		e.solution(n,costs);
	}
}

class Node implements Comparable<Node>{
	int s;
	int e;
	int v;
	public Node(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}
	@Override
	public int compareTo(Node o) { //min Heap을 만들기 위한 우선순위 큐용 Comparable 메서드
		// TODO Auto-generated method stub
		return o.v >= this.v ? -1 : 1;
	}
	@Override
	public String toString() {
		return "Node [s=" + s + ", e=" + e + ", v=" + v + "]";
	}
}
