package com.comco.exactcover.algorithm;

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
	
	public String columnsToGraphviz(ColumnNode[] columns) {
		beginHeader(); 
		{
			// command: dot -Tpng -Kfdp network.dot -o network.png
			ColumnNode head = columns[0].left;
			
			addHead(head);
			int pos = 1;
			for (ColumnNode column : columns) {
				addColumnNode(column, pos);
				++pos;
			}
			
			addEdge(head, head.right);
			for (ColumnNode column : columns) {
				if (column.right != head) {
					addEdge(column, column.right);
				}
				addEdge(column, column.left);
			}
		}
		endHeader();
		return sb.toString();
	}
	
	String label(ColumnNode column) {
		return String.format("_%d", System.identityHashCode(column));
	}

	private void addHead(ColumnNode head) {
		sb.append(String.format("%s [label = \"head\", pos=\"0,0!\", shape=box];\n", label(head)));
	}

	private void addColumnNode(ColumnNode column, int position) {
		sb.append(String.format("%s [label = \"%d\", pos=\"%d,0!\", shape=box];\n", label(column), column.size, position));
	}
	
	void addEdge(ColumnNode a, ColumnNode b) {
		sb.append(String.format("%s -> %s;\n", label(a), label(b)));
	}
	
}
