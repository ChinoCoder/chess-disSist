package Games.Chess.Factories;

import Games.Commons.Board;

public interface Factory {
    public Board createBoard(int rows, int columns);

}
