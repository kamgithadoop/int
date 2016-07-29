package list;

import java.util.List;

public class SpreadSheet<E> {
	
	private Row<E> header;
	
	private int size;
	
	public SpreadSheet(){
		this.header = new Row<E>();
		
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void addFirstRow(E[] array){
		Row<E> newRow = new Row<E>(header.getNext(), header);
		header.setNext(newRow);
		newRow.getNext().setPrevoius(newRow);
		for(int i=0;i<array.length;i++){
			newRow.getColumns().add(array[i]);
		}
		size++;
	}

	public void display(){
		Row<E> curr=header.getNext();
		while(curr != header ){
			System.out.println();
			LinkList<E> list = curr.getColumns();
			for(int i=0; i<list.getSize();i++){
				System.out.print(list.get(i));
				System.out.print(", ");
			}
			curr = curr.getNext();
			size++;
		}
		
	}
	public void addLastRow(E[] array){
		Row<E> newRow = new Row<E>(header, header.getPrevoius());
		header.getPrevoius().setNext(newRow);
		header.setPrevoius(newRow);
		for(int i=0;i<array.length;i++){
			newRow.getColumns().add(array[i]);
		}
		size++;
	}

	public static class Row<E>{
		
		private Row<E> next;

		private Row<E> prevoius;
		
		private LinkList<E> columns;
		
		public Row(){
			columns = new LinkList<E>();
			this.next=this;
			this.prevoius=this;
			
		}
		public Row(Row<E> nex, Row<E> prev){
			this.next=nex;
			this.prevoius=prev;
			columns = new LinkList<E>();
		}
		
		public LinkList<E> getColumns() {
			return columns;
		}

		public void setColumns(LinkList<E> columns) {
			this.columns = columns;
		}

		public Row<E> getNext() {
			return next;
		}

		public void setNext(Row<E> next) {
			this.next = next;
		}
		public Row<E> getPrevoius() {
			return prevoius;
		}

		public void setPrevoius(Row<E> prevoius) {
			this.prevoius = prevoius;
		}

	}

}
