public class PQHeap implements PQ 
{
	
	int HeapSize;
	Element[] heapRay;
	
	public PQHeap(int maxElms)
	{
		heapRay = new Element[maxElms+1];
		HeapSize = 0;
	}
    
	public int Parent(int i) {
		return i/2;
	}
	
	public int Left(int i) {
		return i * 2;
	}
	
	public int Right(int i) {
		return i * 2 + 1;
	}


	public Element extractMin() {
		Element minEl;
		if (HeapSize < 1) {
			System.out.println("List empty");
			return null;
		}
		else {
			minEl = heapRay[1];
			heapRay[1] = heapRay[HeapSize];
			HeapSize--;
			MinHeapify(1);
			return minEl;
		}
	}


	public void insert(Element e) {
		Element temp;
		int InsVal;
		HeapSize++;
		heapRay[HeapSize] = e;
		InsVal = HeapSize;
		if (HeapSize == 1) {
			heapRay[1] = e;
		}
		else {
			while (InsVal > 1 && heapRay[InsVal].key < heapRay[Parent(InsVal)].key) {
				temp = heapRay[Parent(InsVal)];
				heapRay[Parent(InsVal)] = e;
				heapRay[InsVal] = temp;
				InsVal = Parent(InsVal);
			}
		}
	}
	
	public void MinHeapify(int i) {
		int least;
		int l;
		int r;
		Element temp;
		l = Left(i);
		r = Right(i);
		if (l <= HeapSize && heapRay[l].key < heapRay[i].key) {
			least = l;
		}
		else {
			least = i;
		}
		if (r <= HeapSize && heapRay[r].key < heapRay[least].key) {
			least = r;
		}
		if (least != i) {
			temp = heapRay[i];
			heapRay[i] = heapRay[least];
			heapRay[least] = temp;
			MinHeapify(least);
		}
	}
	
	public Element returnElement(int id) {
		return heapRay[id];
	}

}
