public class IntegerListImpl2 implements IntegerList {
    private static final int DEFAULT_SIZE = 15;
    private Integer[] list;
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
    public void grow() {
        Integer [] newList = new Integer[(int) (list.length * 1.5)];
        System.arraycopy(list, 0, newList, 0, capacity);
        this.list = newList;


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
        mergeSort(arrayCopyForSearch);

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
    private static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, left.length);

        System.arraycopy(arr, mid , right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}
