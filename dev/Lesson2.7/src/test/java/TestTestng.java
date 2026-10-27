import org.example.Main;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.expectThrows;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
public class TestTestng {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {3, 6},
                {5, 120},
                {7, 5040}
        };
    }
    @Test(dataProvider = "factorialData")
    public void testFindFactorial(int x, int expected) {
        int result = Main.findFactorial(x);
       assertEquals(result, expected);
    }
@Test
    public void factorialTest3(){
        IllegalArgumentException exception = expectThrows(
                IllegalArgumentException.class,
    () -> Main.findFactorial(-1)
    );
 assertEquals(exception.getMessage(), "Факториал отрицательного числа не определён");
}
    @DataProvider(name = "triangleAreaData")
    public Object[][] triangleAreaData() {
        return new Object[][]{
                {4.0, 6.0, 12.0},
                {5.0, 8.0, 20.0},
                {3.0, 3.0, 4.5},
                {10.0, 5.0, 25.0}
        };
    }

    @Test(dataProvider = "triangleAreaData")
    public void testTriangleArea(double base, double height, double expected) {
        double result = Main.triangleArea(base, height);
        assertEquals(result, expected, 0.001);
    }
    @DataProvider(name = "triangleAreaExceptionData")
    public Object[][] triangleAreaExceptionData() {
        return new Object[][]{
                {-3.0, 0.0},
                {0.0, 0.0},
                {10.0, 0.0},
                {-4.0, -6.0},
                {4.0, -8.0}
        };
    }

    @Test(dataProvider = "triangleAreaExceptionData")
    public void testTriangleAreaThrowsException(double base, double height) {
        Assert.expectThrows(IllegalArgumentException.class,
                () -> Main.triangleArea(base, height));
    }

@DataProvider(name = "subtractData")
public Object[][] subtractData() {
    return new Object[][] {
            {10, 5, 5},
            {7, 2, 5},
            {3, 8, -5}
    };
}
    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, double expected) {
      double result = Main.arithmeticOperations(a,b,'-');
   assertEquals(result,expected,0.001);
    }
    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][] {
                {0, 5, 5},
                {7, 2, 9},
                {-3, 8, 5}
        };
    }
    @Test(dataProvider = "additionData")
    public void testAddition(int a, int b, double expected){
    double result = Main.arithmeticOperations(a,b,'+');
    assertEquals(result,expected,0.001);
    }
    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationData(){
    return new Object[][]{
            {3, 5, 15.0},
            {0, 5, 0.0},
            {-3, 5, -15.0},
            {-3, -5, 15.0},
            {100, 200, 20000.0}
    };
    }
    @Test(dataProvider = "multiplicationData")
    public void testMultiplication(int a, int b, double expected){
    double result = Main.arithmeticOperations(a,b,'*');
    assertEquals(result,expected,0.001);
    }
    @DataProvider(name = "divideData")
    public Object[][] divideData(){
    return new Object[][]{
            {10, 5, 2.0},
            {0, 5, 0.0},
            {7, 2, 3.5},
            {-10, -2, 5.0},
            {-10, 2, -5.0},
            {10, -2, -5.0}
    };
    }
    @Test(dataProvider = "divideData")
    public void testDivide(int a,int b, double expected){
    double result = Main.arithmeticOperations(a,b,'/');
    assertEquals(result,expected,0.001);
    }
@Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero(){
    Main.arithmeticOperations(10,0,'/');
}
@Test(expectedExceptions = IllegalArgumentException.class)
    public void testWrongArgument(){
Main.arithmeticOperations(1,2,'h');
}
    @DataProvider(name = "firstNumberIsGreater")
    public Object[][] firstNumberIsGreater() {
        return new Object[][] {
                {0, 5, "Число 0 меньше числа 5."},
                {7, 2, "Число 7 больше числа 2."},
                {-3, 8, "Число -3 меньше числа 8."},
                {5,-5,"Число 5 больше числа -5."},
                {7, 7, "Число 7 равно числу 7."},
                {-2, -5, "Число -2 больше числа -5."}
        };
    }
    @Test(dataProvider = "firstNumberIsGreater")
    public void testFirstNumberIsGreater(int a,int b,String expected){
    String result = Main.comparisonResult(a,b);
    assertEquals(result,expected);
    }
}
