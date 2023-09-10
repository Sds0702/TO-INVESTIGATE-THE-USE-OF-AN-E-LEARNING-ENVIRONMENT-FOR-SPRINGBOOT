package ELearning.Portal.Authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTH_USERGRP")
public class AuthenticationGrp {
    @Id
    @Column( name = " AUTH_USERGRPID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column( name = "AUTH_GRP")
    private String authgrp;

    public AuthenticationGrp(String username, String authgrp){
        this.username = username;
        this.authgrp = authgrp;
    }
}
