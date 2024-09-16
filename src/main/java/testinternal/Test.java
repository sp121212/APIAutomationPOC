package testinternal;

import java.util.Scanner;

import exp.ApiFrameWorkException;

public class Test {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your age:");
		String str=scanner.next();
		int age=Integer.valueOf(str);
		
		if(age<18) {
			throw new ApiFrameWorkException("\nYour age is '"+age + "' . Which is less than 18. So you're not eligible for vote!!!");
		}else {
			System.out.println("Congrat!!. You can proceed for vote!!");
		}
		
		scanner.close();
	}
	
	
	
}
