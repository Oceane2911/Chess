public class Interface {
    private Case[][] chess = {
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },
            { new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case(), new Case() },

    };
    public Interface(){
        init();
        display();
    }
    private void init(){
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
        
        chess[6][0].piece = new Rook('W');
        chess[6][1].piece = new Knight('W');
        chess[6][2].piece = new Bishop('W');
        chess[6][3].piece = new Queen('W');
        chess[6][4].piece = new King('W');
        chess[6][5].piece = new Bishop('W');
        chess[6][6].piece = new Knight('W');
        chess[6][7].piece = new Rook('W');
        chess[7][0].piece = new Pawn('W');
        chess[7][1].piece = new Pawn('W');
        chess[7][2].piece = new Pawn('W');
        chess[7][3].piece = new Pawn('W');
        chess[7][4].piece = new Pawn('W');
        chess[7][5].piece = new Pawn('W');
        chess[7][6].piece = new Pawn('W');
        chess[7][7].piece = new Pawn('W');
    };

    private void display() {
        System.out.println(" _________________");
        for (int i = 0; i < chess.length; i++) {
            System.out.print(8-i);
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j].piece == null) {
                    
                    System.out.print("|" + " ");
                }else{

                    System.out.print("|" + chess[i][j].display());
                }
            }
            
            System.err.println("|");
            System.out.println(" _________________");
            
        }
        System.out.println("  A B C D E F G H ");
    }
}