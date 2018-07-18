package pratap.tictactoe;



import java.util.Scanner;

public class Game {
    private String player1, player2;
    private String winner;


    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getWinner() {

        return winner;
    }


    String pos[][] = new String[3][3];
    int s = 0;

    public void board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos[i][j] = " ";
            }
        }
        System.out.println("     _0,0_|_0,1_|_0,2_");
        System.out.println("     _1,0_|_1,1_|_1,2_");
        System.out.println("      2,0 | 2,1 | 2,2");
    }


public  boolean flag=true;
    void gameStart(int i, int j,String input)   {


        Scanner scanner=new Scanner(System.in);
        boolean k=true;int count=0;
        while(k) {
            if (pos[i][j] != " ") {
                System.out.println("Error " + ": The position [" + i + "," + j + "] contains => " + pos[i][j] + " Restart the game");
                i = scanner.nextInt();
                j = scanner.nextInt();

            } else k = false;
        }

        try {
            pos[i][j] = input;
        }catch (Exception e) {
            System.out.println("Invalid location :"+e);
        }

        System.out.println();
        System.out.println("     _" + pos[0][0] + "_|_" + pos[0][1] + "_|_" + pos[0][2] + "_");
        System.out.println("     _" + pos[1][0] + "_|_" + pos[1][1] + "_|_" + pos[1][2] + "_");
        System.out.println("      " + pos[2][0] + " | " + pos[2][1] + " | " + pos[2][2] + "");


    }






    public  boolean cheakStatus() {
        int i,j=0,count=0;

        for(int l=0;l<3;l++)
            for(int p=0;p<3;p++){
                if(pos[l][p]=="0"||pos[l][p]=="x"){
                    count++;
                }
            }
        if(count==9) {
            winner="NO Winner DRAW";
            flag =false;
            return flag;
        }
        for (i = 0; i < 3; i++) {

            if (pos[i][0] == pos[i][1] && pos[i][0] == pos[i][2] && pos[i][0] != " " && pos[i][1] != " " && pos[i][2] != " ") {
                if (pos[i][0] == "0") {
                    winner = player2;
                } else if (pos[i][0] == "x"){
                    winner = player1;
                }

                return flag;
            }
        }

        for (i = 0; i < 3; i++) {
            if (pos[0][i] == pos[1][i] && pos[0][i] == pos[2][i]&&pos[0][i]!=" "&&pos[1][i]!=" "&&pos[2][i]!=" ") {
                if(pos[0][i]=="0") {
                    winner = player2;
                }
                else if(pos[0][i]=="x"){
                    winner = player1;
                }

                return flag;
            }
        }
        if(pos[0][0]==pos[1][1]&&pos[0][0]==pos[2][2]&&pos[0][0]!=" "&&pos[1][1]!=" "&&pos[2][2]!=" ") {
            if(pos[0][0]=="0") {
                winner = player2;
            }
            else if(pos[2][0]=="x"){
                winner = player1;
            }

            return flag;
        }
        if(pos[2][0]==pos[1][1]&&pos[2][0]==pos[0][2]&&pos[0][2]!=" "&&pos[1][1]!=" "&&pos[2][0]!=" ") {
            if(pos[2][0]=="0") {
                winner = player2;
            }
            else if(pos[2][0]=="x"){
                winner = player1;
            }

            return flag;
        }

        return false;
    }
}