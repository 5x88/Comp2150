public class Student 
{

	protected int studentNum;
	protected String name;
	protected Student next;
	protected Transcript transcript;


	public Student(int studentNum, String name)
	{
		this.studentNum = studentNum;
		this.name = name;
		this.next = null;
		this.transcript = new Transcript();
	}


	public Student()
	{
		this.studentNum = 0;
		this.name = null;
		this.next = null;
		this.transcript = new Transcript();
	}

	public boolean equals(Student student)
	{
		boolean result = false;

		if(this.studentNum == student.studentNum)
		{
			result = true;
		}

		return result;
	}
	
	public boolean hasPreReq(String course)
	{
		return transcript.hasCourse(course);
	}

	public void print()
	{
		System.out.println("Student number: " + studentNum + " Name: " + name);
		
	}


	public Student getNext() 
	{
		return next;
	}


	public void setNext(Student next)
	{
		this.next = next;
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * @return the studentNum
	 */
	public int getStudentNum()
	{
		return studentNum;
	}


	public Transcript getTranscript()
	{
		return transcript;
	}


}
