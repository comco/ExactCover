package com.comco.exactcover.dancinglinks;

public class GraphvizDrawer {

	private final StringBuilder sb = new StringBuilder();

	public GraphvizDrawer() {
	}

	void beginHeader() {
		sb.append("digraph G {\n");
	}

	void endHeader() {
		sb.append("}\n");
	}

	int getColumn(Node node) {
		return node.column.column.colId();
	}

	public String columnsToGraphviz(Network network) {
		beginHeader();
		{
			// command: dot -Tpng -Kfdp network.dot -o network.png
			int pos = 0;
			for (ColumnNode column : network.columnNodes()) {
				addHead(column.base, column.size, pos);
				for (Node node = column.base.top; node != column.base; node = node.top) {
					addNode(node, pos);
				}
				pos++;
			}

			for (ColumnNode column : network.columnNodes()) {
				addEdge(column.base, "B", column.base.top, "L");
				for (Node node = column.base.top; node != column.base; node = node.top) {
					if (getColumn(node.left) < getColumn(node)) {
						addEdge(node, "L", node.left, "T");
					}
					if (getColumn(node) < getColumn(node.right)) {
						addEdge(node, "R", node.right, "B");
					}
					addEdge(node, "T", node.bottom, "R");
					if (node.top != column.base) {
						addEdge(node, "B", node.top, "L");
					}
				}
			}
		}
		endHeader();
		return sb.toString();
	}

	private void addNode(Node node, int pos) {
		sb.append(String
				.format("%s [shape=record, label=\"{<L> L|<B> B}|{<T> T|<R> R}\", pos=\"%d,%d!\"];\n",
						label(node), pos, -(node.row.rowId() + 1)));
	}

	String label(Node node) {
		return String.format("_%d", System.identityHashCode(node));
	}

	private void addHead(Node head, int size, int pos) {
		sb.append(String
				.format("%s [shape=record, label=\"{<L> L|<B> B}|{<T> T|<R> R}\", pos=\"%d,0!\"];\n",
						label(head), pos));
	}

	void addEdge(Node a, String aa, Node b, String bb) {
		sb.append(String
				.format("%s:%s -> %s:%s;\n", label(a), aa, label(b), bb));
	}

}
