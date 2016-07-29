package array;

public class BitOperation {
	
	public int  lonelyinteger(int[] arr) {
		int unique = arr[0];
		for (int i = 1; i < arr.length; i++) {
			unique = unique ^ arr[i];
		}
		return (unique);
	}

}
