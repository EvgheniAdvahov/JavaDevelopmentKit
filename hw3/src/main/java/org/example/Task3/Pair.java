package org.example.Task3;

public class Pair<T,K> {
    private T t;
    private K k;

    public Pair(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getFirst() {
        return t;
    }

    public K getSecond() {
        return k;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t +
                ", k=" + k +
                '}';
    }

    public static void main(String[] args) {
        Pair pair = new Pair("1",2f);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println("pair = " + pair);
    }
}
