package auto_scheduler;

public class Employee {

	private int numHoursPerWeek;

	private String name;

	private Shift[] availabilities;

	private Shift[] schedule;

	public Employee(String name, int hoursPerWeek) {
		availabilities = new Shift[7];
		schedule = new Shift[7];

		this.numHoursPerWeek = hoursPerWeek;

		this.name = name;

	}

	public String getName() {
		return name;
	}

	public int getHours() {
		return numHoursPerWeek;
	}

	public void setHours(int hours) {
		numHoursPerWeek = hours;
	}

	public String getAvailability(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getShift();
		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getShift();
		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getShift();
		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getShift();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getShift();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getShift();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getShift();

		} else {
			return "INVALID DAY";
		}
	}

	public String getStandardAvailability(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getStandardShift();
		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getStandardShift();
		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getStandardShift();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getStandardShift();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getStandardShift();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getStandardShift();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getStandardShift();

		} else {
			return "INVALID DAY";
		}
	}

	public void setAvailabilityShift(String day, int start, int end) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			availabilities[0] = new Shift(start, end);
		} else if (day.equals("TUESDAY")) {
			availabilities[1] = new Shift(start, end);
		} else if (day.equals("WEDNESDAY")) {
			availabilities[2] = new Shift(start, end);
		} else if (day.equals("THURSDAY")) {
			availabilities[3] = new Shift(start, end);

		} else if (day.equals("FRIDAY")) {
			availabilities[4] = new Shift(start, end);

		} else if (day.equals("SATURDAY")) {
			availabilities[5] = new Shift(start, end);

		} else if (day.equals("SUNDAY")) {
			availabilities[6] = new Shift(start, end);

		} else {
			System.out.println("Error. Not a validate day, please enter a full day. Ex: Monday");
		}
	}

	public int getAvailabilityStart(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getStart();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getStart();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getStart();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getStart();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getStart();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getStart();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getStart();

		} else {
			return 0;
		}
	}
	
	public int getAvailabilityStartHr(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getStartHr();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getStartHr();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getStartHr();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getStartHr();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getStartHr();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getStartHr();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getStartHr();

		} else {
			return 0;
		}
	}

	public int getAvailabilityStartMin(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getStartMin();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getStartMin();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getStartMin();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getStartMin();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getStartMin();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getStartMin();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getStartMin();

		} else {
			return 0;
		}
	}

	public int getAvailabilityEnd(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getEnd();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getEnd();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getEnd();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getEnd();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getEnd();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getEnd();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getEnd();

		} else {
			return 0;
		}
	}
	
	public int getAvailabilityEndHr(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getEndHr();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getEndHr();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getEndHr();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getEndHr();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getEndHr();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getEndHr();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getEndHr();

		} else {
			return 0;
		}
	}

	public int getAvailabilityEndMin(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return availabilities[0].getEndMin();

		} else if (day.equals("TUESDAY")) {
			return availabilities[1].getEndMin();

		} else if (day.equals("WEDNESDAY")) {
			return availabilities[2].getEndMin();

		} else if (day.equals("THURSDAY")) {
			return availabilities[3].getEndMin();

		} else if (day.equals("FRIDAY")) {
			return availabilities[4].getEndMin();

		} else if (day.equals("SATURDAY")) {
			return availabilities[5].getEndMin();

		} else if (day.equals("SUNDAY")) {
			return availabilities[6].getEndMin();

		} else {
			return 0;
		}
	}

	public String getScheduleAvailability(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getShift();
		} else if (day.equals("TUESDAY")) {
			return schedule[1].getShift();
		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getShift();
		} else if (day.equals("THURSDAY")) {
			return schedule[3].getShift();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getShift();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getShift();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getShift();

		} else {
			return "INVALID DAY";
		}
	}

	public String getStandardScheduleAvailability(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getStandardShift();
		} else if (day.equals("TUESDAY")) {
			return schedule[1].getStandardShift();
		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getStandardShift();

		} else if (day.equals("THURSDAY")) {
			return schedule[3].getStandardShift();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getStandardShift();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getStandardShift();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getStandardShift();

		} else {
			return "INVALID DAY";
		}
	}
	
	public void setScheduleShift(String day, int start, int end) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			schedule[0] = new Shift(start, end);
		} else if (day.equals("TUESDAY")) {
			schedule[1] = new Shift(start, end);
		} else if (day.equals("WEDNESDAY")) {
			schedule[2] = new Shift(start, end);
		} else if (day.equals("THURSDAY")) {
			schedule[3] = new Shift(start, end);

		} else if (day.equals("FRIDAY")) {
			schedule[4] = new Shift(start, end);

		} else if (day.equals("SATURDAY")) {
			schedule[5] = new Shift(start, end);

		} else if (day.equals("SUNDAY")) {
			schedule[6] = new Shift(start, end);

		} else {
			System.out.println("Error. Not a validate day, please enter a full day. Ex: Monday");
		}
	}

	public int getScheduleStartHr(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getStartHr();

		} else if (day.equals("TUESDAY")) {
			return schedule[1].getStartHr();

		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getStartHr();

		} else if (day.equals("THURSDAY")) {
			return schedule[3].getStartHr();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getStartHr();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getStartHr();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getStartHr();

		} else {
			return 0;
		}
	}

	public int getScheduleStartMin(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getStartMin();

		} else if (day.equals("TUESDAY")) {
			return schedule[1].getStartMin();

		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getStartMin();

		} else if (day.equals("THURSDAY")) {
			return schedule[3].getStartMin();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getStartMin();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getStartMin();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getStartMin();

		} else {
			return 0;
		}
	}

	public int getScheduleEndHr(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getEndHr();

		} else if (day.equals("TUESDAY")) {
			return schedule[1].getEndHr();

		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getEndHr();

		} else if (day.equals("THURSDAY")) {
			return schedule[3].getEndHr();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getEndHr();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getEndHr();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getEndHr();

		} else {
			return 0;
		}
	}

	public int getScheduleEndMin(String day) {
		day = day.toUpperCase();
		if (day.equals("MONDAY")) {
			return schedule[0].getEndMin();

		} else if (day.equals("TUESDAY")) {
			return schedule[1].getEndMin();

		} else if (day.equals("WEDNESDAY")) {
			return schedule[2].getEndMin();

		} else if (day.equals("THURSDAY")) {
			return schedule[3].getEndMin();

		} else if (day.equals("FRIDAY")) {
			return schedule[4].getEndMin();

		} else if (day.equals("SATURDAY")) {
			return schedule[5].getEndMin();

		} else if (day.equals("SUNDAY")) {
			return schedule[6].getEndMin();

		} else {
			return 0;
		}
	}
}
