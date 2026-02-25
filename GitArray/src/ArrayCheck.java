import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Arraylist is used to overcome disadvantage of Array, ie size of Array remains fixed.
	//Arraylist is Class in Util package of Java library.
	
	ArrayList<String> a = new ArrayList<String>();

	a.add("Mobile");
	a.add("Sunflower");
	a.add("Hi");
	a.add("FullName");
	a.add("CheckCheck");
	a.add("Rose");
	System.out.println(a.get(1));
	
	
	System.out.println("--------------");
	
	for(int i=0;i<a.size();i++)
	{
		System.out.println(a.get(i)); 
	}

	List lis = Arrays.asList(a);
	{
	System.out.println(lis.get(0));
	}
	
}
}

