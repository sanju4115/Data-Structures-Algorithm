package stack;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntStack {
	
	private static class Node{
		boolean flag;
		int count;
		
	}
	
	static long[] maxMin(String[] operations, int[] x) {
		Queue<Integer> q = new PriorityQueue<>();
		long[] result = new long[x.length];
		for (int i =0; i<operations.length; i++){
			if(operations[i].equals("push")){
				q.add(x[i]);
			}else{
				q.remove(x[i]);
			}
			ArrayList<Integer> array = new ArrayList<Integer>(q);
			result[i]=array.get(0)*array.get(array.size()-1);
		}
		return result;
    }
	static long waitingTime(int[] tickets, int p) {
		
		Queue<Integer> q = new PriorityQueue<>();
		
		
		LinkedList<Node> list = new LinkedList<>();
		for(int i=0;i<tickets.length;i++){
			Node node = new Node();
			node.count = tickets[i];
			if(i==p){
				node.flag = true;
			}
			list.addLast(node);
		}
		
		int time =0;
		
		while(!list.isEmpty()){
			time++;
			Node node = list.removeFirst();
			node.count = node.count-1;
			if(node.flag==true && node.count == 0){
				break;
			}
			
			if(node.count>0){
				list.addLast(node);
			}
		}
		
		return time;
    }
	
	public static void main(String[] args) {	
		Scanner sc  = new Scanner(System.in);
		int loop = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i =0;i<loop;i++){
			int low = sc.nextInt();
			int high = sc.nextInt();
			int totalCount = 0;
			while(low<=high){
			    if(set.contains(low)){
					totalCount++;
					low++;
					continue;
				}
				String binary = Integer.toBinaryString(low);
				/*if(binary.indexOf('0')==-1){
					totalCount++;
					set.add(low);
					low++;
					continue;
				}
				*/
				int firstIndexOfZero = binary.indexOf('0');
				if(firstIndexOfZero > 0 && binary.substring(firstIndexOfZero).indexOf('1')==-1){
					totalCount++;
					set.add(low);
					low++;
					continue;
				}
						
				int count = 0;
				char[] charArray = binary.toCharArray();
				int max = 0;
				for(int j=0;j<charArray.length;j++){
					if(charArray[j]=='1'){
						while(j<charArray.length && charArray[j]!='0'){
							j++;
							count++;
						}			
						if(count>max){
							max = count;
							count=0;
							String sub = binary.substring(j);
							if(j==charArray.length || sub.indexOf('1')==-1){
							    set.add(low);
								totalCount++;
							}
						}else{
							break;
						}
						j--;
					}
					
				}
				
				low++;
			}
			
			System.out.println(totalCount);
		}
		
		sc.close();
		
	}

}
