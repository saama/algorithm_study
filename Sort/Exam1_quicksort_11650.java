package algoritmExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main e = new Main();
		List<int[]> list = new ArrayList<int[]>();
		
		Scanner sc = new Scanner(System.in);
		int cnt;
		//정렬할 갯수
		cnt = sc.nextInt();
//		cnt = 5;
//		System.out.println(cnt);
		//입력받는부분
		Random ran = new Random();
		for(int i=0;i<cnt;i++) {
			int []arr = new int[3];
//			arr[0] = sc.nextInt();
//			arr[1] = sc.nextInt();
			//-100000 ~ 100000
			arr[0] = ran.nextInt(100000)-100000;
			arr[1] = ran.nextInt(1000000)-100000;
//			System.out.println(arr[0]+"  "+arr[1]);
			list.add(arr);
		}
		
		//임시데이터 입력
//        int []arr1 = new int[3];
//        arr1[0]=1;
//        arr1[1]=2;
//        int []arr2 = new int[3];
//        arr2[0]=-11;
//        arr2[1]=-100;
//        int []arr3 = new int[3];
//        arr3[0]=1;
//        arr3[1]=200;
//        int []arr4 = new int[3];
//        arr4[0]=100;
//        arr4[1]=-2;
//        
//        list.add(arr1);
//        list.add(arr2);
//        list.add(arr3);
//        list.add(arr4);
		
		long start = System.currentTimeMillis();
		//X정렬(list,몇번째배열 정렬할지,리스트의시작,리스트의끝)
		e.quickSort(list,0,0,list.size()-1);
		//X가 정렬된 기준으로 그룹핑
		e.makeGroup(list, 0);
		
		int groupCnt=0;
		int startIdx=0;
		int endIdx=0;
		//Y좌표(배열의 두번째인자)정렬
		//그룹핑된 애들의 start와 end를 구해 그 값으로 LIST정렬
		for(int i=1;i<list.size();i++){
			int groupNum = list.get(i)[2];
			if(groupNum==groupCnt) {
				endIdx++;
				if(i==list.size()-1) {
					e.quickSort(list, 1, startIdx,endIdx);
				}else {
					continue;
				}
			}else {
				e.quickSort(list, 1, startIdx,endIdx);
				startIdx=i;
				endIdx=i;
				groupCnt++;
			}
		}
		long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
//		e.showList(list);
	}

	/*
	 * 그룹핑할 리스트,몇번째인자 그룹핑할지
	 * result: seq번째있는 배열중 같은값은 0부터 같은값으로 그룹핑됨
	 */
	public void makeGroup(List<int[]> list,int seq){
		int groupIdx=0;
		int isSame=0;
		for(int i=0;i<list.size();i++){
			if(i==0){
				isSame = list.get(i)[seq];
				list.get(i)[2]=groupIdx;
				continue;
			}
			if(isSame==list.get(i)[seq]){
				list.get(i)[2]=groupIdx;
			}else{
				isSame=list.get(i)[seq];
				list.get(i)[2]=++groupIdx;
			}
			
		}
	}
	
	/* 
	 * 선택정렬
	 * 그룹핑할 리스트,몇번째인자 솔팅할지,LIST의 시작,LIST의 끝
	 * result: seq번째있는 배열기준으로 LIST를 soring
	 */
	public void selectSort(List<int[]> list,int seq,int startIdx,int endIdx){
		//seq번째의 배열로 내림차순비교 -> list를 정렬함
		int min;
		int[] tmp;
		for(int i=startIdx;i<endIdx;i++){
		      min = i;
		      for (int j = i + 1; j < endIdx+1; j++) {
			        if (list.get(j)[seq] < list.get(min)[seq])
			          min = j;
			      }
			      tmp = list.get(i);
			      list.set(i, list.get(min));
			      list.set(min,tmp);
		}
	}
	
	/* 
	 * 퀵정렬
	 * 그룹핑할 리스트,몇번째인자 솔팅할지,LIST의 시작,LIST의 끝
	 * result: seq번째있는 배열기준으로 LIST를 soring
	 */
    public void quickSort(List<int[]> data,int seq, int l, int r){
        int left = l;
        int right = r;
//        int pivot = data[(l+r)/2];
        int pivot = data.get((l+r)/2)[seq];
        
        do{
            while(data.get(left)[seq] < pivot) left++;
            while(data.get(right)[seq] > pivot) right--;
            if(left <= right){    
            	int[] temp = data.get(left);
//                    data[left] = data[right];
                data.set(left,data.get(right));
                data.set(right,temp);
                left++;
                right--;
            }

        }while (left <= right);
        
        if(l < right) quickSort(data,seq, l, right);
        if(r > left) quickSort(data,seq, left, r);
    }
	
	public void showList(List<int[]> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
		}
	}
	
}

