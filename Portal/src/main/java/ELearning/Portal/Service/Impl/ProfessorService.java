package ELearning.Portal.Service.Impl;

import ELearning.Portal.DataTransferObject.ProfessorDTO;
import ELearning.Portal.Model.Professor;
import ELearning.Portal.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void create(ProfessorDTO professorDTO) {
        String FirstName = professorDTO.getFirstName();
        String LastName = professorDTO.getLastName();
        String EmailId = professorDTO.getEmailId();

        Professor professor = new Professor(FirstName, LastName, EmailId);

       professorRepository.save(professor);
    }

    public List<Professor> getAll() {
        return (List<Professor>) professorRepository.findAll();
    }

    public void update(Professor professor) {
        Professor currentProfessor = professorRepository.findById(professor.getId_professor()).get();

        currentProfessor.setProfessorFirstName(professor.getProfessorFirstName());
        currentProfessor.setProfessorLastName(professor.getProfessorLastName());
        currentProfessor.setProfessorEmailId(professor.getProfessorEmailId());

        professorRepository.save(currentProfessor);
    }

    public void patch(Professor professor) {
        Professor current = professorRepository.findById(professor.getId_professor()).get();

        current.setProfessorDetails(professor.getProfessorDetails());

        professorRepository.save(current);
    }

    public void delete(Professor professor) {
        professorRepository.delete(professor);
    }

}
