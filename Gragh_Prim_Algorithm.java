package algoritmExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Exam11_Gragh_Prim_Algorithm {
	static int N;
	static int E;
	static ArrayList<Node>[] nodeList;
	static boolean visit[];
	static int ans;
	static ArrayList<Node> array = new ArrayList<Node>();
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		
//		↓이모양이됨
		
//		 ───    10    ───    9     ─── 
//		│ 0 │ ────── │ 5 │ ────── │ 3 │ ── 
//		 ─── \        ───        / ─── 	  │
//		3 │    \ 7     │6    10/    │ 2   │
//		  │      \     │     /      │     │
//	     ───    2  \  ───  /  4    ───    │
//	    │ 4 │ ────── │ 1 │ ────── │ 2 │   │
//	     ─── \        ───          ───    │
//			   \                         /
//			  5  \		               /  
//		 		   \  ───      4     /
//		 		     │ 6 │ ─────────         
//		 		      ───         
		 /*데이터 입력 받기
		 * 정점, 간선...
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0; //최종 최소 비용 출력을 위한 변수
		N = Integer.valueOf(br.readLine()); //정점의 개수
		E = Integer.valueOf(br.readLine()); //간선의 개수
		visit = new boolean[N]; //방문체크용 배열
		
		nodeList = new ArrayList[N+1];
		//각 노드의 연결상태를 저장하는 ArrayList;
		
		for(int i = 0; i <= N; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		
		String [] tempStr;
		int start;
		int end;
		int value;
		for(int i=0; i<E; i++) {
			tempStr = br.readLine().split(" ");
			start = Integer.valueOf(tempStr[0]); //시작 정점
			end = Integer.valueOf(tempStr[1]); //시작과 연결된 정점
			value = Integer.valueOf(tempStr[2]); //가중치
			nodeList[start].add(new Node(start,end,value));
			// s 1 e 2 비용 2 를 nodeList[1]에 추가
			// 1] 2번노드,3번노드,4번노드
			nodeList[end].add(new Node(end,start,value));
			// s 2 e 1 비용 2 를 nodeList[2]에 추가
			// 2] 1번노드, 3번노드, 7번노드
		}
		
		/*최소비용신장트리 MST만들기*/
		MST();
	}
	
	public static void MST() {
		Comp cp = new Comp(); //우선순위 큐를 활용해서 Min Heap을 구현
		PriorityQueue<Node> pq = new PriorityQueue<>(cp); //비용이 가장 작은 간선을 바로 뽑기 위한 우선순위 큐 (보통 heap으로 구현)
		Deque<Integer> dq = new ArrayDeque<>(); //정점 모두를 방문하는데 쓸 큐 (Double Ended Queue)
		
		dq.add(0); //시작점을 0번으로 지정 -> 임의의 정점으로 시작하더라도 최소비용신장트리의 모양은 같음
		ArrayList<Node> tempList;
		Node tempNode;
		while(!dq.isEmpty()){
			//큐에서 하나 빼서 주변의 노드를 다 넣음
			int currentNode = dq.poll(); //최초 currentNode 는 1
			visit[currentNode] = true; //해당 노드 방문 처리해서 한 번 방문해서 간선이 연결된 노드는 다시 처리하지 않음
			System.out.println(Arrays.toString(visit));
			tempList = nodeList[currentNode]; //nodeList[1] = tempList = [2번노드,3번노드,4번노드]
			for (int i=0;i<tempList.size();i++) {
				if(!visit[tempList.get(i).e]) {
					System.out.println(tempList.get(i).toString()+" was added");
					pq.add(tempList.get(i)); //현재 노드에 연결된 모든 간선을 우선순위 큐에 add -> v가 작은것부터 들어감
				}
			}
			Iterator<Node> pqe = pq.iterator();
			while(pqe.hasNext()) {
				System.out.println(pqe.next().toString()); //0을 시작으로 4 1 2 3 6 5순서로 방문 
			}
			
			//가장 작은 간선 빼서 값은 답으로 출력, 노드는 방문처리
			//만약 이미 방문한 것 중 작은 값이 나왔을 경우 한번 더 빼서 또 확인
			while(!pq.isEmpty()) {
				tempNode = pq.poll(); //tempNode 는 현재 까지 진행한 노드에 연결된 간선중 가장 작은 값을 가진 노드
				System.out.println(tempNode.toString()+" was polled");
				if(!visit[tempNode.e]) {
					//선택할 간선에 연결된 정점이 이미 방문한 곳이면 아무것도 하지 않고
					//첫 방문이면 정점을 연결하고 연결된 간선이 최소 신장트리를 이루는 간선이므로 결과값에 더해줌
					visit[tempNode.e]=true;
					ans+= tempNode.v;
					dq.add(tempNode.e);
					break; //최소비용신장트리의 일부로 되었으므로 break되어 다음 pq에 있는 정점은 접근하지않음
				}
				//이미 선택되어 방문된 노드에서 최소값이 나왔을 경우 아무것도 안함
			}
			System.out.println("===========================");
		}
		System.out.println(ans);
	}
}

class Node {
	int s, e, v;
	public Node(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}
	@Override
	public String toString() {
		return "Node [s=" + s + ", e=" + e + ", v=" + v + "]";
	}
}

//비용에 대한 Min Heap을 만들기 위한 우선순위 큐의 Comparator
//위에서 작성된 Node클래스의 v를 기준으로 정렬하기 위함
class Comp implements Comparator<Node>{
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.v > o2.v ? 1 : -1;
	} 
}

