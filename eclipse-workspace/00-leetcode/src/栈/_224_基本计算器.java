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
			char sc1 = stack.elementAt(0);
			char sc2 = stack.elementAt(1);
			char sc3 = stack.elementAt(2);
			stack.remove(0);
			stack.remove(0);
			stack.remove(0);
			if(sc2 == '+') {
				sum =  (sc1 - '0') + (sc3 -'0');
				stack.add(0, (char) (sum + '0'));
			}else if(sc2 == '-') {
				sum = (sc1 - '0') - (sc3 -'0');
				stack.add(0, (char) (sum + '0'));
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
			ch = stack.pop();
		}
		stack.pop();
		
		while (stack1.size() >=3) {
			char sc1 = stack1.elementAt(0);
			char sc2 = stack1.elementAt(1);
			char sc3 = stack1.elementAt(2);
			stack1.remove(0);
			stack1.remove(0);
			stack1.remove(0);
			if(sc2 == '+') {
				sum =  (sc1 - '0') + (sc3 -'0');
				stack1.add(0, (char) (sum + '0'));
			}else if(sc2 == '-') {
				sum = (sc1 - '0') - (sc3 -'0');
				stack.add(0, (char) (sum + '0'));
			}
			
		}
		
		return stack1.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}
