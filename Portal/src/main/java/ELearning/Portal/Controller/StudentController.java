package ELearning.Portal.Controller;

import ELearning.Portal.Entity.StudentEntity;
import ELearning.Portal.Model.Student;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    private final StudentEntity studentEntity;

    public StudentController(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @RequestMapping({"/profile"})
    public ModelAndView profile(@RequestAttribute("student") Student student) {
        return this.studentEntity.getProfile(student, "profile");
    }

    @GetMapping({"/editProfile/{id}"})
    public ModelAndView editProfile(@PathVariable Long id) {
        return this.studentEntity.getProfileToEdit(id);
    }

    @PostMapping({"/editProfile"})
    public ModelAndView editProfile(Student student) {
        return this.studentEntity.editProfile(student);
    }

    public Long getStudentJson(Long id) {
        return id;
    }
}
