package com.company;

import java.util.Scanner;

public class Tricut {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stroki = scan.nextInt();
        for (int i = 1; i <= stroki; i++) {
            for (int a = 1; a <= i; a++)
                System.out.print(a);
            System.out.println();
        }
    }
}