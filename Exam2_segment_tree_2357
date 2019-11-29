package algoritmExam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exam2_segment_tree_2357 {
	
	static int start;
	static int[] max_tree;
	static int[] min_tree;
	
	public static void main(String[] args) {
		
		Exam2_segment_tree_2357 ex = new Exam2_segment_tree_2357();
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
//		int n=5;
//		int m=3;
		
		int []sharedNumbers = new int[n];
		for (int i = 0; i < n; i++) {
//			Random ran = new Random();
//			sharedNumbers[i] = ran.nextInt(100)+1;
			sharedNumbers[i] = sc.nextInt();
		}
		//세그먼트 트리 초기화(MAX)
		for (start = 1; start < n; start *= 2) ;
		max_tree = new int[2 * start];
//		max_tree
		Arrays.fill(max_tree, Integer.MIN_VALUE);//배열모든 인자를 MIN값으로 채움
		for (int i = 0; i < n; i++) {
        	max_tree[start + i] = sharedNumbers[i];
        }
		make_max();
		
		//세그먼트 트리 초기화(MIX)
		for (start = 1; start < n; start *= 2) ;
		min_tree = new int[2 * start];
		Arrays.fill(min_tree, Integer.MAX_VALUE);//배열모든 인자를 MAX값으로 채움
		for (int i = 0; i < n; i++) {
			min_tree[start + i] = sharedNumbers[i];
        }
		make_min();
		
		//결과물 출력용 배열
		int[][] minMaxs = new int[m][2];
		
		for(int i=0;i<m;i++) {
			//최댓값 최솟값 입력받기
			int temp1;
			int temp2;
//			Random ran = new Random();
//			temp1 = ran.nextInt(n)+1;
//			temp2 = ran.nextInt(n)+1;
			temp1 = sc.nextInt();
			temp2 = sc.nextInt();
			if(temp1>temp2) {
				minMaxs[i][1] = temp1;
				minMaxs[i][0] = temp2;
			}else {
				minMaxs[i][0] = temp1;
				minMaxs[i][1] = temp2;
			}
		}
		
		for(int i=0;i<m;i++) {
			int [][]resArr = getMaxMin(minMaxs[i][0]-1,minMaxs[i][1]-1);
			showArr(resArr);
		}
		
	}
	
	//시작,끝을 정해 해당 배열의 Max값과 Min값을 반환
	public static int[][] getMaxMin(int begin,int end){
		int[][]resArr = new int[1][2];
		resArr[0][0] = get_min(begin, end, 1, 0, start - 1);
		resArr[0][1] = get_max(begin, end, 1, 0, start - 1);
		return resArr;
	}
	
	//MAX일경우 [0, 0, 0, 0, 4, 56, 76, 10] -> [0, 76, 56, 76, 4, 56, 76, 10]
	//SUM일경우 [0, 0, 0, 0, 6, 66, 82, 15] -> [0, 169, 72, 97, 6, 66, 82, 15]
	 public static void make_max() {
	        int idx = start - 1;
	        while (idx > 0) {
	        	//MAX일경우
	            max_tree[idx] = Math.max(max_tree[idx * 2], max_tree[idx * 2 + 1]);
	            //SUM일경우
//	        	max_tree[idx] = max_tree[idx * 2] + max_tree[idx * 2 + 1];
	            idx--;
	        }
	    }

	//구하고자하는 구간의 left,right,idx(노드의 시작위치),각노드의 구간(노드가 1일경우 루트를의미, 전체구간조회)left,right
	 public static int get_max(int L, int R, int idx, int temp_L, int temp_R) {
	     //ex)1~3의 구간값을 구하고자 할때 전혀 겹치지 않으면 0반환
		 if (temp_L > R || temp_R < L) return Integer.MIN_VALUE;
		 //ex)1~3일때 tempL,tempR이 1~4이면 겹쳐지므로 해당 노드값의 데이터
	     if (L <= temp_L && temp_R <= R) return max_tree[idx];
	     int mid = (temp_L + temp_R) / 2;

	     //MAX일경우
	     return Math.max(get_max(L, R, idx * 2, temp_L, mid), get_max(L, R, idx * 2 + 1, mid + 1, temp_R));
	     //SUM일경우
//	       return get_max(L, R, idx * 2, temp_L, mid) + get_max(L, R, idx * 2 + 1, mid + 1, temp_R);
	    }
	 
		 public static void make_min() {
		        int idx = start - 1;
		        while (idx > 0) {
		        	//MAX일경우
//		            max_tree[idx] = Math.max(max_tree[idx * 2], max_tree[idx * 2 + 1]);
		            //MIN일경우
		        	min_tree[idx] = Math.min(min_tree[idx * 2], min_tree[idx * 2 + 1]);
		            //SUM일경우
//		        	max_tree[idx] = max_tree[idx * 2] + max_tree[idx * 2 + 1];
		            idx--;
		        }
		    }

		 public static int get_min(int L, int R, int idx, int temp_L, int temp_R) {
			 if (temp_L > R || temp_R < L) return Integer.MAX_VALUE;
		     if (L <= temp_L && temp_R <= R) return min_tree[idx];
		     int mid = (temp_L + temp_R) / 2;

		     return Math.min(get_min(L, R, idx * 2, temp_L, mid), get_min(L, R, idx * 2 + 1, mid + 1, temp_R));
		    }
	
	//배열출력 int[]
	public static void showArr(int[] param){
		for(int i=0;i<param.length;i++){
			System.out.println(param[i]);
		}
	}
	
	//배열출력 int[][]
	public static void showArr(int[][] param){
		for(int i=0;i<param.length;i++){
			System.out.println(param[i][0]+" "+param[i][1]);
		}
	}
	
}

