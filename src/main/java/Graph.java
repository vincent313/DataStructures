import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Graph {
	/**add node to */
	public void addNode(String nodeName);
	public void addEdge(String node,String node2,int value);
	public void deepFirstTraverse(String node);
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
}


