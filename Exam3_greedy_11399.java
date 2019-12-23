package algoritmExam;

import java.util.Random;
import java.util.Scanner;

public class Exam3_greedy_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt,min =0;
		cnt = sc.nextInt();
		
		Random ran = new Random();
		int []arr = new int[cnt];
//		int []arr = {3,1,4,3,2};
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
//			arr[i] = ran.nextInt(1000)+1;
		}
		//시작
		long start = System.currentTimeMillis();
		quickSort(arr,0,arr.length-1);
//		System.out.println(Arrays.toString(arr));
		
		min = arr[0]; //초기값넣어줌
		for(int i=1;i<=arr.length-1;i++) {
			arr[i] = arr[i-1]+arr[i];
			min += arr[i];
		}
		long end = System.currentTimeMillis();
//		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
		System.out.println(min);
	}
	//data [3 1 4 5 3] 0 , 4
    public static void quickSort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{				//4		4      0->1->2
            while(data[left] < pivot) left++;
        				//3		4	   4
            while(data[right] > pivot) right--;
        		//2		4
            if(left <= right){
            	 //4
            	int temp = data[left];
            	 //3
                data[left] = data[right];
            	 //4
                data[right] = temp;
            	 //3
                left++;
            	 //3
                right--;
            }
        }while (left <= right);
        
//        3 1 3 5 4
//           0     3
        if(l < right) quickSort(data, l, right);
//           4     3
        if(r > left) quickSort(data, left, r);
    }
}


