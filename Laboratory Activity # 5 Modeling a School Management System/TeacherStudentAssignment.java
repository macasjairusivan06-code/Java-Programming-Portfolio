class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

// Student IS-A Person
class Student extends Person {
    String studentId;

    public Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println("--- Student Information ---");
        displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println();
    }
}

// Course class used as an example of aggregation
class Course {
    String courseCode;
    String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + courseName);
    }
}

// Teacher IS-A Person, HAS-A Course (Aggregation)
class Teacher extends Person {
    String department;
    Course[] courses;

    public Teacher(String name, int age, String gender, String department, Course[] courses) {
        super(name, age, gender);
        this.department = department;
        this.courses = courses;
    }

    public void displayTeacher() {
        System.out.println("--- Teacher Information ---");
        displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Courses Handled:");
        for (Course c : courses) {
            c.displayCourse();
        }
        System.out.println();
    }
}

// Main program class
public class TeacherStudentAssignment {
    public static void main(String[] args) {

        // 1. Showing the student's information
        Student student = new Student("Ana Santos", 19, "Female", "S1023");
        student.displayStudent();

        // 2. Showing the teacher's Information 
        Course c1 = new Course("CS101", "Programming Fundamentals");
        Course c2 = new Course("CS102", "Object-Oriented Programming");
        Course[] handledCourses = { c1, c2 };

        Teacher teacher = new Teacher("Mr. Dela Cruz", 45, "Male", "Computer Studies", handledCourses);
        teacher.displayTeacher();

       // 3. Displaying a specific course
        System.out.println("--- Displaying the course ---");
        c1.displayCourse();
    }
}
