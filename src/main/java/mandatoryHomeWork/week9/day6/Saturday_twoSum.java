package mandatoryHomeWork.week9.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Saturday_twoSum {

	@Test
	public void testData() {
		int[] Output = twoSum1(new int[] { 1, 2, 3, 6, 4, 8 }, 4);
		System.out.println(Arrays.toString(Output));
		/*
		 * String key = "SizeOfTheArray"; //Integer txt = 150; int hashValue =
		 * key.hashCode();
		 * 
		 * int boxValue =(hashValue >>> 16); int index = ((16 - 1) & boxValue);
		 * System.out.println(index);
		 */
		
	}
	public int[] twoSum1(int[] arr, int target) {
	     for (int i = 0; i < arr.length; i++) {
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] + arr[j] == target) {
	                    return new int[] {i, j};
	                }
	            }
	        }
		return null;
	}
	public int[] twoSum_Map(int[] arr, int target) {
		HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(target-arr[i])) {
				return new int[]{map.get(target-arr[i]),i};
			}else {
				map.put(arr[i], i);
			}
		}
		return null;
	}
	}
