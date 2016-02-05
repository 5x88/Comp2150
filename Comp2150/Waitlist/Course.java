public class Course
{


	String name;

	Course next;
	int cap;
	int studentsReg;
	int waitlistSize;
	StudentList students;
	WaitList waitlist;
	PreReq preReq;


	public Course()
	{
		this.name = null;
		this.next = null;
		this.cap = 0;
		this.studentsReg = 0;
		this.waitlistSize = 0;
		this.students = new StudentList();
		this.waitlist = new WaitList();
		this.preReq = new PreReq();
	}

	/**
	 * @param course - name of course
	 * @param preReq - prereq of course
	 */
	public Course(String course)
	{
		this.name = course;
		this.next = null;
		this.cap = 0;
		this.studentsReg = 0;
		this.waitlistSize = 0;
		this.students = new StudentList();
		this.waitlist = new WaitList();
		this.preReq = new PreReq();
	}

	public void increaseCap(int n)
	{
		this.cap += n;

		if(waitlistSize > 0)
		{
			while(studentsReg < cap && waitlistSize > 0)
			{
				students.addStudent(waitlist.moveToClassList());
				waitlistSize--;
				studentsReg++;
			}
		}

	}

	public void addPreReq(String preReq, CourseList courses)
	{
		this.preReq.addPreReq(courses.search(preReq));	
	}

	public void addStudent(Student student)
	{

		if(students.searchForDup(student.studentNum))
		{
			if(waitlist.searchForDup(student.studentNum))
			{

				if(studentsReg<cap)
				{
					students.addStudent(student);
					studentsReg++;
					System.out.println("ADDED");
				}
				else
				{
					waitlist.addStudent(student);
					waitlistSize++;
					System.out.println("CONFIRMED");
				}
			}
			else
			{
				System.out.println("AlREADY ON WAITLIST");
			}
		}
		else
		{
			System.out.println("AlREADY IN COURSE");
		}


	}

	public boolean removeFromWaitlist(int studentNum)
	{
		boolean removed = false;

		removed = waitlist.removeStudent(studentNum);

		return removed;
	}

	public boolean removeStudent()
	{
		boolean result = false;




		return result;
	}

	public void print()
	{

	}

	public boolean equals(Course course)
	{
		boolean result = false;

		if(this.name.equalsIgnoreCase(course.name))
		{
			result = true;
		}

		return result;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return name;
	}

	/**
	 * @return the next
	 */
	public Course getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Course next) {
		this.next = next;
	}

}
