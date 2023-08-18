package mandatoryHomeWork.week2;

import org.junit.Test;

import junit.framework.Assert;

public class W2D4_LC_1232_StraightLine {

	/*
	  * [time taken -> 2 Mins] You are given an array coordinates, coordinates[i] = [x, y], 
	  * where [x, y] represents the coordinate of a point. 
	  * Check if these points make a straight line in the XY plane.
	 * 
	 * Example:  coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
	 * Output: true
	 * 
	 * 1. Did I understand the problem? Yes
	 * What is the input(s)?  int[][]
	 * What is the expected output? boolean 
	 * Do I have any constraints to solve the problem? O(n) Do
	 * I have all the information to go to the next steps How big is your test data
	 * set will be?
	 * 
	 * Time Taken : 5 Mins 
	 * 2. Test data set Minimum 3 data set including positive,
	 * negative and edge
	 * 
	 * +ve case:
	 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
	 * Output: true
	 * 
	 * -ve case:
	 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
	 * Output: false
	 * 
	 * Edge case:
	 * Input: coordinates = [[1,1],[2,2]]
	 * Output: true
	 * 
	 * 3. Do I know to solve it? No 
	 * can I break the problem into sub problems? -- Yes
	 * 
	 * 4. Ask for hint () - Yes i did
	 * 5. Do I know alternate
	 * solutions as well Approach 1 : Bruteforce
	 * 
	 */
	
	@Test
	public void positiveTestData() {
		Assert.assertEquals(true, checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
	}
	@Test
	public void negativeTestData() {
		Assert.assertEquals(false, checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
	}
	@Test
	public void edgeTestData() {
		Assert.assertEquals(true, checkStraightLine(new int[][]{{1,1},{2,2}}));
	}
	
	public boolean checkStraightLine(int[][] coordinated) {
		if (coordinated.length < 2) {
			return true;
		}

		int x0 = coordinated[0][0];
		int y0 = coordinated[0][1];
		int x1 = coordinated[1][0];
		int y1 = coordinated[1][1];
		for (int i = 2; i < coordinated.length; i++) {
			int x = coordinated[i][0];
			int y = coordinated[i][1];
			if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
				return false;
			}

		}
		return true;
	}

}
