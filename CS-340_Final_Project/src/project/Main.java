package project;

import java.util.Scanner;

public class Main {
	static int ptr;
	static char[] input;
	

	public static void main(String[] args) {
		
		String[] keywords = {"int", "double","if","else"};
		
		String[] operators = {"+","-","*","/","%","==","!=","<",">","<=",">="};
		
		String[] punctuation = {";","(",")","'"};
		
		/// parser stuff
		
		System.out.println("Enter the input string:");
		String s = new Scanner(System.in).nextLine();
		input = s.toCharArray();
		if(input.length < 2) {
			System.out.println("The input string is invalid.");
			System.exit(0);
		}
		ptr = 0;
		boolean isValid = E();
		if((isValid) & (ptr == input.length)) {
			System.out.println("The input string is valid.");
		} else {
			System.out.println("The input string is invalid.");
		}
		
		

	}
	
	
	static boolean E() {
		// Check if 'ptr' to 'ptr+2' is 'x + T'
		int fallback = ptr;
		if(input[ptr++] != 'x') {
			ptr = fallback;
			return false;
		}
		if(input[ptr++] != '+') {
			ptr = fallback;
			return false;
		}
		if(T() == false) {
			ptr = fallback;
			return false;
		}
		return true;
	}
	
	static boolean T() {
		// Check if 'ptr' to 'ptr+2' is '(E)' or if 'ptr' is 'x'
		int fallback = ptr;
		if(input[ptr] == 'x') {
			ptr++;
			return true;
		}
		else {
			if(input[ptr++] != '(') {
				ptr = fallback;
				return false;
			}
			if(E() == false) {
				ptr = fallback;
				return false;
			}
			if(input[ptr++] != ')') {
				ptr = fallback;
				return false;
			}
			return true;
		}
	}

}