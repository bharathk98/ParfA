public class ASTLoopStatement extends SimpleNode 
{
	public ASTLoopStatement(int id) 
	{
		super(id);
	}

	public ASTLoopStatement(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		jjtGetChild(0).interpret();
		try
		{
			int numtimes = ((Double) ParfANode.stack[ParfANode.p--]).intValue();
			for(int i = 0; i < numtimes; i++)
				jjtGetChild(1).interpret();
		}
		catch(ClassCastException e)
		{
		    System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", loop time must be a numeric expression.");
		    throw new IllegalStateException();
		}
	}
}