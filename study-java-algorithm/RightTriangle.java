package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RightTriangle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        int z = Integer.parseInt(st.nextToken());
	        if(x == 0 && y == 0 && z == 0) break;
	        if(x*x + y*y == z*z) sb.append("right").append('\n');
	        else if(z*z + y*y == x*x) sb.append("right").append('\n');
	        else if(x*x + z*z == y*y) sb.append("right").append('\n');
	        else sb.append("wrong").append('\n');
		}
		
		System.out.print(sb);
	}
}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
       
        
        while(true) {
        	
        	int x = in.nextInt();
        	int y = in.nextInt();
        	int z = in.nextInt();
        	
			// 0 0 0 을 입력받으면 종료
        	if(x == 0 && y == 0 && z == 0) break;
            
        	
        	if((x * x + y * y) == z * z) {
				System.out.println("right");
			}
        	else if(x * x == (y * y + z * z)) {
				System.out.println("right");
			}
        	else if(y * y == (z * z + x * x)) {
				System.out.println("right");
			}
        	else {
				System.out.println("wrong");
			}
        	
		}
 
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
       
 
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	
        	
			// 0 0 0 을 입력받으면 종료
        	if(x == 0 && y == 0 && z == 0) break;
            
        	
        	if((x * x + y * y) == z * z) {
				System.out.println("right");
			}
        	else if(x * x == (y * y + z * z)) {
				System.out.println("right");
			}
        	else if(y * y == (z * z + x * x)) {
				System.out.println("right");
			}
        	else {
				System.out.println("wrong");
			}
        	
		}
 
	}
 
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
       
 
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	
        	
			// 0 0 0 을 입력받으면 종료
        	if(x == 0 && y == 0 && z == 0) break;
            
        	
        	if((x * x + y * y) == z * z) {
				sb.append("right").append('\n');
			}
        	else if(x * x == (y * y + z * z)) {
				sb.append("right").append('\n');
			}
        	else if(y * y == (z * z + x * x)) {
				sb.append("right").append('\n');
			}
        	else {
				sb.append("wrong").append('\n');
			}
        	
		}
		System.out.println(sb);
	}
 
}
*/