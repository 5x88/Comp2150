
public class WaitList extends StudentList{

	public WaitList()
	{
		this.head = null;
	}
	
	public boolean addStudent(Student newStudent)
	{
		boolean result = false;
		Student curr;

		if(this.head == null)
		{
			this.head = newStudent;
		}
		else
		{
			curr = head;
			while ((curr.getNext() != null)) 
			{
				curr = curr.getNext();
			}

			curr.setNext(newStudent); 
		}
		return result;
	}
	
	public void removeStudent()
	{
		
		head = head.getNext();
		
	}
	
	public Student moveToClassList()
	{
		Student first;
		
		first = head;
		
		head = head.getNext();
		
		return first;
	}
	
}
