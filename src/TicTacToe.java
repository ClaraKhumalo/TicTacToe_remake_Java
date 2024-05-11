import java.util.*;

public class TicTacToe{
    public static String player1;
    public static String player2;
    public static String currentPlayer;
    public static boolean isContinuing=true;
    public static String move=" ";
    public static String move1="1";
    public static String move2="2";
    public static String move3="3";
    public static String move4="4";
    public static String move5="5";
    public static String move6="6";
    public static String move7="7";
    public static String move8="8";
    public static String move9="9";
    public static ArrayList<String> player1Moves=new ArrayList<>();
    public static ArrayList<String> player2Moves=new ArrayList<>();
    public static ArrayList<String> availablePositions=new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));


    public static void main(String[] Args) {
        System.out.println("Postions="+availablePositions.toString());
        System.out.println("Welcome!\nYou are playing a terminal based version of TIC TAC TOE.");
        gameLoop();
    }

    /**
     * Contains a while loop to control the game.
     */
    public static void gameLoop(){
        int chosenPartner=partnerPrompt();
        displayBoard(move);
        while (isContinuing) {
            String move1 = choosePosition();
            player1Moves.add(move1);
            playWithFriend1(move1);
            currentPlayer=player1;
            displayBoard(move1);
            assessWinner();
            if (isContinuing) {
                if (chosenPartner == 1) {
                    String move2 = choosePosition();
                    player2Moves.add(move2);
                    playWithFriend2(move2);
                    currentPlayer=player2;
                    displayBoard(move2);
                    assessWinner();
                } else if (chosenPartner == 2) {
                    String move2 = playWithBot();
                    player2Moves.add(move2);
                    currentPlayer=player2;
                    displayBoard(move2);
                    assessWinner();
                }else {
                    partnerPrompt();
                }
            }
        }
        playAgain();
    }


    /**
     * Convert a move number to the symbol of the player that has selected it then displays the board.
     * @param move: the position that a player selects.
     */
    public static void displayBoard(String move){
        System.out.println("\nGame Board");
        if(move.equals("1")){
            move1=currentPlayer;
        }else if(move.equals("2")){
            move2=currentPlayer;
        }else if(move.equals("3")){
            move3=currentPlayer;
        }else if(move.equals("4")){
            move4=currentPlayer;
        }else if(move.equals("5")){
            move5=currentPlayer;
        }else if(move.equals("6")){
            move6=currentPlayer;
        }else if(move.equals("7")){
            move7=currentPlayer;
        }else if(move.equals("8")){
            move8=currentPlayer;
        }else if(move.equals("9")){
            move9=currentPlayer;
        }
        System.out.println(String.format ("  %s  |  %s  |  %s  \n_____|_____|_____\n  %s  |  %s  |  %s  \n_____|_____|_____\n  %s  |  %s  |  %s  \n",move1,move2,move3,move4,move5,move6,move7,move8,move9));
    }


    /**
     * Prompts the user to enter their choice of partner.
     * @return chosenPartner: stores the users choice.
     */
    public static int partnerPrompt(){
        assignTokens();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select who you would like to play with:\n1. Friend\nor\n2. Robot");
        int chosenPartner=scanner.nextInt();
        return chosenPartner;
    }


    /**
     * Prompts the user to select their game tokens (either x or o).
     */
    public static void assignTokens(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Would you like to be X or O:");
        String player1Input=scanner.nextLine();
        player1 =player1Input;
        if (player1.equalsIgnoreCase("X")) {
            player2 = "O";
        }else if (player1.equalsIgnoreCase("O")) {
            player2 = "X";
        }else {
            System.out.println("Incorrect Input.\nChoose one of the specified options.");
            assignTokens();
        }
    }


    /**
     * Assesses who the winner is based on the player that has three consecutive spaces in a diagonals, columns and rows.
     */
    public static void assessWinner(){
        if (player1Moves.contains("1")&&player1Moves.contains("2")&&player1Moves.contains("3")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("4")&&player1Moves.contains("5")&&player1Moves.contains("6")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("7")&&player1Moves.contains("8")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("1")&&player1Moves.contains("4")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("2")&&player1Moves.contains("5")&&player1Moves.contains("8")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("3")&&player1Moves.contains("6")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("1")&&player1Moves.contains("5")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player1Moves.contains("3")&&player1Moves.contains("5")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player2Moves.contains("1")&&player2Moves.contains("2")&&player2Moves.contains("3")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player2Moves.contains("4")&&player2Moves.contains("5")&&player2Moves.contains("6")){
            System.out.println(String.format("%s is the winner.",player1));
            isContinuing=false;
        }else if (player2Moves.contains("7")&&player2Moves.contains("8")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (player2Moves.contains("1")&&player2Moves.contains("4")&&player2Moves.contains("7")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (player2Moves.contains("2")&&player2Moves.contains("5")&&player2Moves.contains("8")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (player2Moves.contains("3")&&player2Moves.contains("6")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (player2Moves.contains("1")&&player2Moves.contains("5")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (player2Moves.contains("3")&&player2Moves.contains("5")&&player2Moves.contains("7")){
            System.out.println(String.format("%s is the winner.",player2));
            isContinuing=false;
        }else if (availablePositions.isEmpty()){
            System.out.println("Tie!");
            isContinuing=false;
        }
    }


    /**
     * Prompts the user to play again or end the game when there is a winner or all the spaces have been filled.
     * @return isContinuing: a boolean to control the game loop.
     */
    public static boolean playAgain(){
        System.out.println("Thank you for playing.");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Would you like to play again?\nEnter either Yes/Y or No/N:");
        String continueGame=scanner.nextLine();
        if (continueGame.equalsIgnoreCase("Y")||continueGame.equalsIgnoreCase("Yes")){
            resetGlobalVariables();
            gameLoop();
        }else if (continueGame.equalsIgnoreCase("N")||continueGame.equalsIgnoreCase("No")){
            System.out.println("Sad to see you leave.\nCome again soon!");
        }else{
            System.out.println("Incorrect Input Try Again");
            playAgain();
        }
        return isContinuing;
    }


    /**
     * Prompts the player to choose their position/move.
     * @return move: the position that a player selects.
     */
    public static String choosePosition(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter an available number above to select a position:");
        String move=scanner.nextLine();
        return move;
    }


    /**
     * Displays the move of the first player and handles human error.
     */
    public static void playWithFriend1(String move){
        if (availablePositions.contains(move)){
            System.out.println(String.format("%s: %s",player1,move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input.\nTry again!");
            choosePosition();
        }
    }


    /**
     * Displays the move of the second player and handles human error.
     */
    public static void playWithFriend2(String move){
        if (availablePositions.contains(move)){
            System.out.println(String.format("%s: %s",player2,move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input");
            choosePosition();
        }
    }


    /**
     * Displays the move of the robot (random selection).
     * @return botMove: random choice generated using the Java Random class.
     */
    public static String playWithBot(){
        Random randomMove=new Random();
        String botMove=availablePositions.get(randomMove.nextInt(availablePositions.size()));
        System.out.println(String.format("%s: %s",player2,botMove));
        availablePositions.remove(botMove);
        return botMove;
    }

    /**
     * Sets the global variables back to their initial state at the end of the game.
     */
    public static void resetGlobalVariables(){
        player1=" ";
        player2=" ";
        currentPlayer=" ";
        isContinuing=true;
        move1="1";
        move2="2";
        move3="3";
        move4="4";
        move5="5";
        move6="6";
        move7="7";
        move8="8";
        move9="9";
        player1Moves.clear();
        player2Moves.clear();
        availablePositions.clear();
        availablePositions=new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    }

}
