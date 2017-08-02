package heap;

import java.util.Collection;

public class MinHeap<T extends Comparable<T>> extends BinaryHeap<T> {

  public MinHeap() {
		super(-1);
	}

	public MinHeap(Collection<T> contents) {
		super(-1, contents);
	}
	

}
