package com.bridgelabz.hashmap;

class MyMapNode<K, V> implements INode<K, V> {
	K key;
	V value;
	MyMapNode<K, V> next;

	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public INode<K, V> getNext() {
		return next;
	}

	@Override
	public void setNext(INode<K, V> next) {
		this.next = (MyMapNode<K, V>) next;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append(" MyMapNode { " + "K=").append(key).append(" V=").append(value).append(" } ");
		if (next != null) {
			myMapNodeString.append("->").append(next);
		}
		return myMapNodeString.toString();
	}
}