import java.util.Scanner;
import java.util.Stack;

// [백준 2504] 괄호의 값
// https://blog.naver.com/tnwls0529/222053546679

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String bracket = sc.nextLine();
		Stack<Integer> stack = new Stack<>();
		// ( : 0, [ : 1
		
		for(int i=0; i<bracket.length(); i++) {
			char brac = bracket.charAt(i);
			int int_cal = 0;
			while(!stack.isEmpty() && stack.peek() > 1) {
				int_cal += stack.pop();
			}
			if(int_cal != 0) {
				stack.push(int_cal);
			}
			
			if(brac =='(') {
				stack.push(0);
			}
			else if(brac == '[') {
				stack.push(1);
			}
			else if(stack.isEmpty()) {
				break;
			}
			else if(brac == ')') {
				if(stack.peek() == 0) {
					// 짝이 맞다면 숫자가 따로 없는 것이므로
					stack.pop();
					stack.push(2);
				}
				else if(stack.peek() == 1) {
					break;
				}
				else {
					int calc = stack.pop();
					calc *= 2;
					if(stack.isEmpty() || stack.peek() == 1) {
						break;
					}
					stack.pop(); // 괄호 빼기
					stack.push(calc);
				}
			}
			else if(brac == ']') {
				if(stack.peek() == 1) {
					// 짝이 맞다면 숫자가 따로 없는 것이므로
					stack.pop();
					stack.push(3);
				}
				else if(stack.peek() == 0) {
					break;
				}
				else {
					int calc = stack.pop();
					calc *= 3;
					if(stack.isEmpty() || stack.peek() == 0) {
						break;
					}
					stack.pop(); // 괄호 빼기
					stack.push(calc);
				}
			}
		}
		
		int int_cal = 0;
		while(!stack.isEmpty() && stack.peek() > 1) {
			int_cal += stack.pop();
		}
		if(int_cal != 0) {
			stack.push(int_cal);
		}
		
		if(stack.size() == 1) {
			int result = stack.pop();
			if(result < 2) {
				System.out.println(0);
			}
			else {
				System.out.println(result);
			}	
		}
		else {
			System.out.println(0);
		}
	}
}