import java.util.Scanner;

import java.util.Random;
class Insiders{
    private int a;
    
    public int getA() {
        return a;
    }

    // public void setA(int a) {
    //     this.a = a;
    // }

    Random rand=new Random();
    int cls=0;
    public int randomEx(String uarr[]){
        
        int random;
        do{
            random=rand.nextInt(0,9);
        }while(uarr[random]!="-");
        cls=random;
        return random;
    }

    public void printBoard(String arr[]){
        int i=0;
        for (String str:arr){
            if (i==3){
                System.out.println();
                i=0;
            }
            System.out.print(str+"\t");
            i++;
        }
    }

    public int equalTo(String arr[],int i,int j,int k){
        if((arr[i]==arr[j])&&(arr[j]==arr[k])&&(arr[i]=="X")){
            System.out.println("\nuser wins");
            a=1;
            return 1;
        }
        else if((arr[i]==arr[j])&&(arr[j]==arr[k])&&(arr[i]=="O")){
            System.out.println("\ncomputer wins");
            a=1;
            return 2;
        }
        return 0;
        
    }

    public void win(String arr[]){
        equalTo(arr,0,1,2);
        equalTo(arr,0,3,6);
        equalTo(arr,0,4,7);

        equalTo(arr,0,1,2);
        equalTo(arr,0,3,6);
        equalTo(arr,0,4,8);

        equalTo(arr,3,4,5);
        equalTo(arr,6,7,8);
        equalTo(arr,0,4,8);

        equalTo(arr,1,4,7);
        equalTo(arr,2,5,8);
        equalTo(arr,2,4,6);

    }


}





public class TicTacToe {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Insiders ins=new Insiders();

        System.out.println("TicTacToe setup -\n0.  1.  2.\n3.  4.  5.\n6.  7.  8.\n");
        System.out.println("(you are X computer is O)...Play against computer -");
        String arr[]={"-","-","-","-","-","-","-","-","-"};
        //String carr[]={"-","-","-","-","-","-","-","-","-",};
        //System.out.println(arr[0]);
        int n=0;
        int user;
        int computer;
        while(n==0){
            System.out.print("\nUser choice :");
            try{
                user = scan.nextInt();
                if (user>8 ||user<0)
                throw new Exception("Number out of range");
                else if(arr[user]!="-"){
                    throw new Exception("place alredy used");   
                } 
            }
            catch(Exception e){
                System.out.println(e+"Not allowed");
                continue;    
            }
            arr[user]="X";
            ins.printBoard(arr);
            ins.win(arr);

            if(ins.getA()==1){
                break;
            }

            System.out.print("\nComputer choice :");
            computer=ins.randomEx(arr);
            System.out.println(computer);
            arr[computer]="O";
            
            ins.printBoard(arr);
            ins.win(arr);

            if(ins.getA()==1){
                break;
            }

            }
    


    scan.close();
    }
}
