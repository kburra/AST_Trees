package com.bgsu.cs.research.task;

import java.util.ArrayList;
import java.util.Stack;

public class CalculateExpression {
	
	private static TreeNode root;
	public CalculateExpression(String expression) throws Exception {
		parse(expression);
	}
	
	public int getResult() {
		CalculateExpressionVisitor cv = new CalculateExpressionVisitor();
		CalculateExpression.accept(cv);
		return (int) cv.getResult();
	}
	
	private void parse(String exp) throws Exception {
		Stack<String> st = new Stack<String>();
	    ArrayList<String> postorder = new ArrayList<String>();
	    ArrayList<String> inorder = new ArrayList<String>();
	    st.push("#");
	    String str= "";
	    String OperatorStr="[-+/*]";
		 try{
		    for (int i=0;i<exp.length();i++) {
		      char ch = exp.charAt(i);
					if (!OperatorStr.contains(String.valueOf(ch))) {
					    str=str+String.valueOf(ch);
				  		Integer.parseInt(str);
					  	postorder.add(str);
					    inorder.add(str);
					    str = "";
					}else{
						inorder.add(String.valueOf(ch));
						  while (!st.empty() && OperatorStr.contains(st.peek())) {                      
							  postorder.add(st.pop());     
						  }  
					  	st.push(String.valueOf(ch));  
					}
		    }
		    String c = st.pop();
		    while (!c.equals("#")) {
		    	postorder.add(c);
		    	c=st.pop();
		    }
	  	}catch (Exception e) {
	  		System.err.println("exception "+e.toString());
	  	}
	
		 
    String str1[]=new String[inorder.size()];
    String u[] = (String[]) inorder.toArray(str1);
    System.out.println("inorder::");
    for(int i=0;i<u.length;i++){
    	System.out.print(u[i]);
    }
    System.out.println();
    String str2[]=new String[postorder.size()];
  	String v[] = (String[]) postorder.toArray(str2); 
  	 System.out.println("postOrder::");
  	 for(int i=0;i<v.length;i++){
     	System.out.print(v[i]);
     }
  	 System.out.println();
  	
  	root = buildTree(u,v);
	}
	
	private static TreeNode buildTree(String[] inorder, String[] postorder) {
      return build(inorder, postorder, 0, 0, inorder.length);
  }
  
  private static TreeNode build(String[] inorder, String[] postorder, int ins,int posts, int length) {
    if (ins < 0||ins+length>inorder.length||posts<0||posts+length>postorder.length||length < 1) {
    	return null;
    }
    TreeNode root = null;  
    String OperatorStr="[-+/*]";
    String insertValue = postorder[posts+length-1];
    
		if (OperatorStr.contains(insertValue)) {
			root = new ExpressionNode(insertValue);
		}else{
			root = new IdentifierNode(insertValue);
		}
			
    int i=0;
    for (i=0;i<length;i++) {
      if (inorder[ins+i].equals(insertValue)) {
      	break;
      }
    }
    
    int leftlength = i;
    int rightlength = length - 1 - leftlength;
    root.setLeftChild(build(inorder, postorder, ins, posts, leftlength));
    root.setRightChild(build(inorder, postorder, ins + leftlength + 1, posts + leftlength, rightlength));
    return root;
  }
  
  public static void accept(Visitor visitor) {
		root.accept(visitor);
	}
}