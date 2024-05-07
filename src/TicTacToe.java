import java.util.*;

public class TicTacToe{
    public static String player1;
    public static ArrayList<String> player1Moves=new ArrayList<>();
    public static ArrayList<String> player2Moves=new ArrayList<>();
    public static String player2;
    public static boolean isContinuing=true;
    public static ArrayList<String> availablePositions=new ArrayList<>();


//    public static int[] availablePositions= {1, 2, 3, 4, 5, 6, 7, 8, 9};

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
//            if (!availablePositions.isEmpty()) {
            if (chosenPartner == 1) {
                String move1 = choosePosition();
                player1Moves.add(move1);
                playWithFriend1(move1);
                assessWinner();
                if (isContinuing==false) {
                    String move2 = choosePosition();
                    player2Moves.add(move2);
                    playWithFriend2(move2);
                    assessWinner();
                }
            } else if (chosenPartner == 2) {
                playWithBot();
            } else {
                partnerPrompt();
            }
//            } else {
//                System.out.println("Thank you for playing.\nSee you again soon!");
//            }
        }
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
        if (player1Moves.contains("1")&&player1Moves.contains("2")&&player1Moves.contains("3")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("1")&&player1Moves.contains("4")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("1")&&player1Moves.contains("5")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("2")&&player1Moves.contains("5")&&player1Moves.contains("8")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("3")&&player1Moves.contains("6")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("3")&&player1Moves.contains("5")&&player1Moves.contains("7")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (player1Moves.contains("7")&&player1Moves.contains("8")&&player1Moves.contains("9")){
            System.out.println(String.format("%s is the winner",player1));
        }else if (availablePositions.isEmpty()){
            System.out.println("Tie!");
        }
        playAgain();
    }


    /*
    * This method will ask the user if they want to play again
    * */
    public static boolean playAgain(){
        System.out.println("Thank you for playing.\nSee you again soon!");
        Scanner scanner=new Scanner(System.in);
        String continueGame=scanner.nextLine();
        if (continueGame.equalsIgnoreCase("Y")||continueGame.equalsIgnoreCase("Yes")){
            isContinuing=true;
            player1Moves.clear();
            player2Moves.clear();
            player1="";
            player2="";
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
//            if (move>=1){
//                move=move-1;
//            }
//            java.lang.String finalMove = move;
//            availablePositions.removeIf(position->position.equals(finalMove));
//            availablePositions.removeAll(List.of(move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input");
            choosePosition();
        }
        // return;
    }
    public static void playWithFriend2(String move){
        if (availablePositions.contains(move)){
            System.out.println(String.format("%s: %s",player2,move));
//            if (move>=1){
//                move=move-1;
//            }
//            availablePositions.removeAll(List.of(move));
            availablePositions.remove(move);
        } else{
            System.out.println("Incorrect Input");
            choosePosition();
        }
        // return;
    }

    public static void playWithBot(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose an available number from the list below:");
        int move=scanner.nextInt();
    }

}