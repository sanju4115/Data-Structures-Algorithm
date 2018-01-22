package searching;

public class StringInMatrix {
	public static boolean findBiggestRegion(char[][] array, String str){
		int pos=0;
		boolean exist = false;
		for(int row=0;row<array.length;row++){
			for(int column=0;column<array[row].length;column++){
				if(array[row][column]==str.charAt(pos)){
					System.out.println(str.charAt(pos));
					boolean[][] visited = new boolean[array.length][array[0].length];
					visited[row][column]=true;
					exist = getRegionSize(array,row,column,str,pos+1,visited);
					if(exist==true)
						return true;
				}
			}
		}		
		return exist;
	}
	
	private static boolean getRegionSize(char[][] array, int row, int column, String str, int pos,boolean[][] visited) {
		if(str.length() == pos){
			return true;
		}
		if(row<0 || column < 0 || row >= array.length || column >=array[row].length){
			return false;
		}
		
		for(int r=row-1; r<=row+1;r++){
			for(int c=column-1; c<=column+1;c++){
				if(r<0 || c < 0 || r >= array.length || c >=array[r].length || (row==r && column==c)){
				}else{
					if(array[r][c]==str.charAt(pos) && !visited[r][c]){
						System.out.println(str.charAt(pos));
						visited[r][c] = true;
						boolean exist = getRegionSize(array,r,c,str,pos+1,visited);
						if(exist==true){
							return true;
						}
					}
				}

			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		char grid[][] = {
				{'A','C','P','R','C'},
				{'X','S','O','P','C'},
				{'V','O','V','N','I'},
				{'W','G','F','M','N'},
				{'Q','A','T','I','T'}
		};
		
		char grid1[][] = {
				{'X','C','A','T'},
				{'P','A','L','Q'},
				{'I','R','B','U'},
				{'G','P','X','N'},
				{'G','O','D','W'}
				
		};
		System.out.println(findBiggestRegion(grid,"ASVM"));
		System.out.println(findBiggestRegion(grid,"Z"));
		System.out.println(findBiggestRegion(grid,"MICROSOFT"));
		System.out.println(findBiggestRegion(grid1,"GAS"));
	}
}
