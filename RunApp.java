package in.ineuron.controllerLayer;

import java.util.Scanner;

import in.ineuron.Dto.Students;
import in.ineuron.ServiceFactory.*;
import in.ineuron.ServiceLayer.*;


public class RunApp {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("**************************************** Welcome to Console Based CRUD Operations Project **************************************");
		System.out.println();
		System.out.println("Please Select the Operations You Want to Perform");
		System.out.println("1. Insertion");
		System.out.println("2. Selection");
		System.out.println("3. Deletion");
		System.out.println("4. Updation");
		System.out.println("5. Exit");
		System.out.println();
		System.out.println("Please type the number of operation you want to perform");
		int choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println("Insertion Operation has been selected.....");
			System.out.println();
			System.out.println("Calling Insertion Operation.......");
			Thread.sleep(1000);
			insetionOperation();		
		}		
		if(choice == 2)
		{
			System.out.println("Selection Operation has been selected.....");
			System.out.println();
			System.out.println("Calling Selection Operation.......");
			Thread.sleep(1000);
			selectionOperation();		
		}		
		if(choice == 3)
		{
			System.out.println("Deletion Operation has been selected.....");
			System.out.println();
			System.out.println("Calling Deletion Operation.......");
			Thread.sleep(1000);
			deleteOperation();		
		}		
		if(choice == 4)
		{
			System.out.println("Update Operation has been selected.....");
			System.out.println();
			System.out.println("Calling Update Operation.......");
			Thread.sleep(1000);
			updateOperation();		
		}		
		if(choice == 5)
		{
			System.out.println("Application logging Off.................");
			System.exit(0);
		}		

	}
	
	public static void updateOperation()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Student id you want to update ::");
		int sid = scan.nextInt();
		
		System.out.println("Enter the student age ::");
		int sage = scan.nextInt();
		
		System.out.println("Enter the student name ::");
		String sname = scan.next();
		
		System.out.println("Enter the student address");
		String saddress = scan.next();
		
		IStudentsService studentsService = StudentsServiceFactory.getstudentsService();
		String msg = studentsService.updateStudents(sid, sage, sname, saddress);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("Updation Success");
		}
		else {
			System.out.println("Updation Unsuccessfull");
		}
		scan.close();
		
	}
	
	public static void deleteOperation()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id to be deleted:: ");
		int sid = scanner.nextInt();

		IStudentsService studentsService = StudentsServiceFactory.getstudentsService();
		String message = studentsService.deletStudents(sid);
		if(message.equalsIgnoreCase("Failed")) 
		{
			System.out.println("record deleted Unsuccesfully");
		}
		else 
		{
			System.out.println("record deletion success....");
		}
		scanner.close();
	}
	
	public static void selectionOperation()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of the students you want to retrieve data of ::");
		int sid = scan.nextInt();
		IStudentsService studentsService = StudentsServiceFactory.getstudentsService();
		Students std = studentsService.searchStudents(sid);

		if (std != null) {
			System.out.println(std);
			System.out.println("SID\tAGE\tSNAME\tSADDR");
			System.out.println(std.getSid() + "\t" + std.getSage() + "\t" + std.getSid() + "\t" + std.getSaddress());
		} else {
			System.out.println("Record not found for the given id :: " + sid);
		}

		scan.close();
	}
	
	public static void insetionOperation()
	{
		IStudentsService studentsService = StudentsServiceFactory.getstudentsService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the id ::");
		int sid = scan.nextInt();
		
		System.out.println("Enter the age :: ");
		int sage = scan.nextInt();
		
		System.out.println("Enter the name :: ");
		String sname = scan.next();
		
		System.out.println("Enter the address ::");
		String saddress = scan.next();
		
		String msg = studentsService.addStudents(sid, sage, sname, saddress);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}

		scan.close();
	}
}
