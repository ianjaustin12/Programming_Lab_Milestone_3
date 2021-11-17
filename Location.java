
public class Location {

    private CampusLoc currentPosition;
    private CampusLoc optionNorth;
    private CampusLoc optionSouth;
    private CampusLoc optionWest;
    private CampusLoc optionEast;

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

    //this is where the stupid hardcoded stuff starts... 
    //we dont want that
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

