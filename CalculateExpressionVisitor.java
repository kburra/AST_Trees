package com.bgsu.cs.research.task;

import java.util.Stack;

public class CalculateExpressionVisitor implements Visitor {
	private int result;
	private Stack<String> st = new Stack<String>();  
	@Override
	public void visitIdentifer(IdentifierNode num) {
		st.push(num.getValue());
	}
	@Override
	public void visitExpression(ExpressionNode op) {
		op.getLeftChild().accept(this);
		op.getRightChild().accept(this);
		Integer rightChild = Integer.valueOf(st.pop());  
		Integer leftChild = Integer.valueOf(st.pop()); 
		String operator = op.getValue();
		switch(operator){
			case "+":
				result=leftChild+rightChild;
				break;
			case "-":
				result=leftChild-rightChild;
				break;
			case "*":
				result=leftChild*rightChild;
				break;
			case "/":
				result=leftChild/rightChild;
				break;
		}
		 st.push(String.valueOf(result));  
	}
	
	public int getResult()	{
		return result;   
	}
}