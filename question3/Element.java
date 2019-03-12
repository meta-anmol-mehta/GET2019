package com.metacube.training.question3;

public class Element {
    private char symbol;
    private int base;
    
    
    public Element(char symbol, int base) {
        
        this.symbol = symbol;
        this.base = base;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    

}
