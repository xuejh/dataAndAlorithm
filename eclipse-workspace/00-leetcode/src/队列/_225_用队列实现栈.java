package 队列;

import java.util.LinkedList;
import java.util.Queue;

public class _225_用队列实现栈 {
	
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	public _225_用队列实现栈() {

    }
    
    public void push(int x) {
    	queue2.offer(x);
    	while (!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}
    	Queue<Integer> temp = queue2;
    	queue2 = queue1;
    	queue1 = temp;
    }
    
    public int pop() {
    	return queue1.poll();
    }
    
    public int top() {
    	
    	return queue1.peek();
    }
    
    public boolean empty() {
    	return queue1.isEmpty();
    }
}


