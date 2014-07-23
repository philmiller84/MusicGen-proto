/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicgen;

/**
 *
 * @author Phil
 */


public class Accidental {
    public enum AccidentalType {SHARP, FLAT};
    
    private AccidentalType type;
    private int quantity;
    
    public Accidental(int quantity, AccidentalType type)
    {
        this.quantity = quantity;
        this.type = type;    
    }
    
    public String ToString()
    {
        String typeString = "";
        String accidentalString = "";
        
        switch (type)
        {
            case SHARP:
                typeString = "#";
                break;
            case FLAT:
                typeString = "b";
                break;
        }
        for(int i=0; i < this.quantity; i++)
        {
            accidentalString += typeString;
        }
        return accidentalString;        
    }
}
