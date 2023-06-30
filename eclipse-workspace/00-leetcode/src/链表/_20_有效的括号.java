package 链表;


import java.util.Stack;

public class _20_有效的括号 {
	
	public boolean isValid(String s) {
		Boolean result = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}else if (c == ')' && stack.size() >0 && stack.peek() == '(') {
				stack.pop();
			}else if (c == '}'&& stack.size() >0 && stack.peek() == '{') {
				stack.pop();
			}else if (c == ']'&& stack.size() >0 && stack.peek() == '[') {
				stack.pop();
			}else if(c == ')' || c == '}' || c == ']') {
				stack.push(c);
			}
		}
		
		if(stack.size() == 0) {
			result = true;
		}
		
		
		return result;
    }
	
}
