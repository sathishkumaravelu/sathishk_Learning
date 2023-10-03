package mandatoryHomeWork.week10.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class W10D1_LC1436_DestinationCity {

	/*
	 * https://leetcode.com/problems/destination-city/description/
	 */
	/*
	   1. Problem understanding - 2 Mins
	   		Input - List<List<String>>
	   		Output- String 
	   		Constrain 
	   2. Test Data - 3 Mins
	   3. Solution - Yes ( Hashing Algo )
	   4. Best solution / alternate solution - Yes
	   5. Pesudo Code - Yes - 2 Mins 
	   6. dry run - pseudo code - 2 mins
 	   7. write the code on paper - 5 mins 
 	   8. test code - 2 mins
 	   9. code on IDE - 5 Mins
 	   10. test nd debug - 2 mins
 	   11. optimize
	 */
	
	@Test
	public void validData() {
//		
//		  List<List<String>> listOfLists = new ArrayList<>(); 
//		  //String[][] paths ={{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
//		  List<String> innerList1 = new ArrayList<>(); innerList1.add("London");
//		  innerList1.add("New York");
//		  
//		  List<String> innerList2 = new ArrayList<>(); innerList2.add("New York");
//		  innerList2.add("Lima");
//		  
//		  List<String> innerList3 = new ArrayList<>(); innerList3.add("Lima");
//		  innerList3.add("Sao Paulo");
//		  
//		  listOfLists.add(innerList1); listOfLists.add(innerList2);
//		  listOfLists.add(innerList3);
//		  
//		  System.out.println(listOfLists);
		 
		
		String[][] paths = {{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}};

        List<List<String>> listPaths = Arrays.stream(paths)
                .map(Arrays::asList)
                .map(ArrayList::new)
                .collect(Collectors.toList());
        String destCity = destCity(listPaths);
        System.out.println(destCity);
	}

	
	public String destCity(List<List<String>> paths) {
		
		HashSet<String> destinationSet = new HashSet<String>();
		for (List<String> listdest : paths) {
			destinationSet.add(listdest.get(1));
		}
		for (List<String> listorg : paths) {
			destinationSet.remove(listorg.get(0));
		}
		if (!destinationSet.isEmpty()) return destinationSet.iterator().next();
 		else return null;
	}
	
	
	//Pseudo Code:
	//iterate thru the given list 
	//keep adding all the values to the map 
	//fetch the last value of the map and return 

	public String destCity_errors(List<List<String>> paths) {
		Map<String, Integer> destinationMap = new LinkedHashMap<>();
		for (List<String> listCitites : paths) {
			destinationMap.put(listCitites.get(0), destinationMap.getOrDefault(listCitites.get(0), 0) + 1);
			destinationMap.put(listCitites.get(1), destinationMap.getOrDefault(listCitites.get(1), 0) + 1);
		}
		Map.Entry<String, Integer> lastEntry = null;
		for (Map.Entry<String, Integer> entry : destinationMap.entrySet()) {
			lastEntry = entry;
		}
		if (lastEntry != null) {
			return lastEntry.getKey();
		}
		return null;
	}
	
}
