package ELearning.Portal.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String emailid;
}
