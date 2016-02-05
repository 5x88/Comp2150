public class CourseList
{

	private Course head;

	public CourseList()
	{
		this.head = null;
	}

	public boolean addCourse(Course course)
	{
		boolean added = false;

		if(head == null)
		{
			head = course;
			added = true;
		}
		else
		{
			Course curr = head;
			
			head = course;
			head.next = curr;
			
		}

		return added;
	}

	public void removeHead()
	{
		if(head.next==null)
		{
			head = null;
		}
		else
		{
			head = head.next;
		}
	}

	public void addToCourse(String course, StudentList students, int studentNum)
	{
		Student temp = students.search(studentNum);
		Course curr = search(course);
		
		
		if(temp!=null)
		{
			if(curr!=null)
			{
				if(temp.hasPreReq(course))
				{
				curr.addStudent(temp);
				}
				else
				{
					System.out.println("NO PREREQ");
				}
			}
			else
			{
				System.out.println("Course: " + course + " Not Found");
			}
		}
		else
		{
			System.out.println("Student Number: " + studentNum +" Not Found");
		}
	}

	public boolean noDup(String course)
	{
		boolean noRepeat = true;
		Course curr = head;


		while(curr != null && noRepeat == true)
		{
			if(curr.name.trim().equalsIgnoreCase(course.trim()))
			{
				noRepeat = false;

			}
			curr = curr.getNext();
		}

		return noRepeat;
	}

	public Course search(String course)
	{
		Course result = null;
		Course curr = head;

		while(curr != null)
		{
			if(curr.name.equalsIgnoreCase(course))
			{
				result = curr;
			}
			curr = curr.getNext();
		}

		return result;
	}

	public boolean remove(int studentNum, String course)
	{
		boolean removed = false;

		removed = search(course).removeFromWaitlist(studentNum);

		return removed;
	}

	public void lists(String course)
	{
		Course curr = search(course);

		if(curr!=null)
		{
			curr.print();
		}
		else
		{
			System.out.println("NOT FOUND");
		}
	}

}
