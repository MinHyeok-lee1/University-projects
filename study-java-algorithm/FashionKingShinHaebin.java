package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class FashionKingShinHaebin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int com = 1;
			String [] str = new String[N];
			int [] arr = new int[N];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				str[j] = st.nextToken();
				for(int t = 0; t < N; t++) {
				   if(str[t] != null && str[j].equals(str[t])) {
					   arr[t]++;
					   break;
				   }else if(str[t] != null) {
					   arr[j]++;
					   break;
				   }
				}
				for(int u = 0; u < N; u++) {
					   if(arr[u] != 0) com *= arr[u];
					}
			}
			if(arr[1] != 0) sb.append(N+com).append('\n');
			else sb.append(N).append('\n');
		}
		System.out.print(sb);
	}

}

/*다른방법 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
   public static void main(String[] args) throws IOException {
 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
 
      int T = Integer.parseInt(br.readLine());   // 테스트 케이스 
 
      while (T -- > 0) {
         
         HashMap<String, Integer> hm = new HashMap<>();   // <종류, 개수>
         
         int N = Integer.parseInt(br.readLine());   // 입력받는 옷의 개수
         
         while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            st.nextToken();   // 옷 이름은 필요 없음 
            
            String kind = st.nextToken();   // 옷 종류 
 
            *//**
             * 해당 종류의 옷이 해시맵에 있을경우
             * 해시맵에 저장되어있던 해당 종류의 개수를 +1 증가시킨다.
             *
             * 해당 종류의 옷이 해시맵에 없을 경우
             * 해당 종류와 개수 1을 넣는다.
             *//*
            
            if (hm.containsKey(kind)) {
               hm.put(kind, hm.get(kind) + 1);
            } 
            else {
               hm.put(kind, 1);
            }
         }
 
         int result = 1;
 
         *//**
          * 안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해준 값을
          * 곱해주어야 한다.
          *//*
         for (int val : hm.values()) {
            result *= (val + 1);
         }
         // 알몸인 상태를 제외해주어야 하므로 최종값에 -1이 정답.
         sb.append(result - 1).append('\n');
 
      }
      System.out.println(sb);
   }
 
}*/