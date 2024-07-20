/*
assignment number : 8
File name : 		College.java
Name : 				Daniel Eliyahu
ID : 				316461656
Email : 			danieliyahu1@gmail.com
*/

/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
import linkedList.*;
public class College {
	
	private static String nl =  System.getProperty("line.separator");

	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) {
		if ( this.getCourse(cid) == null ) {
			Course newcourse = new Course(cid, title);
			courses.add(newcourse);
		}
	}
	
	/**
	 * Prints a list of all the courses.
	 */
	public void coursesList() {
		System.out.println(courses);
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {

		// Note: You can get the course with the given cid by calling
		// the private getCourse method.
		Course rem = this.getCourse( cid );
		if ( rem == null ) return false;
		courses.remove( rem );

		ListIterator<Student> stu = students.iterator();
		Student current;
		while ( stu.hasNext() ) {
			current = stu.next();
			if ( current.tookCourse( rem )) current.removecourse( rem );
		}
		return true;
	}

	// Returns the course that has the given id, or null if there is no such course.
	private Course getCourse(int cid) {
		//if there is no course return null
		if ( courses.size() == 0 ) return null;
		//create new listiterator
		ListIterator<Course> gcourse = courses.iterator();
		//declare new course
		Course current;
		while ( gcourse.hasNext() ) {
			//current has the object o gcourse
			//gcourse advance
			current = gcourse.next();
			if (current.getCid() == cid) return current;
		}
		return null;
	}

	
	/**
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		if ( this.getStudent(sid) == null ) {
			Student astudent = new Student(sid, name);
			students.add(astudent);
		}
	}
	
	/**
	 * Prints a list of all the students.
	 */
	public void studentsList() {
		System.out.println(students);
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		if ( this.getStudent( sid ) == null ) return false;
		students.remove(this.getStudent( sid ));
		return true;
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	private Student getStudent(int sid) {
		//if ( students.getFirst().getSid() == sid ) return students.getFirst();
		//declare new listiterator of students object
		ListIterator <Student> gstudents = students.iterator();
		//declare new student object
		Student current;
		//run over all the linkedlist
		while ( gstudents.hasNext() ) {
			//current contain the object of gstudents
			current = gstudents.next();

			//if the student i check is the one i search return him
			if (current.getSid() == sid ) return current;
		}

		return null;
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		Course taken = this.getCourse( cid );
		getStudent(sid).addCourse(taken, grade);
	}
	
	/** 
	 * Prints the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public void studentReport(int sid) {
		Student check = getStudent(sid);
		if ( check == null ) System.out.println( " there is no such student ");
		else check.studentReport();
	}
	
	/**
	 * Prints a list of all the students who took the course with the given cid.
	 * @param cid  the course
	 */
	public void courseReport(int cid) {
		//declare a new Course from the course
		Course core = this.getCourse(cid);
		// if the course does not exist print a message
		if ( core == null ) {
			System.out.println( "this course does not exist in our collage" );
			return;
		}
		boolean noonetook = true;
		ListIterator<Student> stu = students.iterator();
		Student current;
		System.out.println( " the students who took " + core.getTitle() + ':');
		while ( stu.hasNext() ) {
			current = stu.next();
			if ( current.tookCourse( core ) ) {
				System.out.println ( current );
				if ( noonetook ) noonetook = false;
			}
		}
		if ( noonetook ) System.out.println( " no one took this course ");

	}
	
	/** 
	 * Prints the number of students in the given course
	 * @param cid  course id
	 */
	public void printSize(int cid) {
		//declare a new Course from the course
		Course core = this.getCourse(cid);
		// if the course does not exist print a message
		if ( core == null ) {
			System.out.println( "this course does not exist in our collage" );
			return;
		}
		ListIterator<Student> stu = students.iterator();
		int num = 0;
		Student current;
		System.out.println( " the number of students who took " + core.getTitle() + " is : ");
		while ( stu.hasNext() ) {
			current = stu.next();
			if ( current.tookCourse( core ) ) num++;
		}
		System.out.println ( num );
	}
	
	// Returns a list of all the students who took the given course
	public LinkedList<Student> studentsWhoTook(Course c) {
		//create new linked list
		LinkedList<Student> newlinked = new LinkedList();
		//create Listiterator of the students
		ListIterator<Student> stu = students.iterator();
		//declare new student variable
		Student current;
		while (stu.hasNext()) {
			current = stu.next();
			if ( current.tookCourse( c ) ) newlinked.add( current );
		}

		return newlinked;
	}
	
	/** 
	 * Prints the student with the highest grade in the given course.
	 * @param cid  course id
	 */
	public void topPerfomerReport(int cid) {
		//get the course of the cid
		Course taken = getCourse(cid);
		//if there is no course print it and return
	if ( taken == null ) {
		System.out.println( "there is no such course");
		return;
	}
	//make a linked list of the student who took the course
	LinkedList<Student> students = studentsWhoTook( taken );
	//if no one took this course print it and return
	if ( students.size() == 0 ) {
		System.out.println( "no one took this course" );
		return;
	}

	ListIterator<Student> check = students.iterator();
	Student current;
	int top = 0;
	while ( check.hasNext() ) {
		current = check.next();
		//top is the highest grade we saw
		top = Math.max( top, current.gradeInCourse(taken ));
	}
		ListIterator<Student> check2 = students.iterator();
		Student current2;
		System.out.println( " the top performer :");
		while ( check2.hasNext() ) {
			current2 = check2.next();
			//print all the students who got the highest grade
			if ( current2.gradeInCourse(taken) == top ) System.out.println( current2 );
		}


	}





	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + nl;
		str += "courses:" + nl;
		str += courses.toString() + nl;
		str += "students:" + nl;
		str += students.toString() + nl;
		return str;
	}

}
