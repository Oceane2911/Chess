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
    
    public boolean place(Case oldCase){
        if (oldCase.piece==null) {
            return false;
        }

        if(!oldCase.piece.checkMove(oldCase,this)){
            return false;
        }
        piece=oldCase.piece;
        oldCase.piece=null;
        return true;
    }
}
