package com.comco.exactcover.dancinglinks;


public class Node {
	private Node left, right, bottom, top;

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
}
