package personal.davide.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.davide.domain.JSon;
import personal.davide.domain.Multiplication;
import personal.davide.domain.MultiplicationResultAttempt;
import personal.davide.domain.User;
import personal.davide.service.MultiplicationService;

import java.util.HashMap;

@RestController
@RequestMapping(path="/multiplication",produces="application/json")
@CrossOrigin(origins="*")
public class MultiplicationControllerRest {

    MultiplicationService multiplicationService;
    Multiplication multiplication;

    @Autowired
    public MultiplicationControllerRest(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
        this.multiplication = multiplicationService.createRandomMultiplication();
    }


    @GetMapping(path = "/generateMultiplication", produces = "application/json")
    public String generateMultiplication() {
        HashMap<String,String> multiplicationAsJson = new HashMap<>();
        multiplicationAsJson.put("factorA",String.valueOf(multiplication.getFactorA()));
        multiplicationAsJson.put("factorB",String.valueOf(multiplication.getFactorB()));
        JSon json = new JSon();
        return json.getJSonFromMap(multiplicationAsJson);
    }

    @GetMapping(path = "/checkUser", produces = "application/json")
    public String checkUser(@RequestParam(value = "username") String username) {
        User user = new User(username, 0);
        HashMap<String,String> userAsJson = new HashMap<>();
        userAsJson.put("user",user.toString());
        JSon json = new JSon();
        return json.getJSonFromMap(userAsJson);
    }

    @PostMapping(path="/verifyMultiplication", produces = "application/json")
    public String verifyMultiplication( @RequestParam(value = "inserted_value") String inserted_value, @RequestParam(value="username") String username) {
        User user = new User(username, 0);
        MultiplicationResultAttempt multiplicationResultAttempt = new MultiplicationResultAttempt(user, multiplication,  Integer.parseInt(inserted_value));
        HashMap<String,String> multiplicationResultAttemptAsJson = new HashMap<>();
        multiplicationResultAttemptAsJson.put("user",user.toString());
        multiplicationResultAttemptAsJson.put("multiplication",multiplication.toString());
        multiplicationResultAttemptAsJson.put("inserted_value", inserted_value);

        if(multiplicationResultAttempt.getAttempt() == multiplicationResultAttempt.getMultiplication().getResult()) {
            multiplicationResultAttemptAsJson.put("result", "SUCCESS");
        } else {
            multiplicationResultAttemptAsJson.put("result", "FAILURE");
        }
        JSon json = new JSon();
        return json.getJSonFromMap(multiplicationResultAttemptAsJson);
    }
}
