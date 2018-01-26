package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter Message to encode");
            String subject = scanner2.nextLine();
            ArrayList<Character> charList = new ArrayList<>();
            ArrayList<Integer> numList = new ArrayList<>();
            for (int i = 0; i < subject.length(); i++) {
                charList.add(subject.charAt(i));
            }
            for (int i = 0; i < subject.length(); i++) {
                Character singleChar = charList.get(i);
                numList.add(Character.getNumericValue(singleChar));
            }

            Integer sum = 0;
            for (Integer d : numList) {
                sum += d;
            }

            Integer encodedValue = sum * (Character.getNumericValue(subject.charAt(3)));
            System.out.println(encodedValue);
            System.out.println("Do you wish to continue?");
            input = scanner.nextLine();

        } while (!input.equals("no"));

    }
}
