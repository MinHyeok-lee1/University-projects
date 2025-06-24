package backjoon_basic01;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AplusB {

	public static void main(String[] args) throws IOException{
		//방법 1 - Scanner 사용
		/*Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a+b);
		sc.close();*/
		
		//방법 2 - BufferedReader(readLine()) + StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
 		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(a+b);
	
/*    
        굳이 String 변수 생성 안하고 입력과 동시에 구분자로 분리해줘도 된다.
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(a+b); 
        
*/
		
		//방법 3 - BufferedReader(readLine()) + Split 사용
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		System.out.println(a+b);*/
	}

}
