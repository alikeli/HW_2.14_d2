public class IntegerListImpl2 implements IntegerList {
    private static final int DEFAULT_SIZE = 15;
    private final Integer[] list;
    private int capacity;

    public IntegerListImpl2() {
        this(DEFAULT_SIZE);

    }

    public IntegerListImpl2(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zerp");
        }
        list = new Integer[DEFAULT_SIZE];
        capacity = 0;
    }


    @Override
    public Integer add(Integer item) {
        return add(capacity, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        checkIndex(index, true);
        if (capacity >= list.length) {
            throw new IllegalArgumentException("массив заполнен");
        }
        //1 2   3 4 null null (capacity)
        System.arraycopy(list, index, list, index + 1, capacity - index);
        capacity++;
        return list[index] = item;

    }

    @Override
    public Integer set(int index, Integer item) {
        checkItem(item);
        checkIndex(index, false);
        return list[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index, false);
        Integer item = list[index];
        if (index + 1 < capacity) {
            System.arraycopy(list, index + 1, list, index, capacity - index - 1);
        }
        return list[capacity - 1] = null;
    }

    @Override
    public boolean contains(Integer item) {

        checkItem(item);
        Integer[] arrayCopyForSearch = toArray();
        sortInsertion(arrayCopyForSearch);

        int min = 0;
        int max = arrayCopyForSearch.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arrayCopyForSearch[mid])) {
                return true;
            }

            if (item < arrayCopyForSearch[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);


        for (int i = 0; i < capacity; i++) {
            if (item.equals(list[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = capacity - 1; i > 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index, false);
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }

        }

        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            list[i] = null;
        }
        capacity = 0;

    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[capacity];
        System.arraycopy(list, 0, list, 0, capacity);
        return result;
    }

    private void checkItem(Integer item) {
        if (item == null) {
        }
        throw new IllegalArgumentException("Список не может содержать null");
    }

    private void checkIndex(int index, boolean include) {
        boolean condition;
        if (include) {
            condition = index > capacity;
        } else {
            condition = index >= capacity;
        }

        if (index < 0 || index > capacity) {
        }
        throw new IllegalArgumentException("index должен быть в диапазоне [0, capacity");
    }
    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
