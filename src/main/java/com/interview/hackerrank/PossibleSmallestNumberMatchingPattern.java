package com.interview.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Pattern consists of M and N. Both 2 digit
 * M decreasing and N increasing
 * First digit of next two digit will be considered of the previous two digits
 * return smallest of all possible integers
 */
public class PossibleSmallestNumberMatchingPattern {
	public static void main(String[] args){
		System.out.println(findPossibleSmallestNumberMatchingPattern(""));        
		System.out.println(findPossibleSmallestNumberMatchingPattern("M"));        
		System.out.println(findPossibleSmallestNumberMatchingPattern("MNM"));        
		System.out.println(findPossibleSmallestNumberMatchingPattern("MNMMMMM"));        
	}
	
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		if(pattern == null || pattern.equals("")){
			return -1;
		}
		String str ="";
		for(int i=1;i<=pattern.length()+1;i++){
			str = str.concat(String.valueOf(i));
		}
		
		List<String> list = permute(str.toCharArray());
		
		for(String s : list){
			int i;
			boolean flag = true;
			for(i=0;i<pattern.length();i++){
				if(pattern.charAt(i)=='M'){
					if(s.charAt(i) < s.charAt(i+1)){
						flag = false;
						break;
					}
				}
			
				if(pattern.charAt(i)=='N'){
					if(s.charAt(i) > s.charAt(i+1)){
						flag = false;
						break;
					}
				}
			}
			if(flag){
				return Integer.valueOf(s);
			}
		
		}
		
		return -1;
    }
	
	
	public static List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public static void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }
}
