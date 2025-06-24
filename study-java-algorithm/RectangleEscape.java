package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class RectangleEscape {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int x = Integer.parseInt(st.nextToken());
	    int y = Integer.parseInt(st.nextToken());
	    int w = Integer.parseInt(st.nextToken());
	    int h = Integer.parseInt(st.nextToken());
	    
	    System.out.print(w - x > h - y ? h - y : w - x);
	}

}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		int x = in.nextInt();
		int y = in.nextInt();
		int w = in.nextInt();
		int h = in.nextInt();
        
		int x_min = Math.min(x, w-x);	// x축 최소거리
		int y_min = Math.min(y, h-y);	// y축 최소거리
        
		// x와 y축 최소거리 중 가장 작은 값
		System.out.println(Math.min(x_min, y_min));
	}
 
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
        
		int x_min = Math.min(x, w-x);	// x축 최소거리
		int y_min = Math.min(y, h-y);	// y축 최소거리
        
		// x와 y축 최소거리 중 가장 작은 값
		System.out.println(Math.min(x_min, y_min));
	}
 
}

*/