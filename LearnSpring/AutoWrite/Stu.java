package AutoWrite;

public class Stu {
    Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "course=" + course.toString() +
                '}';
    }
}
