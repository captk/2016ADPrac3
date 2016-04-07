/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author k
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Starting Bracket Checker application");

        BracketChecker checker = new BracketChecker();
        Scanner in = new Scanner(new File("brackets01.txt"));
        String line;
        
        //I really don't like this
        line = in.nextLine();
        while (!line.equals("")) {

            System.out.println(line);
            if (checker.check(line)) {
                System.out.println("Syntax Correct");
            } else {
                System.out.println("Syntax Error");
            }
            line = in.nextLine();
            
        }
        System.out.println("Exiting Checker");
    }
}
