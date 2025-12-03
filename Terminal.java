import java.util.Scanner;

class Terminal {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static Scanner scan = new Scanner(System.in);

  private static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

  public static int[] pickCase() {

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