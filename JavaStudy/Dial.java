package backjoon_basic05;

import java.io.IOException;

public class Dial {

	public static void main(String[] args) throws IOException {
		int t = 0;
		int str;
		while (true) {
			str = System.in.read();
			if (str == 65 || str == 66 || str == 67) {
				t += 3;
			} else if (str == 68 || str == 69 || str == 70) {
				t += 4;
			} else if (str == 71 || str == 72 || str == 73) {
				t += 5;
			} else if (str == 74 || str == 75 || str == 76) {
				t += 6;
			} else if (str == 77 || str == 78 || str == 79) {
				t += 7;
			} else if (str == 80 || str == 81 || str == 82 || str == 83) {
				t += 8;
			} else if (str == 84 || str == 85 || str == 86) {
				t += 9;
			} else if (str == 87 || str == 88 || str == 89 || str == 90) {
				t += 10;
			} else if (str == 10) {
				break;
			}
		}
		System.out.print(t);
	}
}

/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
 
		int count = 0;
		int k = s.length();
        
		for(int i = 0; i < k; i++) {
        
			switch(s.charAt(i)) {
            
			case 'A' : case 'B': case 'C' : 
				count += 3;
				break;
                
			case 'D' : case 'E': case 'F' :
				count += 4; 
				break;
                
			case 'G' : case 'H': case 'I' :
				count += 5; 
				break;
                
			case 'J' : case 'K': case 'L' : 
				count += 6;
				break;
                
			case 'M' : case 'N': case 'O' :
				count += 7;
				break;
                
			case 'P' : case 'Q': case 'R' : case 'S' : 
				count += 8; 
				break;
                
			case 'T' : case 'U': case 'V' : 
				count += 9;
				break;
                
			case 'W' : case 'X': case 'Y' : case 'Z' : 
				count += 10;
				break;
			}
		}		
		System.out.print(count);
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String s = br.readLine();
        
		int count=0;
		int k = s.length();
        
		for(int i = 0 ; i < k ; i++) {
        
			switch(s.charAt(i)) {
			case 'A' : case 'B': case 'C' : 
				count += 3; 
				break;
                
			case 'D' : case 'E': case 'F' : 
				count += 4; 
				break;
                
			case 'G' : case 'H': case 'I' : 
				count += 5; 
				break;
                
			case 'J' : case 'K': case 'L' : 
				count += 6; 
				break;
                
			case 'M' : case 'N': case 'O' : 
				count += 7; 
				break;
                
			case 'P' : case 'Q': case 'R' : case 'S' :
				count += 8; 
				break;
                
			case 'T' : case 'U': case 'V' : 
				count += 9; 
				break;
                
			case 'W' : case 'X': case 'Y' : case 'Z' : 
				count += 10; 
				break;
			}
		}		
		System.out.print(count);
	}
}

다른방법 3)
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		int count = 0;
		int value;
		
		while(true) {
			
			value = System.in.read();
			
			if(value == '\n') {
				break;
			}
			
			if(value < 68) count += 3;
			else if(value < 71) count += 4;
			else if(value < 74) count += 5;
			else if(value < 77) count += 6;
			else if(value < 80) count += 7;
			else if(value < 84) count += 8;
			else if(value < 87) count += 9;
			else count += 10;
			
			
		}
		System.out.print(count);
	}
}

*/
