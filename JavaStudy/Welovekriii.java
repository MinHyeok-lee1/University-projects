package backjoon_basic01;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Welovekriii {

	public static void main(String[] args) throws IOException{
/*		// 1번째 방법
        System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");
        System.out.printf("%s","강한친구 대한육군\n강한친구 대한육군\n");
        System.out.printf("%s\n%s","강한친구 대한육군", "강한친구 대한육군\n");
        System.out.printf("강한친구 대한육군\n강한친구 대한육군");*/
		
      // 2번 방법 BufferedWriter를 사용
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write("강한친구 대한육군");
				bw.newLine(); // 줄 구분자, \n과 같은 역할
				bw.write("강한친구 대한육군");
				bw.flush();
				bw.close();
		
/*		// 3번 방법 StringBuilder를 사용
		StringBuilder sb = new StringBuilder();
		sb.append("강한친구 대한육군\n");
		sb.append("강한친구 대한육군");
		System.out.println(sb);*/
		
/*		// 4번 방법 StringBuffer를 사용
		StringBuffer sb = new StringBuffer();
		sb.append("강한친구 대한육군\n");
		sb.append("강한친구 대한육군");
		System.out.println(sb);
			*/	
        
	}

}
