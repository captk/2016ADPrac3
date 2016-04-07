/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical3;

import java.util.Stack;

/**
 *
 * @author k
 */
public class BracketChecker {

    private Stack<Character> brackStack = new Stack();

    boolean check(String text) {

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '{') {
                this.brackStack.push('{');
            } else if (text.charAt(i) == '}') {
                if (brackStack.empty()) {
                    return false;
                } else {
                    brackStack.pop();
                }
            }
        }

        if (brackStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
