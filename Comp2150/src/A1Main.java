import java.util.Scanner;

public class A1Main
{

	public static void main(String[] args)
	{


		Scanner kbd;
		String inputString;
		String[] split;
		StudentList students = new StudentList();
		WaitList waitlist = new WaitList();


		kbd = new Scanner(System.in);
		System.out.println("Please enter stuff");

		inputString = kbd.nextLine();
		while(!(inputString.equalsIgnoreCase("Quit")))
		{

			split = inputString.split("\\s+");

			if(split[0].equalsIgnoreCase("NEW"))
			{
				add(students,split);
			}
			else if(split[0].equalsIgnoreCase("COURSE"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("ADD"))
			{
				waitlist.addStudent(new Student(Integer.parseInt(split[1]),split[2]));
			}
			else if(split[0].equalsIgnoreCase("REMOVE"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("TRANSCRIPT"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("CAPACITY"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("STATUS"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("LISTS"))
			{
				
			}
			else if(split[0].equalsIgnoreCase("#"))
			{
				System.out.println(split[1]);
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
