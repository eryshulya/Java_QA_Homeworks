import org.example.Main;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JunitTesting {
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "3, 6",
            "5, 120",
            "7, 5040"
    })
    void testFindFactorial(int x, int expected) {
        int result = Main.findFactorial(x);
        assertEquals(expected, result);
    }
    @Test
    void illegalArgumentException(){
        assertThrows(IllegalArgumentException.class,() -> Main.findFactorial(-4));
    }

    @ParameterizedTest
    @CsvSource({
            "4,6,12",
            "5,8,20",
            "3,3,4.5"
    })
    void testTriangleArea(double a, double b, double expected) {
        double result = Main.triangleArea(a, b);
        assertEquals(expected, result,0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "-3,3",
            "0,7",
            "-4,-6",
            "4,-8"
    })
    void triangleAreaThrowsException(double a, double b) {
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 5, 15",
            "-3, 3, 0",
            "-4, -6, -10",
            "0, 7, 7",
            "100, 200, 300"
    })
    void testAddition(int a, int b, double expected) {
        double result = Main.arithmeticOperations(a, b, '+');
        assertEquals(expected, result,0.001);
    }
    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "10, 5, 5",
            "3, 8, -5",
            "-4, -6, 2",
            "0, 7, -7",
            "100, 200, -100"
    })
    void testSubtraction(int a, int b, double expected) {
        double result = Main.arithmeticOperations(a, b, '-');
        assertEquals(expected, result,0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "10, 5, 50",
            "-3, 3, -9",
            "-4, -6, 24",
            "0, 7, 0",
            "100, 200, 20000"
    })
    void testMultiplication(int a, int b, double expected) {
        double result = Main.arithmeticOperations(a, b, '*');
        assertEquals(expected, result,0.001);
    }
    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "10, 5, 2",
            "9, 3, 3",
            "-12, 3, -4",
            "-20, -5, 4",
            "0, 7, 0"
    })
    void testDivision(int a, int b, double expected){
        double result = Main.arithmeticOperations(a,b,'/');
        assertEquals(expected,result,0.001);
    }
    @ParameterizedTest
    @CsvSource({
            "-3,0",
            "0,0",
            "10,0"
    })
    void testDivisionZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> Main.arithmeticOperations(a, b,'/'));
    }
    @Test
    void illegalArgument(){
        assertThrows(IllegalArgumentException.class,() -> Main.arithmeticOperations(4,6,'h'));
    }
    @ParameterizedTest
    @CsvSource({
            "-3, 0, 'Число -3 меньше числа 0.'",
            "0, 0, 'Число 0 равно числу 0.'",
            "10, 0, 'Число 10 больше числа 0.'"
    })
    void comparisonResult(int a, int b, String expected) {
        String result = Main.comparisonResult(a, b);
        assertEquals(expected,result);
    }

}
