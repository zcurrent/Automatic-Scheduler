package auto_scheduler;


public class Shift {
	
	private int startHr;
	
	private int startMin;
	
	private int endHr;
	
	private int endMin;
	
	/**
	 * Constructs and Shift with start time and end time
	 * @param start - start of Shift in military time
	 * @param end - end of Shift in military time
	 */
	public Shift(int start, int end) {
		this.startHr = start / 100;
		this.startMin = start % 100;
		this.endHr = end / 100;
		this.endMin = end % 100;
		
	}
	
	/**
	 * Access the Shift in military time
	 * @return the Shift in format 00:00 - 00:00
	 */
	public String getShift() {
		
		return String.format("%02d:%02d - ", startHr, startMin) + String.format("%02d:%02d", endHr, endMin);
	}
	
	/**
	 * Access the Shift in Standard time (12hr)
	 * @return the Shift in format 00:00 a.m. - 00:00 a.m.
	 */
	public String getStandardShift() {
		
		if(startHr > 12) {
			if(endHr > 12) {
				return String.format("%02d:%02d p.m. - ", startHr - 12, startMin)  + String.format("%02d:%02d p.m.", endHr - 12, endMin);
				
			}
			return String.format("%02d:%02d p.m. - ", startHr - 12, startMin) + String.format("%02d:%02d a.m.", endHr, endMin);
			
		} else if(endHr > 12) {
			return String.format("%02d:%02d a.m. - ", startHr, startMin) + String.format("%02d:%02d p.m.", endHr - 12, endMin);
			
		} else {
			return String.format("%02d:%02d a.m. - ", startHr, startMin) + String.format("%02d:%02d a.m.", endHr, endMin);
			
		}
	}
	
	public int getStart() {
		return (startHr * 100) + startMin;
	}
	
	public int getEnd() {
		return (endHr * 100) + endMin;
	}
	
	public int getStartHr() {
		return startHr;
	}
	
	public int getStartMin() {
		return startMin;
	}
	public int getEndHr() {
		return endHr;
	}
	public int getEndMin() {
		return endMin;
	}
	

}
