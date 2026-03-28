import java.util.*;

/* 
 * Implement your test cases under the class BSTTest 
 * Follow the principles of Behavior-Driven Testing
 * Start by identifying and defining the expected behaviors
 * Implement test for each of the identified behavior
*/
public class HeapMaxTest {
	public static void main(String[] args) {
		// do whatever you need to do to test your implementation

		HeapMax heap = new HeapMax();
		HeapMax heap2 = new HeapMax();
		/*heap.insert(7);
		heap.insert(6);
		heap.insert(5);
		heap.insert(10);
		heap.insert(31);
		heap.insert(43);
		heap.insert(32);
		heap.display();
		heap.insert(3);

		heap.removeMax();
		heap.display();*/

		int[] arr ={2,3,5,7,3,1,7,53,44,43,22,66,834,64};
		int[] arr2 ={24,633,5743,7,373,1,377,5533,454,473,282,676,88834,654};
		heap.build(arr);
		heap.display();
		heap2.build(arr2);
		heap2.display();

	}

	// you will need helper methods to implement the test cases
}
