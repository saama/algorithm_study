package algoritmExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Exam13_Bellman_Ford_Algorithm_11655_ing {
	
//	3 4
//	1 2 4
//	1 3 3
//	2 3 -1
//	3 1 -2
	
	static int N,M;
	static int dist[];
	static Vector3[] array;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //3 4에서 3을받음
		M = Integer.parseInt(st.nextToken()); //4를 받음
		
		dist = new int[N+1];
		dist[1] = 0; //시작점 1 값
		//초기화
		for(int i = 2; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		boolean isCycle = false;
		array = new Vector3[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = new Vector3(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i <= N; i++) { //음수 사이클 판정을 위해 N번째도 수행
			for(int j = 0; j < M; j++) {
				if(dist[array[j].A] != Integer.MAX_VALUE && dist[array[j].B] > dist[array[j].A]+array[j].C) {
					dist[array[j].B] = dist[array[j].A]+array[j].C;
					if(i==N) {
						isCycle = true;
					}
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(isCycle) {
			bw.write("-1");
		} else {
			for(int i = 2; i < dist.length; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					bw.write("-1"+"\n");
				} else {
					bw.write(dist[i]+"\n");
				}
				
			}
		}
		
		br.close();
		bw.close();
		
	}

}

class Vector3 {
	int A,B,C;

	public Vector3(int a, int b, int c) {
		super();
		A = a;
		B = b;
		C = c;
	}
	
}