class MyTreeNode {
  MyTreeNode left;
  MyTreeNode right;
  MyToken token;
  int value = 0;

  public void preOrderPrint(){
    preOrderPrint(this);
  }
  public void inOrderPrint(){
    inOrderPrint(this);
  }
  public void postOrderPrint(){
    postOrderPrint(this);
  }

  public void preOrderPrint(MyTreeNode node){
    if (node.token.type == MyToken.NUMBER){
      System.out.print(" " + node.token.value);
    }else if (node.token.type == MyToken.OP){
      System.out.print("(");
      System.out.print("" + (char)node.token.value + "");
      preOrderPrint(node.left);
      preOrderPrint(node.right);
      System.out.print(")");
    }
  }

  public void inOrderPrint(MyTreeNode node){
    if (node.token.type == MyToken.NUMBER){
      System.out.print(" " + node.token.value);
    }else if (node.token.type == MyToken.OP){
      System.out.print("(");
      inOrderPrint(node.left);
      System.out.print(" " + (char)node.token.value);
      inOrderPrint(node.right);
      System.out.print(")");
    }
  }

  public void postOrderPrint(MyTreeNode node){
    if (node.token.type == MyToken.NUMBER){
      System.out.print(" " + node.token.value);
    }else if (node.token.type == MyToken.OP){
      postOrderPrint(node.left);
      postOrderPrint(node.right);
      System.out.print(" " + (char)node.token.value);
      
    }
  }
  
  public int calc(){
    return calc(this);
  }
 
  public int calc(MyTreeNode node){
  	int value, result=0;
    if (node.token.type == MyToken.NUMBER){
      return node.token.value;
    }else if (node.token.type == MyToken.OP){
      switch((char)node.token.value){
      case '+': value = calc(node.left) + calc(node.right);
      			result=result+value;
      			return result;
      case '-': value = calc(node.left) - calc(node.right);
      			result=result+value;
      			return result;
      case '*': value = calc(node.left) * calc(node.right);
      			result=result+value;
      			return result;
      case '/': value = calc(node.left) / calc(node.right);
      			result=result+value;
      			return result;
      default: return 0;
      }
    }else{
      return 0;
    }
  }
  
  public int xml(){
    return xml(this);
  }
  
  public int xml(MyTreeNode node){
    if (node.token.type == MyToken.NUMBER){
      System.out.print("  <num>" + node.token.value + "</num> \n" );
      return node.token.value;
    }else if (node.token.type == MyToken.OP){
      switch((char)node.token.value){
      case '+': System.out.print("<add> \n  ");
      			xml(node.left);
      			System.out.print("  ");
      			xml(node.right);
      			System.out.print("</add> \n" );
      			return 0;
      case '-': System.out.print("<sub> \n  ");
      			xml(node.left);
      			System.out.print("  ");
      			xml(node.right);
      			System.out.print("  </sub> \n" );
      			return 0;
      case '*': System.out.print("<mul> \n  ");
      			xml(node.left);
      			System.out.print("  ");
      			xml(node.right);
      			System.out.print("  </mul> \n" );
      			return 0;
      case '/': System.out.print("<div> \n  ");
      			xml(node.left);
      			System.out.print("  ");
      			xml(node.right);
      			System.out.print("  </div> \n" );
      			return 0;
      default: return 0;
      }
    }else{
      return 0;
    }
  }
  
  public int make(){
    return make(this);
  }
  
  public int make(MyTreeNode node){
  	String text= "  ";
    if (node.token.type == MyToken.NUMBER){
      value++;
      System.out.print("  " + value + ": push " + node.token.value + "\n" );
      return node.token.value;
    }else if (node.token.type == MyToken.OP){
      switch((char)node.token.value){
      case '+': make(node.left);
      			make(node.right);
      			value++;
      			text="add";
      			break;
      case '-': make(node.left);
      			make(node.right);
      			value++;
      			text="sub";
      			break;
      case '*': make(node.left);
      			make(node.right);
      			value++;
      			text="mul";
      			break;
      case '/': make(node.left);
      			make(node.right);
      			value++;
      			text="div";
      			break;
      default:  return 0;
      }
      System.out.print("  " + value + ": " + text + " \n");
      text=" ";
      return value;
    }else{
        return 0;
    }
    
  }
  
  public int run(){
    return run(this);
  }
  
  public int run(MyTreeNode node){
    int result = calc(node);
    return result;
  }
  
}
