package mainStuff;

import mainStuff.Color;
import mainStuff.Movement;

import java.util.List;

public abstract class Piece {
    private final List<Movement> movements;
    private final Color color;
    private final boolean hasMoved;

    public Piece(Color color, List<Movement> moveList){
        this.color = color;
        this.movements = moveList;
        this.hasMoved = false;
    }

    private Piece(Color color, List<Movement> moveList, boolean hasMoved){
        this.color = color;
        this.movements = moveList;
        this.hasMoved = hasMoved;
    }

    public List<Movement> getMovements() {
        return movements;
    }
    public Color getColor() {
        return color;
    }
    public boolean HasMoved() {
        return hasMoved;
    }

}
