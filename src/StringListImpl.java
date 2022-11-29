import java.util.Arrays;

//public class StringListImpl implements StringList {
//    private final String[] repository;
//    private int size;
//
//    public StringListImpl(String[] repository) {
//        this.repository = new String[10];
//
//    }
//
//    public StringListImpl(int size) {
//        this.repository = new String[size];
//    }
//
//
//    @Override
//    public String add(String item) {
//        validateItem(item);
//        validateSize();
//        repository[size++] = item;
//
//        return item;
//    }
//
//    @Override
//    public String add(int index, String item) {
//        validateSize();
//        validateItem(item);
//        validateIndex(index);
//        if (index==size) {
//            repository[size++] = item;
//            return item;
//        }
//        System.arraycopy(repository,index,repository,index+1,size-index);
//        repository[index] = item;
//        size++;
//        return item;    }
//
//    @Override
//    public String set(int index, String item) {
//        validateIndex(index);
//        validateItem(item);
//        repository[index] = item;
//        return item;
//    }
//
//    @Override
//    public String remove(String item) {
//        validateItem(item);
//        return item;
//    }
//
//    @Override
//    public String remove(int index) {
//        validateIndex(index);
//        return null;
//    }
//
//    @Override
//    public boolean contains(String item) {
//
//        //   return indexOf(item) != -1;
//        return Arrays.asList(repository).contains(item);
//    }
//
//
//    @Override
//    public int indexOf(String item) {
//        for (int i = 0; i < size; i++) {
//            if (repository[i].equals(item))
//                return i;
//
//        }
//        return -1;
//    }
//
//    @Override
//    public int lastIndexOf(String item) {
//        for (int i = size - 1; i > 0; i--) {
//            String s = repository[i];
//            if (s.equals(item)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//    @Override
//    public String get(int index) {
//        validateSize();
//        return repository[index];
//
//
//    }
//
//    @Override
//    public boolean equals(StringList otherList) {
//        validateItem(otherList.toString());
//        return Arrays.equals(otherList.toArray(), repository);
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void clear() {
//        size = 0;
//
//    }
//
//    @Override
//    public String[] toArray() {
//        return Arrays.copyOf(repository, size);
//    }
//
//    private void validateSize() {
//        if (size < 0 || size == repository.length) {
//            throw new RepositoryIsFullException();
//        }
//    }
//
//    private void validateItem(String item) {
//        if (item == null) {
//            throw new ItemNotFoundException();
//
//        }
//    }
//
//    private void validateIndex(int index) {
//        if (index < 0 || index >= repository.length) {
//            throw new IndexNotFoundException();
//        }
//    }


//}
