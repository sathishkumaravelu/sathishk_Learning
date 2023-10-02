package mandatoryHomeWork.week9.day6;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class EmployeeDetails {

	@Test
	public void Employee() {
		Map<Integer, Employee> employeeMap = new HashMap<>();
		employeeMap.put(1, new Employee("Sathish", 100, 18));
		employeeMap.put(2, new Employee("guna", 101, 28));
		employeeMap.put(3, new Employee("Leen", 102, 24));
		employeeMap.put(4, new Employee("Vishnu", 103, 26));
		employeeMap.put(5, new Employee("Nishok", 104, 1));
		
		for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
			int id = entry.getKey();
			Employee employee = entry.getValue();
			System.out.println("Employee ID: " + id + ", Name: " + employee.getName() + ", Age: " + employee.getAge());
		}
	}
}