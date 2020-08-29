
package my_project;
import java.util.*;
import javax.swing.*;




//*****************************************************************************

public class My_project {

 ////////////////////////////////////////////////////////////////////////////
public static int calc(String s,int h){

         if(s.equals("Truck"))return 15*h;
          if(s.equals("Bus"))return 15*h;
          if(s.equals("Car"))return 10*h;
          if(s.equals("motorcyclye"))return 5*h;
          return 0;
}
 static void show_cars( Car [] car)     // to print how many car in the parking and all cars lengths and IDs
{
  int c=0;
   for(int i=0;i<100;i++)
   {
     if(car[i].ID!=0)
     {
       c++;  
     }
   }
  System.out.println("you have (" + c + ")car");
  c=0;
  
   for(int i=0;i<100;i++)
   {
     if(car[i].ID!=0)
     {
       c++; 
        System.out.println("***************************************************************************************");
       System.out.print("car number***["+c+"]*** ID is ***{"+car[i].ID+"}*** and its lenth***{"+car[i].length+"}*** meters \n");
      
     }
   }
   System.out.println("*****************************************************************"
           + "**************************************************************************************\n\n");
 }   
   ////////////////////////////////////////////////////////////////////////// 
    
static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
             
   int choice1;
   int choice2;
Car []c=new Car[100];                                             //create array of car opject
Parking b=new Parking();                                          // creat an opject of the parking
b.intial();

///////////////////////////////////////////////////////////////////////////////
for(int i=0;i<100;i++)                                           
{
c[i]=new Car();
}
int idx=0;
int i=1;
 int a=0;
 int length=0;
 String s;
//*****************************************************************************
do{
    System.out.println(  " enter which you want \n"
             + "if you want to add a new car press 1 \n"
             + "if a car want to leave press 2\n"
             + "if you want to show the parking status press 3 \n"
             + "if you want to exit  press 0 \n");
             String x=in.next();
             choice1=Integer.parseInt(x);
 //////////////////////////////////////////////////////////////////////////////

    switch (choice1)
     {

       case 1:
       boolean h=false;
 /////////////////////////////////////////////////////////////////////////////// 
       do{
           h=true;
           System.out.println( "enter car ID "); 
           s=in.next();
           System.out.println( "enter car type"); 
           String y=in.next();
           
          if(y.equals("Truck"))length=7;
          if(y.equals("Bus"))
              length=10;
          if(y.equals("Car"))length=5;
          if(y.equals("motorcyclye"))length=2;
           int ID=Integer.parseInt(s);
           for(int n=0;n<100;n++)
           {
             if(ID==c[n].ID)
             {  
               System.out.println("there is a car with the same ID ");
                 System.out.println( "enter car ID "); 
                 s=in.next();
                 ID=Integer.parseInt(s);
                n=0;
             }
               
           }
           
            for(int count=0;count<100;count++)
            {
             if(c[count].ID==0&&length!=0)
             {
               c[count].ID=ID;
               c[count].type=y;
               c[count].length=length;
                idx=count;
               break;
             }
            }
           if(length==0)h=false;
        }while(h==false);

             int place;
             place=b.Search_for_parking(length);
             if(place==0)
             {
               System.out.println("there is no space for this car");
             }
        
             else
             {
                 int count=0;
        ///////////////////////////////////////////////////////////////////////////////////////////       
            do{   
               System.out.println("<< choose your strategy >> \n"
                       + "to set the car in the best space enter 1 \n"
                       + "to set the car in the largest space enter 2 \n"
                       + "to set the car in the in the first empty space enter 3 \n");
               s=in.next();
                choice2=Integer.parseInt(s);
            }while((choice2!=1)&&(choice2!=2)&&(choice2!=3));
         ////////////////////////////////////////////////////////////////////////////////////   
                c[idx].car_plac = b. get_strategy(choice2, c[idx].length);
                 i++;
                 
             }
              a=i; 
         break;      
    ///////////////////////////////////////////////////////////////////////
       case 2:
            boolean z=true;
            
   if (a!=0)
   {  
        do{
            
          System.out.println("enter car ID ");
           s=in.next();
              System.out.println("enter the duration");
           int hours=in.nextInt();
           int ID=Integer.parseInt(s);
           for(int t=0 ;t<i;t++)
           {
             if(ID==c[t].ID)
             {
                 System.out.println("the cost = " +calc(c[t].type,hours));
               b.clear(c[t].car_plac, c[t].length);
               z=false;
               c[t].ID=0;
               c[t].length=0;
               --a;
              break;
             }
             if(t==i-1&&z==true)
             {
              System.out.println( "this is not ID  try again");
             }

            }
        }while(z==true);
   }
      break;
  
       case 3:
	b.show_parking();
        int print_or_not=1;
        show_cars(c);
        b.find_spaces(print_or_not);
       
       break;
	
       default:
	
       break;
     }  
        
  }while(choice1!=0 );   

 }   
}
  