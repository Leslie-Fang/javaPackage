package intel.dcg.leslie;

public class main{
	public static void main(String[] args){
		System.out.println("Hello World!");
		cat a = new cat();
		a.sayName();
		a.sayNumber();
		a.eat("apple");
		cat b = new cat("mango");
		b.sayName();
		b.sayNumber();
		animal c = new cat("bob");
		c.sayNumber();
	}
}