package my.algorithm.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {
	public static List<String> topKFrequentSort(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, WordAndCount> wordAndCountMap = new HashMap<>();
        for (String s : words) {
            if (wordAndCountMap.get(s) != null) {
            	wordAndCountMap.get(s).increaseCount();
            } else {
            	wordAndCountMap.put(s, new WordAndCount(s));
            }
        }
        Collection<WordAndCount> wordAndCounts = wordAndCountMap.values();
        ArrayList<WordAndCount> wordAndCountList = new ArrayList<WordAndCount>(wordAndCounts);
		Collections.sort(wordAndCountList);
        for (WordAndCount wordAndCount : wordAndCountList.subList(0, k)) {
            result.add(wordAndCount.word);
        }
        return result;
    }
	
	public static List<String> topKFrequentHeap(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, WordAndCount> wordAndCountMap = new HashMap<>();
        for (String s : words) {
            if (wordAndCountMap.get(s) != null) {
            	wordAndCountMap.get(s).increaseCount();
            } else {
            	wordAndCountMap.put(s, new WordAndCount(s));
            }
        }
        
        PriorityQueue<WordAndCount> heap = new PriorityQueue<WordAndCount>(wordAndCountMap.values());
        for (int i=0; i<k; i++) {
        	result.add(heap.poll().word);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
//    	System.out.println(topKFrequentSort(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
//    	System.out.println(topKFrequentHeap(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 2));
    	
    	String[] array1 = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    	String[] array2 = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
    	{
    	long start = System.currentTimeMillis();
    	for (int i=0; i<100000; i++) {
    		topKFrequentHeap(array1, 4);
    		topKFrequentHeap(array2, 3);
    		topKFrequentHeap(array1, 2);
    		topKFrequentHeap(array2, 2);
    	}
    	long end = System.currentTimeMillis();
    	System.out.println(end-start);
    	}
    	{
    	long start = System.currentTimeMillis();
    	for (int i=0; i<100000; i++) {
    		topKFrequentSort(array1, 4);
    		topKFrequentSort(array2, 3);
    		topKFrequentSort(array1, 2);
    		topKFrequentSort(array2, 2);
    	}
    	long end = System.currentTimeMillis();
    	System.out.println(end-start);
    	}
    	
    }
}

class WordAndCount implements Comparable<WordAndCount> {
	int count = 1;
	String word;
	public WordAndCount(String s) {
		this.word = s;
	}
	public void increaseCount() {
		this.count ++;
	}
	@Override
	public int compareTo(WordAndCount o) {
		if (this.count == o.count) {
            return this.word.compareTo(o.word);
        }
		return this.count < o.count ? 1 : -1;  //desend
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof WordAndCount) {
			return ((WordAndCount)o).word.equals(this.word);
		} 
		return false;
	}
	@Override
	public String toString() {
		return this.word+":"+this.count;
	}
}