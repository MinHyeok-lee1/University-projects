package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourthPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine(), " ");
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x,y;
		if(x1 == x2) x = x3;
		else if(x1 == x3) x = x2;
		else x = x1;

		if(y1 == y2) y = y3;
		else if(y1 == y3) y = y2;
		else y = y1;
			System.out.print(x +" "+ y);
	}
}

/* 다른풀이 1)
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int[] coord_1 = { in.nextInt(), in.nextInt() };	// 첫 번째 좌표
		int[] coord_2 = { in.nextInt(), in.nextInt() };	// 두 번째 좌표
		int[] coord_3 = { in.nextInt(), in.nextInt() };	// 세 번째 좌표
 
		
		in.close();
		
		int x;
		int y;
 
		// x 좌표 비교 후 쌍을 이루지 않는 x좌표를 저장
		// 1번 x좌표와 2번 x좌표 비교 
		if (coord_1[0] == coord_2[0]) {	
			x = coord_3[0];
		}
		// 1번 x좌표와 3번 x좌표 비교
		else if (coord_1[0] == coord_3[0]) {
			x = coord_2[0];
		}
		// 2번 x좌표와 3번 x좌표 비교
		else {
			x = coord_1[0];
		}
 
		// y 좌표 비교
		// 1번 y좌표와 2번 y좌표 비교
		if (coord_1[1] == coord_2[1]) {
			y = coord_3[1];
		}
		// 1번 y좌표와 3번 y좌표 비교
		else if (coord_1[1] == coord_3[1]) {
			y = coord_2[1];
		}
		// 2번 y좌표와 3번 y좌표 비교
		else {
			y = coord_1[1];
		}
		
		System.out.println(x + " " + y);
		
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int[] coord_1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		st = new StringTokenizer(br.readLine()," ");
		int[] coord_2 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		st = new StringTokenizer(br.readLine()," ");
		int[] coord_3 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
 
		
		
		int x;
		int y;
 
		// x 좌표 비교
		// 1번 x좌표와 2번 x좌표 비교
		if (coord_1[0] == coord_2[0]) {
			x = coord_3[0];
		}
		// 1번 x좌표와 3번 x좌표 비교
		else if (coord_1[0] == coord_3[0]) {
			x = coord_2[0];
		}
		// 2번 x좌표와 3번 x좌표 비교
		else {
			x = coord_1[0];
		}
 
		// y 좌표 비교
		// 1번 x좌표와 2번 x좌표 비교
		if (coord_1[1] == coord_2[1]) {
			y = coord_3[1];
		}
		// 1번 x좌표와 3번 x좌표 비교
		else if (coord_1[1] == coord_3[1]) {
			y = coord_2[1];
		}
		// 2번 x좌표와 3번 x좌표 비교
		else {
			y = coord_1[1];
		}
		
		System.out.println(x + " " + y);
		
 
	}
 
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] coord_1 = br.readLine().split(" ");
		String[] coord_2 = br.readLine().split(" ");
		String[] coord_3 = br.readLine().split(" ");
        
		String x;
		String y;
        
		// x 좌표 비교
		// 1번 x좌표와 2번 x좌표 비교
		if(coord_1[0].equals(coord_2[0])){
        	x = coord_3[0];
		}
        
		// 1번 x좌표와 3번 x좌표 비교
		else if (coord_1[0] == coord_3[0]) {
			x = coord_2[0];
		}
		// 2번 x좌표와 3번 x좌표 비교
		else {
			x = coord_1[0];
		}
  
		// y 좌표 비교
		// 1번 x좌표와 2번 x좌표 비교
		if (coord_1[1] == coord_2[1]) {
			y = coord_3[1];
		}
		// 1번 x좌표와 3번 x좌표 비교
		else if (coord_1[1] == coord_3[1]) {
			y = coord_2[1];
		}
		// 2번 x좌표와 3번 x좌표 비교
		else {
			y = coord_1[1];
		}
		
		System.out.println(x + " " + y);
	}
 
}
*/