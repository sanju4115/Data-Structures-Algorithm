package recursion;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutations {
	
	public static void permutation(char[] input){
		TreeMap<Character, Integer> map = new TreeMap<>();
		for(char ch : input){
			map.compute(ch, (key,val) ->{
				if(val==null){
					return 1;
				}else{
					return val+1;
				}
			});
		}
		
		int[] count = new int[map.size()];
		char[] str = new char[map.size()];
		int index =0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			count[index] = entry.getValue();
			str[index] = entry.getKey();
			index++;
		}
		
		char[] result = new char[input.length];
		permutationUtil(count,str,result,0);
	}

	private static void permutationUtil(int[] count, char[] str, char[] result, int level) {
		if(level==result.length){
			for(char ch : result){
				System.out.print(ch);
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<str.length;i++){
			if(count[i]==0){
				continue;
			}
			result[level]=str[i];
			count[i]--;
			permutationUtil(count, str, result, level+1);
			count[i]++;
		}
	}
	
	public static void combination(char[] input){
		TreeMap<Character, Integer> map = new TreeMap<>();
		for(char ch : input){
			map.compute(ch, (key,val) ->{
				if(val==null){
					return 1;
				}else{
					return val+1;
				}
			});
		}
		
		int[] count = new int[map.size()];
		char[] str = new char[map.size()];
		int index =0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			count[index] = entry.getValue();
			str[index] = entry.getKey();
			index++;
		}
		
		char[] result = new char[input.length];
		combinationaUtil(count,str,result,0,0);
	}

	private static void combinationaUtil(int[] count, char[] str, char[] result, int length,int pos) {
		
		for(int i=0; i<length;i++){
			System.out.print(result[i]);
		}
		System.out.println();
		
		for(int i=0;i<str.length;i++){
			if(count[i]==0){
				continue;
			}
			result[length]=str[i];
			count[i]--;
			combinationaUtil(count, str, result, length+1,i);
			count[i]++;
		}
	}

}
