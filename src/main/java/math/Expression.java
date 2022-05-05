package math;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Expression {
    private int a;
    private int b;
    private Operator operator;

    public enum Operator {
        plus("+"),
        minus("-"),
        multiply("*"),
        divide("/");

        private String humanReadablePresentation;

        Operator(String humanReadablePresentation) {
            this.humanReadablePresentation = humanReadablePresentation;
        }

        @Override
        public String toString() {
            return humanReadablePresentation;
        }

        public char toChar() {
            return toString().charAt(0);
        }
    }
}
