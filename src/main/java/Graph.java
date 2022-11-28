import java.util.*;

/**
 * @author Zhiyong
 */
interface Graph {
	/**add node to
	 * @return void
	 * @param nodeName
	 * */
	 void addNode(String nodeName);
	 void addEdge(String node,String node2,int value);
	 void deepFirstTraverse(String node);
	 void breadthFirstSearch(String node);
}

class GraphImplementByArray implements Graph{

	private int[][] graph;
	private Map<String,Integer> dictonary;
	private Map<Integer,String> dictionaryVK;
	private int pointer;
	private final int size;
	private int edgeNum;

	private Set<String> dfsSet;

	public GraphImplementByArray(int size) {
	this.size=size;
	this.pointer=0;
	this.edgeNum=0;
	this.dictonary=new HashMap<String,Integer>();
	this.dictionaryVK=new HashMap<Integer,String>();
	this.dfsSet=new HashSet<>();
	graph=new int[size][size];
	for (int i=0;i<size;i++){
		for (int j=0;j<size;j++){
			graph[i][j]=-1;
		}
	}
	}

	@Override
	public void addNode(String nodeName) {
	if (pointer>=size){
		System.out.println("The maximum size of this graph is: "+ size);
		return;
	}
	if (dictonary.containsKey(nodeName)){
		System.out.println("node "+nodeName+" already exist");
		return;
	}
	dictonary.put(nodeName,pointer);
	dictionaryVK.put(pointer,nodeName);
	pointer++;
	}

	@Override
	public void addEdge(String s, String s2, int value) {
	Integer index=dictonary.get(s);
	Integer index2=dictonary.get(s2);
	if (index==null||index2==null){
		System.out.println("Node not found");
		return;
	}
	graph[index][index2]=value;
	edgeNum++;
	}

	@Override
	public void deepFirstTraverse(String node) {
		Integer index=dictonary.get(node);
		if (index==null){
			System.out.println(node + "no exist");
			return;
		}
		if (dfsSet.contains(node)){return;}
		dfsSet.add(node);
		System.out.println("Visit node: "+node);
		for (int i=0;i<size;i++){
			if (graph[index][i]!=-1){
				deepFirstTraverse(dictionaryVK.get(i));
			}
		}
	}

	@Override
	public void breadthFirstSearch(String node) {
		if (!dictonary.containsKey(node)){
			System.out.println("Node doesn't exist");
			return;
		}

		LinkedListQueue queue=new LinkedListQueue();
		queue.enqueue(node);
		dfsSet.add(node);
		while(!queue.isEmpty()){
			String s=queue.dequeue();
			System.out.println("Node->"+s);
			int index=dictonary.get(s);
			for (int i=0;i<size;i++){
				if (graph[index][i]!=-1){
					if (dfsSet.contains(dictionaryVK.get(i))){
						continue;
					}else {
						dfsSet.add(dictionaryVK.get(i));
						queue.enqueue(dictionaryVK.get(i));
					}
				}
			}
		}
		System.out.println("Finish graph traverse");
	}
}

class GraphImplementByLinkedList{
	Map<String,Vertex> vertexMap;
	Set<Vertex> dstSet;
	GraphImplementByLinkedList(){
		this.vertexMap=new HashMap<String,Vertex>();
		dstSet=new HashSet<Vertex>();
	}
	void addVertex(String vertexName){
		if (vertexMap.containsKey(vertexName)){
			System.out.println("Vertex already exist");
			return;
		}

		vertexMap.put(vertexName,new Vertex(vertexName));
	}

	void addEdge(String source,String destination,int weight){
		if (!vertexMap.containsKey(source)||!vertexMap.containsKey(destination)){
			System.out.println("Vertex doesn't exist");
			return;
		}

		vertexMap.get(source).addEdge(vertexMap.get(destination),weight);
	}

	void deepFirstSearch(String s){

		Vertex vertex=vertexMap.get(s);
		if (vertex==null){
			System.out.println("vertex doesn't exist");
			return;
		}

		if (dstSet.contains(vertex)){return;}
		dstSet.add(vertex);
		System.out.println("vertex->"+vertex.vertexName);
		for (Edge e:vertex.edgeList){
			deepFirstSearch(e.getDestination().getVertexName());
		}
	}

	void breadthFirstSearch(String s){
	LinkedListQueue queue=new LinkedListQueue();
	Vertex vertex=vertexMap.get(s);
	dstSet.add(vertex);
	if (s==null){return;}
	queue.enqueue(vertex.getVertexName());
	while (!queue.isEmpty()){
		String s1=queue.dequeue();
		System.out.println("vertex->"+s1);
		Vertex v=vertexMap.get(s1);
		ArrayList<Edge> list=v.edgeList;
		for (Edge l:list){
			if (dstSet.contains(l.destination)){
				continue;
			}
			dstSet.add(l.destination);
			queue.enqueue(l.destination.getVertexName());
		}
	}
	}
	class Vertex{
		String vertexName;
		ArrayList<Edge> edgeList;
		Vertex(String vertexName){
			this.vertexName=vertexName;
			this.edgeList=new ArrayList<Edge>();
		}

		void addEdge(Vertex destination,int weight){
			edgeList.add(new Edge(destination,weight));
		}

		String getVertexName(){
			return vertexName;
		}

	}
	class Edge{
		Vertex destination;
		int weight;

		Edge(Vertex destination,int weight){
			this.destination=destination;
			this.weight=weight;
		}

		int getWeight(){
			return weight;
		}

		Vertex getDestination(){
			return destination;
		}
	}
}


