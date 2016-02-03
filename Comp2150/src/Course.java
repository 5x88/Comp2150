
public class Course {

	
	String course;
	String preReq;
	int cap;
	int studentsReg;
	int waitlistSize;
	
	
	public Course()
	{
		this.course = null;
		this.preReq = null;
		this.cap = 0;
		this.studentsReg = 0;
		this.waitlistSize = 0;
		
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
	}
	
	public void increaseCap(int n)
	{
		this.cap += n;
	}
	
	
	
	
}
