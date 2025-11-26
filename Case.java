public class Case {

    public Piece piece = null;

    public String display() {
        if (piece == null){
                return  " ";
        }
        else{
            return piece.display();
        }

    }
}
