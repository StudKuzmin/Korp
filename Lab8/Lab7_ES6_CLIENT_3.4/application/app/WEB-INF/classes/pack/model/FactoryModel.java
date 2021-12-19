package pack.model;

public class FactoryModel implements IFactoryModel
{
	public IModel createModel()
	{
		return new Model();
	}
}