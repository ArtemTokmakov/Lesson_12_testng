package org.aston;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @DataProvider(name = "numbers")
    public Object[][] createNumbers() {
        return new Object[][]{
                {Integer.valueOf(0), Integer.valueOf(1)},
                {Integer.valueOf(1), Integer.valueOf(1)},
                {Integer.valueOf(2), Integer.valueOf(2)},
                {Integer.valueOf(3), Integer.valueOf(6)},
                {Integer.valueOf(4), Integer.valueOf(24)},
                {Integer.valueOf(5), Integer.valueOf(120)},
                {Integer.valueOf(6), Integer.valueOf(720)},
                {Integer.valueOf(7), Integer.valueOf(5040)},
                {Integer.valueOf(8), Integer.valueOf(40320)},
                {Integer.valueOf(9), Integer.valueOf(362880)},
                {Integer.valueOf(10), Integer.valueOf(3628800)}
        };
    }

    @Test(dataProvider = "numbers")
    public void testCalculateFactorial(Integer n, Integer expectedFactorial) {
        assertEquals(Factorial.calculateFactorial(n), expectedFactorial.intValue());
    }

    @DataProvider(name = "negativeNumbers")
    public Object[][] createNegativeNumbers() {
        return new Object[][]{
                {Integer.valueOf(-1)},
                {Integer.valueOf(-5)},
                {Integer.valueOf(-10)}
        };
    }

    @Test(dataProvider = "negativeNumbers")
    public void testCalculateFactorialWithNegativeNumbers(Integer n) {
        try {
            Factorial.calculateFactorial(n);
        } catch (IllegalArgumentException e) {
            return;
        }
        assert false : "Ожидалось исключение IllegalArgumentException";
    }
}
