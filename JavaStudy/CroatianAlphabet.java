package backjoon_basic05;

import java.io.IOException;

public class CroatianAlphabet {

	public static void main(String args[]) throws IOException {
// l = 108 n=110 j = 106 z= 122 d=100 - 45, = 61
		int cnt = 0;
		int str;
		int str_pre = 10;
		int flag = 0;
		while (true) {
			str = System.in.read();
			if (flag == 1 && str == 61)
				cnt--;
			else
				flag = 0;

			if (str >= 97 && str <= 122) {
				cnt++;
			} else if (str == 10) {
				break;
			}
			if (str_pre == 108 && str == 106)
				cnt--;
			else if (str_pre == 110 && str == 106)
				cnt--;
			else if (str_pre == 100 && str == 122)
				flag = 1;
			str_pre = str;
		}
		System.out.print(cnt);
	}

}
/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
        
		String str = in.nextLine();
        
		int count = 0;
 
		for (int i = 0; i < str.length(); i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c') {			// 만약 ch 가 c 라면?
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {		//만약 ch 다음 문자가 '=' 이라면?
						// i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
						i++;		
					}
					else if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
			}
		    
			else if(ch == 'd') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'z') {
						if(i < str.length() - 2) {
							if(str.charAt(i + 2) == '=') {	// dz= 일 경우
								i += 2;
							}
						}
					}
		        
					else if(str.charAt(i + 1) == '-') {	// d- 일 경우
						i++;
					}
				}
			}
		    
			else if(ch == 'l') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {	// lj 일 경우
						i++;
					}
				}
			}
		    
			else if(ch == 'n') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {	// nj 일 경우
						i++;
					}
				}
			}
 
			else if(ch == 's') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {	// s= 일 경우
						i++;
					}
				}
		    }
 
			else if(ch == 'z') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {	// z= 일 경우
						i++;
					}
				}
			}
		    
			count++;
 
		}
 
		System.out.println(count);
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int count = 0;
 
		for (int i = 0; i < len; i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c' && i < len - 1) {			// 만약 ch 가 c 라면?
				//만약 ch 다음 문자가 '=' 또는 '-' 이라면?
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {		
					// i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
					i++;		
				}
				
			}
		    
			else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') {	// d- 일 경우
						i++;
					}
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					
					if(str.charAt(i + 2) == '=') {	// dz= 일 경우
						i += 2;
					}
				}
			}
		    
			else if((ch == 'l' || ch == 'n') && i < len - 1) {
				if(str.charAt(i + 1) == 'j') {	// lj 또는 nj 일 경우
					i++;
				}
			}
		    
 
			else if((ch == 's' || ch == 'z') && i < len - 1) {
				if(str.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
					i++;
				}
			
		    }
		    
			count++;
 
		}
 
		System.out.println(count);
	}
}

*/