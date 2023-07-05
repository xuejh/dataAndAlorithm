package 栈;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
	
	
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<tokens.length;i++) {
			if( tokens[i].equals("+")  || tokens[i].equals("-")||tokens[i].equals("*") ||tokens[i].equals("/") ) {
				int a = stack.pop();
				int b = stack.pop();
				int sum = 0;
				if(tokens[i].equals("+") ) {
					sum = b + a;
				}else if(tokens[i].equals("-") ) {
					sum = b - a;
				}else if(tokens[i].equals("*") ) {
					sum = b * a;
				}else if(tokens[i].equals("/") ) {
					sum = b / a;
				}
				
				stack.push(sum);
			}else {
				stack.push(Integer.parseInt(tokens[i]));
			}
			
		}
		
		return stack.pop();
    }
	
	public static void main(String[] args) {
		String[] strs = {"2","1","+","3","*"};
		System.out.println(evalRPN(strs));;
	}
}
