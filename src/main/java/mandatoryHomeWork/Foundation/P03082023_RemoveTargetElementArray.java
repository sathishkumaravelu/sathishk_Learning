package mandatoryHomeWork.Foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P03082023_RemoveTargetElementArray {

	@Test
	public void test() {
		List<Integer> removeTargetEle = removeTargetEle(new int[] { 2, 3, 3, 4, 5 }, 3);

		System.out.println(removeTargetEle);
	}

	public List<Integer> removeTargetEle(int[] input, int target) {

		//Arrays.sort(input);

		List<Integer> outputList = new ArrayList<>();

		for (int i = 0; i < input.length; i++) {

			if (input[i] != target) {

				outputList.add(input[i]);
			}
		}
		return outputList;
	}
}
