class Rook extends Piece {

    public Rook(Team team) {
        super('R', team);

    }

    @Override
    public boolean checkMove(Case currentCase, Case nextCase) {
        return true;
    }
    @Override
    public int[][] move(Case[][] chess, int row, int column) {
        /**
         * direction possible of the piece
         * {line, column}
         */
        int[][] directionMove = {
                { 0, 1 }, { 0, -1 },
                { 1, 0 }, { -1, 0 }
        };
        /** count for the multiplication of the move */
        int countMove = 0;
        /**
         * loop on the possible direction of the piece to extract the actual line and
         * the actual column of the piece on the board
         */
        for (int i = 0; i < directionMove.length; i++) {
            int actualLine = directionMove[i][0];
            int actualColumn = directionMove[i][1];
            /** calculte the new place of the piece on the board */
            for (int j = 1; j < chess.length; j++) {
                int newLine = row + actualLine * j;
                int newColumn = column + actualColumn * j;
                /** verification of the new line and the new column */
                if (newLine < 0 || newLine >= 8 || newColumn < 0 || newColumn >= 8) {
                    break;
                }
                /** create a object Case with the new position of the piece */
                Case casePossible = chess[newLine][newColumn];
                /**
                 * verification of the case is empty or not and what the team of the piece on
                 * new case
                 */
                if (casePossible.piece == null) {
                    countMove++;
                } else if (casePossible.piece.getTeam() != getTeam()) {
                    countMove++;
                    break;
                } else {
                    break;
                }
            }
        }
        int[][] possibleMove = new int[countMove][2];
        int currentIndex = 0;
        for (int i = 0; i < directionMove.length; i++) {
            int actualLine = directionMove[i][0];
            int actualColumn = directionMove[i][1];
            /** calculte the new place of the piece on the board */
            for (int j = 1; j < chess.length; j++) {
                int newLine = row + actualLine * j;
                int newColumn = column + actualColumn * j;
                /** verification of the new line and the new column */
                if (newLine < 0 || newLine >= 8 || newColumn < 0 || newColumn >= 8) {
                    break;
                }
                /** create a object Case with the new position of the piece */
                Case casePossible = chess[newLine][newColumn];

                if (casePossible.piece == null) {
                    possibleMove[currentIndex][0] = newLine;
                    possibleMove[currentIndex][1] = newColumn;
                    currentIndex++;

                }
                else if (casePossible.piece.getTeam() != getTeam()) {
                    possibleMove[currentIndex][0] = newLine;
                    possibleMove[currentIndex][1] = newColumn;
                    currentIndex++;
                    break;

                } else {
                    break;
                }
            }
        }
        return possibleMove;
    }
}