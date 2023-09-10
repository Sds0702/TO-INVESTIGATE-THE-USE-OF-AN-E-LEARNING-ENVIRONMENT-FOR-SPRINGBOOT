package ELearning.Portal.Controller;

import ELearning.Portal.DataTransferObject.ProfessorDTO;
import ELearning.Portal.Model.Course;
import ELearning.Portal.Model.Professor;
import ELearning.Portal.Repository.CourseRepository;
import ELearning.Portal.Repository.ProfessorRepository;
import ELearning.Portal.Service.Impl.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Professors")
public class ProfessorController {
    private ProfessorService professorService;
    private ProfessorRepository professorRepository;
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorController(ProfessorService professorService, ProfessorRepository professorRepository, CourseRepository courseRepository) {
        this.professorService = professorService;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public String saveProfessor(Model model) {
            model.addAttribute("professor",new ProfessorDTO());
    return"professors/add-professor";
   }
    @PostMapping("/save")
    @PreAuthorize("hasRole('USER')")
    public String saveProfessor(ProfessorDTO professor) {
        professorService.create(professor);

        return "redirect:/professors";
    }

    @GetMapping("/edit/{id_professor}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getProfessorForUpdate(@PathVariable Long id_professor, Model model) {
        try {
            Professor professorActual = professorRepository.findById(id_professor).get();
            model.addAttribute("professor", professorActual);
            return "professors/edit-professor";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/update/{id_profesor}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProfessor(@PathVariable Long id_professor, Professor professor, RedirectAttributes attributes, Model model){

        try {
            Professor currentProfessor = professorRepository.findById(id_professor).get();
            currentProfessor.setProfessorFirstName(professor.getProfessorFirstName());
            currentProfessor.setProfessorLastName(professor.getProfessorLastName());
            currentProfessor.setProfessorEmailId(professor.getProfessorEmailId());

            professorService.update(professor);
            attributes.addAttribute("id_professor", id_professor);

            return "redirect:/professors/{id_professor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/patch/{id_professor}")
    public String patchProfessor(@PathVariable Long id_professor, Professor professor, RedirectAttributes attributes, Model model) {

        try {
            Professor current = professorRepository.findById(id_professor).get();
            current.setProfessorDetails(professor.getProfessorDetails());
            professorService.patch(current);

            attributes.addAttribute("id_professor", id_professor);
            return "redirect:/professors/{id_professor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String getProfessorsList(Model model) {
        List<Professor> professors = professorService.getAll();
        model.addAttribute("professors", professors);
        return "professors/professors";
    }

    @GetMapping("/delete/{id_profesor}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProfessor(@PathVariable Long id_professor, Model model) {
        try {
            Professor professorActual = professorRepository.findById(id_professor).get();
            professorService.delete(professorActual);

            return "redirect:/professors";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/{id_professor}")
    @PreAuthorize("hasRole('USER')")
    public String getProfessorDetail(@PathVariable Long id_professor, Model model) {
        try {
            Professor professor = professorRepository.findById(id_professor).get();
            model.addAttribute("professor", professor);
            java.util.List<Course> course = courseRepository.findAllByProfessor(professor);
            model.addAttribute("course", course);
            return "professores/professor-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
