package com.natwest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_API {

	public static void main(String[] args) {
		Set<String> city = new HashSet<>();
		
		city.add("Chennai");
		city.add("Delhi");
		city.add("Kolkata");
		System.out.println(city);
		city.forEach((String add) ->
		{
			System.out.println(add);
		});
		
		TreeSet<Integer> nums = new TreeSet<Integer>();
		nums.add(40);
		nums.add(10);
		nums.add(60);
		nums.add(30);
		nums.add(80);
		nums.add(70);
		
		System.out.println(nums);
		
		TreeSet<String> name = new TreeSet<String>();
		name.add("Harry");
		name.add("David");
		name.add("Peter");
		name.add("Albert");
		name.add("Albert");
		
		System.out.println(name);
		
		};
	}

