package personal.davide.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

    @Autowired
    RandomGeneratorService randomGeneratorService;

    @Test
    public void verifyMultiplication() {
        assertTrue(randomGeneratorService.generateRandom() <= 100 && randomGeneratorService.generateRandom() >= 0);

    }
}
