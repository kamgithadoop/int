package algorithm;

import java.util.List;
import java.util.Stack;


public class Greedy {
	public void greedyActivityRecur(Stack<Activity> stack, Activity first, List<Activity> max){
		if(stack.isEmpty()){
			return;
		}
		Activity second = stack.pop();
		while(second.start < first.end){
			second = stack.pop();
			if(second == null){
				max.add(first);
				return;
			}
		}
		max.add(second);
		greedyActivityRecur(stack, second, max);
	}
	
	public void greedyActivityLoop(Stack<Activity> stack,List<Activity> max){
		if(stack.isEmpty()){
			return;
		}
		Activity first = stack.pop();
		max.add(first);
		Activity second = stack.pop();
		while(!stack.isEmpty()){
			if(second.start >= first.end){
				max.add(second);
				first = second;
			}
			second = stack.pop();
		}
		if(second.start >= first.end){
			max.add(second);
		}
	}

	public static class Activity {
		public int start;public int end;
		
		public Activity(int s, int e){
			start =s;
			end = e ;
		}
		
		public String toString(){
			return this.start + "-" + this.end;
		}
	}
}
