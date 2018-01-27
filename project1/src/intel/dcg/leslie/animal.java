package intel.dcg.leslie;

public class animal{
	private String name;
	public animal(){
		name = "leslie";
	}
	public animal(String myName){
		name = myName;
	}
	public String sayName(){
		System.out.println(name);
		return name;
	}
}