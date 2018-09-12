import sun.reflect.generics.tree.Tree;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MuxTree {
	private MyString data;
	public MuxTree parent;
	public List<MuxTree> children;

	public MuxTree(){
		this.data = new MyString("");
		this.parent = null;
		this.children = new LinkedList<>();
	}

	public MuxTree(String data, MuxTree parent){
		this.data = new MyString(data);
		this.parent = parent;
		this.children = new LinkedList<>();
	}
	public MuxTree insert(String data, MuxTree parent){
		MuxTree child = new MuxTree(data, parent);
		parent.children.add(child);
		return child;
	}
	public MuxTree insert(MyString myString){
		String s = myString.getParent().getString();
		MuxTree parent = this.search(new MyString(s));
		if(parent != null)
			return this.insert(myString.getString(), parent);
		else return null;
	}
	public MuxTree delete(MuxTree parent, int index){
		return parent.children.remove(index);
	}
	public boolean delete(MuxTree parent, MuxTree child){
		return parent.children.remove(child);
	}
	public MuxTree search(MyString myString){
		Queue<MuxTree> queue = new LinkedList<>();
		MuxTree p = this;
		String s = p.data.getString();
		while(p != null){
			if(p.data.getString().equals(myString.getString())){
				return  p;
			}
			if(p.children != null){
				for(MuxTree temp : p.children){
					((LinkedList<MuxTree>) queue).add(temp);
				}
			}
			p = queue.poll();
		}
		return null;
	}

	public void preOrder(MuxTree temp){
		if(temp == null)
			return;
		MuxTree p = temp;
		int parentNum = 0;
		if(p.parent != null){
			while(p.parent != null){
				parentNum += p.data.getString().length();
				p = p.parent;
			}
			for(int i = 0; i < parentNum; i++){
				System.out.print(" ");
			}
			System.out.println(temp.data);
		}
		for(MuxTree index : temp.children){
			preOrder(index);
		}
		return ;
	}
	public void preOrder(){
		this.preOrder(this);
		return ;
	}

	@Override
	public String toString() {
		return "MuxTree{" +
				"data=" + data +
				'}';
	}
}
