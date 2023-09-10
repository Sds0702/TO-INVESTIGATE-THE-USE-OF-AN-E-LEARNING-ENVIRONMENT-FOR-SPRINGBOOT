package ELearning.Portal.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private String FirstName;
    private String LastName;
    private String EmailId;


}
