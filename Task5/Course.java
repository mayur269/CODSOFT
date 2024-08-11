public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        capacity++;
    }

    @Override
    public String toString() {
        return courseCode + " - " + title + " (" + capacity + " slots left)";
    }
}
