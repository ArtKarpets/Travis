package com.company;

import java.util.Scanner;

public class Slova {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input string");
        String inStrg = scan.nextLine();
        System.out.println(cycle(inStrg) + " слова");

    }

    static int cycle(String stroka) {
        int num = 1;

        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == ' ') {
                num++;
            }
        }
        return num;
    }
}
