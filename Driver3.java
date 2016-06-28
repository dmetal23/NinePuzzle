/*
Programmer: Daniel Rojas
Project #3: NinePuzzle
Class: COMP 282, MoWe 9:30
*/

import java.util.*;
import java.io.*;

public class Driver3 { 
  
   public static void main(String args[]) throws Exception {
      // Initialize input.txt
      File file = new File("data.txt");
      StringBuilder sB = new StringBuilder();
      int i = 0; 
         
      if (!file.exists())
      {
         System.out.println("data.txt does not exist.");
         System.exit(1);
      }
      
      Scanner inputFile = new Scanner(file);
   
      while(inputFile.hasNextInt()){
         sB.append(inputFile.nextInt());
        
      }  
      //String str="103526478"; 
      String str = sB.toString(); 
      
      System.out.println("Welcome to the Nine Puzzle\n");  
      System.out.println("Reading initial input: " +str);
      System.out.println();               
   
      NinePuzzle e = new NinePuzzle();      
      e.add(str,null);                           
      
      while(!e.plan.isEmpty()){
         String current = e.plan.remove();
         e.up(current);                                       // Move the blank space up and add new state to queue
         e.down(current);                                     // Move the blank space down
         e.left(current);                                     // Move left
         e.right(current);                          // Move right and remove the current node from Queue
      }
      System.out.println("Solution doesn't exist\n");
   }
   
}