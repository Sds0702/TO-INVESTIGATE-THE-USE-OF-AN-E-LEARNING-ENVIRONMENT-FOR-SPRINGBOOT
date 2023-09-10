package ELearning.Portal.DataTransferObject;

import ELearning.Portal.Model.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private String Coursename;
    private String CourseDescription;

    private String Details;

    private Professor professor;
}
