package com.bgsu.cs.research.task;

public class ExpressionNode extends TreeNode {
	public ExpressionNode(String value) {
		super(value);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitExpression(this);
	}
}