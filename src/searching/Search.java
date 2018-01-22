package searching;

public class Search {
	
	public static int binarySearch(int[] arr, int n){
		int low = 0;
		int high = arr.length-1;
		return binarySearchUtil(arr, low, high, n);
	}
	
	private static int binarySearchUtil(int[] arr, int low, int high, int n){
		if (low>high){
			return -1;
		}
		
		int mid = low + (high-low)/2;
		if(arr[mid]==n){
			return mid;
		}else if(arr[mid]<n){
			return binarySearchUtil(arr, low, mid-1, n);
		}else{
			return binarySearchUtil(arr, mid+1, high, n);
		}
	}

}
