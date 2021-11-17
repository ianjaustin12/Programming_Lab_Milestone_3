
public class Location {

//    public final String EAST = "East";
//    public final String WEST = "West";
//    public final String NORTH = "North";
//    public final String SOUTH = "South";
//    private String currentLocation = "The Stag Statue";

    private CampusLoc currentPosition;
    private CampusLoc optionNorth;
    private CampusLoc optionSouth;
    private CampusLoc optionWest;
    private CampusLoc optionEast;

//    public String getCurrentLocation() {
//        return currentLocation;
//    }
//
//    public void setCurrentLocation(String currentLocation) {
//        this.currentLocation = currentLocation;
//    }
//
//    public void move(String direction) {
//        System.out.println("You're moving from the [" + currentLocation + "] in the following direction: [" + direction + "]");
//
//        if (currentLocation.equals("The Stag Statue"))
//            handleStagMove(direction);
//
//        else if (currentLocation.equals("The Quad"))
//            handleQuadMove(direction);
//
//        else if (currentLocation.equals("The Tully"))
//            handleTullyMove(direction);
//
//        else if (currentLocation.equals("The Main Gate"))
//            handleMainGateMove(direction);
//
//        else if (currentLocation.equals("Bellarmine Field"))
//            handleBellarmineMove(direction);
//
//        else if (currentLocation.equals("The Fairfield Prep School"))
//            handlePrepMove(direction);
//
//        else if (currentLocation.equals("Baseball Field"))
//            handleBaseballMove(direction);
//
//        else if (currentLocation.equals("The Town Houses"))
//            handleTownMove(direction);
//
//        else if (currentLocation.equals("The Zen Garden"))
//            handleZenGardenMove(direction);
//
//
//        //else..  other current locations...
//
//
//    }

    public CampusLoc getCurrentPosition(){
        return currentPosition;
    }

    public void setCurrentPosition(CampusLoc currentPosition) {
        this.currentPosition = currentPosition;
    }

    public CampusLoc getOptionNorth() {
        return optionNorth;
    }

    public void setOptionNorth(CampusLoc optionNorth) {
        this.optionNorth = optionNorth;
    }

    public CampusLoc getOptionSouth() {
        return optionSouth;
    }

    public void setOptionSouth(CampusLoc optionSouth) {
        this.optionSouth = optionSouth;
    }

    public CampusLoc getOptionWest() {
        return optionWest;
    }

    public void setOptionWest(CampusLoc  optionWest) {
        this.optionWest = optionWest;
    }

    public CampusLoc getOptionEast() {
        return optionEast;
    }

    public void setOptionEast(CampusLoc optionEast) {
        this.optionEast = optionEast;
    }

    public Location(CampusLoc currentPosition) {
        this.currentPosition = currentPosition;
        optionNorth = CampusLoc.Quad;
        optionSouth = CampusLoc.Tully;
        optionWest = null;
        optionEast = CampusLoc.MainGate;
    }


    public void handleMove(CampusLoc Loc, Direction dir) {

        switch(Loc) {
            case Stag:
                handleStagMove(dir);
                break;
            case Quad:
                handleQuadMove(dir);
                break;
            case MainGate:
                handleMainGateMove(dir);
                break;
            case Tully:
                handleTullyMove(dir);
        }

    }


    //state ( location ) has been updated
//    public void handleStagMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST))
//            currentLocation = "The Quad";
//
//        else if (direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Tully";
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            currentLocation = "The Zen Garden";
//
//        else if (direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Main Gate";
//    }
//
//    public void handleQuadMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST)){
//            System.out.println("You cannot continue this way...");}
//
//        else if (direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Stag Statue";
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            currentLocation = "Baseball Field";
//
//        else if (direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Town Houses";
//
//    }
//
//    public void handleTullyMove(String direction) {
//
//        if(direction.equalsIgnoreCase(EAST))
//            currentLocation = "The Stag";
//
//        else if(direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Tully";
//
//        else if(direction.equalsIgnoreCase(NORTH))
//            currentLocation = "Bellarmine Field";
//
//        else if(direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Fairfield Prep School";
//    }
//    public void handleMainGateMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST))
//            currentLocation = "The Town Houses";
//
//        else if (direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Fairfield Prep School";
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            currentLocation = "The Stag Statue";
//
//        else if (direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Main Gate";
//    }
//    public void handleTownMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST)){
//            System.out.println("You cannot continue this way...");}
//
//        else if (direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Main Gate";
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            currentLocation = "The Quad";
//
//        else if (direction.equalsIgnoreCase(SOUTH)){
//            System.out.println("You cannot continue this way...");}
//    }
//
//    public void handleBaseballMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST)){
//            System.out.println("You cannot continue this way...");}
//
//        else if (direction.equalsIgnoreCase(WEST))
//            currentLocation = "The Zen Garden";
//
//        else if (direction.equalsIgnoreCase(NORTH)){
//            System.out.println("You cannot continue this way..."); }
//
//        else if (direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Quad";
//
//    }
//
//    public void handleBellarmineMove(String direction) {
//
//        if(direction.equalsIgnoreCase(EAST))
//            currentLocation = "The Zen Garden";
//
//        else if(direction.equalsIgnoreCase(WEST)){
//            System.out.println("You cannot continue this way...");}
//
//        else if(direction.equalsIgnoreCase(NORTH)){
//            System.out.println("You cannot continue this way...");}
//
//        else if(direction.equalsIgnoreCase(SOUTH))
//            currentLocation = "The Tully";
//    }
//    public void handlePrepMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST))
//            currentLocation = "The Main Gate";
//
//        else if (direction.equalsIgnoreCase(WEST)) {
//            System.out.println("You cannot continue this way...");}
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            currentLocation = "The Tully";
//
//        else if (direction.equalsIgnoreCase(SOUTH)) {
//            System.out.println("You cannot continue this way...");}
//    }
//
//    public void handleZenGardenMove(String direction) {
//
//        if (direction.equalsIgnoreCase(EAST))
//                currentLocation = "Baseball Field";
//
//        else if (direction.equalsIgnoreCase(WEST)){
//                currentLocation = "Bellarmine Field";}
//
//        else if (direction.equalsIgnoreCase(NORTH))
//            System.out.println("You cannot continue this way...");
//
//        else if (direction.equalsIgnoreCase(SOUTH)){
//                currentLocation = "The Stag Statue";}
//        }
    public void handleStagMove(Direction dir) {
        CampusLoc oldPosition = currentPosition;

        switch (dir) {
            case NORTH:
                currentPosition = CampusLoc.Quad;
                optionNorth = null;
                optionSouth = CampusLoc.Stag;
                optionEast = null;
                optionWest = null;
                break;
            case EAST:
                currentPosition = CampusLoc.MainGate;
                optionNorth = null;
                optionSouth = null;
                optionEast = null;
                optionWest = CampusLoc.Stag;
                break;
            case SOUTH:
                currentPosition = CampusLoc.Tully;
                optionNorth = CampusLoc.Stag;
                optionSouth = null;
                optionEast = null;
                optionWest = null;
                break;
            case WEST:
                currentPosition = CampusLoc.Stag;
                optionNorth = CampusLoc.Quad;
                optionSouth = CampusLoc.Tully;
                optionEast = CampusLoc.MainGate;
                optionWest = null;
                break;
        }
        print(oldPosition);
    }

    public void handleQuadMove(Direction dir) {
        CampusLoc oldPosition = currentPosition;
        switch (dir) {
            case NORTH: case EAST: case WEST:
                currentPosition = CampusLoc.Quad;
                optionNorth = null;
                optionSouth = CampusLoc.Stag;
                optionEast = null;
                optionWest = null;
                break;
            case SOUTH:
                currentPosition = CampusLoc.Stag;
                optionNorth = CampusLoc.Quad;
                optionSouth = CampusLoc.Tully;
                optionEast = CampusLoc.MainGate;
                optionWest = null;
                break;
        }
        print(oldPosition);
    }

    public void handleMainGateMove(Direction dir) {
        CampusLoc oldPosition = currentPosition;
        switch (dir) {
            case NORTH: case EAST: case SOUTH:
                currentPosition = CampusLoc.MainGate;
                optionNorth = null;
                optionSouth = null;
                optionEast = null;
                optionWest = CampusLoc.Stag;
                break;
            case WEST:
                currentPosition = CampusLoc.Stag;
                optionNorth = CampusLoc.Quad;
                optionSouth = CampusLoc.Tully;
                optionEast = CampusLoc.MainGate;
                optionWest = null;
                break;
        }
        print(oldPosition);
    }
    public void handleTullyMove(Direction dir) {
        CampusLoc oldPosition = currentPosition;
        switch (dir) {
            case NORTH: case EAST: case WEST:
                currentPosition = CampusLoc.Quad;
                optionNorth = CampusLoc.Stag;
                optionSouth = null;
                optionEast = null;
                optionWest = null;
                break;
            case SOUTH:
                currentPosition = CampusLoc.Stag;
                optionNorth = CampusLoc.Quad;
                optionSouth = CampusLoc.Tully;
                optionEast = CampusLoc.MainGate;
                optionWest = null;
                break;
        }
        print(oldPosition);
    }

    public void print(CampusLoc oldPosition) {

        System.out.println("............");
        if (!oldPosition.equals(currentPosition)) {
            System.out.println("You have stumbled across a " + currentPosition);
        } else {
            System.out.println("You are still stuck at the " + currentPosition);
        }
        System.out.println("");

    }

    public void setCurrentPosition(String area) {

    }
}

