import MyHashMap;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
	MyHashMap<String,Integer> myHashMap;
@Test
@Before
	public void addElement(){
	myHashMap=new MyHashMap<String,Integer>(10);
	myHashMap.addNode("Zhiyong",319);
	myHashMap.addNode("Lei",313);
	myHashMap.addNode("Brian",1102);
	myHashMap.addNode("jian",101);
	myHashMap.addNode("dian",840);
	myHashMap.addNode("DD",102);
	myHashMap.addNode("Huang",2);
//update key "Brian"
	myHashMap.addNode("Brian",2015);
	String s=myHashMap.toString();
	System.out.println(s);
}

@Test
public void resizing(){
	myHashMap.addNode("Hng",21);
	String s=myHashMap.toString();
	System.out.println(s);
}

@Test
	public void queryElement(){
	String key1="Brian";//2015

	//brian doesn't exist
	String key2="brian";
	String key3="Zhiyong";//319

	System.out.println(myHashMap.query(key1));
	System.out.println(myHashMap.query(key2));
	System.out.println(myHashMap.query(key3));
}

@Test
	public void deleteElement(){
	String key1="Brian";//2015

	//brian doesn't exist
	String key2="brian";
	String key3="Zhiyong";//319

	System.out.println(myHashMap.delete(key1));
	System.out.println(myHashMap.delete(key2));
	System.out.println(myHashMap.delete(key3));

	System.out.println(myHashMap.toString());

}
}
