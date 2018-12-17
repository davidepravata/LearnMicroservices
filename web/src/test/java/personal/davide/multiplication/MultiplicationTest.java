package personal.davide.multiplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import personal.davide.domain.Multiplication;
import personal.davide.service.MultiplicationService;
import personal.davide.service.RandomGeneratorService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationTest {

    @Autowired
    MultiplicationService multiplicationService;
    @MockBean
    RandomGeneratorService randomGeneratorService;

    @Test
    public void verifyMultiplication() {
        given(randomGeneratorService.generateRandom()).willReturn(30, 50);
        Multiplication multiplication = multiplicationService.createRandomMultiplication();
        assertEquals(multiplication.getFactorA(), 30);
        assertEquals(multiplication.getFactorB(), 50);
        assertEquals(multiplication.getResult(), 1500);
    }
}
