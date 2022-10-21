public class StringListImpl2 implements StringList {
    private static final int DEFAULT_SIZE = 15;
    private final String[] list;
    private int capacity;

    public StringListImpl2() {
        this(DEFAULT_SIZE);

    }

    public StringListImpl2(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zerp");
        }
        list = new String[DEFAULT_SIZE];
        capacity = 0;
    }


    @Override
    public String add(String item) {
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index, false);
        return list[index] = item;
    }

    @Override
    public String remove(String item) {
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        checkIndex(index, false);
        String item = list[index];
        if (index + 1 < capacity) {
            System.arraycopy(list, index + 1, list, index, capacity - index - 1);
        }
        return list[capacity - 1] = null;
    }

    @Override
    public boolean contains(String item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < capacity; i++) {
            if (item.equals(list[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = capacity - 1; i > 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index, false);
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        String[] result = new String[capacity];
        System.arraycopy(list, 0, list, 0, capacity);
        return result;
    }

    private void checkItem(String item) {
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
}
