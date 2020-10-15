package com.brideglabz.hashmap;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hashmap.MyHashTable;

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
}
