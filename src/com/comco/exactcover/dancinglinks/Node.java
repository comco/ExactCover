package com.comco.exactcover.dancinglinks;

/**
 * Node inside the Dancing Links representation of the Exact Cover problem.
 * 
 * @author comco
 * 
 */
public class Node {
    private Node left, right, bottom, top;
    private final int row, col;

    public Node(final int row, final int col) {
	if (row >= 0 && col >= 0) {
	    this.row = row;
	    this.col = col;

	    left = this;
	    right = this;
	    bottom = this;
	    top = this;
	} else {
	    throw new IllegalArgumentException(
		    "Dancing links node row and column should be non-negative.");
	}
    }

    public Node getLeft() {
	return left;
    }

    public void setLeft(Node node) {
	left = node;
    }

    public Node getRight() {
	return right;
    }

    public void setRight(Node node) {
	right = node;
    }

    public Node getBottom() {
	return bottom;
    }

    public void setBottom(Node node) {
	bottom = node;
    }

    public Node getTop() {
	return top;
    }

    public void setTop(Node node) {
	top = node;
    }

    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public void attachLeftRight() {
	left.setRight(this);
	right.setLeft(this);
    }

    public void detachLeftRight() {
	left.setRight(right);
	right.setLeft(left);
    }

    public void attachBottomTop() {
	bottom.setTop(this);
	top.setBottom(this);
    }

    public void detachBottomTop() {
	bottom.setTop(top);
	top.setBottom(bottom);
    }

    public void insertRight(final Node node) {
	node.right = right;
	right.left = node;

	node.left = this;
	right = node;
    }

    public void insertTop(final Node node) {
	node.top = top;
	top.bottom = node;

	node.bottom = this;
	top = node;
    }
}
