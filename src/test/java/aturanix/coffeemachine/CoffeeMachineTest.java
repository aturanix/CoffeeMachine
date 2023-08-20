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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alihan Turan
 */
public class CoffeeMachineTest {

    public CoffeeMachineTest() {
    }

    /**
     * Test of run method, of class CoffeeMachine.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        String inputText = "9\ndsfgsdf\n4\n";
        var in = new ByteArrayInputStream(inputText.getBytes());
        var out = new ByteArrayOutputStream();
        var err = new ByteArrayOutputStream();

        CoffeeMachine instance = new CoffeeMachine();
        instance.run(in, new PrintStream(out), new PrintStream(err));

        var menu = """
            1. Espresso 20TL
            2. Double Espresso 29TL
            3. Cappuccino 27TL
            4. Caffe Latte 27TL
            5. Mocha 32TL
            6. Americano 25TL
            7. Hot Water 5TL""";

        var outExpected = menu
                + "\nPlease enter the number of the coffee you want to drink\n> "
                + "Please enter the number of the coffee you want to drink\n> "
                + "Please enter the number of the coffee you want to drink\n> "
                + "Thank you. Your coffee is being prepared.\n"
                + "You have chosen Caffe Latte. this coffee consists of ";
        // the rest of it is checked in CoffeeTest

        String outResult = out.toString();
        assertEquals(outExpected, outResult.substring(0, outExpected.length()));

        var errExpected
                = """
                  ERROR: Entered number doesn't exist
                  ERROR: Input isn't number
                  """;

        String errResult = err.toString();
        assertEquals(errExpected, errResult);
    }
}
