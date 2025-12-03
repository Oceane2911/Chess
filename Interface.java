public class Interface {
    private static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
    private Case[][] chess = {
            { new Case(),
                    new Case(),
                    new Case(),
                    new Case(),
                    new Case(),
                    new Case(),
                    new Case(),
                    new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },

    };

    public Interface() {
        init();
        display();
        while (true) {
            play();
            display();
        }
    }

    private void init() {
        chess[0][0].piece = new Rook('B');
        chess[0][1].piece = new Knight('B');
        chess[0][2].piece = new Bishop('B');
        chess[0][3].piece = new Queen('B');
        chess[0][4].piece = new King('B');
        chess[0][5].piece = new Bishop('B');
        chess[0][6].piece = new Knight('B');
        chess[0][7].piece = new Rook('B');
        chess[1][0].piece = new Pawn('B');
        chess[1][1].piece = new Pawn('B');
        chess[1][2].piece = new Pawn('B');
        chess[1][3].piece = new Pawn('B');
        chess[1][4].piece = new Pawn('B');
        chess[1][5].piece = new Pawn('B');
        chess[1][6].piece = new Pawn('B');
        chess[1][7].piece = new Pawn('B');

        chess[7][0].piece = new Rook('W');
        chess[7][1].piece = new Knight('W');
        chess[7][2].piece = new Bishop('W');
        chess[7][3].piece = new Queen('W');
        chess[7][4].piece = new King('W');
        chess[7][5].piece = new Bishop('W');
        chess[7][6].piece = new Knight('W');
        chess[7][7].piece = new Rook('W');
        chess[6][0].piece = new Pawn('W');
        chess[6][1].piece = new Pawn('W');
        chess[6][2].piece = new Pawn('W');
        chess[6][3].piece = new Pawn('W');
        chess[6][4].piece = new Pawn('W');
        chess[6][5].piece = new Pawn('W');
        chess[6][6].piece = new Pawn('W');
        chess[6][7].piece = new Pawn('W');
    };

    private void display() {
        System.out.println(" _________________");
        for (int i = 0; i < chess.length; i++) {
            System.out.print(8 - i);
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j].piece == null) {

                    System.out.print("|" + " ");
                } else {

                    System.out.print("|" + chess[i][j].display());
                }
            }

            System.err.println("|");
            System.out.println(" _________________");

        }
        System.out.println("  A B C D E F G H ");
    }

    private void play() {
        System.out.println("Quel est le pion que vous voulez déplacer ?");
        int[] currentLocation = pickCase();

        int currentLine = currentLocation[0];
        int currentColumn = currentLocation[1];
        Piece selectPiece = chess[currentLine][currentColumn].piece;

        if (selectPiece != null) {
            int[][] ValidatedMove = selectPiece.move(chess, currentLine, currentColumn);
            System.out.println("Où mettre la pièce ?");
            int[] newLocation = pickCase();
            int newLine = newLocation[0];
            int newColumn = newLocation[1];

            boolean isValidMove = false;
            // System.err.println(isValidMove);
            for (int index = 0; index < ValidatedMove.length; index++) {
                if (ValidatedMove[index][0] == newLine && ValidatedMove[index][1] == newColumn) {
                    isValidMove = true;
                    break;
                }
            }
            if (isValidMove) {
                chess[newLine][newColumn].place(chess[currentLine][currentColumn]);
            } else {
                System.out.println("Déplacement pas possible pour cette pièce ou case inaccessible.");
                return;

            }
        } else {
            System.out.println("Veuillez sélectionner une case qui contient une pièce");
        }
    }

    public int[] pickCase() {

        String pieceLoc = Terminal.scan.nextLine();

        char columnLetters = pieceLoc.charAt(0);
        int line = 7 - ((pieceLoc.charAt(1) - '0') - 1);

        int column = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == columnLetters) {
                column = i;
            }
        }
        int[] response = { line, column };
        return response;
    }
}