package AnimalApplication.counter;

public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws IllegalStateException {
        if (count > 0) {
            throw new IllegalStateException(
                    "Работа с объектом типа Counter не в ресурсном try или ресурс остался открыт.");
        }
    }
}