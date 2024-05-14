package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1Addition() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertThrows(NumberFormatException.class, () -> MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testQ2Subtraction() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0);
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        Assert.assertThrows(NumberFormatException.class, () -> MathQuestionService.q2Subtraction("3", ""));
    }

    @Test
    public void testQ3Multiplication() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        Assert.assertThrows(NumberFormatException.class, () -> MathQuestionService.q3Multiplication("2", ""));
    }
}
