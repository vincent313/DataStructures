import org.junit.Test;

public class GraphTest {
	@Test
	public void graphArrayTest(){
		Graph graph=new GraphImplementByArray(8);
		graph.addNode("v1");
		graph.addNode("v2");
		graph.addNode("v3");
		graph.addNode("v4");
		graph.addNode("v5");
		graph.addNode("v6");
		graph.addNode("v7");
		graph.addNode("v7");
		graph.addNode("v8");

		graph.addNode("v8");

		graph.addEdge("v1","v2",1);
		graph.addEdge("v2","v4",1);
		graph.addEdge("v2","v5",1);
		graph.addEdge("v7","v5",1);
		graph.addEdge("v4","v8",1);
		graph.addEdge("v8","v5",1);
		graph.addEdge("v5","v2",1);
		graph.addEdge("v1","v3",1);
		graph.addEdge("v6","v7",1);
		graph.addEdge("v3","v6",1);
		graph.addEdge("v7","v3",1);
		graph.addEdge("v3","v7",1);

		graph.addEdge("v9","v7",1);
		graph.addEdge("v1","v10",1);
		graph.deepFirstTraverse("v1");
	}
}
