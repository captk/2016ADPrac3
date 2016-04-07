/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical3;

import java.util.Scanner;

/**
 *
 * @author k
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Bracket Checker application");

        BracketChecker checker = new BracketChecker();
        Scanner in = new Scanner(System.in);

        while (true) {
            if (checker.check(in.nextLine())) {
                System.out.println("Syntax Correct");
            } else {
                System.out.println("Syntax Error");
            }

        }
        System.out.println("Exiting Checker");
    }
}
