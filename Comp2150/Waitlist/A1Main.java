import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class A1Main
{

	public static void main(String[] args) 
	{

		try{


			Scanner kbd;
			String inputString;
			String[] split;
			StudentList students = new StudentList();
			CourseList courses = new CourseList();

			kbd = new Scanner(System.in);

			FileReader f1 = new FileReader(System.getProperty("user.dir") + kbd);
			//FileReader f1 = new FileReader("/Users/Mike/Desktop/a1_data.txt");
			BufferedReader br1 = new BufferedReader(f1);


			//inputString = kbd.nextLine();
			String line = br1.readLine();
			
			


			while(!(line.equalsIgnoreCase("Quit")))
			{

				System.out.println("\n"+line);
				split = line.split("\\s+");

				if(split[0].equalsIgnoreCase("NEW"))
				{
					newStudent(students,split);
				}
				else if(split[0].equalsIgnoreCase("COURSE"))
				{
					addCourse(courses, students, split);
				}
				else if(split[0].equalsIgnoreCase("ADD"))
				{
					addToCourse(courses,students,split);
				}
				else if(split[0].equalsIgnoreCase("REMOVE"))
				{
					remove(courses,students,split);
				}
				else if(split[0].equalsIgnoreCase("TRANSCRIPT"))
				{
					transcript(students, courses, split);
				}
				else if(split[0].equalsIgnoreCase("CAPACITY"))
				{
					capacity(courses,students,split);
				}
				else if(split[0].equalsIgnoreCase("STATUS"))
				{
					status(students,split);
				}
				else if(split[0].equalsIgnoreCase("LISTS"))
				{
					lists(courses,split);
				}
				else if(split[0].equalsIgnoreCase("#"))
				{
					String comment = "";
					for(int i=1;i<split.length;i++)
					{
						comment += split[i] + " ";
					}
					comment.trim();
					System.out.println(comment);
				}

				line = br1.readLine();
				//inputString = kbd.nextLine();
			}

			System.out.println("\nDONE");

			br1.close();
			kbd.close();

		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}

	}


	public static void newStudent(StudentList students, String[] split)
	{
		String name = "";

		for(int i=2;i<split.length;i++)
		{
			name += split[i] + " ";
		}

		name.trim();

		if(students.addStudent(new Student(Integer.parseInt(split[1]),name)))
		{
			System.out.println("CONFIRMED");
		}
		else
		{
			System.out.println("DUPLICATE");
		}
	}

	public static void addCourse(CourseList courses, StudentList students, String[] split)
	{
		String courseName = split[1] + " " + split[2];

		if(courses.noDup(courseName))
		{

			Course newCourse = new Course(courseName);
			courses.addCourse(newCourse);

			String preReq = "";

			for(int i=3; i<split.length; i++)
			{
				preReq += split[i] + " ";
			}

			preReq.trim();
			String temp = "";

			boolean preReqDup = false;

			for(int i=2;i<split.length-1 && !preReqDup;i+=2)
			{
				for(int j=1;j<3;j++)
				{
					temp += split[j+i] + " ";
				}
				temp.trim();

				preReqDup = courses.noDup(temp);


				if(!preReqDup)
				{
					newCourse.addPreReq(temp,courses);
				}
				else
				{
					courses.removeHead();
					System.out.println("PREREQ COURSE: " + temp + " NOT FOUND");
					preReqDup = true;
				}
				temp = "";
			}

			if(!preReqDup)
			{
				System.out.println("CONFIRMED");
			}

		}
		else
		{
			System.out.println("DUPLICATE");
		}
	}

	public static void addToCourse(CourseList courses, StudentList students, String[] split)
	{
		courses.addToCourse(split[2] + " " + split[3], students, Integer.parseInt(split[1]));
	}

	public static void remove(CourseList courses, StudentList students,String[] split)
	{
		String name = split[2] + " " + split[3];
		int studentNum = Integer.parseInt(split[1]);

		if(!students.searchForDup(studentNum))
		{
			if(!courses.noDup(name))
			{
				if(courses.remove(studentNum,name))
				{
					System.out.println("CONFIRMED");
				}
				else
				{
					System.out.println("NOT APPLICABLE");
				}
			}
			else
			{
				System.out.println("Course: " + name + " Not Found");
			}
		}
		else
		{
			System.out.println("Student Number: " + studentNum +" Not Found");
		}

	}

	public static void transcript(StudentList students, CourseList courses, String[] split)
	{
		
		students.addToTranscript(Integer.parseInt(split[1]), courses,  split[2] + " " + split[3], split[4]);

	}

	public static void capacity(CourseList courses, StudentList students, String[] split)
	{
		if(courses.noDup(split[1]))
		{
			courses.search((split[1]) + " " + split[2]).increaseCap(Integer.parseInt(split[3]));
			System.out.println("CONFIRMED");
		}
		else
		{
			System.out.println("Course: "+ split[1] +" NOT FOUND");
		}

	}

	public static void status(StudentList students, String[] split)
	{
		Student status = students.search(Integer.parseInt(split[1]));
		if(status!=null)
		{
		status.print();
		}
		else
		{
			System.out.println("Student: " + split[1] + " Not Found");
		}
	}

	public static void lists(CourseList courses, String[] split)
	{
		courses.lists(split[1] + " " + split[2]);
	}
}
