package MainPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danieln Johansen
 */
public enum ItemType {

	KEY("key"), WEAPON("weapon"), FLASHLIGHT("flashlight"), BLUEPRINT("blueprint"), MISC("misc");
        
        String stringItemType;

        private ItemType (String stringItemType) {
            this.stringItemType = stringItemType;
        }
        
        @Override
        public String toString() {
            return stringItemType;
        }
}
