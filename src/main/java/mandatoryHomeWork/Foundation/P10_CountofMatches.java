package mandatoryHomeWork.Foundation;

import org.junit.Assert;
import org.junit.Test;

public class P10_CountofMatches {
	@Test
	public void testData1() {
		 Assert.assertEquals(6, numberOfMatches(7)); ;
	}
	@Test
	public void testData() {
		 Assert.assertEquals(13, numberOfMatches(14)); ;
	}
	 public int numberOfMatches(int n) {
	        int count =0;
	        int matches =0;
	        while (n>1){

	            if(n%2==0){
	                count =count+n/2;
	                n=n-n/2;
	            }else {
	                count = count + ((n-1)/2);
	                n=n-(n-1)/2;
	            }
	        }
	        return count;
	    }
}
