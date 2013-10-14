package yeah.cstriker1407.think_in_java.Generics;

public class GenericClass<T>
{
	public GenericClass(T item)
	{
		super();
		this.item = item;
	}
	private T item;
	public T getItem()
	{
		return item;
	}
	public void setItem(T item)
	{
		this.item = item;
	}
}
