package yeah.cstriker1407.think_in_java.Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


//http://wanqiufeng.blog.51cto.com/409430/458883
public class AnnotationTest
{
	@MethodDesc(id=0,des="this is test method")
	public static void test()
	{
		Annotation[] annArrs = FirstDescClass.class.getAnnotations();
		for (Annotation annotation : annArrs)
		{
			System.out.println(annotation.toString());
		}
		System.out.println("==");
		FourthDesc fourthDesc = FourthDescClassB.class.getAnnotation(FourthDesc.class);
		System.out.println("fourthDesc:id=" + fourthDesc.id() + " des:" + fourthDesc.des());
		System.out.println(fourthDesc.toString());
		System.out.println("==");
		annArrs = FourthDescClassB.class.getAnnotations();
		for (Annotation annotation : annArrs)
		{
			System.out.println(annotation.toString());
		}
		
		System.out.println("==");
		Method testM = null;
		try
		{
			testM = AnnotationTest.class.getMethod("test", null);
			annArrs = testM.getAnnotations();
			for (Annotation annotation : annArrs)
			{
				System.out.println(annotation.toString());
			}
		}
		catch (Exception e)
		{
		}
	}
	
	@FirstDesc("This is a first description")
	@SecondDesc(des="This is a second description")
	@ThirdDesc(id=3,des="This is a third description")
	@FourthDesc(id=4)
	static class FirstDescClass
	{
	}
	
	/* 
	 *  FourthDescClassB 继承了FirstDescClass，也继承了 FirstDescClass 的各种注解，但是FirstDescClass的各种注解里面
	 *  只有 @FirstDesc @SecondDesc设置了@Inherited属性，因此只有这两个是可以继承的。
	 */
	@FirstDesc(value="This is FourthDescClassB a first description")
	@FourthDesc(id=4,des="this FourthDescClassB is fourth desc class B")
	static class FourthDescClassB extends FirstDescClass
	{
	}
}

@Target(ElementType.TYPE)//这个标注应用于类
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented//将此注解包含在javadoc中
@Inherited
@interface FirstDesc
{
	public String value();//value比较特殊，它在被指定参数的时候可以不用显示的写出来
	
}

@Target(ElementType.TYPE)//这个标注应用于类
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented//将此注解包含在javadoc中
@Inherited
@interface SecondDesc
{
	public String des();
}

@Target(ElementType.TYPE)//这个标注应用于类
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented//将此注解包含在javadoc中
@interface ThirdDesc
{
	public int id();
	public String des();
}

@Target(ElementType.TYPE)//这个标注应用于类
@Retention(RetentionPolicy.RUNTIME)//标注会一直保留到运行时
@Documented//将此注解包含在javadoc中
@interface FourthDesc
{
	public int id();
	public String des() default "This is Fourth Desc" ;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodDesc
{
	public int id();
	public String des() default "This ia a method desc";
}