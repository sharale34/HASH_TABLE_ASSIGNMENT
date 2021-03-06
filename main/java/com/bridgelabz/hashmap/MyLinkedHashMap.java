package com.bridgelabz.hashmap;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int bucketSize;
	ArrayList<MyLinkedList<K, V>> myBucketArray;

	public MyLinkedHashMap() {
		this.bucketSize = 10;
		this.myBucketArray = new ArrayList<>(bucketSize);
		for (int index = 0; index < bucketSize; index++) {
			this.myBucketArray.add(null);
		}
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			return (myMapNode == null) ? null : myMapNode.getValue();
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % bucketSize;
		return index;
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public MyMapNode<K, V> remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			if (myMapNode == null) {
				return null;
			} else {
				myLinkedList.delete(myMapNode);
				return myMapNode;
			}
		}
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List {" + myBucketArray + "}";
	}
}
