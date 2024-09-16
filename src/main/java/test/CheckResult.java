package test;

import java.util.Scanner;

public class CheckResult {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter your mark:");
		int mark=scanner.nextInt();
		
		if(mark >=0 && mark <=100) {
		String result= (mark<30) ? "Sorry, you're fail!!": "Congrats!!  you're pass!!";
		System.out.println(result);
		}else {
			System.out.println("Invalid input: "+mark +". Entered value should should be between 1--100");
		}
	}

}
