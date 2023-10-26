package Games.Commons;

import java.util.Objects;

public class Square{
    private final int row;
    private final int column;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square position = (Square) o;
        return this.getRow() == position.getRow() && this.getColumn() == position.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
