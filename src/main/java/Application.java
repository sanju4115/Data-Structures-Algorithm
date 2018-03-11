import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application {

	public static void main(String[] args){
		int[] input3 = {};
		int[] input1 = {};
		int[] input2 = {};

		//merge2

		//merge1
		System.out.println(findPossibleSmallestNumberMatchingPattern("MNMMM"));


	}

	private static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		if(pattern == null){
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
