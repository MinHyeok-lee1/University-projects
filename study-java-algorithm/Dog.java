package backjoon_basic01;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Dog {

	public static void main(String[] args) throws IOException{
		//  "는 \"로해야 출력된다
		// 1번째 방법
        /*System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");  */
		
		
		// 2번 방법 BufferedWriter를 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("|\\_/|");
		bw.newLine(); // 줄 구분자
		bw.write("|q p|   /}");
		bw.newLine();
		bw.write("( 0 )\"\"\"\\");
		bw.newLine();
		bw.write("|\"^\"`    |");
		bw.newLine();
		bw.write("||_/=\\\\__|");
		bw.flush();
		bw.close();
		
		// 3번 방법 StringBuilder를 사용
		/*StringBuilder sb = new StringBuilder();
		sb.append("|\\_/|\n");
		sb.append("|q p|   /}\n");
		sb.append("( 0 )\"\"\"\\\n");
		sb.append("|\"^\"`    |\n");    
		sb.append("||_/=\\\\__|\n");         
		System.out.println(sb);*/
		
		// 4번 방법 StringBuffer를 사용
		/*StringBuffer sb = new StringBuffer();
		sb.append("|\\_/|\n");
		sb.append("|q p|   /}\n");
		sb.append("( 0 )\"\"\"\\\n");
		sb.append("|\"^\"`    |\n");    
		sb.append("||_/=\\\\__|\n");         
		System.out.println(sb);*/
	}

}
