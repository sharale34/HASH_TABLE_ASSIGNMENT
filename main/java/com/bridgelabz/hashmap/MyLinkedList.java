package com.bridgelabz.hashmap;

class MyLinkedList<K, V> {
	public INode<K, V> head;
	public INode<K, V> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode<K, V> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			INode<K, V> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}

	public void append(INode<K, V> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void insert(INode<K, V> myNode, INode<K, V> newNode) {
		INode<K, V> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode<K, V> pop() {
		INode<K, V> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	public INode<K, V> popLast() {
		INode<K, V> tempNode = this.head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}

	public INode<K, V> search(K key) {
		INode<K, V> tempNode = this.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			} else {
				tempNode = tempNode.getNext();
			}
		}
		return null;
	}

	public INode<K, V> insertAfterNode(K key, INode<K, V> newNode) {
		INode<K, V> tempNode = this.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			} else {
				tempNode = tempNode.getNext();
			}
		}
		INode<K, V> newTempNode = tempNode.getNext();
		tempNode.setNext(newNode);
		newNode.setNext(newTempNode);
		return tempNode;
	}

	public void delete(INode<K, V> deleteNode) {
		INode<K, V> tempNode = this.head;
		INode<K, V> prevNode = null;
		while (tempNode != null && tempNode.getKey() != deleteNode.getKey()) {
			prevNode = tempNode;
			tempNode = tempNode.getNext();
		}
		prevNode.setNext(tempNode.getNext());
		tempNode.setNext(null);
	}

	public int size() {
		int size = 0;
		INode<K, V> node = head;
		while (node != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	public void printMyNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode<K, V> tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail)) {
				myNodes.append("->");
			}
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}

	@Override
	public String toString() {
		return "MyLinkedList {" + head + "}";
	}
}
