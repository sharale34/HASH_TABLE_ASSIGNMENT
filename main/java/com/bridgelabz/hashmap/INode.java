package com.bridgelabz.hashmap;

interface INode<K, V> {
	K getKey();

	void setKey(K key);

	V getValue();

	void setValue(V value);

	INode<K, V> getNext();

	void setNext(INode<K, V> next);

}
