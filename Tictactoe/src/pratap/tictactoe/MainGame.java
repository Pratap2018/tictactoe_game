package pratap.tictactoe;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MainGame {

        public static  void  main(String [] args){
            int x[]=new int [50];
            Scanner sc=new Scanner(System.in);
            String player1,player2;
            System.out.println("Enter the name of Player 1:");
            player1=sc.nextLine();
            System.out.println("Enter the name of Player 2:");
            player2=sc.nextLine();

            Game g=new Game(player1,player2);
            System.out.print("Loading\n");

            for(int i: x){
                x[i]=i++;
                System.out.print("__");

                try {
                    sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println();

            g.board();

            int i,j;
            System.out.print(g.getPlayer1()+" :");
            i=sc.nextInt();
            j=sc.nextInt();
            g.gameStart(i,j,"x");
            boolean status=false;
            while(status==false ){
                if(g.flag==false)
                    break;

                System.out.print(g.getPlayer2()+" :");
                i=sc.nextInt();
                j=sc.nextInt();
                g.gameStart(i,j,"0");
                   if(g.flag==false)
                       break;

                status=g.cheakStatus();
                if (status==true)
                    break;
                System.out.print(g.getPlayer1()+" :");
                i=sc.nextInt();
                j=sc.nextInt();
                g.gameStart(i,j,"x");
                status=g.cheakStatus();
                if(g.flag==false)
                    break;

                if (status==true)
                    break;

            }
            System.out.println("Winner :"+g.getWinner());
        }

    }


