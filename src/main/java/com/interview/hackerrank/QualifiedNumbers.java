package com.interview.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;


/*
 * Given an array of integers find sequence of integers separated by comma
 * in ascending order which contains 1, 2 and 3 in any order.
 */
public class QualifiedNumbers {

	public static void main(String[] args) {
		int[] numberArray = {456123,67231,123,321,4123};
		System.out.println(findQualifiedNumbers(numberArray));
		System.out.println(findQualifiedNumbers(new int[]{321,123456,56789,0,111,222,333}));
		System.out.println(findQualifiedNumbers(new int[]{123456,56789,4321,411233,112233,221133}));
		System.out.println(findQualifiedNumbers(new int[]{}));
		        
	}
	
	static String findQualifiedNumbers(int[] numberArray) {
		Arrays.sort(numberArray);
		String str = "";
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<numberArray.length;i++){
			if(util(numberArray[i])){
				list.add(numberArray[i]);
			}
		}
		
		for(int i=0;i<list.size();i++){
			str = str.concat(String.valueOf(list.get(i)));
			if(i!=list.size()-1){
				str = str.concat(",");
			}
		}
		
		if(list.isEmpty()){
			return "-1";
		}
		
		return str;
    }

    private static boolean util(int number){
    	String input = String.valueOf(number);
    	String chars = "123";
    	int charsLen = chars.length();
    	
    	int[] needTofind = new int[256];
    	for(int i=0;i<chars.length();i++){
    		needTofind[chars.charAt(i)]++;
    	}
    	int[] hasFound = new int[256];
    	int count = 0;
    	for(int begin=0;begin<input.length();begin++){
    		if(needTofind[input.charAt(begin)] ==0){
    			continue;
    		}
    		
    		hasFound[input.charAt(begin)]++;
    		if(hasFound[input.charAt(begin)] <= needTofind[input.charAt(begin)]){
    			count++;
    		}
    		
    		if(count==charsLen){
    			return true;
    		}
    	}
    	
    	return false;
    }

}
