package conditiontester;

/**	
 * This is the ConditionTester template. Use this class to test simple boolean methods!
 * @author Keshav Gurushankar
 * @date 11/1/16
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionTester {
	public static void main(String[] args) {
		ConditionTester ct = new ConditionTester();
		Scanner in = new Scanner(System.in);
		System.out.println("1 - Check if a point is in a rectangle.");
		System.out.println("2 - Check if a year is a leap year.");
		System.out.println("3 - Check if a number has only two ending zeroes.");
		System.out.println("4 - Check which of two dates is later.");
		System.out.println("5 - Get the total cost of your order from apzone.com");
		System.out.println("6 - Find the closest color to a RGB ratio.");
		System.out.println("7 - Find which file can fit on a medium of a give size.");
		// System.out.println("3 - ");
		System.out.print("Enter the number of the option you would like to select:");
		int option = in.nextInt();

		switch (option) {
		case (1): // point in rect
			System.out.print("Enter the x coordinate =>");
			int x = in.nextInt();
			System.out.print("Enter the y coordinate =>");
			int y = in.nextInt();
			System.out.print("Enter the x coordinate of the rectangle =>");
			int rectX = in.nextInt();
			System.out.print("Enter the y coordinate of the rectangle =>");
			int rectY = in.nextInt();
			System.out.print("Enter the rectangle's width =>");
			int rectW = in.nextInt();
			System.out.print("Enter the rectangle's height =>");
			int rectH = in.nextInt();
			System.out.println("The point is" + ((ct.isPointinRect(x, y, rectX, rectY, rectW, rectH)) ? " " : " not ")
					+ "in the rectangle.");
			break;
		case (2): // leap year
			System.out.print("Enter the year you would like to test =>");
			int year = in.nextInt();
			System.out.println("The year " + year + " is" + ((ct.isLeapYear(year)) ? " " : " not ") + "a leap year.");
			break;
		case (3): // 2 ending zeroes
			System.out.print("Enter the number =>");
			int num = in.nextInt();
			System.out.println("The number " + num + ((ct.hasTwoEndingZeroes(num)) ? " ends" : " does not end")
					+ " with two zeroes.");
			break;
		case (4): // later date
			System.out.print("Enter the first date in format mm/dd/yyyy =>");
			String da1 = in.next();
			System.out.print("Enter the second date in format mm/dd/yyyy =>");
			String da2 = in.next();
			System.out.println(
					da1 + " is" + ((ct.isLater(da1, da2)) ? " later than " : " the same day or before ") + da2 + ".");
			break;
		case (5): // order total
			System.out.print("Enter the number of \"Be Prepared\" textbooks being bought =>");
			int bp = in.nextInt();
			System.out.print("Enter the number of \"Next Best\" textbooks being bought =>");
			int nb = in.nextInt();
			DecimalFormat money = new DecimalFormat("$0.00");
			System.out.println("The total cost of the order is " + money.format(ct.getOrderTotal(bp, nb)));
			break;
		case (6):
			System.out.println("Enter the red value =>");
			int r = in.nextInt();
			System.out.println("Enter the green value =>");
			int g = in.nextInt();
			System.out.println("Enter the blue value =>");
			int b = in.nextInt();
			System.out.println("The best color is " + ct.bestMatch(r, g, b) + ".");
			break;
		case (7):
			System.out.println("Enter the size of the first file =>");
			int size1 = in.nextInt();
			System.out.println("Enter the size of the second file =>");
			int size2 = in.nextInt();
			System.out.println("Enter the size of the available storage on the medium =>");
			int space = in.nextInt();
			int out = ct.findBestFit(size1, size2, space);
			String text = (out == 0) ? "Neither file will fit on the storage medium."
					: (out == 1) ? "File 1 will fit but file 2 will not fit as well"
							: (out == 2) ? "File 2 will fit but file 1 will not fit as well"
									: "Both files will fit on the storage medium.";
			System.out.println(text);
			break;
		default:
			System.out.println("That is not an option. Please enter a valid menu option.");
			main(args);
			in.close();
			return;
		}

		System.out.print("Would you like to run again? (y/n)");
		if (in.next().equals("y")) {
			main(args);
			in.close();
			return;
		} else {
			in.close();
			System.out.println("Goodbye...");
		}
	}

	public boolean exampleTestMethod(int x, int y) {
		return false;
	}

	public boolean isPointinRect(int x, int y, int rectX, int rectY, int rectW, int rectH) {
		return x >= rectX && x <= rectX + rectW && y >= rectY && y <= rectY + rectH;
	}

	public boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	public boolean hasTwoEndingZeroes(int num) {
		return (num % 100 == 0 && num % 1000 != 0);
	}

	public boolean isLater(String da1, String da2) {
		String[] date1 = da1.split("/");
		String[] date2 = da2.split("/");
		int m1 = Integer.parseInt(date1[0]);
		int d1 = Integer.parseInt(date1[1]);
		int y1 = Integer.parseInt(date1[2]);
		int m2 = Integer.parseInt(date2[0]);
		int d2 = Integer.parseInt(date2[1]);
		int y2 = Integer.parseInt(date2[2]);
		return (y1 > y2) || ((y1 == y2) && ((m1 > m2) || ((m1 == m2) && (d1 > d2))));
	}

	public Double getOrderTotal(int bp, int nb) {
		int both;
		if (bp + nb < 3) {
			both = Math.min(bp, nb);
			bp -= both;
			nb -= both;
			return (both * 37.95) + (bp * 18.95) + (nb * 21.95);
		} else if (bp + nb < 12) {
			return (bp + nb) * 15.95;
		} else {
			return (bp + nb) * 14.00;
		}

	}

	public int findBestFit(int size1, int size2, int space) {
		if (size1 + size2 <= space) {
			return 3;
		} else if (size1 > space && size2 > space) {
			return 0;
		} else {
			if (size1 >= size2 && size1 <= space) {
				return 1;
			} else {
				return 2;
			}
		}
	}

	public String bestMatch(int r, int g, int b) {
		int max = (Math.max(r, Math.max(g, b)));
		if (r == g && g == b) {
			return "Gray";
		} else if (r == g && r == max) {
			return "Yellow";
		} else if (g == b && g == max) {
			return "Cyan";
		} else if (b == r && b == max) {
			return "Magenta";
		} else if (max == r) {
			return "Red";
		} else if (max == g) {
			return "Green";
		} else if (max == b) {
			return "Blue";
		} else {
			return "error";
		}

	}
}
