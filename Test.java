package com.bgsu.cs.research.task;

public class Test{
	public static void main(String[] args) throws Exception {
		CalculateExpression calExp = new CalculateExpression("2+3");
		System.out.println("result ::"+calExp.getResult());
	}
}
