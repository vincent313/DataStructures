import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BinarySearchTreeTest {
	BinarySearchTree bst;
	@Before
	public void insertNode(){
		bst=new BinarySearchTree();
		Random r = new Random();
		System.out.print("Insert number: ");
		for (int i=0;i<20;i++){
			int i1 = r.nextInt(100);
			bst.insert(i1,i1+"s");
			System.out.print(i1+" ");
		}
		System.out.println();
	}
	@Test
	public void queryNode(){
		for (int i=10;i<21;i++){
			String s= bst.query(i);
			if (s==null){
				System.out.println(i+" value not found");
				continue;
			}
			System.out.println(s);
		}
	}

	@Test
	public void deleteTest(){
		bst.delete(3);
		System.out.println(bst.delete(6));
		bst.delete(8);
		bst.delete(11);
		bst.delete(1);
		bst.delete(9);
		bst.delete(4);
		System.out.println(bst.delete(4));
		traverseTest();
	}

	@Test
	public void traverseTest(){
		bst.inOrdertraverse(bst.root);
		System.out.println();
		bst.preOrdertraverse(bst.root);
		System.out.println();
		bst.postOrdertraverse(bst.root);
	}
}
