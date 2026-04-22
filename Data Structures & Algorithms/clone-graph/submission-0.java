/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     public void getClone(Node node,Node copyNode,Node[]clones,boolean[]visited){
        visited[node.val]= true;
        clones[node.val]=copyNode;
        for(int i=0;i<node.neighbors.size();i++){           
            if(!visited[node.neighbors.get(i).val]){
                Node newNode = new Node(node.neighbors.get(i).val);
                copyNode.neighbors.add(newNode);
                getClone(node.neighbors.get(i),newNode,clones,visited);
            }else{
                copyNode.neighbors.add(clones[node.neighbors.get(i).val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        boolean[]visited = new boolean[101];
        Node[] cloneArray = new Node[101];
        if(node==null) return null;
        Node headNode = new Node(node.val);
        getClone(node,headNode,cloneArray,visited);
        return headNode;
    }
}