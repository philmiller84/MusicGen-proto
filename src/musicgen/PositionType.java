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
public enum PositionType { BEGINNING, END, BEFORE, AFTER, AT, NEXT, PREV;

    public PositionType GetInverse(PositionType positionType){

        PositionType inverse = null;

        switch(positionType)
        {
            case BEGINNING: 
                inverse = END;
                break;
            case END:
                inverse = BEGINNING;
                break;
            case BEFORE:
                inverse = AFTER;
                break;
            case AFTER:
                inverse = BEFORE;
                break;
            case NEXT:
                inverse = PREV;
                break;
            case PREV:
                inverse = NEXT;
                break;
        }

        return inverse;
    }

}
