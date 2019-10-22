package model.data_structures;
import java.util.Iterator;
public interface IQueue<T> extends Iterable<T> {
	
	/**
	 * add the item o to the queue.
	 * @param o
	 */
	
	public void enqueue(T o);
	
	/**
	 * remove the least recently added item
	 * @return
	 */
	
	public T dequeue();
	
	/**
	 * is the queue empty.
	 * @return true or false depending its empty or not.
	 */
	
	public boolean isEmpty();
	
	/**
	 * number of items in the queue.
	 * @return
	 */
	
	public int size();
	
	public Iterator<T> iterator();
}
