
public class Waitlist extends StudentList{

	public Waitlist()
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
}
