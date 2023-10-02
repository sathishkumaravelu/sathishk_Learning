package mandatoryHomeWork.week9.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class allTheChar {

	@Test
	public void testData() {
		String str ="Farmer jack realized that big yellow quilts were expensive";
		str.toLowerCase();
		boolean string = isString(str);
		System.out.println(string);
	}
	
	public boolean isString(String str) {
		if(str.length()<26)return false;

		HashSet<Character> hs = new HashSet<Character>();
		for (char i = 0; i < str.length(); i++) {
			if(str.charAt(i)!=' ')
			hs.add(str.charAt(i));
		}
		return hs.size()==26;
	}
}
