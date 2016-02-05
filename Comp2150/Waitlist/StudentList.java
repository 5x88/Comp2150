public class StudentList {

	protected Student head;


	public StudentList()
	{
		this.head = null; //Initialize empty list
	}

	public boolean addStudent(Student newStudent)
	{
		boolean noDuplicate = searchForDup(newStudent.studentNum);

		if(noDuplicate)
		{
			Student curr = this.head;
			this.head = newStudent;
			this.head.setNext(curr);
		}

		return noDuplicate;

	}

	public void addToTranscript(int studentNum, CourseList courses, String course, String status)
	{
		Student tempStudent = search(studentNum);
		Course tempCourse = courses.search(course);

		if(tempCourse!=null)
		{
			if(tempStudent != null)
			{
				tempStudent.transcript.addCourse(new TransEntry(course,status));
				System.out.println("CONFIRMED");
			}
			else
			{
				System.out.println("Student: " + studentNum + "NOT FOUND");
			}

		}
		else
		{
			System.out.println("Course: " + course + "NOT FOUND");
		}
	}

	public void status(int studentNum)
	{
		Student curr = head;

		while(curr!=null)
		{
			curr.print();
			curr = curr.next;
		}

	}

	public boolean searchForDup(int studentNum)
	{
		boolean notFound = true;
		Student curr = head;

		while(curr != null && notFound == true)
		{
			if(curr.studentNum == studentNum)
			{
				notFound = false;
			}
			curr = curr.getNext();
		}

		return notFound;
	}

	public Student search(int studentNum)
	{
		boolean found = false;
		Student curr = head;
		Student result = null;

		while(curr != null && found == false)
		{
			if(curr.getStudentNum() == studentNum)
			{
				found = true;
				result = curr;
			}
			curr = curr.getNext();
		}

		return result;
	}


}
