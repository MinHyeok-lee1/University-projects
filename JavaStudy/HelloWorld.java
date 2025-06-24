package backjoon_basic01;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class HelloWorld {

	public static void main(String[] args) throws IOException {
/*		// 1번 방법 System.out.print ~ 를 사용
		System.out.print("Hello Wolrd!");
		System.out.println("Hello World!");
		System.out.printf("Hello Wolrd!");
		System.out.printf("%s", "Hello World!");*/
		
		// 2번 방법 BufferedWriter를 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Hello World!");
		bw.flush();
		bw.close();
		
/*		// 3번 방법 StringBuilder를 사용
		StringBuilder sb = new StringBuilder();
		sb.append("Hello World!");
		System.out.println(sb);*/
		
/*		// 4번 방법 StringBuffer를 사용
		StringBuffer sb = new StringBuffer();
		sb.append("Hello World!");
		System.out.println(sb);*/
	}

}
