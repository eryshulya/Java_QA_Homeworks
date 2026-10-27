import org.example.Main;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.expectThrows;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class TestTestng {
    @Test
    public void checkFactorialTest1(){
        assertTrue(Main.findFactorial(5) == 120);
    }
    @Test
    public void checkFactorialTest2(){
        assertTrue(Main.findFactorial(0) == 1);
    }
@Test
    public void factorialTest3(){
        IllegalArgumentException exception = expectThrows(
                IllegalArgumentException.class,
    () -> Main.findFactorial(-1)
    );
 assertEquals(exception.getMessage(), "Факториал отрицательного числа не определён");
}
@Test
    public void triangleArea(){
        double value = (3*5)/2.0;
        assertEquals(Main.triangleArea(3,5),value);
}
/*@Test
    public void arithmeticOperations(){
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(Main.arithmeticOperations(3,5,'+'),8,"Ошибка в сложении");
    softAssert.assertEquals(Main.arithmeticOperations(3,-5,'-'),8,"Ошибка в вычитании");
    softAssert.assertEquals(Main.arithmeticOperations(1,8,'*'),1*8,"Ошибка в умножении");
    softAssert.assertEquals(Main.arithmeticOperations(1,8,'/'),1/8,"Ошибка в делении");

}
 */
@DataProvider(name = "subtractData")
public Object[][] subtractData() {
    return new Object[][] {
            {10, 5, 5},
            {7, 2, 5},
            {3, 8, -5}
    };
}
    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, int expected) {
      double result = Main.arithmeticOperations(a,b,'-');
   assertEquals(result,expected);
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
    public void testAddition(int a, int b, int expected){
    double result = Main.arithmeticOperations(a,b,'+');
    assertEquals(result,expected);
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
    assertEquals(result,expected);
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
    assertEquals(result,expected);
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
