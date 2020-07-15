/*
Michael Puou 
 
This is a small program written to simulate a battle for me while I was DMing for a Dungeons and Dragons session. 
First you will input the total number of each troop type for the Dm's army, then it will ask if there is a general or a captain present, a general is valued higher than a captian. 
Once the DM's army is done you will do the same for the players army. The different troop types have various values for example a footman has a value of 3 
while a healer has a value of 6. Once both armies are finished it will ask if you want to add any negative or positive modifiers, this section is still being worked on
so that the DM can add any positive rest modifers any or negative modifers. 
Once all values have been inputted the program will then calculate the total value of each army and then display the winner/loser while also 
calculating the total losses of each army.
*/
inputted 
import java.util.Scanner;
import java.util.Random;

public class DnD{
public static void main(String args[]){3   
   Scanner kb = new Scanner(System.in);
   
   int TheirArmy = 0;   //Stats for Their army 
   int TheirMages=0;    
   int TheirArchers=0;
   int TheirFootmen=0;
   int TheirHealers=0;
   
   int MyArmy = 0;      //Stats for DM army
   int MyMages=0;
   int MyArchers=0;
   int MyFootmen=0;
   int MyHealers=0;
   
   int General=0;       //Empty variable for the value of the general
   int GeneralPresent=0;//Boolean variable for if the general is present
   int ArmyDifference=0;//Empty variable for the calculated army difference 
   String a = "yes";
   
   if(a == "yes"){
         //This section calcualtes the DM's armys total points
         System.out.println("Enter troops for DM army.\n");
         System.out.println("Enter amount of Mages.");
         MyMages = kb.nextInt();
         System.out.println("Enter amount of Archers.");
         MyArchers = kb.nextInt();
         System.out.println("Enter amount of Footmen.");
         MyFootmen = kb.nextInt();
         System.out.println("Enter amount of Healers.");
         MyHealers = kb.nextInt();
         System.out.println("Is there a General or a Captain? \n1) General\n2) Captain");
         GeneralPresent = kb.nextInt();
         
         if(GeneralPresent == 1){
            General = 150; //Value for if there is a general
         }
         else{
            General = 70;  //Value for if there is a captain
         }
         
         MyArmy=General+MyMages*10+MyArchers*3+MyFootmen*3+MyHealers*6;
         
         //This section cacluates Their army's total points 
         System.out.println("Enter troops for Their army.\n");
         System.out.println("Enter amount of Mages.");
         TheirMages = kb.nextInt();
         System.out.println("Enter amount of Archers.");
         TheirArchers = kb.nextInt();
         System.out.println("Enter amount of Footmen.");
         TheirFootmen = kb.nextInt();
         System.out.println("Enter amount of Healers.");
         TheirHealers = kb.nextInt();
         System.out.println("Is there a General or a Captain? \n1) General\n2) Captain");
         GeneralPresent = kb.nextInt();
         
         if(GeneralPresent == 1){
            General = 150;  //Value for if there is a general
         }
         else{
            General = 70;   //Value for if there is a captain
         }
         
         TheirArmy=General+TheirMages*10+TheirArchers*3+TheirFootmen*3+TheirHealers*6;
         
         //This Section calculates if there are any modifers added to the army totals
         System.out.println("Would you like to add any modifiers?"); 
         String Answer = kb.next();
         if(Answer == "yes"){
            System.out.println("Other negative modifiers for DM army.");
            int Change = kb.nextInt();
            MyArmy = MyArmy - Change;
               
            System.out.println("Other positive modifiers for DM army.");
            int Change2 = kb.nextInt();
            MyArmy = MyArmy + Change2;
            
            System.out.println("Other negative modifiers for Their army.");
            int Change3 = kb.nextInt();
            TheirArmy = TheirArmy - Change3;
               
            System.out.println("Other positive modifiers for Their army.");
            int Change4 = kb.nextInt();
            TheirArmy = TheirArmy + Change4;
         }
         
         //This section calcuates the difference in points of the armies 
         if(MyArmy>TheirArmy){
            ArmyDifference = MyArmy-TheirArmy;
         }
         else{
            ArmyDifference = TheirArmy-MyArmy;
         }
         
         //If the difference between the armies is less than 250 then it will throw 
         // a random percentage and give an army an advanage 
         if (ArmyDifference < 250){
            Random rand5 = new Random();
            int Result5 = rand5.nextInt(100) + 0;
            double DiffPercent = Result5 / 100.0;
            System.out.println(DiffPercent);
            if(DiffPercent < .50){
               MyArmy = MyArmy + 1000;
            }
            else{
               TheirArmy = TheirArmy + 1000;
            }
         }
         
         //This section will cacluate the losses for their team if they lost 
         if(MyArmy>TheirArmy){
            System.out.println("They Lost");
            
            Random rand = new Random();
            int Result = rand.nextInt(20) + 70;//The losses will be higher due to Them losing
            double NumLost = Result / 100.0;
            
            double TheirMages2=TheirMages;
            double TheirArchers2=TheirArchers;
            double TheirFootmen2=TheirFootmen;
            double TheirHealers2=TheirFootmen;
            
            TheirMages2=TheirMages*NumLost;    //Here each respective variable is multiplied by the percentage loss
            TheirArchers2=TheirArchers*NumLost;
            TheirFootmen2=TheirFootmen*NumLost;
            TheirHealers2=TheirHealers*NumLost;
            
            System.out.println(TheirArmy);
            System.out.println("Their Remaining Mages: " + TheirMages2);
            System.out.println("Their Remaining Archers: " + TheirArchers2);
            System.out.println("Their Remaining Footmen: " + TheirFootmen2);
            System.out.println("Their Remaining Healers: " + TheirHealers2 + "\n");
            
            //This section will calcuate the losses for the DM army
            Random rand2 = new Random();
            int Result2 = rand2.nextInt(6) + 95; //The losses will be less due to the DM winning 
            double NumLost2 = Result2 / 100.0;
            
            double MyMages2=MyMages;
            double MyArchers2=MyArchers;
            double MyFootmen2=TheirFootmen;
            double MyHealers2=TheirFootmen;
            
            MyMages2=MyMages*NumLost2;    //Here each respective variable is multiplied by the percentage loss
            MyArchers2=MyArchers*NumLost2;
            MyFootmen2=MyFootmen*NumLost2;
            MyHealers2=MyHealers*NumLost2;
            
            System.out.println(MyArmy);   //Displaying My remaining troop totals 
            System.out.println("My Remaining Mages: " + MyMages2);
            System.out.println("My Remaining Archers: " + MyArchers2);
            System.out.println("My Remaining Footmen: " + MyFootmen2);
            System.out.println("My Remaining Healers: " + MyHealers2);
         }
         
         //This section will calculate the losses if the DM lost 
         else{
            System.out.println("I Lost");
            
            Random rand3 = new Random();
            int Result3 = rand3.nextInt(20) + 60;//The percentage will be higher for the losing DM (60 whereas its 70 for them)
            double NumLost3 = Result3 / 100.0;
            
            double MyMages3=MyMages;       //Creating a dumby variable to help calculate the percentage loss 
            double MyArchers3=MyArchers;
            double MyFootmen3=TheirFootmen;
            double MyHealers3=TheirFootmen;
            
            MyMages3=MyMages*NumLost3;    //Updating original troop value with the new value after loss calcuation
            MyArchers3=MyArchers*NumLost3;
            MyFootmen3=MyFootmen*NumLost3;
            MyHealers3=MyHealers*NumLost3;
            
            System.out.println(MyArmy);   //Displaying my remaining army after calculation 
            System.out.println("My Remaining Mages: " + MyMages3);    
            System.out.println("My Remaining Archers: " + MyArchers3);
            System.out.println("My Remaining Footmen: " + MyFootmen3);
            System.out.println("My Remaining Healers: " + MyHealers3 + "\n");
            
            Random rand4 = new Random();
            int Result4 = rand4.nextInt(6) + 95;//Calculating their losses which will be less because they won
            double NumLost4 = Result4 / 100.0;
            
            
            double TheirMages4=TheirMages;      //Creating a dumby variable to help calculate the percentage loss 
            double TheirArchers4=TheirArchers;
            double TheirFootmen4=TheirFootmen;
            double TheirHealers4=TheirFootmen;
            
            TheirMages4=TheirMages*NumLost4;    //Updating original troop value with the new value after loss calcuation 
            TheirArchers4=TheirArchers*NumLost4;
            TheirFootmen4=TheirFootmen*NumLost4;
            TheirHealers4=TheirHealers*NumLost4;
            
            System.out.println(TheirArmy);      //Displaying their remaining army 
            System.out.println("Their Remaining Mages: " + TheirMages4);
            System.out.println("Their Remaining Archers: " + TheirArchers4);
            System.out.println("Their Remaining Footmen: " + TheirFootmen4);
            System.out.println("Their Remaining Healers: " + TheirHealers4);
         }
   }
   else{
      System.exit(0);
   }
}
}
