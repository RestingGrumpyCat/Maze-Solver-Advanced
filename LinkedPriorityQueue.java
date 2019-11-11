import java.util.Iterator;

/**
 * LinkedPriorityQueue represents a linked implementation of a priority queue
 *
 * @author Shiyu Wang From Computer Science 1027
 * 
 */

public class LinkedPriorityQueue<T> implements PriorityQueueADT<T>
{
	  /**
	   * the number of item in the queue
	   */
	   private int count;
	   /**
		* the first element in the queue
		*/
	   private PriorityNode<T> front;
	   /**
		* the last element in the queue
		*/
	   private PriorityNode<T> rear;

	   
	    /** 
	     * Initializes an empty queue.
	     */
	   public LinkedPriorityQueue()
	   {
	      count = 0;
	      front = null;
	      rear = null;
	   }


	   /**
	    * Adds the specified element to the rear of this queue.
	    *
	    * @param element  the element to be added to the rear of this queue
	    */
	  
	   public void enqueue (T element)
	   {
		   PriorityNode<T> node = new PriorityNode<T>(element);

	      if (isEmpty())
	         front = node;
	      else
	         rear.setNext (node);

	      rear = node;
	      count++;
	   }

	   
	   
	   /**
	    * Adds the specified element to the priority queue in the proper location based on priority.
	    *
	    * @param element  the element to be added to the rear of this queue
	    */
	   public void enqueue (T element, double priority)
	   {
		   PriorityNode<T> node = new PriorityNode<T>(element);
		   node.setPriority(priority);
		   PriorityNode<T> current = front;
		   Boolean found = false;

		   if (isEmpty())
	         front = node;
	       else     
	    	   
	    	   if(count == 1){
	    		   if(priority <= current.getPriority()){
		        		 node.setNext(front);
		        		 front = node;		        	    
		        	 } 	
	    		   else
	    			     front.setNext(node);
	    	   }
	    	   else	    		   
		    	   while(current != null &&! found){
		        	 if(priority < current.getPriority()){
		        		 node.setNext(front);
		        		 front = node;
		        	     found = true;
		        	 }
		        	 if(priority == current.getPriority()){
		        		 node.setNext(front.getNext());
		        		 front.setNext(node);
		        		 found = true;
		        	 }
		        	 else{
		        		 if(current.getNext()!= null){
		        			 if(priority > current.getPriority() && priority < current.getNext().getPriority()){
			        			 node.setNext(current.getNext());
			        			 current.setNext(node);
			        			 found = true;
		        			 }
		        		 
		        		 }
		        		 else{
			        			 current.setNext(node);
			        			 found = true;
		        		 }
		        		 
		        	 }
		        	 current = current.getNext();	    	   
		 
	   }
		   rear = node;
	           
		   count++;
	   }

	   /**
	    * Removes the element at the front of this queue and returns a
	    * reference to it. Throws an EmptyCollectionException if the
	    * queue is empty.
	    *
	    * @return the element at the front of this queue
	    * @throws EmptyCollectionException  if an empty collection exception occurs
	    */
	   public T dequeue() throws EmptyCollectionException
	   {
	      if (isEmpty())
	         throw new EmptyCollectionException ("queue");

	      T result = front.getElement();
	      front = front.getNext();
	      count--;

	      if (isEmpty())
	         rear = null;

	      return result;
	   }
	   
	   /**
	    * Returns a reference to the element at the front of this queue.
	    * If the element is not removed from the queue.Throws an
	    * EmptyCollectionException if the queue is empty.  
	    *
	    * @return a reference to the first element in this queue
	    * @throws EmptyCollectionsException if an empty collection exception occurs
	    */
	   public T first() throws EmptyCollectionException
	   {
		   if (isEmpty())
				throw new EmptyCollectionException ("queue underflow");
				T result = front.getElement();
			    return result;
	   }

	   /**
	    * Returns true if this queue is empty and false otherwise. 
	    *
	    * @return  true if this queue is empty and false if otherwise
	    */
	   public boolean isEmpty()
	   {
	       return front == null;
	   }
	 
	   /**
	    * Returns the number of elements currently in this queue.
	    *
	    * @return  the integer representation of the size of this queue
	    */
	   public int size()
	   {
	       return count;
	   }

	   /**
	    * Returns a string representation of this queue. 
	    *
	    * @return  the string representation of this queue
	    */
	   public String toString()
	   {
		   String result = "";
		      PriorityNode<T> current = front;

		      while (current != null)
		      {
		         result = result + (current.getElement()).toString() + "\n";
		         current = current.getNext();
		      }

		      return result;

	   }


}
