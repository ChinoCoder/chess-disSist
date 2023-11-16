package Games.Commons;

import Games.Commons.Validators.OrValidator;

public class Piece {
    private final int id;
    private final Type type;
    private final Color color;
    private final OrValidator movements;

    public Piece(int id, Type type, Color color, OrValidator movements) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.movements = movements;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public OrValidator getMovements() {
        return movements;
    }

    public int getId() {
        return id;
    }

}
