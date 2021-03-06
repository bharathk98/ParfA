public class ASTEquals extends SimpleNode 
{
	public ASTEquals(int id) 
	{
		super(id);
	}

	public ASTEquals(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    String val = ParfANode.stack[ParfANode.p - 1].toString();
	    String val1 = ParfANode.stack[ParfANode.p].toString();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = Boolean.valueOf(Double.parseDouble(val) == Double.parseDouble(val1));
	    }
	    catch(NumberFormatException e)
	    {
	    	
	    	ParfANode.stack[ParfANode.p] = Boolean.valueOf(ParfANode.stack[ParfANode.p].toString().equals(ParfANode.stack[ParfANode.p + 1].toString())); 
	    }
	}
}