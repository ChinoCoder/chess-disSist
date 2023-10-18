package mainStuff;

import mainStuff.Validators.AndValidator;

public abstract class Piece {
    private final int id;
    private final Type type;
    private final Color color;
    private final AndValidator movements;

    public Piece(int id, Type type, Color color, AndValidator movements) {
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

    public AndValidator getMovements() {
        return movements;
    }

}
