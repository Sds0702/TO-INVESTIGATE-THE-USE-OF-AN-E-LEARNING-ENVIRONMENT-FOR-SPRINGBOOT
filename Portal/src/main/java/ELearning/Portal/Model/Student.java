package ELearning.Portal.Model;

import java.time.LocalDate;

public class Student {
    private java.util.List<Course> enrolledCourses;
    private LocalDate createDate;
    private LocalDate expiryDate;

    public Student(int id, String name, String email, String major, String password) {
        super();
        this.enrolledCourses = new java.util.ArrayList<>();
        this.createDate = LocalDate.now();
        this.expiryDate = this.createDate.plusDays(28);
    }

    public java.util.List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(java.util.List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

   /* public String toString() {
        return "ID: " + super.getStudentId() + "\n" +
                "Name: " + super.getName() + "\n" +
                "Email: " + super.getEmail() + "\n" +
                "Create Date: " + createDate + "\n" +
                "Expiry Date: " + expiryDate + "\n" +
                "Password: " + super.getPassword();
    }*/

    public String getUsername() {
        return null;
    }

    public Student get() {
        return null;
    }

    public String getDetails() {
        return null;
    }

    public void setDetails(String details) {
    }

    public String getUsername(Class<? extends Long> aClass) {
        return null;
    }

    public void getEnrolledCourses(Class<? extends Long> aClass) {
    }
}
