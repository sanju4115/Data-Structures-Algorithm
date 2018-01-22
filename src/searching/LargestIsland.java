package searching;

public class LargestIsland {
	
	public static int findBiggestRegion(int[][] array){
		int maxRegion =0;
		int count=0;
		for(int row=0;row<array.length;row++){
			for(int column=0;column<array[row].length;column++){
				if(array[row][column]==1){
					int size  = getRegionSize(array,row,column);
					maxRegion = Math.max(size, maxRegion);
					count++;
				}
			}
		}
		
		return count; // island count
		//return maxRegion; // max area 

	}
	
	private static int getRegionSize(int[][] array, int row, int column) {
		if(row<0 || column < 0 || row >= array.length || column >=array[row].length){
			return 0;
		}
		
		if(array[row][column] == 0){
			return 0;
		}
		
		array[row][column] =0;
		int size =1;
		for(int r=row-1; r<=row+1;r++){
			for(int c=column-1; c<=column+1;c++){
				size +=getRegionSize(array,r,c);
			}
		}
		
		return size;
	}

	public static void main(String[] args) {
		int array[][]= {  
				{1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };
		 System.out.println(findBiggestRegion(array));
	}

}
