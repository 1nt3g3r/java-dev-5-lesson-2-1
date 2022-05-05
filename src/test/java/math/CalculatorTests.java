package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void testThatPlusExpressionCalculatedCorrectly() {
        Expression expression = Expression.builder()
                .a(3)
                .b(4)
                .operator(Expression.Operator.plus)
                .build();

        Assertions.assertEquals(7, calculator.calculate(expression));
    }

    @Test
    public void testThatMinusExpressionCalculatedCorrectly() {
        Expression expression = Expression.builder()
                .a(-4)
                .b(10)
                .operator(Expression.Operator.minus)
                .build();

        Assertions.assertEquals(-14, calculator.calculate(expression));
    }

    @Test
    public void testThatMultiplyExpressionCalculatedCorrectly() {
        Expression expression = Expression.builder()
                .a(6)
                .b(7)
                .operator(Expression.Operator.multiply)
                .build();

        Assertions.assertEquals(42, calculator.calculate(expression));
    }

    @Test
    public void testThatDivideExpressionCalculatedCorrectly() {
        Expression expression = Expression.builder()
                .a(13)
                .b(3)
                .operator(Expression.Operator.divide)
                .build();

        Assertions.assertEquals(4, calculator.calculate(expression));
    }

    @Test
    public void testThatIllegalArgumentExceptionThrownForInvalidInput() {
        Expression[] invalidInputs = {
                null,
                Expression.builder().build(),
                Expression.builder().b(0).operator(Expression.Operator.divide).build()
        };

        for (Expression invalidInput : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.calculate(invalidInput),
                    invalidInput + ""
            );
        }
    }
}