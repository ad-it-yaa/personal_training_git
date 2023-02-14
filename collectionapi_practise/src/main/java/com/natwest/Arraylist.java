package com.natwest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Arraylist {

	public static void main(String[] args) {
		
		ArrayList<String> custlist = new ArrayList<String>();
		custlist.add(0,"One");
		custlist.add(0,"1");
		System.out.println(custlist);
		
		ArrayList<String> custlist2 = new ArrayList<String>();
		custlist2.add("One");
		custlist2.add("Two");
		custlist.addAll(custlist2);
		custlist.set(0, "String updated using set");
		System.out.println(custlist);
		
		Iterator<String> i = custlist.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next() + " ");
		}
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,89,0);
		Collections.sort(nums);
		int pos = Collections.binarySearch(nums, 4);
		System.out.println(pos);;
		
	}
	
}
