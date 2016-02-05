public class WaitList extends StudentList
{

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
			this.head.next = null;
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

	public boolean removeStudent(int studentNum)
	{
		boolean found = false;

		Student curr = head;
		Student prev = null;

		while(curr != null && found == false)
		{
			if(curr.getStudentNum() == studentNum)
			{
				if(prev!=null)
				{
					prev.setNext(curr.getNext());
				}
				else
				{
					curr = null;
				}
				found = true;
			}
			prev = curr;

			if(curr!=null)
			if(curr.getNext()!=null)
			{
				curr = curr.getNext();
			}
		}

		return found;


	}

	public Student moveToClassList()
	{
		Student first = head;

		head = head.getNext();

		return first;
	}

}
