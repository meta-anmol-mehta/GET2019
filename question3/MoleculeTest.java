package com.metacube.training.question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoleculeTest {

    @Test
    public void test() {
        OrganicMolecularMass obj = new OrganicMolecularMass();
        String compound = "ch3";
        assertEquals(15,obj.evaluate(compound));
        compound = "CHOC(CH3)3";
        assertEquals(86,obj.evaluate(compound));
        compound = "C(OH)2";
        assertEquals(46,obj.evaluate(compound));
        compound = "C12H10";
        assertEquals(154,obj.evaluate(compound));
    }

    
    @Test(expected=NullPointerException.class)
    public void nulltest() {
        OrganicMolecularMass obj = new OrganicMolecularMass();
        assertEquals(15,obj.evaluate(null));
    }
    
    @Test
    public void digitMakerTest() {
        OrganicMolecularMass obj = new OrganicMolecularMass();
        assertEquals(10,obj.digitMaker("C10CH"));   //first C has 10 atoms
        assertEquals(1,obj.digitMaker("CH"));       //first C has 1 atom
    }
    @Test
    public void elementCheck() {
        Element e = new Element('C',3);
        assertEquals('C',e.getSymbol());
        assertEquals(3,e.getBase());
    }
}
