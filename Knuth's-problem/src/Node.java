import java.math.*;

public class Node {
		
	private double val;
	private Node left;
	private Node mid;
	private Node right;
	private Node parent;
	private String op;
	private long depth;

	public Node(double val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.mid = null;
		this.parent = null;
		this.op = "nothing";
		this.depth = 0;
	}
	
	public void setLeft(Node l) {
		this.left = l;
	}
	
	public void setRight(Node r) {
		this.right = r;
	}
	
	public void setMid(Node m) {
		this.mid = m;
	}
	
	public void setParent(Node p) {
		this.parent = p;
	}
	
	public void setOp(String o) {
		this.op = o;
	}
	
	public double getval() {
		return val;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public String getOp() {
		return this.op;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getMid() {
		return this.mid;
	}
	
	public void setDepth(long d) {
		this.depth = d;
	}
	
	public long getDepth() {
		return this.depth;
	}
	

}
