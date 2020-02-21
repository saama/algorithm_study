package algoritmExam;

import java.util.Arrays;

public class Exam14_Dijkstra {
 
    public static void main(String[] args) {
         Graph g = new Graph(8);
            g.input(1, 2, 3);
            g.input(1, 5, 4);
            g.input(1, 4, 4);
            g.input(2, 3, 2);
            g.input(3, 4, 1);
            g.input(4, 5, 2);
            g.input(5, 6, 4);
            g.input(4, 7, 6);
            g.input(7, 6, 3);
            g.input(3, 8, 3);
            g.input(6, 8, 2);
            g.dijkstra(1);
    }
     
    static class Graph{
        private int n; //노드들의 수
        private int map[][]; //노드간 간선의 가중치
 
        public Graph(int n){
            this.n = n; //노드의 갯수 초기화
            map = new int[n+1][n+1]; //가중치 저장소 초기화
        }
         
        //i,j : 연결된 2개의 노드, w : 가중치 
        public void input(int i, int j, int w){
            //무방향일 경우 양쪽다 저장 
            map[i][j] = w; 
            map[j][i] = w;
        }

        public void dijkstra(int v){
            int distance[] = new int[n+1]; //최단 거리 가중치 저장 변수(ex:distance[2]은 시작노드에서 2노드까지 가는데 있어 최단거리 가중치 합이란 뜻)
            boolean[] check = new boolean[n+1]; //노드 방문 유무 체크 변수
             
            //distance 가중치 변수에 integer가 가질 수 있는 최대의 값으로 초기화
            for(int i=1; i<n+1; i++) distance[i] = Integer.MAX_VALUE;
             
            //시작 노드(v)의 최단거리 가중치 0 세팅, 방문유무 체크 
            //why? 시작노드는 당연히 자기자신이니 가중치가 없고, 방문하고 시작하니 방문유무 체크해야함
            distance[v] = 0;
            check[v] = true;
             
            for(int i=1; i<n+1; i++){
                //모든 노드를 돌면서, 방문하지 않았고, 가중치가 있는 경우(즉 연결된 경우)
                //distance 최단 거리 가중치 변수에 가중치 세팅(처음 시작하는 노드와 연결되어 있는 노드들간 최단거리 세팅)
                if(!check[i] && map[v][i]!=0){
                    distance[i] = map[v][i];
                }
            }
 
            for(int a=0;a<n-1;a++){
                //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
                int min=Integer.MAX_VALUE; //최소 거리 가중치 임시변수 초기화
                int min_index=-1; //최소 거리 가중치를 가질 수 있는 노드 index임시변수 초기화
                  
                //최소값 찾기 ->전체를 돌면서 최소값과 해당 인덱스를 찾음 -> 최소값별로 인덱스를 우선순위큐로 미리 정의해서 굳이 이작업을 안해도 되게 할수있을거같음
                for(int i=1;i<n+1;i++){
                    //방문하지 않았고, 연결된 노드가 있을 경우(MAX_Value가 있다는 뜻은 아직 직간접이든 연결이 안되어있다는 뜻)
                    if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                        if(distance[i] < min){
                            min=distance[i];
                            min_index = i;
                        }
                    }
                }
//                System.out.print(min_index +" "+min+", ");
                check[min_index] = true;//방문 표시
                for(int i=1;i<n+1;i++){
                    //방문하지 않았고, min_index 최소 가중치로 정해진 노드와 연결되어 있는 노드
                    if(!check[i] && map[min_index][i]!=0){
                        if(distance[i]>distance[min_index]+map[min_index][i]){//현재 합산된 최소가중치 합이 다른 루트를 통해 합산된 가중치보다 크면 최소거리 값 교체
                            distance[i] = distance[min_index]+map[min_index][i];
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(distance));
        }
    }
}
