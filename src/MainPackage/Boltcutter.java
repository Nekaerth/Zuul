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
public class Boltcutter extends Item {

    public Boltcutter(boolean pickup, String name, boolean useable, int weight, int capacity) {
        super(pickup, name, useable, weight, capacity);
    }

    @Override
    public ItemType getType() {
        return ItemType.BOLTCUTTER;
    }
    
}
