/**
 /**
 * MazeSolverToo represents a higher algorithm of solving a maze using a linked priority queue
 * 
 * @author Shiyu Wang from Computer Science 1027
 * 
 */
 
import java.io.*;
public class MazeSolverToo {
	
	/**
	 * This main method shows the maze
	 * @param args[] is the maze file
	 */
	public static void main (String[] args) {
		try{
            if(args.length<1){
				throw new IllegalArgumentException("No Maze Provided");
            }
           
            
           /*create bookkeeping variables to keep track of 
            * steps taken so far and the number of hexagon 
            * left in the queue*/
           int stepCounter = 0;
           int hexagonOnQueue = 0;
           
           /*create a hexagon current to refer to the current hexagon examined*/
           Hexagon current;
           
           /*read maze file from argument line*/
           String mazetxt = args[2];
                            
           /*create a new maze based on the maze file processed*/
           Maze maze = new Maze(mazetxt);
            
           /*create a hexagon refers to the start of the maze*/
           Hexagon theStart = maze.getStart();
            
           /*create a LinkedPriorityQueue*/
           LinkedPriorityQueue <Hexagon> myQueue = new LinkedPriorityQueue <Hexagon>();
            
           /*calculate the priority of the start hexagon based 
            * on stepsToMe and distanceToEnd*/
           double pri = theStart.getSteps() + theStart.distanceToEnd(maze);        
           
           /*enqueue the start hexagon to the queue based on its priority*/
           myQueue.enqueue(theStart,pri);
           /*set the color of the start to be start_processed*/
           theStart.setStarted();
           theStart.setSteps(0);
           /*increment the number of hexagon on the queue*/
           hexagonOnQueue ++;
            
           /*create a boolean to stop the loop when needed*/
           boolean done = false;
           
           /*use while loop to dequeue the current hexagon and checks if it is the end
            * if so, the code prints out detailed information of solving the maze
            * if not, the code enqueue all the available neighbours of the current 
            * hexagon and check if they are the end */
            
           while(!(done) && ! myQueue.isEmpty()){
				 
        	     current = myQueue.dequeue();					 
				 /*start hexagon remains the same color for better view*/
				 if(!current.isStart()){
				 current.setCurrent();
				 current.setDequeued();
				 }
				 
                 hexagonOnQueue --; 
				 stepCounter ++;
				 /*prints details of how we solved the maze if end is found*/
				 if(current.isEnd()){
					 current.setFinished(); 
					 System.out.println("We found the end of this maze successfully!");
					 /*stepsToMe of the end hexagon is the shortest path to the end from the start*/
					 System.out.println(current.getSteps() + " steps to the end");
					 System.out.println("There are still "  + hexagonOnQueue + " hexagon in the queue.");
					 System.out.println("We have taken " + stepCounter + " steps.");
					 /*loop ends if end is found*/
					 done = true;
				 }
				 
				 else{	
					 /*for loop to access each neighbour of the current and enqueue them when fits correct condition*/
					 for (int i = 0; i <= 5; i++){	 
				 		if( current.getNeighbour(i) != null)
				 			if( ! current.getNeighbour(i).isWall())
				 				if(! current.getNeighbour(i).isDequeued() && ! current.getNeighbour(i).isEnqueued()){
				 					
				 					/*set the stepsToMe of the neighbour to be one more step from the step of the current*/
				 					current.getNeighbour(i).setSteps(current.getSteps() + 1);
				 					/*calculate priority of the neighbour*/				
				 					double priority = current.getNeighbour(i).distanceToEnd(maze) + current.getNeighbour(i).getSteps();
				 					/*enqueue the neighbour based on its priority*/
				 					myQueue.enqueue(current.getNeighbour(i),priority);
				 					/*make sure the start remains the its type color*/
				 					if(!current.getNeighbour(i).isStart()){
				 					current.getNeighbour(i).setEnqueued();
				 					}
				 				hexagonOnQueue ++;
				 				
				 			}
				 	  

				 	   }
					 /* if no end exists, the code prints the notice*/
					 if(hexagonOnQueue == 0 && !done){
							System.out.println("The end is not found.");
							System.out.println("We have taken " + stepCounter + " steps.");
				 }
				 }
				 /*update the maze with repaint function*/
				 maze.repaint();			
            }          
	}

	  /* catch blocks to catch and handle possible exceptions*/
   	 
  	  /*catch and handle possible exceptions when the command 
  	   * line argument does not exist*/ 	  
  	  catch (IllegalArgumentException o){
  		  System.out.println("No input information" + o.getMessage());
  	  }
  	  
  	  /*catch and handle possible exceptions when maze file is missing*/
  	  catch (FileNotFoundException w){
  		  System.out.println("File Not Found" + w.getMessage());
	  }	  
  	  
      /*catch and handle possible exceptions when something is wrong 
  	   * with the input or output information*/
	  catch (IOException k){				
		  System.out.println("Fail To Read File" + k.getMessage());
	  }
  	 
	  /*catch and handle possible exceptions when Encountered A Character The Maze Cannot Recognize*/
  	  catch (UnknownMazeCharacterException e ) {
  	      System.out.println("Encountered A Character The Maze Cannot Recognize" + e.getMessage());
	  }
  	  
  	  /*catch and handle possible exceptions when try t peek or pop item from an empty stack*/
  	  catch (EmptyCollectionException p){
  		  System.out.println("You Try To Pop Or Peek From An Empty Stack" + p.getMessage());
  	  }
  	  
  	  /*catch and handle possible exceptions when reference an index of the neighbor out of range*/
  	  catch (InvalidNeighbourIndexException l){
  		  System.out.println("You Try To Access To An Invalid Index" + l.getMessage());
      }
             
     }
   }
                
