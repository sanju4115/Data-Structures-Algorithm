package sorting;

public class Sorting {

    //merge4
	
	public static void insertionSort(int arr[]){
		for(int i=1;i<arr.length-1;i++){
			int value = arr[i];
			int hole = i;
			while(hole> 0 && arr[hole-1]>value){
				arr[hole] = arr[hole-1];
				hole = hole-1;
			}
			arr[hole] = value;
		}
	}
	
	public static void selectionSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int min = i;
			for(int j=i+1;j<arr.length-1;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min]=temp;
		}
	}
	
	
	public static void bubbleSort(int arr[]){
		boolean swapped =true;
		for(int i = arr.length-1;i>=0&&swapped;i--){
			swapped =false;
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
					swapped=true;
				}
			}
		}
	}
	
	public static void mergeSort(int arr[], int start, int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr,start,mid,end);
			
		}
	}
	
	private static void merge(int[] arr, int low, int mid, int high) {
		int left = low;
		int right = mid+1;
		int temp[] = new int[high-low+1];
		int tempPos=0;
		while(left<=mid && right<=high){
			if(arr[left]< arr[right]){
				temp[tempPos] = arr[left];
				left=left+1;
			}else{
				temp[tempPos] = arr[right];
				right=right+1;
			}
			tempPos++;
		}
		
		if(left<=mid){
			while(left<=mid){
				temp[tempPos] = arr[left];
				tempPos++;
				left=left+1;
			}
		}else if(right<=high){
			while(right<=high){
				temp[tempPos] = arr[right];
				right=right+1;
				tempPos++;
			}
		}
		
		
		
		for(int i=0;i<temp.length;i++){
			arr[low+i] = temp[i];
		}
	}


	public static void quickSort(int arr[], int start, int end){
		if(start<end){
			int index = partition(arr,start,end);
			quickSort(arr, start, index-1);
			quickSort(arr, index+1, end);
		}
		
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int index = start;
		for(int i=start;i<end-1;i++){
			if(arr[i]<=pivot){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		int temp = arr[index];
		arr[pivot] = arr[end];
		arr[index] = temp;
		
		return index;
	}

}
