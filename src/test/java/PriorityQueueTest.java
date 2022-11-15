import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.Random;

public class PriorityQueueTest {
	PriorityQueue pq;


	@Before
	public void insertTest(){
		Random r=new Random();
		pq=new PriorityQueue();
		for (int i=0;i<20;i++){
			int i1=r.nextInt(100);
			System.out.print(i1+",");
			pq.insert(i1,i1+"v");
		}

		pq.traverse();
	}

	@Test
	public void popTest(){
		System.out.println();
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());

		pq.traverse();
	}

}
