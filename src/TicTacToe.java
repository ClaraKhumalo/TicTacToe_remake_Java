import java.util.*;

public class TicTacToe{
    public static String player1;
    public static ArrayList<String> player1Moves=new ArrayList<>();
    public static ArrayList<String> player2Moves=new ArrayList<>();
    public static String player2;
    public static boolean isContinuing=true;
    public static ArrayList<String> availablePositions=new ArrayList<>();


    public static void main(String[] Args) {
        addAvailablePositions();
        System.out.println("Postions="+availablePositions);
        System.out.println("Welcome!\nYou are playing a terminal based version of TIC TAC TOE.");
        // System.out.println("Please enter your name and password");
        gameLoop();
    }

    public static void gameLoop(){
        int chosenPartner=partnerPrompt();
            while (isContinuing) {
            String move1 = choosePosition();
            player1Moves.add(move1);
            playWithFriend1(move1);
            assessWinner();
            if (isContinuing==true) {
                if (chosenPartner == 1) {
                    String move2 = choosePosition();
                    player2Moves.add(move2);
                    playWithFriend2(move2);
                    assessWinner();
                } else if (chosenPartner == 2) {
                    String move2 = playWithBot();
                    player2Moves.add(move2);
                    assessWinner();
                }
            } else {
                partnerPrompt();
            }
        }
        playAgain();
    }

    public static ArrayList<String> addAvailablePositions(){
        availablePositions.add(0,"1");
        availablePositions.add(1,"2");
        availablePositions.add(2,"3");
        availablePositions.add(3,"4");
        availablePositions.add(4,"5");
        availablePositions.add(5,"6");
        availablePositions.add(6,"7");
        availablePositions.add(7,"8");
        availablePositions.add(8,"9");
        return availablePositions;
    }

    public static int partnerPrompt(){
        assignIcon();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select who you would like to play with a:\n1. Friend\nor\n2. Robot");
        int chosenPartner=scanner.nextInt();
        return chosenPartner;
    }

    public static void assignIcon(){
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
            assignIcon();
        }
    }

    public static void assessWinner(){
        System.out.println(player1Moves);
        if (player1Moves.contains("1")&&player1Moves.contains("2")&&player1Moves.contains("3")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("1")&&player1Moves.contains("4")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("1")&&player1Moves.contains("5")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("2")&&player1Moves.contains("5")&&player1Moves.contains("8")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("3")&&player1Moves.contains("6")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("3")&&player1Moves.contains("5")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player1Moves.contains("7")&&player1Moves.contains("8")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
            isContinuing=false;
        }else if (player2Moves.contains("1")&&player2Moves.contains("2")&&player2Moves.contains("3")){
            System.out.println(String.format("%s is the winner",player1));isContinuing=true;
        }else if (player2Moves.contains("1")&&player2Moves.contains("4")&&player2Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (player2Moves.contains("1")&&player2Moves.contains("5")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (player2Moves.contains("2")&&player2Moves.contains("5")&&player2Moves.contains("8")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (player2Moves.contains("3")&&player2Moves.contains("6")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (player1Moves.contains("3")&&player1Moves.contains("5")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (player2Moves.contains("7")&&player2Moves.contains("8")&&player2Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player2));
            isContinuing=false;
        }else if (availablePositions.isEmpty()){
            System.out.println("Tie!");
            isContinuing=false;
        }

    }


    /*
    * This method will ask the user if they want to play again
    * */
    public static boolean playAgain(){
        System.out.println("Thank you for playing.\nSee you again soon!");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Would you like to play again?\nEnter either Yes/y or No/n");
        String continueGame=scanner.nextLine();
        if (continueGame.equalsIgnoreCase("Y")||continueGame.equalsIgnoreCase("Yes")){
            isContinuing=true;
            player1Moves.clear();
            player2Moves.clear();
            player1="";
            player2="";
            availablePositions.clear();
            addAvailablePositions();
            gameLoop();
        }else if (continueGame.equalsIgnoreCase("N")||continueGame.equalsIgnoreCase("No")){
            isContinuing=false;
        }else{
            System.out.println("Incorrect Input Try Again");
        }
        return isContinuing;
    }

    public static String choosePosition(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose an available number from the list below:");
        System.out.println(availablePositions);
        String move=scanner.nextLine();
        return move;
    }

    public static void playWithFriend1(String move){
        if (availablePositions.contains(move)&&!availablePositions.isEmpty()){
            System.out.println(String.format("%s: %s",player1,move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input");
            choosePosition();
        }
    }
    public static void playWithFriend2(String move){
        if (availablePositions.contains(move)){
            System.out.println(String.format("%s: %s",player2,move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input");
            choosePosition();
        }
    }

    public static String playWithBot(){
        Random randomMove=new Random();
        String botMove=availablePositions.get(randomMove.nextInt(availablePositions.size()));
        System.out.println(String.format("%s: %s",player2,botMove));
        availablePositions.remove(botMove);
        System.out.println(botMove);
        return botMove;
    }

}