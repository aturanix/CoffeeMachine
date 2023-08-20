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

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Main class of CoffeeMachine.
 *
 * @author Alihan Turan
 */
public class CoffeeMachine {

    private final String menu = """
            1. Espresso 20TL
            2. Double Espresso 29TL
            3. Cappuccino 27TL
            4. Caffe Latte 27TL
            5. Mocha 32TL
            6. Americano 25TL
            7. Hot Water 5TL""";

    /**
     * Returns Coffee instance for selected coffee.
     *
     * @param number coffee number on menu
     * @return Coffee
     */
    private Coffee selectCoffee(int number) {
        return switch (number) {
            case 1 ->
                new Coffee.Espresso();
            case 2 ->
                new Coffee.DoubleEspresso();
            case 3 ->
                new Coffee.Capuccino();
            case 4 ->
                new Coffee.CaffeLatte();
            case 5 ->
                new Coffee.Mocha();
            case 6 ->
                new Coffee.Americano();
            case 7 ->
                new Coffee.HotWater();
            default ->
                null;
        };
    }

    /**
     * Runner method of the class. This is typically called in main.
     *
     * @param in may be System.in
     * @param out may be System.out
     * @param err may be System.err
     */
    public void run(InputStream in, PrintStream out, PrintStream err) {
        out.println(menu);
        out.flush();

        Coffee coffee = null;
        try (var scanner = new Scanner(in)) {
            while (coffee == null) {
                out.print("Please enter the number of the coffee you want to drink\n> ");
                out.flush();

                var line = scanner.nextLine();

                int number;
                try {
                    number = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    err.println("ERROR: Input isn't number");
                    err.flush();
                    continue;
                }

                coffee = selectCoffee(number);
                if (coffee != null) {
                    break;
                }

                err.println("ERROR: Entered number doesn't exist");
                err.flush();
            }
        }

        out.println("Thank you. Your coffee is being prepared.\n"
                + "You have chosen "
                + coffee.toString()
                + ". this coffee consists of "
                + coffee.toStringIngredients(", ")
                + ".");
        out.flush();
    }

    public static void main(String[] args) {
        var coffeeMachine = new CoffeeMachine();
        coffeeMachine.run(System.in, System.out, System.err);
    }
}
