## College Management System - Java Project

This project focuses on building a College Management System in Java. It uses object-oriented programming principles, linked lists, and generic data structures to manage student and course data.

### Key Features:

- Implements classes for Course, Student, and CourseTaken entities.
- Provides functionalities for adding, deleting, and managing courses and students.
- Generates reports on students (including GPA), courses, and enrollment statistics.
- Utilizes a generic linked list implementation for efficient data manipulation.
- Emphasizes exception handling for robust error management.

### Technologies:

- Java programming language
- Object-oriented programming concepts
- Linked lists
- Generic data structures

###  Code Structure:

- **Data Classes:**
    - Course: Represents a course with ID and title.
    - Student: Represents a student with ID, name, and a list of CourseTaken objects.
    - CourseTaken: Represents a student's enrollment in a course with ID and grade.

- **Infrastructure:**
    - LinkedList: Implements a generic linked list for managing any object type.
    - ListIterator (not directly used): Provides iteration services over linked lists.

- **Control:**
    - College: Manages the overall college system, including courses, students, and reports.
    - CollegeDemo (not submitted): Used for testing and demonstration purposes.

###  Implementation and Testing:

- Refer to the comments within the code marked `// Put your code here` for missing implementations.
- The recommended approach is to:
    1. Complete the LinkedList class implementation and testing.
    2. Implement and test College methods one by one.
    3. Implement Student methods and corresponding College methods.


###  Appendix A: CollegeDemo Class (For Reference Only)

This class demonstrates usage of the College class for testing purposes. It showcases functionalities like adding/removing students, generating reports, and finding top performers.
