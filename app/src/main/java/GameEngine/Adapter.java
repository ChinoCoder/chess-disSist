package GameEngine;

import Games.Commons.*;
import edu.austral.dissis.chess.gui.BoardSize;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.Move;
import edu.austral.dissis.chess.gui.PlayerColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adapter {
    public static List<ChessPiece> getCurrentPieces(Board board){
        List<ChessPiece> piecesInAdapter = new ArrayList<ChessPiece>();
        Map<Square, Piece> boardState = board.getBoard();
        boardState.forEach((position, piece) -> {
            if(piece!=null) {
                ChessPiece chessPiece= new ChessPiece(String.valueOf(piece.getId()),
                    convertPlayerColor(piece.getColor()),convertPosition(position),piece.getType().toString().toLowerCase());
                    piecesInAdapter.add(chessPiece);
            }
        });
        return piecesInAdapter;
    }

    public static BoardSize getBoardSize(Board board){
        return new BoardSize(board.getRows(),board.getColumns());
    }

    public static PlayerColor getCurrentTurn(Game game){
        return game.getCurrentTurnColor() == Color.WHITE? PlayerColor.WHITE:PlayerColor.BLACK;
    }

    public static PlayerColor getWinner(Game game){
        return getCurrentTurn(game);
    }


    public static Square[] convertMove(Move move){
        return new Square[]{new Square(move.getFrom().getRow(),move.getFrom().getColumn()),new Square(move.getTo().getRow(),move.getTo().getColumn())};
    }

    private static PlayerColor convertPlayerColor(Color color){
        return color==Color.WHITE? PlayerColor.WHITE:PlayerColor.BLACK;
    }

    public static edu.austral.dissis.chess.gui.Position convertPosition(Square square){
        return new edu.austral.dissis.chess.gui.Position(square.getRow(), square.getColumn());
    }

}