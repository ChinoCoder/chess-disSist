package mainStuff;

import java.util.List;

public class Game {
    private final List<Board> turns;
    private final Player white;
    private final Player black;

    public Game(Board initialBoard, Player white, Player black){
        this.turns = List.of(initialBoard);
        this.white = white;
        this.black = black;
    }
    private Game(List<Board> turns, Player white, Player black){
        this.turns = turns;
        this.white = white;
        this.black = black;
    }

    public List<Board> getTurns() {
        return turns;
    }
    public Player getWhite() {
        return white;
    }
    public Player getBlack() {
        return black;
    }
    public Board getCurrentTurn() {
        return turns.get(turns.size() - 1);
    }
    public Game addTurn(Board board){
        List<Board> newTurns = new java.util.ArrayList<>(List.copyOf(turns));
        newTurns.add(board);
        return new Game(newTurns, white, black);
    }
}
