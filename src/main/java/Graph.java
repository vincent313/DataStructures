import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


