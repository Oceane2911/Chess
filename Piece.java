public abstract class Piece {
    private char name;
    private Team team;

    Piece(char name, Team team) {
        this.name = name;
        this.team = team;
    }


    public Team getTeam(){
        return team;
    } 
    String display() {
        return (team == Team.WHITE? Terminal.ANSI_PURPLE : Terminal.ANSI_BLUE) + name + Terminal.ANSI_RESET;
    }
    public abstract int[][] move(Case[][] chess, int row, int column);
}