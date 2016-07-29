package list;

public class TreeDisjointSet<T> {
	
	private TreeDisjointSet<T> parent;

	private int rank;

	private T value;

	public TreeDisjointSet( T value) {
		this.parent = this;
		this.rank = 0;
		this.value=value;
	}

	public TreeDisjointSet(TreeDisjointSet<T> parent, int rank, T value) {
		this.parent = parent;
		this.rank = rank;
		this.value = value;
	}


	public TreeDisjointSet<T> findSet(TreeDisjointSet<T> set) {
		if(set != set.getParent()){
			set.setParent(findSet(set.getParent()));
		}
		return set.getParent();
	}
	public void linkSet(TreeDisjointSet<T> set) {
		if(rank > set.rank){
			set.setParent(this);
		}else if(rank < set.rank){
			this.setParent(set);
		}else  {
			set.setParent(this);
			rank++;
		}
	}

	public void union(TreeDisjointSet<T> set) {
		linkSet(set);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeDisjointSet<T> getParent() {
		return parent;
	}

	public void setParent(TreeDisjointSet<T> parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
