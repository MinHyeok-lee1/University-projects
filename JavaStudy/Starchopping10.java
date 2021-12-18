package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starchopping10 {
	static char[][] arr;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		star(0,0,N,false);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void star(int x, int y, int N, boolean blank) {
	    if(blank) {
	    	for(int i = x; i < x+N; i++) {
	    		for(int j = y; j < y+N; j++) {
	    			arr[i][j] = ' ';
	    		}
	    	}
	    	return;
	    }
	    
	    if(N == 1) {
	    	arr[x][y] = '*';
	    	return;
	    }
		
		int count = 0;
	    int size = N/3;
	    
	    for(int i = x; i < x+N; i += size) {
	    	for(int j = y; j < y+N; j += size) {
		    	count++;
		    	if(count == 5) star(i,j,size,true);
		    	else star(i,j,size,false);
		    }
	    }
	}
}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
	static char[][] arr;
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
 
		arr = new char[N][N];
        
		star(0, 0, N, false);
 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void star(int x, int y, int N, boolean blank) {
 
		// 공백칸일 경우
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 

		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static char[][] arr;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
        
		star(0, 0, N, false);
 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void star(int x, int y, int N, boolean blank) {
 
		// 공백칸일 경우
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 

		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static StringBuilder[] sb;
 
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		sb = new StringBuilder[N];
		String s = String.format("%" + N + "s" , ' ');
		for(int i = 0; i < N; i++) {
			sb[i] = new StringBuilder(s);
		}
        
		star(0, 0, N);
		for (int i = 0; i < N; i++) {
			System.out.println(sb[i]);
		}
	}
 
	static void star(int x, int y, int N) {
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			sb[x].setCharAt(y, '*');
			return;
		}
 

		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count != 5) { 
					star(i, j, size);
				} 
			}
		}
	}
}

다른풀이 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static StringBuilder[] sb;
 
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = String.format("%" + N + "s", ' ').replace(' ', '*');
		sb = new StringBuilder[N];
		
		for(int i = 0; i < N; i++) {
			sb[i] = new StringBuilder(s);
		}
        
		star(0, 0, N, false);
		
		for (int i = 0; i < N; i++) {
			System.out.println(sb[i]);
		}
	}
 
	static void star(int x, int y, int N, boolean blank) {
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					sb[i].setCharAt(j, ' ');
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			return;
		}
 

		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				}
				else {
					star(i, j, size, false);
				}
			}
		}
	}
}
*/