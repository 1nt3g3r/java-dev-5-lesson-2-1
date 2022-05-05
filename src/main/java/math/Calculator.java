package math;

public class Calculator {
    public int calculate(Expression expression) {
        try {
            switch (expression.getOperator()) {
                case plus:
                    return expression.getA() + expression.getB();
                case minus:
                    return expression.getA() - expression.getB();
                case divide:
                    return expression.getA() / expression.getB();
                case multiply:
                    return expression.getA() * expression.getB();
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }
}
