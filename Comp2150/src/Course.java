
public class Course {

	
	String course;
	String preReq;
	int cap;
	int studentsReg;
	int waitlistSize;
	StudentList students;
	WaitList waitlist;
	
	
	public Course()
	{
		this.course = null;
		this.preReq = null;
		this.cap = 0;
		this.studentsReg = 0;
		this.waitlistSize = 0;
		this.students = new StudentList();
		this.waitlist = new WaitList();
		
	}
	
	/**
	 * @param course
	 * @param preReq
	 * @param cap
	 * @param waitlistSize
	 */
	public Course(String course, String preReq, int cap) {
		this.course = course;
		this.preReq = preReq;
		this.cap = cap;
		this.studentsReg = 0;
		this.waitlistSize = 0;
		this.students = new StudentList();
		this.waitlist = new WaitList();
	}
	
	public void increaseCap(int n)
	{
		this.cap += n;
	}
	
	
	
	
}
