/**
 *PriorityNode represents a node in a LinkedPriorityQueue.
 *
 * @author  Shiyu Wang from Computer Science 1027
 * 
 */

public class PriorityNode<E> 
{
   /**
    * a node refers to the next item of the current
    */
   private PriorityNode<E> next;
   /**
    * the content the node contains
    */
   private E element;
   /**
    * the priority of the node
    */
   private double priority;
   
   /**
    * Creates an empty node.
    */
   public PriorityNode()
   {
       next = null;
       element = null;
   }
   
   /**
    * Creates a node storing the specified element.
    *
    * @param elem  the element to be stored within the new node
    */
   public PriorityNode (E elem)
   {
       next = null;
       element = elem;
   }
   
   /**
    * Returns the node that follows this one.
    *
    * @return  the node that follows the current one
    */
   public PriorityNode<E> getNext()
   {
       return next;
   }
   
   /**
    * Sets the node that follows this one.
    *
    * @param node  the node to be set to follow the current one
    */
   public void setNext (PriorityNode<E> node)
   {
       next = node;
   }
   
   /**
    * Returns the element stored in this node.
    *
    * @return  the element stored in this node
    */
   public E getElement()
   {
       return element;
   }
   
   /**
    * Sets the element stored in this node.
    *
    * @param elem  the element to be stored in this node
    */
   public void setElement (E elem)
   {
       element = elem;
   }
   
   /**
    * Returns the priority of this node.
    *
    * @return  the priority of this node.
    */
   public double getPriority()
   {
       return priority;
   }
   
   /**
    * Sets the priority of this node
    *
    * @param pri  the new priority you want to assign to the node
    */
   public void setPriority(double pri)
   {
       priority = pri;
   }
}
