package personal.davide.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertTrue;

public class RandomGeneratorServiceImplTest {

    RandomGeneratorServiceImpl randomGeneratorServiceImpl;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // tell Mockito to process the annotations
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }
    @Test
    public void verifyMultiplication() {
        assertTrue(randomGeneratorServiceImpl.generateRandom() <= 100 && randomGeneratorServiceImpl.generateRandom() >= 0);
    }
}