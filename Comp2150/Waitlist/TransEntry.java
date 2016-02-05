public class TransEntry {

	protected String courseName;
	protected String status;
	protected TransEntry next;


	public TransEntry(String course, String status)
	{
		this.courseName = course;
		this.status = status;
		this.next = null;
	}


	public boolean equals(String course)
	{
		boolean result = false;

		if(this.courseName.trim().equalsIgnoreCase(course.trim()))
		{
			result = true;
		}

		return result;
	}

	/**
	 * @return the next
	 */
	public TransEntry getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(TransEntry next) {
		this.next = next;
	}


	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
}
