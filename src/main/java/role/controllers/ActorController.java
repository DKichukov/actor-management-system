package role.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import role.models.Actor;
import role.models.Gender;
import role.repositories.ActorRepository;

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
        model.addAttribute("sex", Gender.values());
        return "/create";
    }


}
