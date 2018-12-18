package personal.davide.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import personal.davide.domain.Multiplication;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {

    MultiplicationServiceImpl multiplicationServiceImpl;
    @Mock
    RandomGeneratorService randomGeneratorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // tell Mockito to process the annotations
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }
    @Test
    public void verifyMultiplication() {
        given(randomGeneratorService.generateRandom()).willReturn(30, 50);
        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();
        assertEquals(multiplication.getFactorA(), 30);
        assertEquals(multiplication.getFactorB(), 50);
        assertEquals(multiplication.getResult(), 1500);
    }
}
