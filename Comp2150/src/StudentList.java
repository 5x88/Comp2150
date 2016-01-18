
public class StudentList {

	private Student head;
	
	
	public StudentList()
	{
		this.head = null; //Initialize empty list
	}
	
	public void addStudent(Student newStudent)
	{
		Student curr = this.head;
		this.head = newStudent;
		this.head.next = curr;
		
	}
	
	public void print()
	{
		Student curr = this.head;
		
		while(curr!=null)
		{
		System.out.println(curr.studentNum);
		curr = curr.next;
		
		}
		
		
	}
}
