
public class StudentList {

	protected Student head;


	public StudentList()
	{
		this.head = null; //Initialize empty list
	}

	public boolean addStudent(Student newStudent)
	{
		boolean duplicate = search(newStudent.getStudentNum());
		
		if(duplicate)
		{
		Student curr = this.head;
		this.head = newStudent;
		this.head.setNext(curr);
		}
		
		return duplicate;

	}

	public void print()
	{
		Student curr = this.head;

		while(curr!=null)
		{
			System.out.println(curr.getStudentNum());
			curr = curr.getNext();

		}

	}

	private boolean search(int studentNum)
	{
		boolean noRepeat = true;

		Student curr = head;

		while(curr != null && noRepeat == true)
		{
			if(curr.getStudentNum() == studentNum)
			{
				noRepeat = false;
			}
			curr = curr.getNext();
		}

			return noRepeat;
	}

}
