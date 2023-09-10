package ELearning.Portal.Model;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "Professors")
public class Professor {
    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;
    @Column(name = "First Name")
    private String ProfessorFirstName;
    @Column(name = "Last Name")
    private String ProfessorLastName;
    @Column(name = "Email Id")
    private String ProfessorEmailId;

    @Column(name = "Details")
    private String ProfessorDetails;

    public Professor(String ProfessorFirstName, String ProfessorLastName, String ProfessorEmailId){
        this.ProfessorFirstName = ProfessorFirstName;
        this.ProfessorLastName = ProfessorLastName;
        this.ProfessorEmailId = ProfessorEmailId;
    }
    public Professor(String ProfessorDetails){
        this.ProfessorDetails = ProfessorDetails;
    }

    public Professor() {

    }
}
