package com.bgsu.cs.research.task;

public interface Visitor {
	public void visitIdentifer(IdentifierNode identifier);
	public void visitExpression(ExpressionNode expression);
}