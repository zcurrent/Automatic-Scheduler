package auto_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AutoScheduler {
	
	/**
	 * An array of type integer containing the number of employees wanted for each one of the shifts. The index corresponds with array shifts.
	 */
	private int [] numEmployeesPerShift;
	
	/**
	 * An array of type Shift, these are the shifts that need covered for Monday through Sunday
	 * FIX ME: Upgrade to allow different shifts on different days of the week
	 */
	private Shift [] shifts;
	
	/**
	 * An array of type String for the days of the week, these are used to index through the availabilities
	 */
	private String [] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	/**
	 * An ArrayList of type Employee, array list is used to allow any number of employees 
	 */
	private ArrayList<Employee> employees;
	
	/**
	 * Scanner to allow easier loading of the Shifts and Employees
	 */
	Scanner sc =  new Scanner(System.in);
	
	/**
	 * Constructs an instance of AutoScheduler, with numShifts number of Shifts, then the scheduler asks for the values for shift 
	 * and the number of employees for that given shift
	 * @param numShifts - number of shifts needing scheduled
	 */
	public AutoScheduler(int numShifts) {
		//Constructs a new array numShifts long of type Shift
		shifts = new Shift[numShifts];
		//Constructs an array numShifts long of type int
		numEmployeesPerShift = new int[numShifts];
		//Initializes employees
		employees = new ArrayList<>();
		
		//for loop going through each of the shifts getting start and end time and constructing the shift to store in shifts, 
		//then it gets the employees wanted for this shift and stores it in numEmployeesPerShift
		for(int i = 0; i < numShifts; i++) {
			try {
			System.out.println("Please enter the start and end time, in Military Standard time, for shift " + (i + 1));
			int start = sc.nextInt();
			int end = sc.nextInt();
			shifts[i] = new Shift(start, end);
			System.out.println("Please enter the number of employees you would like to work on shift " + (i + 1));
			numEmployeesPerShift[i] = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error Occured. Expected different values!");
				System.exit(0);
			}
		}
		
		
	}
	
	/**
	 * Adds numEmployees of type Employee to variable employees. for each employee it asks the desired hours and the availability 
	 * of each day of the week. Intended to speed up the initialization process
	 * @param numEmployees - the number of employees wanting to add to the schedule
	 */
	public void addEmployeesWAvail(int numEmployees) {
		/*A for loop, going through each employee to add and getting the first and last name of the employee followed by their hours
		*and another for loop creating that employee and then initializing all of the employee's availability for each day and adds 
		*the availability*/
		for(int i = 0; i < numEmployees; i++) {
			try {
			System.out.println("Please enter the first and last name followed by the hours per week for employee " + (i + 1));
			String name = sc.next() + " " + sc.next();
			int hours = sc.nextInt();
			addEmployee(name, hours);
			for(int j = 0; j < daysOfWeek.length; j++) {
				System.out.println("Please enter the start and end availability, in military standard time, for " + daysOfWeek[j] + ", for " + name);
				int start = sc.nextInt();
				int end = sc.nextInt();
				addAvailability(name, daysOfWeek[j], start, end);
			}
			} catch (InputMismatchException e) {
				System.out.println("Error Occured. Different Input Expected!");
			}
		}
	}
	
	/**
	 * Add an Employee with the given name and hoursPerWeek
	 * @param name - name of the Employee
	 * @param hoursPerWeek - hours per week for the Employee
	 */
	public void addEmployee(String name, int hoursPerWeek) {
		employees.add(new Employee(name, hoursPerWeek));
		
	}
	
	/**
	 * Add/Set an availability for name on day with the given start and end time, in military time
	 * @param name - name of the employee to set the availability
	 * @param day - the day of the week to set the availability
	 * @param start - start time in military time format 0000
	 * @param end - end time in military time format 0000
	 */
	public void addAvailability(String name, String day, int start, int end) {
		//for loop going through the variable employees to find a matching name, if found set the availability, if 
		//not do nothing
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getName().equals(name)) {
				employees.get(i).setAvailabilityShift(day, start, end);
			}
		}
	}
	
	/**
	 * A getter for employees
	 * Needs work
	 * @param i - 
	 * @return
	 */
	public String getEmployee(int i) {
		return employees.get(i).getName() + ", Wants " + employees.get(i).getHours() + " hours per week";
 	}
	
	/**
	 * The method to generate the schedule and print the result
	 */
	public void generateSchedule() {
		//Fill schedules of employees, checking if their availabilities match the shifts
		fillSchedule();
		
		//Format and print the heading of the schedule
		System.out.printf("%18s"," ");
		
		for(int i = 0; i < daysOfWeek.length; i++) {
			System.out.printf("%-24s",daysOfWeek[i]);
		}
		System.out.println();
		
		for(int i = 0; i < employees.size(); i++) {
			System.out.printf("%-18s", employees.get(i).getName());
			for(int j = 0; j < daysOfWeek.length; j++ ) {
					System.out.printf("%-24s", employees.get(i).getStandardScheduleAvailability(daysOfWeek[j]));
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Helper method to generateSchedule() to take care of the checks for the employee's availability to match the shifts and fill in their 
	 * schedule
	 */
	private void fillSchedule() {
		//A for loop to go through each day of the week checking shifts with the employee's availability
		for(int j = 0; j < daysOfWeek.length; j++) {
			int [] copy = Arrays.copyOf(numEmployeesPerShift, numEmployeesPerShift.length);
			//A for loop to go through each one of the employees, it goes through each employee on the same day then switches to the next day
			for(int i = 0; i < employees.size(); i++) {
				//Finally, a for loop to compare the availability of the employee against the stored shifts for the given dayOfWeek
				for(int k = 0; k < shifts.length; k++) {
					//If availability is null, exit inner loop
					if(employees.get(i).getAvailability(daysOfWeek[j]).equals("null")) {
						break;
					}
					/*if the numEmployeesPerShift is not 0 and the Employee has an availability (determined by them being the same number, presumably 0)
					*Then check if the start time of the employee's availability is before or equal to the start time of the shift and check if the 
					*end time is greater than or equal to the end shift. if this is correct then set the shift for the Employee in the schedule and 
					*decrement the hours for the Employee based on the length of the shift. Then decrement the numEmploueesPerShift for this shift 
					*and break from the loop of checking shifts to avoid double shifts																*/
					int hrDiff = (shifts[k].getEnd() / 100) - (shifts[k].getStart() / 100);
					double minDiff = Math.abs((shifts[k].getEndMin() - shifts[k].getStartMin()) / 60);
					double temp = hrDiff + minDiff;
					if(numEmployeesPerShift[k] != 0 && 
							employees.get(i).getAvailabilityStart(daysOfWeek[j]) != employees.get(i).getAvailabilityEnd(daysOfWeek[j]) &&
							employees.get(i).getHours() - temp >= 0 && employees.get(i).getAvailabilityStart(daysOfWeek[j]) <= shifts[k].getStart() &&
							employees.get(i).getAvailabilityEnd(daysOfWeek[j]) >= shifts[k].getEnd()) {

			
								employees.get(i).setScheduleShift(daysOfWeek[j], shifts[k].getStart(), shifts[k].getEnd());
							
								employees.get(i).setHours(employees.get(i).getHours() - temp);
								numEmployeesPerShift[k]--;
								break;
									
					}
				}
			}
			numEmployeesPerShift = Arrays.copyOf(copy, copy.length);
		}
	}
	
	
}
