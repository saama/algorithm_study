package algoritmExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Exam13_Bellman_Ford_Algorithm_11655_ing {

//첫번째 예제
//3 4
//1 2 4
//1 3 3
//2 3 -1
//3 1 -2

//두번째 예제	
//3 4
//1 2 4
//1 3 3
//2 3 -4
//3 1 -2

//세번째 예재
//3 2
//1 2 4
//1 2 3

	static int N,M;
	static int dist[];
	static Vector3[] array;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의갯수
		M = Integer.parseInt(st.nextToken()); //간선의갯수
		
		dist = new int[N+1]; //각 정점의 최단경로 추정값이 들어가는 배열
		dist[1] = 0; //시작점 1 값
		//초기화
		for(int i = 2; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE; //가장큰값
		}
		
		boolean isCycle = false;
		array = new Vector3[M]; //정점간 가중치의 정보를 닮고있는 배열
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = new Vector3(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		System.out.println("초기화된 dist "+Arrays.toString(dist));
		System.out.println("시작점 끝점 가중치 "+Arrays.toString(array));
		System.out.println("==============================");
		for(int i = 0; i <= N; i++) { //정점의 갯수만큼 -> 모든 정점을 relax
			for(int j = 0; j < M; j++) { //간선의 갯수만큼 -> 각 정점에 대한 relax작업
				if(dist[array[j].s] != Integer.MAX_VALUE && dist[array[j].e] > dist[array[j].s]+array[j].v) { //다음정점이 이전정점과 간선보다 크면 다음간선 업데이트
					dist[array[j].e] = dist[array[j].s]+array[j].v;
					System.out.println("array["+j+"] "+array[j]+" 업데이트됐을때 dist "+Arrays.toString(dist));
					if(i==N) {
						isCycle = true;
						System.out.println("음수사이클이 돌았을때 dist "+Arrays.toString(dist));
						//##마지막 정점까지 왔는데도 다음간선이 업데이트되는 작업을 계속 수행하므로 음의 사이클##
					}
				}
			}
		}
		System.out.println("최종 dist "+Arrays.toString(dist));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(isCycle) {
			bw.write("-1"); //음수 사이클이 돌아 -1출력
		} else {
			for(int i = 2; i < dist.length; i++) {
				if(dist[i] == Integer.MAX_VALUE) { //해당 정점에 도달하지못해 아직도 무한대 값이 있을때
					bw.write("-1"+"\n");
				} else {
					bw.write(dist[i]+"\n"); //정상출력
				}
				
			}
		}
		br.close();
		bw.close();
	}
}
class Vector3 {
	int s,e,v;

	public Vector3(int s, int e, int v) {
		super();
		this.s = s; //시작
		this.e = e; //끝
		this.v = v; //가중치
	}
	@Override
	public String toString() {
		return "[s=" + s + ", e=" + e + ", v=" + v + "]";
	}
}
