import java.math.BigInteger;
import java.util.Deque;
import java.util.Scanner;

public class REPL {

	public static void main(String[] args) {
	
		try {
			fix();
		} catch (Exception e) {
			System.out.println("Error");
			fix();
		}
	}
    
	public static void fix() {
		
		Scanner in = new Scanner(System.in);
	       while (in.hasNextLine()) {
			    String input = in.nextLine();
			    String[] array = input.split(" ");
			    Deque20<BigInteger> stack = new Deque20<BigInteger>();
			    
			 
			    
			    for (String s: array) {
			    	 if (isOperator(s)) {
			    		BigInteger num= stack.pop();
			    		BigInteger num2= stack.pop();
			    		stack.push(calculate(num,num2,s.charAt(0)));
			    		
			    	} else {
			    	BigInteger num = new BigInteger(s);
			    		stack.push(num);
			    	}
			    }
			    
			    
			    System.out.println(stack);
			}
	    }

	private static boolean isOperator(String s) {
		if (s.length()!=1) {
			return false;
		}
		char a = s.charAt(0);
		return (a=='+' || a=='-' || a=='/' || a=='*' ||a=='%');
	}
	
	public static BigInteger calculate(BigInteger num, BigInteger num2, char c) {
		//BigInteger answer = new BigInteger("0");
		if (c=='+') {
			return num2.add(num);
		} else if (c=='-') {
			return num2.subtract(num);
		} else if (c=='/') {
			return num2.divide(num);
		} else if (c=='*') {
			return num2.multiply(num);
		} else {
			return num2.mod(num);
		}
			
	}
}
