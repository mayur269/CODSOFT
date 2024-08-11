import java.util.ArrayList;

public class CourseDatabase {
    private ArrayList<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null; // Return null if course is not found
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }
}
