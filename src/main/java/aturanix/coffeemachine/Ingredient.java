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

/**
 * Describes an ingredient.
 * 
 * @author Alihan Turan
 */
public sealed interface Ingredient {

    /**
     * Describes Espresso ingredient.
     */
    public static final class Espresso implements Ingredient {

        @Override
        public String toString() {
            return "Espresso";
        }
    }

    /**
     * Describes Steamed Milk ingredient.
     */
    public static final class SteamedMilk implements Ingredient {

        @Override
        public String toString() {
            return "Steamed Milk";
        }
    }

    /**
     * Describes Milk Foam ingredient.
     */
    public final static class MilkFoam implements Ingredient {

        @Override
        public String toString() {
            return "Milk Foam";
        }
    }

    /**
     * Describes Hot Chocolate ingredient.
     */
    public final static class HotChocolate implements Ingredient {

        @Override
        public String toString() {
            return "Hot Chocolate";
        }
    }

    /**
     * Describes Hot Water ingredient.
     */
    public static final class HotWater implements Ingredient {

        @Override
        public String toString() {
            return "Hot Water";
        }
    }
}
