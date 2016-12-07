/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Niklas
 */
public enum Direction {
    NORTH("north"), SOUTH("south"), EAST("east"), WEST("west"), UNKNOWN("?");
    
    private String directionString;
    
    Direction(String directionString){
        this.directionString = directionString;
    }
    
    @Override
    public String toString(){
        return this.directionString;
    }
}
