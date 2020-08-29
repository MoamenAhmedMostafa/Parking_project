package my_project;
/////////////////////////////////////////////////////////////////////////////// this class for parking1

import java.util.ArrayList;
class Parking{
char [][] arr=new char[100][4];
 ArrayList<Integer> space = new ArrayList<>();                                 //this array list save to impty spaces length
 ArrayList<Integer> P = new ArrayList<>();                                     //this array list save to impty spaces first index
  ////////////////////////////////////////////////////////////////////////////   this functin to put initial value in the parking
void intial (){
   for(int i=0;i<100;i++)
   {
    for(int c=0;c<4;c++)
    {
          if(c==0||c==3)
          { arr[i][c]='-';}
          else   
          arr[i][c]=' ';
        
     }
      
  }
}
////////////////////////////////////////////////////////////////////////////////
void find_spaces(int print_or_not)     //to print and get the empty spaces in the parking
 {
     int c=0;
     ArrayList<Integer> spaces = new ArrayList<>();           //this array list save to impty spaces length
     ArrayList<Integer> p_index= new ArrayList<>();          //this array list save to impty spaces first index 
    

    
   for(int i=0 ;i<100 ;i++)
   {
     if(arr[i][0]=='-')  
     {
       c++;
     }
   if((arr[i][0]!='-'&&c!=0 )||(i==99&&c!=0))
     {
       if(i==99)  
       {
          p_index.add(i-(c-1));
         spaces.add(c);
       }
       else
       {
          p_index.add(i-c);                           //p it is the index of the free space
          spaces.add(c);                             //spaces is the length of the space
       } 
       c=0;
     }
   }
     space=spaces;
     P= p_index;
    if(print_or_not!=0)
    {
     System.out.println( " you have empty spaces after   "+P+"   meters \n  the empty spaces length is "+space);
    }
 }

///////////////////////////////////////////////////////////////////////////////

int Search_for_parking(int l)     //l=car length             this function to return the index of the empty space for the defult choice
 {
     int c=0;
     int place=0;
   for(int i=0 ;i<100 ;i++)
   {
     if(arr[i][0]=='-')  
     {
       c++;
       if(c==l)
       {
           place=i;
           break;
       }
     }
     else{
     c=0;
     } 

   }
return place;                        //place is the index of the empty space
 }
int get_strategy(int choice ,int l)      //to get strategy from the user and search for the parking
{
   int print_or_not=0; 
   find_spaces(print_or_not);
   
   ArrayList <Integer> space_copy = new ArrayList<>();
   
   for(int r=0;r<space.size();r++)
   { 
       space_copy.add(space.get(r));
   } 

   int q=0;
  space_copy.sort(null);
  ///////////////////////////////////////////////////////////////////////  if choice == 1 put the car in the pest space
  if(choice==1)
  {
    
    int min=0;
    int g;
    for( g=0;g<space_copy.size();g++)
    {
     if(space_copy.get(g)>=l)
     {
       min=space_copy.get(g);
       break;
     }
    }
    for(int x=0;x<space.size();x++)
    {
       if(min==space.get(x))
       {
         set_car(P.get(x),l) ;
         return P.get(x);
       }
  
    }
     
  }
  /////////////////////////////////////////////////////////////////////// if choice == 2 put the car in the largest space
 if(choice==2)                        
 {

   int max=space_copy.get((space_copy.size())-1);  
   int i=0;
   for(;i<space_copy.size();i++)
   {
     if(max==space.get(i))
     {
       set_car(P.get(i),l) ;
       return P.get(i);
     }
   
   }
  }
 ////////////////////////////////////////////////////////////////////////  put the car in the first empty space 
   if(choice==3)
   {
     int p_index=(Search_for_parking(l)-(l-1));
     set_car(p_index,l) ;
     return p_index;
   }

 
 return q;
}

/////////////////////////////////////////////////////////////////////////////    to put the car in the parking
void set_car(int p,int l)      
{  
    for(int i=p;i<p+l;i++)
  {
     for(int c=0;c<4;c++)
     {
        arr[i][c]='x';
     }
  
  }
}

//////////////////////////////////////////////////////////////////////////////// to remove the car
void clear(int p,int l)
{  for(int i=p;i<p+l;i++)
   {
     for(int c=0;c<4;c++)
     {
        if(c==0||c==3)
        { arr[i][c]='-';}
        else   
        arr[i][c]=' ';    
     }
    }
      
}

//////////////////////////////////////////////////////////////////////////////   to show the parking status

void show_parking()
{
     System.out.printf("\f");
      System.out.print("<< this is your parking view>> \n");
       System.out.print("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////"
               + "//////////////////////////////////////////////////////////////////////////////////////// \n");
      for(int c=0;c<4;c++)
      //for(int i=0;i<100;i++)
    {
      for(int i=0;i<100;i++)  
      //for(int c=0;c<5;c++)
      {
        System.out.print(arr[i][c]+" ");
      }
      
      System.out.print("\n");
    }  
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"
               + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"
               + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \n");
}  

}
