package com.metacube.training.question3;

import java.util.Stack;

public class OrganicMolecularMass {

   
    private Stack<Element> stack = new Stack<Element>();
    
   
    public int evaluate(String compound) {
        String input = compound.toUpperCase() + ")";    
        int i =0, totalMass =0;
        this.stack.push(new Element('(',1));           
        while(i<input.length()) {
            char symbol = input.charAt(i);
            switch(symbol) {
            case 'C':
            case 'H':
            case 'O':
                if(i==input.length()-1) {
                    this.stack.push(new Element(symbol,1));
                    i++;
                }
                else {
                    int base = this.digitMaker(input.substring(i));
                    this.stack.push(new Element(symbol,base));
                    i++;
                }
                break;
            case '(':
                this.stack.push(new Element('(',1));
                i++;
                break;
            case ')':
                if(i==input.length()-1) {
                    totalMass += this.evaluate(1);
                }
                else {
                    int base = this.digitMaker(input.substring(i));
                    totalMass += this.evaluate(base);
                }
            default:
                i++;
            }
        }
        
        this.stack.clear();
        return totalMass;
    }
    
   
   public int digitMaker(String subCompound) {
        int digit = 0;
        for(int i=1;i<subCompound.length();i++) {
            char symbol = subCompound.charAt(i);
            if(Character.isDigit(symbol)) {
                digit = digit*10 + (int)(symbol - '0');
            }
            else {
                break;
            }
        }
        if(digit == 0) {
            return 1;
        }
        return digit;
    }
   
   private int evaluate(int base) {
        int subMass = 0;
        Element element;
        while(true) {
           element = this.stack.pop();
           if(element.getSymbol() == '(') {
               break;
           }
           else {
               switch(element.getSymbol()) {
                   case 'C':
                             subMass+= (12*element.getBase());
                             break;
                   case 'O':
                             subMass+= (16*element.getBase());
                             break;
                   case 'H':
                             subMass+= (1*element.getBase());
                             break;
               }
            
          } 
       }
        return (subMass*base);
    }
}
