import java.io.IOException;

public class ASTAnnounceStatement extends SimpleNode 
{
	String name;
	String val;
	
	public ASTAnnounceStatement(int id) 
	{
		super(id);
	}

	public ASTAnnounceStatement(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			ParfANode.printer.write(ParfANode.stack[ParfANode.p].toString() + "\n");
		    ParfANode.printer.flush();
		}
		catch (IOException e) 
		{
			throw new IllegalStateException(e);
		}
		catch(NullPointerException e)
		{
			throw new IllegalStateException(e);
		}
	}
}