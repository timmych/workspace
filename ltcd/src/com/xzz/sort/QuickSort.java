package com.xzz.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.xzz.util.Timing;

import junit.framework.Assert;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> test = new ArrayList<Integer>();

		for (int l = 0; l < 5; ++l) {
			for (int i = 0; i < 1000 + r.nextInt(500); ++i) {
				int m = r.nextInt(Integer.MAX_VALUE);
				test.add(m);
			}
			//System.out.println(test);
			Integer[] testArray = test.toArray(new Integer[test.size()]);

			Timing t = new Timing();
			t.reset();
			new QuickSort().qSort(testArray);
			t.check("qsort");

			t.reset();
			Heap<Integer> heap = new Heap<Integer>();
			for (Integer i : test) {
				heap.add(i);
			}
			
			for (Integer i : heap) {
			    System.out.print(i);
			    System.out.print("->");
			}
			System.out.println();

			List<Integer> heapList = new ArrayList<Integer>(test.size());
			while (!heap.isEmpty()) {
				heapList.add(heap.pop());
			}
			t.check("heapsort");

			Assert.assertEquals(Arrays.asList(testArray), heapList);
		}
	}

	private static Random r = new Random();

	public <T extends Comparable<T>> void qSort(T[] list) {
		if (list == null) {
			return;
		}
		qSort(list, 0, list.length - 1);
	}

	public <T extends Comparable<T>> void qSort(T[] list, int start, int end) {
		if (end - start < 1) {
			return;
		}
		int partition = qPart(list, start, end);
		qSort(list, start, partition - 1);
		qSort(list, partition + 1, end);
	}

	public <T extends Comparable<T>> int qPart(T[] list, int start, int end) {
		int pivotPos = start + r.nextInt(end - start + 1);
		T pivot = list[pivotPos];
		swap(list, end, pivotPos);
		// do a scan [start, end - 1]
		int i = start;// i is the left most element larger than pivot
		for (; i < end; ++i) {
			if (list[i].compareTo(pivot) > 0) {
				break;
			}
		}
		int j = i + 1;// j is worker pos
		while (j < end) {
			if (list[j].compareTo(pivot) <= 0) {
				swap(list, i, j);
				++i;
			}
			++j;
		}
		swap(list, i, end);
		return i;
	}

	public <T> void swap(T[] list, int p1, int p2) {
		T tmp = list[p1];
		list[p1] = list[p2];
		list[p2] = tmp;
	}
}
