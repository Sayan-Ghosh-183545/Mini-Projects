#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

struct player{
    char name[100];
    int attmpt;
};

int main(){
    int i,comp,n,guess,flag;
    char name[100];
    printf("enter no of players who's gonna play :");
    scanf("%d",&n);
    struct player a[n+3];

    for(i=0;i<n;i++){
        
        printf("Enter player name :",i);
        scanf("%s",&name);
        strcpy(a[i].name,name);
        int comp;
        srand(time(0));
        comp=rand()%100 +1;
        int attmpt =1;

            do{
                printf("Enter your guess :");
                scanf("%d",&guess);
                if(guess>comp){
                    printf("Thora niche socho bhaii..\n");
                }
                else if(guess<comp){
                    printf("Thora ucha socho bhaii..\n");
                }
                else if(guess=comp){
                    printf("U got it %s!!Thats the number....U found it after %d attempts\n",a[i].name,attmpt);
                    a[i].attmpt=attmpt;
                    break;
                }
                attmpt++;
            }while(guess!=comp);
    }
    
    a[n].attmpt=a[0].attmpt;
    for(i=0;i<n;i++){
        if(a[n].attmpt>a[i].attmpt){
            a[n].attmpt=a[i].attmpt;
            strcpy(a[n].name,a[i].name);
            flag=0;
        }
        else if(a[n].attmpt==a[i].attmpt){
            strcpy(a[n+1].name,a[i].name);
            flag=1;
        }
        else if(a[n].attmpt<a[i].attmpt){
            flag=0;}
    }

    if(flag==1){
        printf("There is a draw with %d attempts....Play again for a result..",a[n].attmpt);
    }
    else{
        printf("Congoo %s!!....You won with %d attempts",a[n].name,a[n].attmpt);
    }
    return 0;
}