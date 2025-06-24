package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dominos {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N+1];
		int[] arr2 = new int[N+1];
		arr1[0] = 0;
		arr2[0] = 0;
        int sum1 = 0, sum2 = 0;
		for (int i = 1; i <= N; i++) {
           arr1[i] = i + arr1[i-1];
           sum1 += arr1[i];
		}

		for (int i = 1; i <= N; i++) {
            arr2[i] = i * (i + 1);
            sum2 += arr2[i];
		}
		System.out.print(sum1 + sum2);
	}
}

/*다른방법 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Dominos {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println((N * (N + 1) * (N + 2)) / 2);
	}
}*/