package role.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import role.models.Actor;
import role.models.Gender;
import role.repositories.ActorRepository;

import javax.validation.Valid;

@Controller
public class ActorController {

    @Autowired
    private ActorRepository repo;
@GetMapping("/")
    private String getAllActors(Model model) {
        model.addAttribute("actors", repo.findAll());
        return "index";
    }

    @GetMapping("/create")
    private String createActor(Model model) {
        model.addAttribute("actor", new Actor());
        model.addAttribute("genderList", Gender.values());
        return "/create";
    }

    @PostMapping("/submit")
    private String addActor(@Valid Actor actor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genderList", Gender.values());
            return "/create";
        } else {
            repo.save(actor);
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    private ModelAndView editActor(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("actor", repo.findById(id));
        model.addAttribute("genderList", Gender.values());
        return new ModelAndView("/edit");
    }
    @PostMapping("/update")
    private ModelAndView updateActor(@Valid Actor actor,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genderList", Gender.values());
            return new ModelAndView("/edit");
        } else {
            repo.save(actor);
            return new ModelAndView("redirect:/");
        }
    }
    @PostMapping("/delete/{id}")
    private ModelAndView deleteActor(@PathVariable(name="id") Integer id) {
        repo.deleteById(id);
        return new ModelAndView("redirect:/");
    }
}
