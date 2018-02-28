package dynamic;

import java.util.Arrays;
import java.util.Comparator;

import model.Item;

public class KnapSackProblem {
	
	public static double FractionalKnapSack(Item[] arr, int weight){
		Arrays.sort(arr, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if(o1.value/o1.weight>o2.value/o2.weight){
					return -1;
				}else if(o1.value/o1.weight < o2.value/o2.weight){
					return 1;
				}else{
					return o1.weight;
				}
			}
			
		});
		
		int currentWeight =0;
		double value =0;
		for(int i=0;i<arr.length;i++){
			if(currentWeight+arr[i].weight <=weight){
				value += arr[i].value;
				currentWeight += arr[i].weight;
			}else{
				 int remain = weight - currentWeight;
		         value += arr[i].value * ((double) remain / arr[i].weight);
		         break;
			}
			
		}
		return value;
	}

}
