import java.util.Random;
import java.util.Scanner;
public class RockPaperScissor{
public static void main(String args[]){
    System.out.print("No.of scores game u want to play :");
    Scanner scan=new Scanner(System.in);
    Random rand=new Random();
    int max_score=scan.nextInt();

    System.out.println("1.Rock\n2.Paper\n3.Scissor");
    int u_s=0;
    int c_s=0;
    String arr[]={"Rock","Paper","Scissor"};
    for(int i=0;i<max_score;i++){
        System.out.print("Round-"+(i+1) + "\nChoose your attack :");
        // try{
            int user=scan.nextInt();
        //     if(user<0 || user>3){
        //         throw new Exception("give the value again within 1-3");
        //     }
        // }
        // catch(Exception e){
        //     int user=scan.nextInt();
        // }
        int computer=rand.nextInt(1,4);

        if((user==1 && computer==3) ||  (user==2 && computer==1) || (user==3 && computer==2)){
            System.out.println("User choose "+arr[user-1]+" Computer choose "+arr[computer-1]+"\n\t USER WINS ROUND-" +(i+1)+ "\n SCORE - > \tUSER:" + (++u_s) + "\t\tCOMPUTER:" + (c_s));
        }

        else if((user==3 && computer==1) ||  (user==1 && computer==2) || (user==2 && computer==3)){
            System.out.println("User choose "+arr[user-1]+" Computer choose "+arr[computer-1]+"\n\t COMPUTER WINS ROUND-" +(i+1)+ "\n SCORE - > \tUSER:" + (u_s) + "\t\tCOMPUTER:" + (++c_s));
        }

        else{
            System.out.println("User choose "+arr[user-1]+" Computer choose "+arr[computer-1]+"\n\t DRAW ON ROUND-" +(i+1)+ "\n SCORE - > \tUSER:" + (u_s) + "\t\tCOMPUTER:" + (c_s));
        }
    }
    scan.close();

    if (u_s>c_s){
        System.out.println("USER WINS !!!");
    }
    else if(c_s>u_s){
        System.out.println("COMPUTER WINS!!!");
    }
    else{
        System.out.println("MATCH DRAW");
    }
}
}