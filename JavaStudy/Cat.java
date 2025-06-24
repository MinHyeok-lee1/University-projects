package backjoon_basic01;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Cat {

	public static void main(String[] args) throws IOException {
		// \는 \\로해야 출력된다.
		/*
		 * // 1번째 방법
		 * System.out.println("\\    /\\");
		 * System.out.println(" )  ( ')");
		 * System.out.println("(  /  )"); 
		 * System.out.println(" \\(__)|");
		 */

		// 2번 방법 BufferedWriter를 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("\\    /\\");
		bw.newLine();
		bw.write(" )  ( ')");
		bw.newLine();
		bw.write("(  /  )");
		bw.newLine();
		bw.write(" \\(__)|");
		bw.flush();
		bw.close();

		
		  // 3번 방법 StringBuilder를 사용 StringBuilder sb = new StringBuilder();
		  /*sb.append("\\    /\\\n");
            sb.append(" )  ( ')\n"); 
            sb.append("(  /  )\n");
		  sb.append(" \\(__)|"); 
		  System.out.println(sb);*/
		 

		/*
		 * // 4번 방법 StringBuffer를 사용 StringBuffer sb = new StringBuffer();
		 * sb.append("\\    /\\\n"); 
		 * sb.append(" )  ( ')\n"); 
		 * sb.append("(  /  )\n");
		 * sb.append(" \\(__)|"); 
		 * System.out.println(sb);
		 */
	}

}
