package bdbt_bada_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer{

    @Autowired
    private UserDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")){
                return "redirect: /main_admin";
            }
            else if (request.isUserInRole("USER")){
                return "redirect: /main_user";
            }
            else {
                return "redirect: /index";
            }
        }
    }

    @RequestMapping(value = "/main_admin")
    public String showAdminPage(Model model){
        return "admin/main_admin";
    }

    @RequestMapping(value = "/main_user")
    public String showUserPage(Model model){
        List<User> listUser = dao.list();
        model.addAttribute("listUser", listUser);
        return "user/main_user";
    }


    @RequestMapping("/new")
    public String showNewForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "new_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        dao.save(user);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "ID_operatora") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        User user = dao.get(id);
        mav.addObject(user);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user){
        dao.update(user);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "ID_Operatora") int id){
        dao.delete(id);

        return "redirect:/";
    }


}
