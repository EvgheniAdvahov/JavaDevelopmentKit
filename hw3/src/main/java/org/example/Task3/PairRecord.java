package org.example.Task3;

public record PairRecord<T, K>(T t, K k) {



    public static void main(String[] args) {
        PairRecord pairRecord = new PairRecord(2,"Hello");

        System.out.println(pairRecord.t());
        System.out.println(pairRecord.k());

        System.out.println(pairRecord);
    }
}
