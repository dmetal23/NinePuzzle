/*
Programmer: Daniel Rojas
Project #3: NinePuzzle
Class: COMP 282, MoWe 9:30
*/
import java.util.*;

public class NinePuzzle {

   Queue<String> plan = new LinkedList<String>();    // Queue stores all nodes using Bredth-First Search 
   Map<String,Integer> state = new HashMap<String, Integer>(); // HashMap ignores repeated nodes
   Map<String,String> history = new HashMap<String,String>(); 

   //Methods to move nodes from BFS into correct positions (up, down, left, right) 
   void up(String current){
      int a = current.indexOf("0");
      if(a>2){
         String nextState = current.substring(0,a-3)+"0"+current.substring(a-2,a)+current.charAt(a-3)+current.substring(a+1);
         check(current, nextState);
      }
   }

   void down(String current){
      int a = current.indexOf("0");
      if(a<6){
         String nextState = current.substring(0,a)+current.substring(a+3,a+4)+current.substring(a+1,a+3)+"0"+current.substring(a+4);
         check(current, nextState);
      }
   }
   void left(String current){
      int a = current.indexOf("0");
      if(a!=0 && a!=3 && a!=6){
         String nextState = current.substring(0,a-1)+"0"+current.charAt(a-1)+current.substring(a+1);
         check(current, nextState);
        
      }
   }
   void right(String current){
      int a = current.indexOf("0");
      if(a!=2 && a!=5 && a!=8){
         String nextState = current.substring(0,a)+current.charAt(a+1)+"0"+current.substring(a+2);
         check(current, nextState);
      }
   }
   
   //Add method to add the new string to the Map and Queue
   public void add(String newState, String oldState){
      if(!state.containsKey(newState)){
         int newValue = oldState == null ? 0 : state.get(oldState) + 1;
         state.put(newState, newValue);
         plan.add(newState);
         history.put(newState, oldState);
      }
   }
   
   //Check method to check completion 
   private void check(String oldState, String newState) {
      add(newState, oldState);
      if(newState.equals("123456780")) {
         System.out.println("Solution Exists at Level "+state.get(newState)+" of the tree\n");
         String traceState = newState;
         while (traceState != null) {
            System.out.println(traceState + " at Level " + state.get(traceState));
            traceState = history.get(traceState);
         }
         System.exit(0);
      }
   }
}
