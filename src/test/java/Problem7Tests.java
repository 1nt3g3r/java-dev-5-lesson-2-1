import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Problem7Tests {
    @Test
    public void testThatRomeToArabicMethodWorksOk() {
        Map<String, Integer> testCases = new LinkedHashMap<>();
        testCases.put("I", 1);
        testCases.put("II", 2);
        testCases.put("III", 3);
        testCases.put("IV", 4);
        testCases.put("V", 5);
        testCases.put("VI", 6);
        testCases.put("VII", 7);
        testCases.put("VIII", 8);
        testCases.put("IX", 9);
        testCases.put("X", 10);
        testCases.put("XII", 12);
        testCases.put("LIII", 53);
        testCases.put("XCVIII", 98);
        testCases.put("DLX", 560);
        testCases.put("M", 1000);
        testCases.put("MX", 1010);
        testCases.put("MMM", 3000);

        testCases.forEach((rome, expectedArabic) ->
            Assertions.assertEquals(
                    expectedArabic,
                    new Main().romeToArabic(rome),
                    rome
            ));
    }

    @Test
    public void testThatArabicToRomeMethodWorksOk() {
        Map<Integer, String> testCases = new HashMap<>();
        testCases.put(1, "I");
        testCases.put(2, "II");
        testCases.put(3, "III");
        testCases.put(4, "IV");
        testCases.put(5, "V");
        testCases.put(6, "VI");
        testCases.put(7, "VII");
        testCases.put(8, "VIII");
        testCases.put(9, "IX");
        testCases.put(10, "X");
        testCases.put(12, "XII");
        testCases.put(53, "LIII");
        testCases.put(98, "XCVIII");
        testCases.put(560, "DLX");
        testCases.put(1000, "M");
        testCases.put(1010, "MX");
        testCases.put(3000, "MMM");

        testCases.forEach((arabic, expectedRome) -> {
            Assertions.assertEquals(
                    expectedRome,
                    new Main().arabicToRome(arabic),
                    Integer.toString(arabic)
            );
        });
    }

    @Test
    public void testThatCalculateMethodWorksOk() {
        Map<String, String> testCases = new HashMap<>();
        testCases.put("III+IV", "VII");
        testCases.put("II+II", "IV");
        testCases.put("I+X", "XI");

        testCases.forEach((expression, expected) -> {
            Assertions.assertEquals(
                    expected,
                    new Main().calculate(expression),
                    expression
            );
        });
    }

    @Test
    public void testThatIllegalArgumentExceptionThrownForInvalidInput() {
        int[] invalidInput = {0, 4001};

        for (int input : invalidInput) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> new Main().arabicToRome(input)
            );
        }
    }
}