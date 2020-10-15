package com.brideglabz.hashmap;

import org.junit.Assert;

import org.junit.Test;

import com.bridgelabz.hashmap.MyHashTable;
import com.bridgelabz.hashmap.MyLinkedHashMap;
import com.bridgelabz.hashmap.MyMapNode;

public class MyHashTableTest {
	@Test
	public void wordFrequencySentenceTest() {
		String sentence = "To be or not to be";
		MyHashTable<String, Integer> myHashMap = new MyHashTable<String, Integer>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("to");
		Assert.assertEquals(2, frequency);
	}

	@Test
	public void wordFrequencyParagraphTest() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<String, Integer>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int frequency = myLinkedHashMap.get("paranoid");
		System.out.println(myLinkedHashMap);
		Assert.assertEquals(3, frequency);
	}

	@Test
	public void removeWordPhraseTest() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<String, Integer>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		MyMapNode<String, Integer> word = myLinkedHashMap.remove("avoidable");
		System.out.println(myLinkedHashMap);
		Assert.assertEquals(word, null);
	}
}