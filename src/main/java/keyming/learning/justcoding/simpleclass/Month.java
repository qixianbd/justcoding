package keyming.learning.justcoding.simpleclass;

import lombok.Getter;

public enum Month {
	Jan(1, "Janary", 31), Feb(2, "Febutary", 28), March(3, "March", 31),
	April(4, "April", 30), May(5, "May", 31), Jun(6, "June", 30), Jul(7, "July", 31),
	Aug(8, "August", 31), Sep(9, "Sepetember", 30), Oct(10, "October", 31), 
	Nov(11, "November", 30), Dec(12, "December", 31);
	
	@Getter
	private int month;
	@Getter
	private String monthName;
	private int days;
	
	private Month(int month, String monthName, int days) {
		this.month = month;
		this.monthName = monthName;
		this.days = days;
	}
	
	public String toString() {
		return getFullName();
	}
	
	public int getDaysInMonth() {
		return days;
	}
	
	private static void check(int month) {
		if (month > 12) {
			throw new RuntimeException("month should not greater than 12.");
		} else if (month < 1) {
			throw new RuntimeException("month should not less than 1.");
		}
	}
	
	public String getShortName() {
		return super.name();
	}
	
	public String getFullName() {
		return this.getMonthName();
	}
	
	public static String getShortName(int m) {
		check(m);
		return Month.values()[m - 1].name();
	}
	
	public static String getFullName(int m) {
		check(m);
		return Month.values()[m - 1].getFullName();
	}
	
	public static String getFullName(String monthName) {
		return Month.valueOf(monthName).getFullName();
	}
	
	public static int getDaysInMonth(int month) {
		check(month);
		Month m = Month.values()[month - 1];
		return m.getDaysInMonth();
	}
}