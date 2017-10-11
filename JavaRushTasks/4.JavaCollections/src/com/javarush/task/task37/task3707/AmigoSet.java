package com.javarush.task.task37.task3707;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.OBJ_ADAPTER;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Administrator on 11.10.2017.
 */
public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int size = (int) Math.ceil(Math.max(16, (collection.size()/.75f)));
        this.map = new HashMap<>(size);
        for (E e : collection) {
            this.map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public boolean add(Object o) {
        return map.put((E)o, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
