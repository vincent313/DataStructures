import HeapMax;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class HeapMaxTest {
	HeapMax heap;

	@Before
	public void insertTest(){
		heap=new HeapMax(10);
		Random random=new Random();
		for (int i=0;i<20;i++){
			int test=random.nextInt(100);
			heap.insert(test);
		}

		System.out.println(heap.toString());
}

@Test
	public void deleteTest(){
		while(true){
			Integer integer=heap.pop();
			if (integer==null){
				break;
			}
			System.out.print(integer+" ");

		}

}
}
