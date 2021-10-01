package com.company;

import java.util.Scanner;

public class Umnojit {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb = scan.nextInt();
        for (int i = 0; i <= numb; i++) {
            int sum = i * numb;
            System.out.println(numb + "X" + i + "=" + sum);
        }
    }
}
