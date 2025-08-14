import java.util.HashMap;
import java.util.Map;

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Map<Position, Character> board = new HashMap<>();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.put(new Position(x, y), '*');
            }
        }

        for (Position position : board.keySet()) {
            System.out.println(position.getX() + ", "
                    + position.getY() + ": " +board.get(position));
        }

        System.out.println(board.get(new Position(1, 1)));
    }
}