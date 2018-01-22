package searching;

public class FllippingOIntoX {
	public static void findBiggestRegion(char[][] array){
		boolean[][] visited = new boolean[array.length][array[0].length];
		
	}
	
	private static void getRegionSize(char[][] array, int row, int column,boolean[][] visited) {
		if(row<0 || column < 0 || row >= array.length || column >=array[row].length){
			return ;
		}
		
		if(visited[row][column]) {
			return;
		}else {
			visited[row][column]=true;
		}
		
		if(array[row][column]=='O') {
			
		}
		
	
	}

	public static void main(String[] args) {
		char grid[][] = {
				{'X','X','X','X','X'},
				{'X','O','X','O','X'},
				{'X','O','X','X','X'},
				{'X','X','O','X','X'},
				{'X','X','O','X','X'},
				{'X','X','O','O','X'},
				{'X','X','X','O','X'}
		};
		
		char grid1[][] = {
				{'X','C','A','T'},
				{'P','A','L','Q'},
				{'I','R','B','U'},
				{'G','P','X','N'},
				{'G','O','D','W'}
				
		};
		
		findBiggestRegion(grid);
	}
}
