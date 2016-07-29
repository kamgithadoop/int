package algorithm;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import algorithm.Greedy;
import algorithm.Greedy.Activity;

import org.junit.After;
import org.junit.Test;

public class GreedyTest {
	Greedy greedy = new Greedy();
	@Test
	public void greedyActivityLoop() {
		List<Activity> maxList = new LinkedList<Activity>();
		long st = System.currentTimeMillis();
		greedy.greedyActivityLoop(getActivities(), maxList);
		System.out.println("time taken greedyActivityLoop " + ( System.currentTimeMillis()-st));
		System.out.println(maxList);
	}

	@Test
	public void greedyActivityRecur() {
		List<Activity> maxList = new LinkedList<Activity>();
		Stack<Activity> st = getActivities();
		Activity first = st.pop(); 
		maxList.add(first);
		long time = System.currentTimeMillis();
		greedy.greedyActivityRecur(getActivities(), first, maxList);
		System.out.println("time taken greedyActivityRecur " + ( System.currentTimeMillis()-time));
		System.out.println(maxList);
	}
	
	
	public Stack<Activity> getActivities(){
		Stack<Activity> st = new Stack<Activity>();
		st.push(new Activity(12,16));
		st.push(new Activity(2,14));
		st.push(new Activity(8,12));
		st.push(new Activity(8,11));
		st.push(new Activity(6,10));
		st.push(new Activity(5,9));
		st.push(new Activity(3,9));
		st.push(new Activity(5,7));
		st.push(new Activity(0,6));
		st.push(new Activity(3,5));

		st.push(new Activity(1,4));
		return st;
	}
}
