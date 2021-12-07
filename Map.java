import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Map {
    
    private final static String filepath = "locations.bin";
    private static Location[][] map;
    private final String starting_Location = "start";

    public Map(){
        map = new Location[7][5];
        //
        //init();
        loadFromFile();
        printMap();
    }

    public void init(){
        //public Location (String currentPos, int y, int x, String about,Set<Item> inItems)
        Location startingLocation = new Location("start", 0, 2, "Welcome to the beginning of your journey!", null);
        startingLocation.addItem(new Item("starter sword", 1));
        startingLocation.addItem(new Item("starter shield", 1));
        Location loc1 = new Location("Cave Entrance", 1, 2, "OOO a spooky cave, I wonder whats around here.", null);
        loc1.addItem(new Item("bugs", 0));
        loc1.addItem(new Item("mildew", 0));
        Location loc2 = new Location("Dug Out", 1, 1, "Wish I had a ball and a bat to play with.", null);
        loc2.addItem(new Item("bat", 5));
        loc2.addItem(new Item("ball", 2));
        Location loc3 = new Location("Caverns", 2, 1, "This is deep", null);
        loc3.addItem(new Item("Acorns", 12));
        Location loc4 = new Location("Armory", 3, 1, "OOO an armory. I wonder what I will find in here.", null);
        loc4.addItem(new Item("Shiny Sword", 10));
        Location loc5 = new Location("Locker Room", 4, 1, "Hmm everything seems locked in here. I wonder if there's anything else.", null);
        loc5.addItem(new Item("helmet", 3));
        Location loc6 = new Location("Tunnel", 5, 1, "Hmm a tunnel. I wonder what is this way.", null);
        loc6.addItem(new Item("crickets", 0));
        Location loc7 = new Location("Treasure Room", 5, 0, "OOOOO TREASURE!", null);
        loc7.addItem(new Item("Gold", 30));
        Location loc8 = new Location("The Ring", 2, 2, "Uh oh this looks like trouble.", null);
        loc8.addItem(new Item("Sword", 10));
        loc1.addItem(new Item("Helmet", 10));
        loc1.addItem(new Item("Shield", 10));
        Location loc9 = new Location("Mosh Pit", 3, 2, "There seems to be a lot of monsters in here.", null);
        loc9.addItem(new Item("bugs", 0));
        Location loc10 = new Location("The Arena", 4, 2, "I see a lot of bones in this room.", null);
        loc10.addItem(new Item("bugs", 0));
        loc10.addItem(new Item("medkit", 10));
        Location loc11 = new Location("Royal Box", 5, 2, "OOO this room is fancy!", null);
        loc11.addItem(new Item("Gold", 30));
        Location loc12 = new Location("Underground Stream",1, 3, "Ah a stream. I wonder what I will find.", null);
        loc12.addItem(new Item("Sword of Griffindor", 40));
        Location loc13 = new Location("Green Room", 2, 3, "This room is green. Cool!", null);
        loc13.addItem(new Item("pears", 3));
        Location loc14 = new Location("The Bunkers", 3, 3, "It seems like something was kept really safe in here.", null);
        loc14.addItem(new Item("medkit", 10));
        Location loc15 = new Location("Abyss", 4, 3, "Its dark and empty in this room.", null);
        loc15.addItem(new Item("medkit", 10));
        Location loc16 = new Location("The Dog House", 5, 3, "Who let the dogs out?", null);
        loc16.addItem(new Item("bone", -10));
        Location finalBoss = new Location("finalBoss", 6, 2, "I guess its go time.", null);
        Location[] locs= {loc1,loc2,loc3,loc4,loc5,loc6,loc7,loc8,loc9,loc10,loc11,loc12,loc13,loc14,loc15,loc16,finalBoss,startingLocation};
        for (Location location : locs) {
            map[location.getYIndex()][location.getXIndex()] = location;
        }
        saveToFile();
    }
    public Location getStartingLocation(){
        return findByName(starting_Location);
    }
//function to print map as 2d Array
    public void printMap(){
        for(int i = 0; i<7; i++){
            String row = "";
            for(int j = 0; j<5; j++)
                if( map[i][j] == null)
                    row += "    empty";
                else
                    row += "    " + findByIndex(i, j).getName();
            System.out.println(row);
        }
    }
//finding locations on map funcstion
    public Location findByIndex(int yIndex, int xIndex){
        try {
            return map[yIndex][xIndex];
        } catch (NullPointerException e) {
            return null;
        }
    }
    public Location findByName(String name){
        for (Location[] locations : map) {
            for (Location location : locations) {
                if(location != null)
                    if(location.getName().equals(name))
                        return location;
            }
        }
        return null;
    }
//get the location north of param
    public Location getNorthLocation(Location fromLoc){
        try {
            Location toLoc = map[fromLoc.getYIndex() - 1][fromLoc.getXIndex()];
        if(!toLoc.getName().equals("empty")||toLoc != null )
            return toLoc;
        } catch (Exception e) {}
        return null;
    }
//get the location south of param
    public Location getSouthLocation(Location fromLoc){
        try{
            Location toLoc = map[fromLoc.getYIndex() + 1][fromLoc.getXIndex()];
            if(!toLoc.getName().equals("empty")||toLoc != null )
                return toLoc;
        }catch(Exception e){}
        return null;
    }
//get the location east of param
    public Location getEastLocation(Location fromLoc){
        try {
            Location toLoc = map[fromLoc.getYIndex()][fromLoc.getXIndex() + 1];
            if(!toLoc.getName().equals("empty")||toLoc != null )
                 return toLoc;
        } catch (Exception e) {}
        return null;
    }
//get the location west of param
    public Location getWestLocation(Location fromLoc){
        try {
            Location toLoc = map[fromLoc.getYIndex()][fromLoc.getXIndex() - 1];
            if(!toLoc.getName().equals("empty")||toLoc != null )
                return toLoc;
        }catch(Exception e){}
        return null;
    }
//adds a location to map
    public void addLocation(Location loc){
        map[loc.getYIndex()][loc.getXIndex()]= loc;
    }
// removes a location from map
    public void removeLocation(Location loc){
        map[loc.getYIndex()][loc.getXIndex()]= null;
    }
//returns the map
    public Location[][] getMap(){
        return map;
    }
//to select a location by iterating through all
    public Location selectLocation(Scan scan){
        Location loc = null;
        for (Location[] locations : map) {
            for (Location location : locations) {
                System.out.println(location + "?");
                if(scan.yesOrNo()){
                    return location;
                }
            }
        }
        return loc;
    }
//saves map to .dat file
    public void saveToFile(){
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            for(Location[] locations: map)
                for(Location location: locations)
                    objectOut.writeObject(location);
            objectOut.close();
                 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
//uploads map from.dat file
    public void loadFromFile(){
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(filepath));
            while (true) {
                try{
                    Location location = (Location)input.readObject();
                    if(findByIndex(location.getYIndex(),location.getXIndex()) == null)
                        addLocation(location);
                }catch(EOFException ex){input.close();}
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
