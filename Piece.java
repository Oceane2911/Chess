public abstract class Piece {
    char name;

    public Piece(char name, String couleur) {
        this.name = name;
        System.out.println("dans piece :" + this.name);
    }
    public char getName(){
        return name;
    }
    public abstract void move();
}