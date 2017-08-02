package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MaxHeap<T extends Comparable<T>> extends BinaryHeap<T> {

  public MaxHeap() {
		super(1);
	}

	public MaxHeap(Collection<T> contents) {
		super(1, contents);
	}
}
