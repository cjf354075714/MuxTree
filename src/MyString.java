
public class MyString implements Comparable<MyString> {
	private String string;

	public MyString(String s){
		this.string = s;
	}
	public String getString(){
		return this.string;
	}
	public MyString getParent(){
		String parent = this.string.substring(0, string.length()-2);
		return new MyString(parent);
	}
	@Override
	public int compareTo(MyString o) {
		if(this.string.length() > o.string.length())
			return 1;
		else if(this.string.length() < o.string.length())
			return -1;
		else {
			if(this.string.compareTo(o.string) > 0)
				return 1;
			else if(this.string.compareTo(o.string) < 0)
				return -1;
			else return 0;
		}
	}

	@Override
	public String toString() {
		return string;
	}
}
