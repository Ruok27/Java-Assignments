package lab10;

public class Node {
	private int row;
	private int column;
	private boolean visited;
	private Node parent;
	private char content;

	public Node(int i, int j, char symb) {

		this.row = i;
		this.column = j;
		this.visited = false;
		this.parent = null;
		this.content = symb;

	}

	public int getRow() {

		return this.row;

	}

	public void setRow(int row) {

		this.row = row;
	}

	public int getColumn() {

		return this.column;

	}

	public void setColumn(int column) {

		this.column = column;
	}

	public Boolean getVisited() {

		return this.visited;

	}

	public void setVisited(boolean visited) {

		this.visited = visited;
	}

	public Node getParent() {

		return this.parent;

	}

	public void setParent(Node parent) {

		this.parent = parent;
	}

	public char getContent() {

		return this.content;
	}

	public void setContent(char content) {

		this.content = content;
	}

}
