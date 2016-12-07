/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldLoader;

import Items.*;
import MainPackage.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldLoader {

    private RoomContainment rc;
    private RoomSaver rs;
    private boolean finishRoom;
    private boolean finishItem;
    private boolean finishBoss;
    private ArrayList<Boss> bosses;
    private ArrayList<String> links;
    private ItemContainment ic;
    private BossContainment bossC;

    public WorldLoader() {
        this.rc = new RoomContainment();
        this.rs = new RoomSaver();
        this.finishRoom = false;
        this.finishItem = false;
        this.finishBoss = false;
        this.bosses = new ArrayList<>();
        this.links = new ArrayList<>();
        this.ic = new ItemContainment();
        this.bossC = new BossContainment();
    }

    /**
     * The loadWorld method is a try-catch contruction The method is used to
     * read from a file containing the rooms and items It uses the Scanner to
     * read 1 line at a time from the file Other methods are then called to
     * create either an item or a room based on the line read
     *
     * @param fileToRead is a String which must contain the file name
     * @return will return an ArrayList<> of the rooms which has been created
     */
    public ArrayList<Room> loadWorld(String fileToRead) {
        try {
            boolean shouldCreateRoom = false, shouldCreateItem = false;
            FileReader file = new FileReader(fileToRead); // Reads the content of the given file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                // While the BufferedReader is ready we read the next line in the file
                String evaluateString = scanner.nextLine();
                if (shouldCreateRoom) {
                    // If createRoom is true the we act on what is in the file
                    shouldCreateRoom = createRoom(evaluateString);

                } else if (shouldCreateItem) {
                    // If createItem is true the we act on what is in the file
                    shouldCreateItem = createItem(evaluateString);
                }
                // We use a if else if to act on the header in the file
                // The header being what is in the []
                if (evaluateString.toLowerCase().equals("[room]")) {
                    shouldCreateRoom = true;
                } else if (evaluateString.toLowerCase().equals("[item]")) {
                    shouldCreateItem = true;
                }
            }
            //the FileNotFoundException is thrown if the given file doesnt exsist
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception in method loadWorld()" + e);
        }
        ArrayList<Room> returnRooms = connectWorld();
        return returnRooms;
    }

    /**
     * The createRoom method is used to create the rooms based on what is read
     * in the file. 
     * It contains a switch-case construction which has cases to
     * all atributes a room can have
     * @param evaluateString is a String that comes from the file
     * @return will return a boolean
     */
    private boolean createRoom(String evaluateString) {
        // We initializes an array of Strings which will contain strings based

        String[] strings = evaluateString.split("=");
        int length = strings.length;
        // We use an enhanced for loop also known as a for-each loop
        // to iterate through alle strings read from the file
        for (String s : strings) {
            switch (s) {
                case "id":
                    rc.setId(strings[length - 1]);
                    break;
                case "name":
                    rc.setName(strings[length - 1]);
                    break;
                case "locked":
                    rc.setLocked(strings[length - 1]);
                    break;
                case "escapeRoom":
                    rc.setEscapeRoom(strings[length - 1]);
                    break;
                case "hasEscapeCode":
                    rc.setContainsHiddenNumber(strings[length - 1]);
                    break;
                case "hidden":
                    rc.setHidden(strings[length - 1]);
                    break;
                case "linkedID":
                    String[] linkStrings = strings[length - 1].split(":");
                    rc.setLinkedID(linkStrings);
                    finishRoom = true;
                    break;
                default:
                    break;
            }
        }
        if (finishRoom) {
            Room room = new Room(rc.getId(), rc.getContainsHiddenNumber(), rc.getLocked(), rc.getEscapeRoom(), rc.getName(), rc.isHidden());
            rs.addRoom(room);
            buildLinkString();
            finishRoom = false;
            rc = new RoomContainment();
            return false;
        }
        return true;
    }

    /**
     * The connectWorld method is used to link
     * @return 
     */
    private ArrayList<Room> connectWorld() {
        Room mainRoom = null, secondRoom = null;
        String[] splitLinkArray = {""};
        do { //Iterate through the arraylist links
            for (String str : links) { //Split every string in links at "=" and save the strings into linkmap
                //links consist of a string of the format "mainroomID=roomToConnectID:roomToConnectID:.."
                //This will generate two strings "mainroomID" and "roomToConnectID:roomToConnectID:.."
                splitLinkArray = str.split("="); //For each iteration through links, iterate through all the rooms saved in RoomSaver
                for (Room r : rs.getAllRooms()) { //Compare the id of a room with the id that is the mainroom saved in linkMap
                    if (r.getId().equalsIgnoreCase(splitLinkArray[0])) { //Set r as the mainroom
                        mainRoom = r; //remove the string from the arraylist links
                        links.remove(str); 
                        break;//Break out of the for each loop
                    }

                } //break out of the outer for each loop
                break;

            } //Split the second string in linkMap at each ":" and save it into the array values, the second string consists of "roomToConnectID:roomToConnectID:.."
            String[] values = splitLinkArray[1].split(":"); //Iterate through the array called values
            for (String str2 : values) { //For each iteration through values, iterate through the rooms saved in RoomSaver
                for (Room r2 : rs.getAllRooms()) { //Compare the id of a room with the string from values. The string from values consist of a "roomToConnectID" string
                    String[] roomIdAndDirection = str2.split(";");
                    if (r2.getId().equalsIgnoreCase(roomIdAndDirection[0])) { //If true, set the room as the secondRoom
                        secondRoom = r2; //Print out a confirmation message to the console
                        mainRoom.setExit(roomIdAndDirection[1].toLowerCase(), secondRoom);
                    }
                }
            } //Do this while there are still links left in the links array
        } while (links.size() > 0); //Return an arraylist of all the rooms saved in RoomSaver
        return rs.getAllRooms();
    }

    private boolean createItem(String evaluateString) {
        String[] strings = evaluateString.split("=");
        int length = strings.length;
        for (String a : strings) {
            switch (a) {
                case "type":
                    ic.setType(strings[length - 1]);
                    break;
                case "roomID":
                    ic.setRoomID(strings[length - 1]);
                    break;
                case "weight":
                    ic.setWeight(strings[length - 1]);
                    break;
                case "capacity":
                    ic.setCapacity(strings[length - 1]);
                    break;
                case "pickup":
                    ic.setPickup(strings[length - 1]);
                    break;
                case "useable":
                    ic.setUseable(strings[length - 1]);
                    break;
                case "charges":
                    ic.setCharges(strings[length - 1]);
                    break;
                case "time":
                    ic.setTime(strings[length - 1]);
                    break;
                case "roomToUnlock":
                    ic.setNameOfRoomThatFitsThisKey(strings[length - 1]);
                    break;
                case "roomBoltcutterCanBeUsedIn":
                    ic.setRoomBoltcutterCanBeUsedIn(strings[length - 1]);
                    break;
                case "name":
                    ic.setName(strings[length - 1]);
                    finishItem = true;
                    break;
            }
        }
        if (finishItem) {
            switch (ic.getType()) {
                case FLASHLIGHT:
                    Flashlight flashlight = new Flashlight(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity(), ic.getCharges());
                    rs.addItem(flashlight, ic.getRoomID());
                    break;
                case KEY:
                    Key key = new Key(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity(), ic.getNameOfRoomThatFitsThisKey());
                    rs.addItem(key, ic.getRoomID());
                    break;
                case MISC:
                    Misc misc = new Misc(false, ic.getName(), false);
                    rs.addItem(misc, ic.getRoomID());
                    break;
                case BLUEPRINT:
                    Blueprint blueprint = new Blueprint(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getWeight(), ic.getCapacity());
                    rs.addItem(blueprint, ic.getRoomID());
                    break;
                case WEAPON:
                    Weapon weapon = new Weapon(ic.isPickup(), ic.getName(), false, ic.getWeight(), ic.getCapacity(), ic.getDamage(), ic.getWeapontype());
                    rs.addItem(weapon, ic.getRoomID());
                    break;
                case TIMEINCREASINGITEM:
                    TimeIncreasingItem timeincreasingitem = new TimeIncreasingItem(ic.isPickup(), ic.getName(), ic.isUseable(), ic.getTime());
                    rs.addItem(timeincreasingitem, ic.getRoomID());
                    break;
                case BOLTCUTTER:
                    Boltcutter boltcutter = new Boltcutter(ic.isPickup(), ic.getName(), ic.isPickup(), ic.getWeight(), ic.getCapacity(), ic.getRoomBoltcutterCanBeUsedIn());
                    rs.addItem(boltcutter, ic.getRoomID());
            }
            finishItem = false;
            ic = new ItemContainment();
            return false;
        }
        return true;
    }

    private void buildLinkString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rc.getId());
        sb.append("=");
        for (String str : rc.getLinkedID()) {
            sb.append(str);
            sb.append(":");
        }
        links.add(sb.toString());

    }

    public ArrayList<Boss> loadBosses(String fileToRead) {
        try {
            boolean shouldCreateBoss = false;
            FileReader file = new FileReader(fileToRead);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String evaluateString;
                evaluateString = scanner.nextLine();
                if (shouldCreateBoss) {
                    shouldCreateBoss = hasCreatedBoss(evaluateString);
                }

                if (evaluateString.equalsIgnoreCase("[boss]")) {
                    shouldCreateBoss = true;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception in loadBosses method" + ex);
        }
        return this.bosses;

    }

    private boolean hasCreatedBoss(String evaluateString) {
        String[] splitEvaluateString = evaluateString.split("=");
        int length = splitEvaluateString.length;
        for (String bossString : splitEvaluateString) {
            switch (bossString.toLowerCase()) {
                case "roomid":
                    bossC.setRoomId(splitEvaluateString[length - 1]);
                    break;
                case "hitpoints":
                    bossC.setHitpoints(splitEvaluateString[length - 1]);
                    break;
                case "bosstype":
                    bossC.setBossType(splitEvaluateString[length - 1]);
                    break;
                case "name":
                    bossC.setName(splitEvaluateString[length - 1]);
                    finishBoss = true;
                    break;
                default:
                    break;
            }
        }
        if (finishBoss) {
            Boss boss = new Boss(rs.getRoom(bossC.getRoomId()), bossC.getHitpoints(), bossC.getName());
            switch (bossC.getBossType()) {
                case BOSSTYPE1:
                    setUpBoss1(boss);
                    break;
                case BOSSTYPE2:
                    setUpBoss2(boss);
                    break;
                default:
                    setUpDefaultBoss(boss);
                    break;
            }
            bosses.add(boss);
            bossC = new BossContainment();
            finishBoss = false;
            return false;
        }
        return true;
    }

    private void setUpBoss1(Boss boss) {
        ArrayList<Move> moves = boss.getMoves();
        moves.add(new Move(10, Attack.LASH, Attack.JUMP));
        moves.add(new Move(10, Attack.CHARGE, Attack.SIDESTEP));
        moves.add(new Move(10, Attack.PUNCH, Attack.STAB));
        boss.getInventory().putItem(new Weapon(true, "Glock-18", false, 5, 1, 25, WeaponType.RANGED));
    }

    private void setUpBoss2(Boss boss) {
        ArrayList<Move> moves = boss.getMoves();
        moves.add(new Move(15, Attack.LASH, Attack.JUMP));
        moves.add(new Move(15, Attack.CHARGE, Attack.SIDESTEP));
        moves.add(new Move(15, Attack.PUNCH, Attack.STAB));
        moves.add(new Move(15, Attack.SHOOT, Attack.DUCK));
        moves.add(new Move(5, Attack.LAUGH, Attack.SHOOT));
    }

    private void setUpDefaultBoss(Boss boss) {
        ArrayList<Move> moves = boss.getMoves();
        moves.add(new Move(100, Attack.LAUGH, Attack.SHOOT));
    }
}
