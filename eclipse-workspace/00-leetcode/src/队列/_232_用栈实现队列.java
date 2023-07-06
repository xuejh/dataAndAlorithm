package 队列;

import java.util.Stack;

public class _232_用栈实现队列 {
	
	
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	public _232_用栈实现队列() {
		
    }
    
    public void push(int x) {
    	stack1.push(x);
    }
    
    public int pop() {
    	while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
    	int num = stack2.pop();
    	while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
    	return num;
    }
    
    public int peek() {
    	while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
    	int num = stack2.peek();
    	while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
    	return num;
    }
    
    public boolean empty() {
    	return stack1.isEmpty();
    }
}
