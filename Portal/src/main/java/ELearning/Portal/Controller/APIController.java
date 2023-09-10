package ELearning.Portal.Controller;

import ELearning.Portal.Model.Course;
import ELearning.Portal.Model.Professor;
import ELearning.Portal.Service.CourseService;
import ELearning.Portal.Service.Impl.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    private CourseService courseService;
    private ProfessorService professorService;

    @Autowired
    public APIController(CourseService courseService, ProfessorService professorService){
        this.courseService =courseService;
        this.professorService =professorService;
    }
    @GetMapping("/Professors")
    public List<Professor> getAllProfessors(){
        return (List<Professor>) this.professorService.getAll();
    }
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return (List<Course>) this.courseService.getAll();
    }
}
