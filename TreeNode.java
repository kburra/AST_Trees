package com.bgsu.cs.research.task;

public abstract  class TreeNode implements Visitable {
	public String value;
	public Visitable leftChild;
	public Visitable rightChild;
	
	public TreeNode(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setLeftChild(Visitable leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(Visitable rightChild) {
		this.rightChild = rightChild;
	}
	
	public Visitable getLeftChild() {
		return this.leftChild;
	}
	
	public Visitable getRightChild() {
		return this.rightChild;
	}
	
	public abstract void accept(Visitor visitor);
}