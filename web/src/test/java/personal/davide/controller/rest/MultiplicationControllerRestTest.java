package personal.davide.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import personal.davide.domain.Multiplication;
import personal.davide.domain.MultiplicationResultAttempt;
import personal.davide.domain.User;
import personal.davide.service.MultiplicationService;
import personal.davide.service.MultiplicationServiceImpl;
import personal.davide.service.RandomGeneratorService;
import personal.davide.service.RandomGeneratorServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationControllerRest.class)
public class MultiplicationControllerRestTest {

    @MockBean
    MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;
    private JacksonTester<MultiplicationResultAttempt> jsonResult;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        given(multiplicationService.createRandomMultiplication()).willReturn(new Multiplication(30, 50));

    }

    @Test
    public void generateMultiplicationTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(get("/multiplication/generateMultiplication")).andReturn().getResponse();
        System.out.println(response);

    }
    @Test
    public void verifyMultiplicationTest() throws Exception {
        Multiplication multiplication = multiplicationService.createRandomMultiplication();
        User user = new User("Davide",0);
        MultiplicationResultAttempt multiplicationResultAttempt = new MultiplicationResultAttempt(user,multiplication, 1500);
        MockHttpServletResponse response = mvc.perform(post("/multiplication/verifyMultiplication").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(multiplicationResultAttempt).getJson())).andReturn().getResponse();
        System.out.println(response);
    }
}
