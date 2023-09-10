package ELearning.Portal.Authentication;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface AuthenticationGrpRepo extends JpaRepository<AuthenticationGrp, Long> {
    List<AuthenticationGrp> findByUsername(String username);

}
