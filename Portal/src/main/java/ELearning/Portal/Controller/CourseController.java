package ELearning.Portal.Controller;

import ELearning.Portal.DataTransferObject.CourseDTO;
import ELearning.Portal.Model.Course;
import ELearning.Portal.Model.Professor;
import ELearning.Portal.Repository.CourseRepository;
import ELearning.Portal.Repository.ProfessorRepository;
import ELearning.Portal.Repository.StudentRepository;
import ELearning.Portal.Service.Impl.CourseServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CourseController {
    private CourseServiceImpl courseService;
    private ProfessorRepository professorRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public CourseController(CourseServiceImpl courseService, ProfessorRepository professorRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        super();
        this.courseService = courseService;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
    //handler method to handle list students and return mode and view

    @GetMapping("/add/{id_professor}")
    @PreAuthorize("hasRole('ADMIN')")
    public String addCourse(@PathVariable Long id_professor, Model model) {
        try {
            Professor current = professorRepository.findById(id_professor).get();
            model.addAttribute("course", new CourseDTO());
            model.addAttribute("professor", current);
            return "course/add_course";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
    @PostMapping("/add/{id_professor}")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveCourse(@PathVariable Long id_professor, CourseDTO course, Model model) {
        try {
            Professor current = professorRepository.findById(id_professor).get();
            course.setProfessor(current);
            courseService.create(course);
            return "redirect:/courses";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }

    }
    @GetMapping("/courses")
    public String listStudents(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model) {

        // create course object to hold student form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "create_course";

    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit_course";
    }

    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable Long id,
                               @ModelAttribute("course") Course course, Model model) {

        // get course from database by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setFirstName(course.getcourseName());
        existingCourse.setLastName(course.gettopicSummary());
        existingCourse.setprofessorName(course.getprofessorName());

        // save updated student object
        courseService.updateCourse(existingCourse);
        return "redirect:/courses";
    }

    // handler method to handle delete course request

    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }

    @PostMapping("/edit/{id_professor}/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateCourse(@PathVariable Long id_professor, @PathVariable Long id, Course course, Model model, RedirectAttributes attributes) {

        try {
            Professor currentProfessor = professorRepository.findById(id_professor).get();
            course.setprofessorName(currentProfessor);

            courseService.update(course, id);
            attributes.addAttribute("id", id);

            return "redirect:/courses/{id}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

       @GetMapping("/")
       public String getCoursesList(Model model) {
           List<Course> courses = courseService.getAll();
           model.addAttribute("courses", courses);
           return "courses/courses";
       }
}
