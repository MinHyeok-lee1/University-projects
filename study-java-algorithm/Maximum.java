package backjoon_basic03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0, n = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 9; i++) {
			int a = Integer.parseInt(br.readLine());
			if (i == 0) {
				max = a;
				n = i;
			} else {
				if (a >= max) {
					max = a;
				    n = i;	
				}
			}
		}
		sb.append(max).append('\n').append(n);
		System.out.print(sb);

	}

}


/* 다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = { in.nextInt(), in.nextInt(), in.nextInt(),
				in.nextInt(), in.nextInt(), in.nextInt(),
				in.nextInt(), in.nextInt(), in.nextInt() };
		in.close();
		
		int count = 0;
		int max = 0;
		int index = 0;
        
		for(int value : arr) {
			count++;
            
			if(value > max) {
				max = value;
				index = count;
			}
		}
		System.out.print(max + "\n" + index);
		
	}
}

다른방법 2)
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		List<Integer> list = Arrays.asList(in.nextInt(), in.nextInt(), in.nextInt(),
					in.nextInt(), in.nextInt(), in.nextInt(),
					in.nextInt(), in.nextInt(), in.nextInt());
 
		in.close();
 
		int val = Collections.max(list);
		int idx = list.indexOf(val) + 1;
 
		System.out.println(val);
		System.out.println(idx);
 
	}
}

다른방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int[] arr = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		int max = 0;
		int index = 0;
		
		int count = 0;
		
		for(int value : arr) {
			count++;
			if(value > max) {
				max = value;
				index = count;
			}
		}
 
		System.out.println(max);
		System.out.println(index);
 
	}
}

다른방법 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int max = 0;
		int index = 0;
		for(int i = 0 ; i < 9 ; i++) {
 
			int val = Integer.parseInt(br.readLine());
			
			if(val > max) {
				max = val;
				index = i+1;
			}
		}
 
		System.out.println(max);
		System.out.println(index);
	}
}
*/


