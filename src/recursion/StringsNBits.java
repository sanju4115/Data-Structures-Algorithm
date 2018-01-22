package recursion;

public class StringsNBits {
	private static int[] arr = new int[3];
	
	public static void binary(int n){
		if(n<1){
			for(int i : arr){
				System.out.print(i);
			}
			System.out.println();
		}else{
			arr[n-1]=0;
			binary(n-1);
			arr[n-1]=1;
			binary(n-1);
		}
	}

}
