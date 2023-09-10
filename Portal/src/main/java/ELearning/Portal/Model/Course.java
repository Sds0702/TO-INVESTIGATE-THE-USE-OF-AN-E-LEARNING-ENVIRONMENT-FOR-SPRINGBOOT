package ELearning.Portal.Model;

import javax.persistence.*;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coursename", nullable = false)
    private String courseName;

    @Column(name = "topicsummary")
    private String topicSummary;

    @Column(name = "professorname")
    private String professorName;

    public Course(){

    }
    public Course(String courseName, String topicSummary, String professorName) {
        this.courseName = courseName;
        this.topicSummary = topicSummary;
        this.professorName = professorName;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setFirstName(String courseName) {
        this.courseName = courseName;
    }

    public String gettopicSummary() {
        return topicSummary;
    }

    public void setLastName(String topicSummary) {
        this.topicSummary = topicSummary;
    }

    public String getprofessorName() {
        return professorName;
    }

    public void setprofessorName(String professorName) {
        this.professorName = professorName;
    }


    public Long getId() {
        return id;
    }

    public void setprofessorName(Professor currentProfessor) {
    }
}
