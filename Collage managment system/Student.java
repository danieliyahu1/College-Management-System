/*
assignment number : 8
File name : 		Student.java
Name : 				Daniel Eliyahu
ID : 				
Email : 			danieliyahu1@gmail.com
*/

/**
 * Represents a student.
 */
import linkedList.*;
public class Student {
	
	private int sid;                             
	private String name;                         
	private LinkedList<CourseTaken> courseList;
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's sid
	 * @param name the student's name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
		courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the sid of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {
		return sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {
		//check if ths student took the course or not
		if ( tookCourse( c )) {
			ListIterator<CourseTaken> current = courseList.iterator();
			CourseTaken curs;
			while (current.hasNext()) {
				//curs contain current object
				//advance current
				curs = current.next();
				//if the student took "curs" change his grade
				if (curs.getCourse().equals(c)) curs.setGrade(grade);
			}
		}
		else{
			//create new CourseTaken
			CourseTaken add = new CourseTaken( c, grade);
			//add the new CourseTaken to the linkedlist of CourseTaken of the student
			courseList.add(add);
		}
	}


	
	/** 
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {
		//create new listiterator that point to the first node of courseList
		ListIterator<CourseTaken> check = this.courseList.iterator();

		//declare new CourseTaken objects
		CourseTaken current;

		//loop while the i still in the linkedlist
		while ( check.next() != null ) {
			//update current
			current = check.next();
			//if i find the course, return the grade
			if ( current.getCourse().equals( c ) ) return current.getGrade();
		}

		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		//create new listiterator that point to the first node of courseList
		ListIterator<CourseTaken> check = this.courseList.iterator();

		//current is the first course
		CourseTaken current;

		//loop while the i still in the linkedlist
		while ( check.hasNext() ) {
			//update current
			current = check.next();
			//if i find the course, return true
			if ( current.getCourse().equals( c ) ) return true;
			if ( current.getCourse().getCid() ==  c.getCid() )  return true;

		}
		return false;
	}
	
	/**
	 * Prints this student, all the courses that s/he took, and the grade point average.
	 */
	public void studentReport() {
		//create ListIterator of the courselist
		ListIterator<CourseTaken> report = this.courseList.iterator();
		//declare CourseTaken that hold report
		CourseTaken current;
		double avr = 0;
		int counter = 0;
		System.out.println( getName() + " courses:");

		while ( report.hasNext() ) {
			//update current
			current = report.next();
			//sum the avarage with the new grade
			avr += current.getGrade();
			//print the name of the course and the grade
			System.out.println( current.getCourse().getTitle() + " : " + current.getGrade() );
			//update counter
			counter++;

		}
		if ( counter == 0 ) System.out.println( getName() + " did not take any course");

		else System.out.println(getName() + " avargae gardes is : " + avr / counter);
	}

	public boolean removecourse( Course c ) {
		ListIterator<CourseTaken> curstaken = courseList.iterator();
		CourseTaken current;
		while ( curstaken.hasNext() ) {
			current = curstaken.next();
			if ( current.getCourse().getCid() == c.getCid() ) {
				courseList.remove( current );
				return true;
			}
		}
		return false;
	}



	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + sid + ": " + name;
	}
}