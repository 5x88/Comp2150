public class Transcript
{

	private TransEntry head;

	public Transcript()
	{
		this.head = null;
	}

	public void addCourse(TransEntry entry)
	{
		TransEntry curr = head;
		head = entry;
		head.next = curr;
		
	}

	public boolean CoursePassed(String course)
	{
		boolean passed = false;

		TransEntry curr = head;

		while(curr!=null)
		{
			if(curr.equals(course))
			{
				if(curr.status.equalsIgnoreCase("PASS"))
				{
					passed = true;
				}
			}
			curr = curr.next;
		}

		return passed;
	}

	public boolean hasPreReq()
	{
		boolean result = false;

		if(this.head!=null)
		{
			result = true;
		}

		return result;
	}

	public boolean hasCourse(String course)
	{
		boolean result = false;

		TransEntry curr = head;

		while(curr != null)
		{
			if(curr.courseName.equalsIgnoreCase(course))
			{
				if(curr.status.equalsIgnoreCase("passed"))
					result = true;
			}
			curr = curr.getNext();
		}
		return result;
	}

}
