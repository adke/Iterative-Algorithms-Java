//Adish Shah
//Henry Wise Wood 2021 Semester 2
//Computer Science 30

public class Searcher {
	
	
	public int doBinarySearch(int[] sortedArray, int key) {
        int low = 0; //lowest index
        int high = sortedArray.length -1; //highest index
        int result = -1;

      /*once the low passes the high, while loop will stop because
       * the entire array would already be searched*/
        while(low <= high) { 
        	
            int middle = ((low + high) / 2); //middle index
           
            /*if the target value is equal to the middle index,
             * then let the result be equal to that middle index and 
             * to make sure the first occurrence takes place, let the
             * high be the middle index minus 1*/
            if(key == sortedArray[middle]) { 
            	
            	result = middle;
            	high = middle - 1;
            	
            }
            
            /*if the target is less than the element at the middle index, 
             * then the high will start searching on the left side of the array
             * for that target*/
            else if (key < sortedArray[middle]){

               high = middle - 1;

            }
            /*if the target is greater than the element at the middle index,
             * then the low will start searching on the right side of the array for
             * that target*/
            else {

               low = middle + 1;

            }
            
        }
        /*return the result, if the target doesn't exist within the array,
         * the program will return a value of -1, otherwise it will return 
         * the appropriate index of for the target*/
        return result;
        
    }
}
