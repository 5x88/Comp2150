public class PreReq {

	private Course head;

	public PreReq()
	{
		head = null;
	}

	protected void addPreReq(Course course)
	{
		if(head == null)
		{
			head = course;
		}
		else
		{
			head.next = course;
		}
	}
	
	

}
