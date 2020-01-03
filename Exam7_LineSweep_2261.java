package algoritmExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exam7_LineSweep_2261 {
//	line sweep의 시간복잡도(O(nlogn))
//	line sweep을 안쓸경우(O(n^2)) 	
//	입력되는 좌표 	
//	[0, 0]
//	[10, 10]
//	[0, 10]
//	[10, 0]
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        //points를 x값이 오름차순이 되도록 정렬
        Arrays.sort(points, (a, b) -> (a.x - b.x));
//        [Point [x=0, y=0], Point [x=0, y=10], Point [x=10, y=10], Point [x=10, y=0]]
        //TreeSet에 들어가는 Point의 y값이 같으면, x값이 오름차순이 되도록, 다르다면, y값이 오름차순이 되도록(y값을 기준으로 정렬)
		TreeSet<Point> set = new TreeSet<Point>((a, b) -> ((a.y == b.y) ? a.x - b.x : a.y - b.y));
		//위 정렬의 의미 ex) 아래와 같은 포인트일경우
//		[0, 0]
//		[10, 10]
//		[0, 10]
//		[10, 0]
		//[PPoint [x=0, y=0], PPoint [x=10, y=0], PPoint [x=0, y=10], PPoint [x=10, y=10]]
		
		set.add(points[0]);
		set.add(points[1]);
		System.out.println("초기 TreeSet "+set);
		long answer = distSquare(points[0], points[1]);
		System.out.println("초기 answer "+answer);
		int start = 0;
		
		for (int i = 2; i < n; i++) {
            Point cur = points[i]; //points[2]
            System.out.println("현재 cur "+cur);
            //set에 있는 점들의 유효성 검사
			while (start < i) {
				Point point = points[start]; //points[0]
                long x = cur.x - point.x;
				if (x * x > answer) {
					//두점(초기 x=0과 x=2를 비교함)의 x 좌표거리가 현재 최단거리인 answer보다 크면 set에서 제거
					System.out.println("제거될 point "+point);
					set.remove(point);
					start += 1;
				} else {
					//두 지점의 x좌표 거리가 현재 최단거리보다 작으면 무조건 break타서 while문 탈출
					System.out.println("최단거리보다 작은 x좌표를 만났을때 TreeSet"+set);
					break;
				}
			}
			//제곱근 + 1 => 현재최단거리보다 1큰거
            int d = (int) Math.sqrt((double) answer) + 1;
            //y값의 범위를 구해줌
			Point from = new Point(-10001, cur.y - d);
			Point to = new Point(10001, cur.y + d);
			System.out.println("from "+from+" to "+to);
//			from [x=-10001, y=-1] to [x=10001, y=21]
//			-> 현재 TreeSet에서 Point가 from과 to사이의 있는애들을 가져옴 
//			x좌표가 -10001, 10001 인 이유는 그냥 전체 X좌표를 가져오라는 의미
//			만약 아래 for문이 아예 돌지않는다면 cur의 y좌표 주위에 최단거리보다 가까운애들이 없다는 뜻임
			for (Point point : set.subSet(from, to)) {
				System.out.println(point);
				long distance = distSquare(cur, point);
				System.out.println("answer "+answer+" "+"distance "+distance);
				//해당 y값 범위내에 있는 TreeSet들의 거리를 구하면 minimum값을 계속 갱신해줌
				answer = Math.min(answer, distance);
				System.out.println("answer "+answer);
			}
			//현재좌표 cur은 무조건 들어간다. 그러나 위 while문에서 최단거리보다 크면 걸러지게 되있음
			set.add(cur);
        }
        for(int i = 0; i < n; i++){
            bw.write(points[i].x + " " + points[i].y + "\n");
        }
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
	}

    //피타고라스 a^2 + b^2 = c^2 => 최단거리의 제곱을 의미
	static long distSquare(Point A, Point B) {
		return (long)((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
	}
}
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

