package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

public class Remainder {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int [] r = new int [10];
		for(int i = 0; i < 10; i++) {
			int A = Integer.parseInt(br.readLine());
			r[i] = A % 42;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i : r) set.add(i);
	/*	List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list); */
		
        sb.append(set.size());
		
		System.out.print(sb);

	}

}

/*
다른방법 1)
import java.util.Scanner;
import java.util.HashSet;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<Integer> h = new HashSet<Integer>();
 
		for (int i = 0; i < 10; i++) {
			h.add(in.nextInt() % 42);
		//입력받은 값의 나머지 값을 add메소드를 통해 HashSet에 저장
		}
        
		in.close();
		System.out.print(h.size());
	}
}

다른방법 2)
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> h = new HashSet<Integer>();
 
		
		for (int i = 0; i < 10; i++) {
			h.add(Integer.parseInt(br.readLine()) % 42);
		}
		
		System.out.print(h.size());
	}
}

다른방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
 
        boolean[] arr = new boolean[42];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0 ; i < 10 ; i++) {
            arr[Integer.parseInt(br.readLine()) % 42] = true;
        }
        
        int count = 0;
        for(boolean value : arr) {
            if(value){    // value 가 true 라면
                count++;
            }
        }
        System.out.println(count);
    }
}
*/
