/*
 * The MIT License
 *
 * Copyright 2023 Alihan Turan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package aturanix.coffeemachine;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alihan Turan
 */
public class CoffeeTest {

    public CoffeeTest() {
    }

    /**
     * Test of toStringIngredients method, of class Coffee.
     */
    @Test
    public void testToStringIngredients_Mocha() {
        System.out.println("toStringIngredients_Mocha");
        Coffee instance = new Coffee.Mocha();

        String delimiter = ", ";
        String[] result = instance.toStringIngredients(delimiter
        ).split(", ");
        Arrays.sort(result);

        String[] expResult = {
            "one dosage of Milk Foam", "one dosage of Espresso", "one dosage of Steamed Milk",
            "two dosages of Hot Chocolate"};
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toStringIngredients method, of class Coffee.
     */
    @Test
    public void testToStringIngredients_DoubleEspresso() {
        System.out.println("toStringIngredients_DoubleEspresso");
        Coffee instance = new Coffee.DoubleEspresso();

        String delimiter = ", ";
        String[] result = instance.toStringIngredients(delimiter
        ).split(", ");
        Arrays.sort(result);

        String[] expResult = {
            "two dosages of Espresso"};
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
}
