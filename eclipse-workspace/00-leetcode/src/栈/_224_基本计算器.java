package 栈;

import java.util.Stack;

public class _224_基本计算器 {
	
	public static int calculate(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(c == ' ') {
				continue;
			}
			if(c == ')') {
				
				char a= cal(stack);
				stack.push(a);
				
			}else {
				stack.push(c);
			}
		}
		int sum = 0;
		while (stack.size() >=3) {
			char sc1 = stack.pop();
			char sc2 = stack.pop();
			char sc3 = stack.pop();
			if(sc2 == '+') {
				sum = (sc1 - '0') + (sc3 -'0');
				stack.push((char) (sum + '0'));
			}else if(sc2 == '-') {
				sum = (sc1 - '0') - (sc3 -'0');
				stack.push((char) (sum + '0'));
			}
			
		}
		return stack.pop()-'0';
		
    }
	
	public static char cal(Stack<Character> stack) {
		Stack<Character> stack1 = new Stack<>();
		char ch = stack.pop();
		int sum = 0;
		while (ch != '(') {
			
			stack1.push(ch);
		}
		
		while (stack1.size() >=3) {
			char sc1 = stack1.pop();
			char sc2 = stack1.pop();
			char sc3 = stack1.pop();
			if(sc2 == '+') {
				sum = (sc1 - '0') + (sc3 -'0');
				stack1.push((char) (sum + '0'));
			}else if(sc2 == '-') {
				sum = (sc1 - '0') - (sc3 -'0');
				stack1.push((char) (sum + '0'));
			}
			
		}
		stack.pop();
		return stack1.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(calculate(" 2-1 + 2 "));
	}
}
