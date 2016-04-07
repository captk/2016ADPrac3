/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
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
        
        ArrayDeque<String> queue = new ArrayDeque();
        String line;
        
        //I really don't like loops like this grrrr
        line = in.nextLine();
        while (!line.equals("")){
            queue.offer(line);
            line = in.nextLine();
        }
        
        while (!queue.isEmpty()) {
            
            line = queue.poll();
            System.out.println(line);
            if (checker.check(line)) {
                System.out.println("Syntax Correct");
            } else {
                for (int i = 0; i < checker.getPosition(); i++){
                    System.out.print(" ");
                }
                System.out.println("|");
                System.out.println("Syntax Error at position " + checker.getPosition());
            }
            
        }
        System.out.println("Exiting Checker");
    }
}
