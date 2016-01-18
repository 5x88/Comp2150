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

			if(spltStr[0].equalsIgnoreCase("ADD"))
			{
				
				students.addStudent(new Student(Integer.parseInt(spltStr[1]),spltStr[2]));
				
			}
			
			System.out.println("Please enter stuff");
			inputString = kbd.nextLine();
		}
		
		students.print();




		kbd.close();
	}

}
