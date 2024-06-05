package org.localhost;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        NumberFinder numberFinder = new NumberFinder();

        Integer[][] numbers = new Integer[][]{
                new Integer[]{random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)},
                new Integer[]{random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)},
                new Integer[]{random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)},
        };
        numberFinder.processNumbers(numbers);
        System.out.println(        numberFinder.processNumbers(numbers)
        );






    }
}