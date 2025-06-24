package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxiGeometry {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		double x = Double.parseDouble(br.readLine());

		sb.append(x * x * Math.PI).append('\n').append(2 * x * x);
		System.out.print(sb);
	}
}

/* 다른풀이 1)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		double R = in.nextDouble();	// 반지름 R
		in.close();
		
		System.out.println(R * R * Math.PI);	// 유클리드 원의 넓이
		System.out.println(2 * R * R);		// 택시기하학 원의 넓이
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		double R = Double.parseDouble(br.readLine()); // 반지름 R
	
		System.out.println(R * R * Math.PI);	// 유클리드 원의 넓이
		System.out.println(2 * R * R);		// 택시기하학 원의 넓이
		
	}
}

*/