class Pawn extends Piece {

    public Pawn(Team team) {
        super('P', team);

    }
    @Override
    public boolean checkMove(Case currentCase, Case nextCase) {
        return true;
    }
    @Override
    public int[][] move(Case[][] chess, int row, int column) {
        /**
         * direction possible of the piece
         */
        int directionMove = (getTeam() == Team.WHITE) ? -1 : 1;
        int initialLine = (getTeam() == Team.WHITE) ? 6 : 1;
        /** count for the multiplication of the move */
        int countMove = 0;

        int nextLine = row + directionMove;
        /**
         * verification of the new Line
         */
        if (nextLine >= 0 && nextLine < 8 && chess[nextLine][column].piece == null) {
            countMove++;
            if (row == initialLine) {
                int stepLineTwo = row + 2 * directionMove;
                if (stepLineTwo >= 0 && stepLineTwo < 8 && chess[stepLineTwo][column].piece == null) {
                    countMove++;
                }
            }
        }
        /** table for the capture of the pawn */
        int[][] capture = {
                { directionMove, -1 },
                { directionMove, 1 }
        };
        for (int i = 0; i < capture.length; i++) {
            int captureLine = row + capture[i][0];
            int captureColumn = column + capture[i][1];

            if (captureLine >= 0 && captureLine < 8 && captureColumn >= 0 && captureColumn < 8) {
                Case targetCase = chess[captureLine][captureColumn];

                if (targetCase.piece != null && targetCase.piece.getTeam() != getTeam()) {
                    countMove++;
                }
            }

        }
        int[][] possibleMove = new int[countMove][2];
        int currentIndex = 0;
        nextLine = row + directionMove;
        if (nextLine >= 0 && nextLine < 8 && chess[nextLine][column].piece == null) {
            possibleMove[currentIndex][0] = nextLine;
            possibleMove[currentIndex][1] = column;
            currentIndex++;

            if (row == initialLine) {
                int stepLineTwo = row + 2 * directionMove;
                if (stepLineTwo >= 0 && stepLineTwo < 8 && chess[stepLineTwo][column].piece == null) {
                    possibleMove[currentIndex][0] = stepLineTwo;
                    possibleMove[currentIndex][1] = column;
                    currentIndex++;
                }
            }
        }

        for (int i = 0; i < capture.length; i++) {
            int captureLine = row + capture[i][0];
            int captureColumn = column + capture[i][1];

            if (captureLine >= 0 && captureLine < 8 && captureColumn >= 0 && captureColumn < 8) {
                Case targetCase = chess[captureLine][captureColumn];
                if (targetCase.piece != null && targetCase.piece.getTeam() != getTeam()) {
                    possibleMove[currentIndex][0] = captureLine;
                    possibleMove[currentIndex][1] = captureColumn;
                    currentIndex++;
                }
            }
        }
        return possibleMove;
    }
}