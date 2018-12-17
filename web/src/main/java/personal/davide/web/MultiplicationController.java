package personal.davide.web;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import personal.davide.multiplication.Multiplication;
import personal.davide.service.MultiplicationService;
import personal.davide.service.RandomGeneratorService;

@Controller
@RequestMapping("/play")
public class MultiplicationController {


    MultiplicationService multiplicationService;
    Multiplication multiplication;

    @Autowired
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
        this.multiplication = multiplicationService.createRandomMultiplication();
    }


    @GetMapping
    public String showMultiplicationAndLogin(Model model) {
        model.addAttribute("value1", multiplication.getFactorA());
        model.addAttribute("value2",multiplication.getFactorB());
        model.addAttribute("result",multiplication.getResult());
        return "login_question";
    }

    @PostMapping("/outcome")
    public String showResult(Model model, @ModelAttribute(value = "inserted_value") String inserted_value, @ModelAttribute(value="username") String username) {
        boolean error=false;
        if (StringUtils.isEmpty(inserted_value) || StringUtils.isEmpty(username)) {
            error = true;
            model.addAttribute("error", error);
        }

        int iInsertedValue = 0;
        try {
            iInsertedValue = Integer.parseInt(inserted_value);
        } catch (NumberFormatException nfe) {
            error = true;
            model.addAttribute("error", error);
        }

        if(!error) {
            model.addAttribute("username",username);
            if (iInsertedValue == multiplication.getResult()) {
                model.addAttribute("outcome", "success!!!");
            } else {
                model.addAttribute("outcome", "FAILURE!");
            }
        }

        return "result_view";
    }
}
