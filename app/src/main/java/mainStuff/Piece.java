package mainStuff;

public abstract class Piece {
    private final String name;
    private final Color color;
    private final MovementValidator[] movements;

    public Piece(String name, Color color, MovementValidator[] movements) {
        this.name = name;
        this.color = color;
        this.movements = movements;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public MovementValidator[] getMovements() {
        return movements;
    }

}
