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

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Describes a coffee.
 *
 * @author Alihan Turan
 */
public sealed abstract class Coffee {

    // immutable map of ingredients and their dosage
    protected final Map<Ingredient, Integer> ingredients;

    protected Coffee(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns ingredients and their dosage.
     *
     * @return ingredients and their dosage
     */
    public Map<Ingredient, Integer> ingredients() {
        return ingredients;
    }

    /**
     * Returns string representation of ingredients joined by delimiter.
     * 
     * @param delimiter put between ingredients; may be ", "
     * @return ingredients joined by delimiter
     */
    public String toStringIngredients(String delimiter) {
        return ingredients.entrySet().stream().map(entry -> {
            var sb = new StringBuilder();
            int dosage = entry.getValue();
            switch (dosage) {
                case 1 ->
                    sb.append("one");
                case 2 ->
                    sb.append("two");
                case 3 ->
                    sb.append("three");
                case 4 ->
                    sb.append("four");
                case 5 ->
                    sb.append("five");
                case 6 ->
                    sb.append("six");
                case 7 ->
                    sb.append("seven");
                case 8 ->
                    sb.append("eight");
                case 9 ->
                    sb.append("nine");
                default ->
                    sb.append(dosage);
            }

            sb.append(" dosage");
            if (dosage > 1) {
                sb.append('s');
            }
            
            sb.append(" of ").append(entry.getKey());

            return sb.toString();
        }).collect(Collectors.joining(delimiter));
    }

    /**
     * Describes Espresso coffee.
     */
    public static final class Espresso extends Coffee {

        public Espresso() {
            super(Map.of(new Ingredient.Espresso(), 1));
        }

        @Override
        public String toString() {
            return "Espresso";
        }
    }

    /**
     * Describes Double Espresso coffee.
     */
    public static final class DoubleEspresso extends Coffee {

        public DoubleEspresso() {
            super(Map.of(new Ingredient.Espresso(), 2));
        }

        @Override
        public String toString() {
            return "Double Espresso";
        }
    }

    /**
     * Describes Americano coffee.
     */
    public static final class Americano extends Coffee {

        public Americano() {
            super(Map.of(new Ingredient.Espresso(), 1,
                    new Ingredient.HotWater(), 4));
        }

        @Override
        public String toString() {
            return "Americano";
        }
    }

    /**
     * Describes Capuccino coffee.
     */
    public static final class Capuccino extends Coffee {

        public Capuccino() {
            super(Map.of(new Ingredient.Espresso(), 1,
                    new Ingredient.SteamedMilk(), 2,
                    new Ingredient.MilkFoam(), 2));
        }

        @Override
        public String toString() {
            return "Capuccino";
        }
    }

    /**
     * Describes Caffe Latte coffee.
     */
    public static final class CaffeLatte extends Coffee {

        public CaffeLatte() {
            super(Map.of(new Ingredient.Espresso(), 1,
                    new Ingredient.SteamedMilk(), 3,
                    new Ingredient.MilkFoam(), 1));
        }

        @Override
        public String toString() {
            return "Caffe Latte";
        }
    }

    /**
     * Describes Mocha coffee.
     */
    public static final class Mocha extends Coffee {

        public Mocha() {
            super(Map.of(new Ingredient.Espresso(), 1,
                    new Ingredient.SteamedMilk(), 1,
                    new Ingredient.MilkFoam(), 1,
                    new Ingredient.HotChocolate(), 2));
        }

        @Override
        public String toString() {
            return "Mocha";
        }
    }

    /**
     * Describes Hot Water coffee.
     */
    public static final class HotWater extends Coffee {

        public HotWater() {
            super(Map.of(new Ingredient.HotWater(), 5));
        }

        @Override
        public String toString() {
            return "Hot Water";
        }
    }
}
