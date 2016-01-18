
public class Student {

	int studentNum;
	String name;
	Student next;

	
	public Student(int studentNum, String name, Student next)
	{
		this.studentNum = studentNum;
		this.name = name;
		this.next = next;
	}
	
	public Student(int studentNum, String name)
	{
		this.studentNum = studentNum;
		this.name = name;
		this.next = null;
	}

	public Student getNext() 
	{
		return next;
	}

	public void setNext(Student next)
	{
		this.next = next;
	}
	
	public int getStudentNum()
	{
		return studentNum;
	}
}
