import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	Graph graph;
@Before
	public void graphArrayTest(){
		 graph=new GraphImplementByArray(8);
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


	}
	@Test
	public void graphDeepFirstTraverse(){
		graph.deepFirstTraverse("v1");
	}

	@Test
	public void graphBreathFirstSearch(){
		graph.breadthFirstSearch("v1");
	}

	@Test
	public void graphLinkedListTest(){
		GraphImplementByLinkedList g=new GraphImplementByLinkedList();
		g.addVertex("v1");
		g.addVertex("v2");
		g.addVertex("v3");
		g.addVertex("v4");
		g.addVertex("v5");
		g.addVertex("v6");
		g.addVertex("v7");
		g.addVertex("v8");

		g.addEdge("v1","v2",1);
		g.addEdge("v2","v4",1);
		g.addEdge("v2","v5",1);
		g.addEdge("v7","v5",1);
		g.addEdge("v4","v8",1);
		g.addEdge("v8","v5",1);
		g.addEdge("v5","v2",1);
		g.addEdge("v1","v3",1);
		g.addEdge("v6","v7",1);
		g.addEdge("v3","v6",1);
		g.addEdge("v7","v3",1);
		g.addEdge("v3","v7",1);
		System.out.println("--------Deep first search--------");
		g.deepFirstSearch("v1");
		g.dstSet.clear();
		System.out.println("--------Breadth first search--------");
		g.breadthFirstSearch("v1");
	}
}
