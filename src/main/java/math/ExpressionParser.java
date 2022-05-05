package math;

import java.util.Arrays;
import java.util.Optional;

public class ExpressionParser {
    public Expression parse(String expression) {
        try {
            StringBuilder cleanExpression = new StringBuilder();
            for (char c : expression.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    continue;
                }

                cleanExpression.append(c);
            }

            expression = cleanExpression.toString();

            char[] chars = expression.toCharArray();

            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];

                Optional<Expression.Operator> operator = getOperator(c);

                if (operator.isPresent()) {
                    return Expression
                            .builder()
                            .a(Integer.parseInt(expression.substring(0, i)))
                            .b(Integer.parseInt(expression.substring(i + 1)))
                            .operator(operator.get())
                            .build();
                }
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private Optional<Expression.Operator> getOperator(char c) {
        return Arrays.stream(Expression.Operator.values())
                .filter(it -> it.toChar() == c)
                .findFirst();
    }
}
