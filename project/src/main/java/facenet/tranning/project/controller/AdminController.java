package facenet.tranning.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/manager")
    public String managerPage() {
        return "forward:/manager.html";
    }

    @GetMapping("/brand")
    public String brandPage() {
        return "forward:/brand.html";
    }

    @GetMapping("/owner")
    public String ownerPage() {
        return "forward:/owner.html";
    }

    @GetMapping("/car")
    public String carPage() {
        return "forward:/car.html";
    }
}
