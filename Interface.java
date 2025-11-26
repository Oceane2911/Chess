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
        chess[0][0].piece = new Rook('R');
        System.out.println(chess[0][0].piece);
    };

    private void display() {
        System.out.println("  A B C D E F G H ");
        System.out.println(" _________________");
        for (int i = 0; i < chess.length; i++) {
            System.out.print(i+1);
            for (int j = 0; j < chess[i].length; j++) {
                System.out.print("|" + chess[i][j].display());
            }

            System.err.println("|");
            System.out.println(" _________________");

        }
    }
}