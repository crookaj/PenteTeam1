
public class Board
{
    // PenteGame master; // currently sends an error, but is not necessary code
    int[][] positions; // 0 = blank, 1 = player1, 2 = player2

    public Board()
    {
        positions = new int[19][19];
    }
    public boolean validMove(int moveRow, int moveCol, int color) // if valid, it will place
    {
        if(moveRow < 0 || moveRow > positions.length)
        {
            return false;
        }
        if(moveCol < 0 || moveCol > positions[0].length)
        {
            return false;
        }
        if(positions[moveRow][moveCol] == 0)
        {
            positions[moveRow][moveCol] = color;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkWin(int moveRow, int moveCol)
    {
        int color = positions[moveRow][moveCol];
        // check up
        if(moveRow >= 4 && positions[moveRow - 1][moveCol] == color) // the 4 check prevents out of bounds
            if(positions[moveRow - 2][moveCol] == color)
                if(positions[moveRow - 3][moveCol] == color)
                    if(positions[moveRow - 4][moveCol] == color)
                        return true;
        // check down
        if(moveRow <= 14 && positions[moveRow + 1][moveCol] == color) // the 14 check prevents out of bounds
            if(positions[moveRow + 2][moveCol] == color)
                if(positions[moveRow + 3][moveCol] == color)
                    if(positions[moveRow + 4][moveCol] == color)
                        return true;
        // check left
        if(moveCol >= 4 && positions[moveRow][moveCol - 1] == color) // the 4 check prevents out of bounds
            if(positions[moveRow][moveCol - 2] == color)
                if(positions[moveRow][moveCol - 3] == color)
                    if(positions[moveRow][moveCol - 4] == color)
                        return true;
        // check right
        if(moveCol <= 14 && positions[moveRow][moveCol + 1] == color) // the 14 check prevents out of bounds
            if(positions[moveRow][moveCol + 2] == color)
                if(positions[moveRow][moveCol + 3] == color)
                    if(positions[moveRow][moveCol + 4] == color)
                        return true;
        // check up-left
        if(moveRow >= 4 && moveCol >= 4 && positions[moveRow - 1][moveCol - 1] == color)
            if(positions[moveRow - 2][moveCol - 2] == color)
                if(positions[moveRow - 3][moveCol - 3] == color)
                    if(positions[moveRow - 4][moveCol - 4] == color)
                        return true;
        // check up-right
        if(moveRow >= 4 && moveCol <= 14 && positions[moveRow - 1][moveCol + 1] == color)
            if(positions[moveRow - 2][moveCol + 2] == color)
                if(positions[moveRow - 3][moveCol + 3] == color)
                    if(positions[moveRow - 4][moveCol + 4] == color)
                        return true;
        // check down-left
        if(moveRow <= 14 && moveCol >= 4 && positions[moveRow + 1][moveCol - 1] == color)
            if(positions[moveRow + 2][moveCol - 2] == color)
                if(positions[moveRow + 3][moveCol - 3] == color)
                    if(positions[moveRow + 4][moveCol - 4] == color)
                        return true;
        // check down-right
        if(moveRow <= 14 && moveCol <= 14 && positions[moveRow + 1][moveCol + 1] == color)
            if(positions[moveRow + 2][moveCol + 2] == color)
                if(positions[moveRow + 3][moveCol + 3] == color)
                    if(positions[moveRow + 4][moveCol + 4] == color)
                        return true;


        return false;
    }

    public boolean checkCapture(int moveRow, int moveCol)
    {
        int color = positions[moveRow][moveCol];
        int opponentColor;
        if(color == 1)
            opponentColor = 2;
        else
            opponentColor = 1;

        // check up
        if(moveRow >= 3 && positions[moveRow - 1][moveCol] == opponentColor)
            if(positions[moveRow - 2][moveCol] == opponentColor)
                if(positions[moveRow - 3][moveCol] == color)
                    return true;
        // check down
        if(moveRow <= 15 && positions[moveRow + 1][moveCol] == opponentColor)
            if(positions[moveRow + 2][moveCol] == opponentColor)
                if(positions[moveRow + 3][moveCol] == color)
                    return true;
        // check left
        if(moveCol >= 3 && positions[moveRow][moveCol - 1] == opponentColor)
            if(positions[moveRow][moveCol - 2] == opponentColor)
                if(positions[moveRow][moveCol - 3] == color)
                    return true;
        // check right
        if(moveCol <= 15 && positions[moveRow][moveCol + 1] == opponentColor)
            if(positions[moveRow][moveCol + 2] == opponentColor)
                if(positions[moveRow][moveCol + 3] == color)
                    return true;
        // check up-left
        if(moveRow >= 3 && moveCol >= 3 && positions[moveRow - 1][moveCol - 1] == opponentColor)
            if(positions[moveRow - 2][moveCol - 2] == opponentColor)
                if(positions[moveRow - 3][moveCol - 3] == color)
                    return true;
        // check up-right
        if(moveRow >= 3 && moveCol <= 15 && positions[moveRow - 1][moveCol + 1] == opponentColor)
            if(positions[moveRow - 2][moveCol + 2] == opponentColor)
                if(positions[moveRow - 3][moveCol + 3] == color)
                    return true;
        // check down-left
        if(moveRow <= 15 && moveCol >= 3 && positions[moveRow + 1][moveCol - 1] == opponentColor)
            if(positions[moveRow + 2][moveCol - 2] == opponentColor)
                if(positions[moveRow + 3][moveCol - 3] == color)
                    return true;
        // check down-right
        if(moveRow <= 15 && moveCol <= 15 && positions[moveRow + 1][moveCol + 1] == opponentColor)
            if(positions[moveRow + 2][moveCol + 2] == opponentColor)
                if(positions[moveRow + 3][moveCol + 3] == color)
                    return true;


        return false;
    }
}