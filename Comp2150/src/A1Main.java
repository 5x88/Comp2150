import java.util.Scanner;

public class A1Main
{

	public static void main(String[] args)
	{


		Scanner kbd;
		String inputString;
		String[] spltStr;
		StudentList students = new StudentList();


		kbd = new Scanner(System.in);
		System.out.println("Please enter stuff");

		inputString = kbd.nextLine();
		while(!(inputString.equalsIgnoreCase("Quit")))
		{

			spltStr = inputString.split("\\s+");

			if(spltStr[0].equalsIgnoreCase("NEW"))
			{
				add(students,spltStr);
			}
			else if(spltStr[0].equalsIgnoreCase("COURSE"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("ADD"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("REMOVE"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("TRANSCRIPT"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("CAPACITY"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("STATUS"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("LISTS"))
			{
				
			}
			else if(spltStr[0].equalsIgnoreCase("#"))
			{
				System.out.println(spltStr[1]);
			}

			System.out.println("Please enter stuff");
			inputString = kbd.nextLine();
		}

		students.print();
		
		System.out.println("\nDONE");




		kbd.close();
	}
	
	
	public static void add(StudentList students, String[] split)
	{
		if(students.addStudent(new Student(Integer.parseInt(split[1]),split[2])))
		{
			System.out.println("CONFIRMED");
		}
		else
		{
			System.out.println("DUPLICATE");
		}
	}

}
