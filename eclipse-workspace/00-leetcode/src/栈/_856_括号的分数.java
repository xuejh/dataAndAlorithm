package 栈;

import java.util.Stack;

public class _856_括号的分数 {
	
	public static int scoreOfParentheses1(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
//			System.out.println(s.charAt(i));
			if(s.charAt(i) == '(') {
				stack.push('(');
			}else {
				char c = stack.pop();
				if(c == '(') {
					stack.push('1');
				}else {
					int sum = c - '0';
					while ((c = stack.pop()) !='(') {
						sum += c -'0';
					}
					stack.push((char) (sum *2 + '0'));
				}
			}
		}
		
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop() - '0';
			
		}
		return result;
    }
	
	
	public static int scoreOfParentheses(String s) {
		
		if(s.length() == 2) {
			return 1;
		}
		
		int bal = 0; int len =0;int n = s.length();
		for (int i = 0; i < n; i++) {
			bal += (s.charAt(i) == '(' ? 1 : -1);
			if(bal == 0) {
				len = i+1;
				break;
			}
		}
		
		if(len == n) {
			return 2 * scoreOfParentheses(s.substring(1, n-1));
		}else {
			return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
		}
    }

	
	
	public static void main(String[] args) {
		scoreOfParentheses("(())()");
	}
	
}
