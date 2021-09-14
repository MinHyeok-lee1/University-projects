package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlarmClock {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		br.close();

		StringBuilder sb = new StringBuilder();
		if (M < 45) {
			H--;
			M += 15; // M = 60 - (45 - M);
			if (H < 0)
				H = 23;
		} else {
			M -= 45;
		}

		sb.append(H + " " + M); // sb.append(H).append(' ').append(M);
		System.out.print(sb);
	}

}


/* 다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		int H = in.nextInt(); // 시
		int M = in.nextInt(); // 분
		in.close();
		
		if(M < 45) {
			H--;		// 시(hour) 1 감소
			M= 60 - (45 - M); 	// 분(min) 감소
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			System.out.println(H + " " + (M - 45));
		}
	}
}

다른방법 2)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int H = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		if(M < 45) {
			H--;
			M = 60 - (45 - M);
            
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			System.out.println(H + " " + (M - 45));
		}
 
	}
 
}

다른방법 3)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
 
		if(M < 45) {
			if(H == 0){
				H = 23;
				sb.append(H).append(' ');
			} else {
				H--;
				sb.append(H).append(' ');
			}
			sb.append(M = 60 - (45 - M));
		}
		else {
			sb.append(H).append(' ').append(M - 45);
		}
 
		System.out.println(sb);
	}
}

*/
