package mandatoryHomeWork.Foundation;
import org.junit.Test;

public class Day5_CountPrimeNo {

	@Test
	public void test() {
		System.out.println(countPrime(13));
	}

	@Test
	public void test1() {
		System.out.println(countPrime(10));
	}

	@Test
	public void test2() {
		System.out.println(countPrime(-10));
	}

	public int countPrime(int num) {
		int count = 0;

		while (num >= 0) {

			if (checkPrimeNo(num)) {
				count++;
			}
			num--;
		}

		return count;

	}

	public boolean checkPrimeNo(int value) {

		if (value == 1) {
			return false;
		}

		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
}
