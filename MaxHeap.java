import java.util.Comparator;
import java.lang.Math;

public class MaxHeap<E extends Comparable> {
    private E[] myArray;
    private int maxSize;
    private int length;

    public MaxHeap(int s){
    	// Build the constructor
        setMaxSize(s);
        setLength(0);
        myArray = (E[]) new Comparable[s + 1];
    }

	// helper functions
    public E[] getArray(){
        return myArray;
    }

    public void setArray(E[] newArray){
    	if (newArray.length -1 > maxSize){
    		return;
    	}
        myArray = newArray;
        length = newArray.length-1;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public void setMaxSize(int ms){
        maxSize = ms;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int l){
        length = l;
    }

    // Other Methods
    public void insert(E data){
        
    	// Insert an element into your heap.
    	
    	// When adding a node to your heap, remember that for every node n, 
    	// the value in n is less than or equal to the values of its children, 
    	// but your heap must also maintain the correct shape.
		// (ie there is at most one node with one child, and that child is the left child.)
		// (Additionally, that child is farthest left possible.)
        if (length < (maxSize - 1)){
            length += 1;
            int current_position = length;
            int parent = current_position/2;
            myArray[current_position] = data;
            while ((current_position > 1 ) && (myArray[current_position].compareTo(myArray[parent]) > 0)){
                myArray[current_position] = myArray[parent];
                myArray[parent] = data;
                current_position = parent;
                parent = current_position /2;
            }
        }
    }

    public Comparable<E> maximum(){
        // return the minimum value in the heap
        if (length < 1){
            return null;
        }
        return myArray[1];
    }

    public Comparable<E> extractMax(){
        // remove and return the minimum value in the heap
        Comparable<E> max_value = maximum();
        myArray[1] = myArray[length];
        setLength(length-1);
        heapify(1);
        return max_value;
    }
    
    public void heapify(int i){
    	// helper function for reshaping the array
        int left_child_position = 2*i;
        int right_child_position = 2*i + 1;
        int largest;
        if ((left_child_position <= length) && (myArray[left_child_position].compareTo(myArray[i])) > 0){
            largest = left_child_position;
        } 
        else{
            largest = i;
        }
        if((right_child_position <= length) && (myArray[right_child_position].compareTo(myArray[largest])) > 0){
            largest = right_child_position;
        } 
        if (largest != i){
            E temp = myArray[i];
            myArray[i] = myArray[largest];
            myArray[largest] = temp;
            heapify(largest);
        }
    }
    
    public void buildHeap(E[] newArr){
		// used for the extra credit
        setArray(newArr);
        for (int i = length/2; i > 0 ; i--){
            heapify(i);
        }
        //for(int i = 1; i < length+1; i++){
        //    System.out.print(myArray[i]);
        //    if (i != length){
        //       System.out.print(",");
        //    }
        //}
        //System.out.println();
    }
}
