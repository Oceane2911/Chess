public abstract class Piece {
    private char name;
    protected char team;

    Piece(char name, char team) {
        this.name = name;
        this.team = team;
    }

    String display() {
        return (team == 'W' ? Terminal.ANSI_PURPLE : Terminal.ANSI_BLUE) + name + Terminal.ANSI_RESET;
    }

    public abstract int[][] move(Case[][] chess, int row, int column);
}