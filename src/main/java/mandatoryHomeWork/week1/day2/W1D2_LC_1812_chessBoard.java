package mandatoryHomeWork.week1.day2;

import org.junit.Test;

import junit.framework.Assert;

public class W1D2_LC_1812_chessBoard {

	 @Test
	public void test() {
		boolean checkChessBoard = checkChessBoard("a1");
		Assert.assertEquals(false, checkChessBoard);
	}

	 @Test
	public void test1() {
		boolean checkChessBoard = checkChessBoard("e3");
		Assert.assertEquals(false, checkChessBoard);
	}

	@Test
	public void test2() {
		boolean checkChessBoard = checkChessBoard("h3");
		Assert.assertEquals(true, checkChessBoard);
	}

	 @Test
	public void test3() {
		boolean checkChessBoard = checkChessBoard("h7");
		Assert.assertEquals(true, checkChessBoard);
	}

	public boolean checkChessBoard(String input) {

		if (input.charAt(0) % 2 == 0) {
			if (input.charAt(1) % 2 != 0) {
				return true;
			}

		} else if (input.charAt(0) % 2 != 0) {
			if (input.charAt(1) % 2 == 0) {
				return true;
			}
		}

		return false;
	}

}
