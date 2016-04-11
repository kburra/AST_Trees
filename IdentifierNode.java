package com.bgsu.cs.research.task;

public class IdentifierNode extends TreeNode {
	public IdentifierNode(String value) {
		super(value);
	}
	
	public void accept(Visitor visitor) {
		visitor.visitIdentifer(this);
	}
}