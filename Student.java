package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int year;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int courseCost = 600;
	private static int currentID = 10000;
	
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student's first name: ");
		this.firstName = in.nextLine();
		System.out.println("Enter student's last name: ");
		this.lastName = in.nextLine();
		System.out.println("Enter student's year: \n1 - Frosh\n2 - Sophmore\n3 - Junior\n4 - Senior");
		this.year = in.nextInt();
		genID();
	}
	
	// generate an ID
	private void genID() {
		this.studentID = this.year + "" + currentID;
		currentID ++;
	}
	
	// course enroll
	public void enroll() {
		System.out.println("Enter course to enroll (q to quit): ");
		Scanner in = new Scanner(System.in);
		while (true) {
			String course = in.nextLine();
			if (!course.equals("q")) {
				this.courses = this.courses + "\n" + course;
				this.tuitionBalance += courseCost;
			}else {
				break;
			}
		}
		in.close();
		System.out.println("You have registered " + this.courses);
		System.out.println("Your total balance is " + this.tuitionBalance);
	}
	
	public void viewBalance() {
		System.out.println(this.firstName + " " + this.lastName + "'s balance is " + this.tuitionBalance);
	}
	
	public void payTuition(int payment) {
		if (payment > this.tuitionBalance) {
			System.out.println("All balance paid, returning " + (payment - this.tuitionBalance));
			this.tuitionBalance = 0;
		}else {
			this.tuitionBalance -= payment;
			System.out.println("Thanks for paying " + payment + ". Your remaining balance is " + this.tuitionBalance);
		}
	}
}
