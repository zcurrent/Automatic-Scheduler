package auto_scheduler;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoScheduler {
	public static final String mon = "MONDAY";
	public static final String tues = "TUESDAY";
	public static final String wed = "WEDNESDAY";
	public static final String thu = "THURSDAY";
	public static final String fri = "FRIDAY";
	public static final String sat = "SATURDAY";
	public static final String sun = "SUNDAY";
	
	private int [] numEmployeesPerShift;
	private Shift [] shifts;
	private String [] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	private ArrayList<Employee> employees;
	Scanner sc =  new Scanner(System.in);
	
	
	public AutoScheduler(int numShifts) {
		shifts = new Shift[numShifts];
		numEmployeesPerShift = new int[numShifts];
		employees = new ArrayList<>();
		
		for(int i = 0; i < numShifts; i++) {
			System.out.println("Please enter the start and end time, in Military Standard time, for shift " + (i + 1));
			int start = sc.nextInt();
			int end = sc.nextInt();
			shifts[i] = new Shift(start, end);
			System.out.println("Please enter the number of employees you would like to work on shift " + (i + 1));
			numEmployeesPerShift[i] = sc.nextInt();
		}
		
		
	}
	
	public void addEmployeesWAvail(int numEmployees) {
		for(int i = 0; i < numEmployees; i++) {
			System.out.println("Please enter the first and last name followed by the hours per week for employee " + (i + 1));
			String name = sc.next() + sc.next();
			int hours = sc.nextInt();
			addEmployee(name, hours);
			for(int j = 0; j < daysOfWeek.length; j++) {
				System.out.println("Please enter the start and end availability, in military standard time, for " + daysOfWeek[j] + ", for " + name);
				int start = sc.nextInt();
				int end = sc.nextInt();
				addAvailability(name, daysOfWeek[i], start, end);
			}
		}
	}
	
	public void addEmployee(String name, int hoursPerWeek) {
		employees.add(new Employee(name, hoursPerWeek));
		
	}
	
	public void addAvailability(String name, String day, int start, int end) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getName().equals(name)) {
				employees.get(i).setAvailabilityShift(day, start, end);
			}
		}
	}
	
	
	public String getEmployee(int i) {
		return employees.get(i).getName() + ", Wants " + employees.get(i).getHours() + " hours per week";
 	}
	
	public void generateSchedule() {
		//Fill schedules of employees
		fillSchedule();
		
		//Format and print the heading of the schedule
		System.out.print("                    ");
		
		for(int i = 0; i < daysOfWeek.length; i++) {
			System.out.print(daysOfWeek[i]);
			System.out.print("    ");
		}
		System.out.println();
		
		
	}
	
	/**
	 * Testing out git 
	 */
	
	private void fillSchedule() {
		for(int j = 0; j < daysOfWeek.length; j++) {
			for(int i = 0; i < employees.size(); i++) {
				for(int k = 0; k < shifts.length; k++) {
					if(numEmployeesPerShift[k] != 0 && employees.get(i).getAvailabilityStart(daysOfWeek[j]) != employees.get(i).getAvailabilityEnd(daysOfWeek[j])) {
						if(employees.get(i).getAvailabilityStart(daysOfWeek[j]) <= shifts[k].getStart() && employees.get(i).getAvailabilityEnd(daysOfWeek[j]) >= shifts[k].getEnd()) {
							employees.get(i).setScheduleShift(daysOfWeek[j], shifts[k].getStart(), shifts[k].getEnd());
							break;
							
						}
					}
				}
			}
		}
	}
	
	
}
