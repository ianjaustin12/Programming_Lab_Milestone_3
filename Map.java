import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Map {
    
    private final static String filepath = "locations.bin";
    private static int size;
    private static Location[][] map;
    private static Location[][] locations;
    private final String starting_Location = "start";

    public Map(){
        locations = new Location[2][15];
        size = (int)Math.ceil(Math.random()*10);
        map = new Location[size][size];
        //
        init(); 
        //loadFromFile();
        //printMap();
    }

    public void init(){
        //public Location (String currentPos, int y, int x, String about,Set<Item> inItems)
        Location startingLocation = new Location("start", 0, 2, "Welcome to the beginning of your journey!", null);
        startingLocation.addItem(new Item("starter sword", 0, 0 ,1));
        startingLocation.addItem(new Item("starter shield", 0,1,0));
        Location loc1 = new Location("Cave Entrance", 1, 2, "OOO a spooky cave, I wonder whats around here.", null);
        loc1.addItem(new Item("pile of bugs", 1,0,0));
        Location loc2 = new Location("Dug Out", 1, 1, "Wish I had a ball and a bat to play with.", null);
        loc2.addItem(new Item("bat", 0,0,5));
        Location loc3 = new Location("Caverns", 2, 1, "This is deep", null);
        loc3.addItem(new Item("Handful of Acorns", 0,10,0));
        Location loc4 = new Location("Armory", 3, 1, "OOO an armory. I wonder what I will find in here.", null);
        loc4.addItem(new Item("Shiny Sword", 10,0,10));
        Location loc5 = new Location("Locker Room", 4, 1, "Hmm everything seems locked in here. I wonder if there's anything else.", null);
        loc5.addItem(new Item("helmet armor", 5,10,10));
        Location loc6 = new Location("Tunnel", 5, 1, "Hmm a tunnel. I wonder what is this way.", null);
        loc6.addItem(new Item("group of crickets", 3,3,0));
        Location treasureRoom = new Location("Treasure Room", 5, 0, "OOOOO TREASURE!", null);
        treasureRoom.addItem(new Item("Golden Star", 30,30,0));
        Location loc8 = new Location("The Ring", 2, 2, "Uh oh this looks like trouble.", null);
        loc8.addItem(new Item("Sword", 10,0,5));
        Location loc9 = new Location("Mosh Pit", 3, 2, "There seems to be a lot of monsters in here.", null);
        loc9.addItem(new Item("Steel Armor", 40,40,40));
        Location loc10 = new Location("The Arena", 4, 2, "I see a lot of bones in this room.", null);
        loc10.addItem(new Item("basic medkit", 10,20,0));
        Location loc11 = new Location("Royal Box", 5, 2, "OOO this room is fancy!", null);
        loc11.addItem(new Item("Pile of Gold", 15,0,0));
        Location loc12 = new Location("Underground Stream",1, 3, "Ah a stream. I wonder what I will find.", null);
        loc12.addItem(new Item("Sword of Griffindor", 20,0,40));
        Location loc13 = new Location("Green Room", 2, 3, "This room is green. Cool!", null);
        loc13.addItem(new Item("couple of pears", 3,0,0));
        Location loc14 = new Location("The Bunkers", 3, 3, "It seems like something was kept really safe in here.", null);
        loc14.addItem(new Item("Godly Medkit", 40,40,40));
        Location loc15 = new Location("Abyss", 4, 3, "Its dark and empty in this room.", null);
        loc15.addItem(new Item("cola", 1,0,0));
        Location loc16 = new Location("The Dog House", 5, 3, "Who let the dogs out?", null);
        loc16.addItem(new Item("bone", 1,0,0));
        Location finalBoss = new Location("finalBoss", 6, 2, "I guess its go time.", null);
        locations[0] = new Location[]{loc1,loc2,loc3,loc4,loc5,loc6,loc8,loc9,loc10,loc11,loc12,loc13,loc14,loc15,loc16};
        locations[1] = new Location[]{startingLocation, finalBoss, treasureRoom};
        randomizeMap();        
        saveToFile();
    }
    public Location getStartingLocation(){
        return findByName(starting_Location);
    }
    public void randomizeMap() {
        map = new Location[size][size];
        
    //set static locations onto the map start, boss, treasure 
            map[0][(map.length - 1) / 2] = locations[1][0];
            locations[1][0].setXIndex((map.length - 1) / 2);
            locations[1][0].setYIndex(0);
            map[(map.length - 1) / 2][(map.length - 1) / 2] = locations[1][1];
            locations[1][1].setXIndex((map.length - 1) / 2);
            locations[1][1].setYIndex(0);
            map[(map.length - 1) / 3][0] = locations[1][2];
            locations[1][2].setXIndex((map.length - 1) / 2);
            locations[1][2].setYIndex(0);

    //randomizes location and adds border;    
        for (int y = 0; y < map.length -1; y++){
            for (int x = 0; x < map.length -1; x++){
                if (map[y][x] != null)
                    continue;
                else if (y == 0 || y == map.length-1|| x == 0 || x == map.length-1)
                    map[y][x] = new Location("empty", y, x, "", null);
                else if (Math.random() >= ((double)map.length)/locations[1].length){
                    int rand = (int)Math.ceil(Math.random() * locations[1].length);
                    map[y][x] = locations[0][rand];
                    locations[0][rand].setXIndex(x);
                    locations[0][rand].setYIndex(y);
                }
                else{
                    map[y][x] = new Location("Hall", y, x, "Just a hall way no monsters in here", null);
                           
                }
            }
        }
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
        } catch (Exception e) {/*????????*/}
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
    public Location selectLocation(){
        Location loc = null;
        for (Location[] locations : map) {
            for (Location location : locations) {
                System.out.println(location + "?(yes/no)");
                while(true){
                    String in = App.scan.nextLine();
                    if(in.equals("yes")){
                        return location;
                    }
                    else if(in.equals("no")){break;}
                    else{System.out.println("need yes or no");}
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
