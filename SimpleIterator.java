import java.util.Iterator;

public class SimpleIterator<T> implements Iterable<T> {
    // array field
    private T[] objArray;

    // default constructor
    public SimpleIterator() {
        this.objArray = null;
    }

    // constructor
    public SimpleIterator(T[] objArray) {
        this.objArray = objArray;
    }

    // change array
    public void setArray(T[] objArray) {
        this.objArray = objArray;
    }

    // iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < objArray.length && objArray[index] != null;
            }

            @Override
            public T next() {
                return objArray[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Method 'remove' is not supported!");
            }
        };
    }

	// main
    public static void main(String[] args) {

        SimpleIterator<Integer> objArr1 = new SimpleIterator<>(new Integer[]{5,4,3,2,1});

        for (Integer n : objArr1)
            System.out.print(n + " ");

        System.out.printf("%n=====================%n");

        SimpleIterator<String> objArr2 = new SimpleIterator<>();
        String[] arr = "some text in array".split(" ");
        objArr2.setArray(arr);

        for (String str : objArr2)
            System.out.println(str);

    }
}