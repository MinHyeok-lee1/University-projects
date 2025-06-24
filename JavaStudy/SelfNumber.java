package backjoon_basic04;

public class SelfNumber {

	public static void main(String[] args) {
		int []arr = new int [10001];
		for(int i = 1; i <= 10000; i++) {
			int x = i;
			int y = i;
			while(true) {
				x += y % 10;
				y = y / 10;
				if(y <= 0) break;
			}
			if(x <= 10000) arr[x]++;
		}
		
		for(int i = 1; i <= 10000; i++) {
		  if(arr[i] != 1) System.out.println(i);
		}
	}
}

/*
 다른방법 1)
 public class Main {
 
	public static void main(String[] args) {
 
		boolean[] check = new boolean[10001];	// 1부터 10000이므로
 
		for (int i = 1; i < 100001; i++){
			int n = d(i);
		
			if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
				check[n] = true;
			}
		}
 
		StringBuilder sb = new StringBuilder();
        
		for (int i = 1; i < 10001; i++) {
			if (!check[i]) {	// false 인 인덱스만 출력
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
 
 
 
	public static int d(int number){
		int sum = number;
    
		while(number != 0){
			sum = sum + (number % 10); // 첫 째 자리수
			number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
		}
    
		return sum;
	}
}
    
*/
