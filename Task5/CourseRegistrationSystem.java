import java.util.Scanner;

public class CourseRegistrationSystem {
    private CourseDatabase courseDatabase;
    private StudentDatabase studentDatabase;

    public CourseRegistrationSystem() {
        courseDatabase = new CourseDatabase();
        studentDatabase = new StudentDatabase();

        // Example initialization of courses
        courseDatabase.addCourse(new Course("CSE101", "Introduction to Programming", "Basic programming course", 30, "MWF 9:00-10:00"));
        courseDatabase.addCourse(new Course("CSE102", "Data Structures", "Advanced programming course", 25, "TTh 11:00-12:30"));

        // Example initialization of students
        studentDatabase.addStudent(new Student("S12345", "John Doe"));
        studentDatabase.addStudent(new Student("S54321", "Jane Smith"));
    }

    public void registerStudentForCourse(String studentID, String courseCode) {
        Student student = studentDatabase.findStudentByID(studentID);
        Course course = courseDatabase.findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (course.getCapacity() > 0) {
                student.registerCourse(course);
                course.decreaseCapacity();
                System.out.println("Registration successful for course: " + courseCode);
            } else {
                System.out.println("Course capacity full.");
            }
        } else {
            System.out.println("Invalid Student ID or Course Code.");
        }
    }

    public void dropStudentFromCourse(String studentID, String courseCode) {
        Student student = studentDatabase.findStudentByID(studentID);
        Course course = courseDatabase.findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.dropCourse(course);
            course.increaseCapacity();
            System.out.println("Successfully dropped from course: " + courseCode);
        } else {
            System.out.println("Invalid Student ID or Course Code.");
        }
    }

    public void listCourses() {
        for (Course course : courseDatabase.getAllCourses()) {
            System.out.println(course);
        }
    }

    public void listStudents() {
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem crs = new CourseRegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. List all courses");
            System.out.println("2. List all students");
            System.out.println("3. Register student for course");
            System.out.println("4. Drop student from course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    crs.listCourses();
                    break;
                case 2:
                    crs.listStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    crs.registerStudentForCourse(studentID, courseCode);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    crs.dropStudentFromCourse(studentID, courseCode);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
