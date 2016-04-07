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
    private int position;
    char[] opening;
    char[] closing;

    public BracketChecker(char[] opening, char[] closing) {
        this.opening = opening;
        this.closing = closing;
    }

    /**
     * Determine if the parameter 'in' is in the opening array and returns the
     * position if found.
     *
     * @param in
     * @return the position in the array if found, - 1 otherwise
     */
    private int isOpening(char in) {
        for (int ci = 0; ci < opening.length; ci++) {
            if (in == opening[ci]) {
                return ci;
            }
        }
        return -1; // character not found 
    }

    /**
     * Determine if the parameter 'in' is in the closing array and returns the
     * position if found.
     *
     * @param in
     * @return the position in the array if found, - 1 otherwise
     */
    private int isClosing(char in) {
        for (int ci = 0; ci < closing.length; ci++) {
            if (in == closing[ci]) {
                return ci;
            }
        }
        return -1; // character not found 
    }

    boolean check(String text) {

        for (int i = 0; i < text.length(); i++) {
            //check to see if opening bracket
            if (isOpening(text.charAt(i)) != -1) {
                //System.out.println("found appropriate opening");
                this.brackStack.push(text.charAt(i));
            } 
            //Check to see if closing bracket
            else if (isClosing(text.charAt(i)) != -1) {
                //System.out.println("found appropriate closing");
                //Check to see if stack is empty
                if (brackStack.empty()) {
                    this.position = i;
                    return false;
                } 
                
                //If not empty, see if item on stack is at the same idex in closing
                else if (isOpening(brackStack.peek()) == isClosing(text.charAt(i))) {
                    //System.out.println ("found matching");
                    brackStack.pop();
                }
                else{
                    //Brackets not matching
                    //This scary error is dealt with later, look below
                }
            }
        }

        if (brackStack.empty()) {
            return true;
        } else {
            //System.out.println("stack not empty: " + brackStack.pop());
            this.position = text.length() - 1;
            
            //empty the stack! This is annoying
            while(!brackStack.empty()){
                brackStack.pop();
            }
            return false;
        }
    }

    int getPosition() {
        return this.position;
    }
}
