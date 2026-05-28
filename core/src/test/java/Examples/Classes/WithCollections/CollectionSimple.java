package Examples.Classes.WithCollections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class CollectionSimple {
    private List<Integer> listInteger;
    private Queue<String> queueString;

    public CollectionSimple() {
        this.listInteger = new ArrayList<>();
        this.queueString = new ArrayDeque<>();

        this.listInteger.add(1);
        this.listInteger.add(2);
        this.listInteger.add(3);

        this.queueString.add("a");
        this.queueString.add("b");
        this.queueString.add("c");
    }

    public CollectionSimple(List<Integer> listInteger, Queue<String> queueString) {
        this.listInteger = listInteger;
        this.queueString = queueString;
    }

    public List<Integer> getListInteger() {
        return listInteger;
    }

    public void setListInteger(List<Integer> listInteger) {
        this.listInteger = listInteger;
    }

    public Queue<String> getQueueDouble() {
        return queueString;
    }

    public void setQueueDouble(Queue<String> queueString) {
        this.queueString = queueString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionSimple that = (CollectionSimple) o;

        if (queueString.size() != that.queueString.size()) {
            return false;
        }

        Iterator<String> it = queueString.iterator();
        Iterator<String> thatIt = that.queueString.iterator();

        while (it.hasNext()) {
            if (!it.next().equals(thatIt.next()))
                return false;
        }

        return listInteger.equals(that.listInteger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listInteger, queueString);
    }
}
