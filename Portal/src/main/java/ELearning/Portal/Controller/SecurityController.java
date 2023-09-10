package ELearning.Portal.Controller;

import ELearning.Portal.Model.Student;
import ELearning.Portal.Repository.StudentRepository;
import ELearning.Portal.Service.Impl.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Id;

@Controller
@PreAuthorize("hasRole('USER')")
@AllArgsConstructor
public class SecurityController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @GetMapping("/profile")
    public String getUserProfile(Authentication authentication, Model model) {
        try {
            String currentUsername = authentication.getName();
            Student student = studentRepository.findByUserName(currentUsername);
            model.addAttribute("student", student);
            Object CourseName = null;
            model.addAttribute("CourseName", CourseName);
            return "user/profile";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/user/edit/{userID}")
    public String getForEdit(@PathVariable Long userID, Authentication authentication, Model model) {

        try {
            String currentusername = authentication.getName();
            Student current = studentRepository.findById(userID).get();
            if (currentusername.equals(current.getUsername())) {
                model.addAttribute(current);
                return "user/user-edit";
            } else {
                throw new Exception("Error in authentication");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/user/edit/{userID}")
    public String updateUser(@PathVariable Long userID, Authentication authentication, Student student, Model model) {

        try {
            Student current = studentRepository.findById(userID).get();
            String currentusername = authentication.getName();
            if (currentusername.equals(current.getUsername())) {
                current.getUsername(userID.getClass());
                current.getEnrolledCourses(userID.getClass());
                studentService.update(current);

                return "redirect:/profile";
            } else {
                throw new Exception("Error in authentication");
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/user/patch/{id_user}")
    public String patchUser(@PathVariable Long id_user, Authentication authentication, Student student, Model model) {

        try {
            Student current = studentRepository.findById(id_user).get();
            String currentusername = authentication.getName();
            if (currentusername.equals(current.getUsername())) {
                current.setDetails(student.getDetails());
                studentService.patch(current);

                return "redirect:/profile";
            } else {
                throw new Exception("Error in authentication");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
