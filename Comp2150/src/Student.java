
public class Student {

	private int studentNum;
	private String name;
	private Student next;

	
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
	

	public Student()
	{
		this.studentNum = 0;
		this.name = null;
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
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	
	/**
	 * @param studentNum the studentNum to set
	 */
	public void setStudentNum(int studentNum)
	{
		this.studentNum = studentNum;
	}
	
	
	/**
	 * @return the studentNum
	 */
	public int getStudentNum()
	{
		return studentNum;
	}
	
}
