package badProgrammerNoCaffiene;

import java.util.Random;

/**
 * Sorts an array of integers or objects by randomly selecting positions in an array to place them in. Completes in O(infinity) time.
 * @author Gabriel Butruille
 *
 */
public class BogoSort {
	private static Random rand = new Random();
	
	@SuppressWarnings("unused")
	private BogoSort(){}
	
	/**
	 * Sorts an integer array by randomly generating number combinations.
	 * Accepts arrays of up to length 2^31-1, although this will take, on average, about 1.13*10^19107526488 permutations.
	 * @param arr
	 * @return
	 */
	public static int[] BogoSort(int arr[]){
		int length = arr.length;
		int[] posArr;
		int[] copyArr = new int[length];
		boolean isSorted = false;
		
		while(!isSorted){
			posArr = positionArray(length);
			
			//randomly sort array
			for(int i = 0; i < length; i++){
				copyArr[i] = arr[posArr[i]];
			}
			
			isSorted = true;
			
			//check to see if the array is randomly sorted
			for(int i = 0; i < length - 1 && isSorted; i++){
				if(copyArr[i] > copyArr[i + 1]){
					isSorted = false;
				}
			}
		}
		
		return copyArr;
	}
	
	/**
	 * Generates an array of randomly sorted positions from 0 to length (exclusive).
	 * @param length
	 * @return
	 */
	private static int[] positionArray(int length){
		int[] positionArray = new int[length];
		boolean isUsed = false;
		int pos;
		int i = 0;
		
		//while there are still spaces left to fill
		while(i < length){
			pos = rand.nextInt(length);
			
			//check to see if this position hasn't been used before
			for(int a = 0; a < i; a++){
				if(positionArray[a] == pos){
					isUsed = true;
					break;
				}
			}
			
			if(isUsed){
				isUsed = false;
			}
			else{
				positionArray[i] = pos;
				i++;
			}
		}
		
		return positionArray;
	}
}
