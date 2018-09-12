public class Main {
	public static void main(String[] args) {
		System.out.println("hello world");
		MyString[] myStrings = new MyString[]{new MyString("AA"), new MyString("BB"), new MyString("CC"), new MyString("AA01"), new MyString("AA02"), new MyString("AA03"),
				new MyString("DD01"), new MyString("CC01"), new MyString("AA0303"), new MyString("AA0304")};
		MuxTree muxTree = new MuxTree();
		for(MyString myString : myStrings){
			muxTree.insert(myString);
		}
		muxTree.preOrder();
	}
}
