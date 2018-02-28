package com.generic;

import com.justcredo.springbootaerospikeexample.optional.Mobile;

import java.util.ArrayList;
import java.util.List;

public class GenericType<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static <E> boolean isEqual(GenericType<E> g1, GenericType<E> g2){
        return g1.get().equals(g2.get());
    }

    public <E> boolean isEqual(T t, GenericType<T> g1, GenericType<E> g2){
        return g1.get().equals(g2.get());
    }



    public static void main(String args[]){
        GenericType<String> type = new GenericType<>();
        type.set("Pankaj"); //valid

        GenericType type1 = new GenericType(); //raw type
        //type1.set("Pankaj"); //valid
        //type1.set(3);
        //type1.set(10);

        GenericType<String> g1 = new GenericType<>();
        g1.set("Pankaj");

        GenericType<String> g2 = new GenericType<>();
        g2.set("Pankaj");

        GenericType<Integer> g3 = new GenericType<>();
        g3.set(1);

        boolean isEqual = GenericType.<String>isEqual(g1, g2);
        //above statement can be written simply as
        isEqual = GenericType.isEqual(g1, g2);


        //isEqual = GenericType.isEqual(g1, g3);


        GenericType<String> g4 = new GenericType<>();
        GenericType<Object> g5 = new GenericType<>();
        //g5 = g4;




        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(5); ints.add(10);
        double sumInt = sum(ints);
        System.out.println("Sum of ints="+sumInt);

        List<Double> doubles = new ArrayList<>();
        doubles.add(3.0); doubles.add(5.0); doubles.add(10.0);
        double sumDouble = sum(ints);
        System.out.println("Sum of ints="+sumInt);


        //Subtyping using Generics Wildcard
        List<? extends Integer> intList = new ArrayList<>();
        //List<Integer> intList = new ArrayList<>();
        //List<? extends Number>  numList = intList;


        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);

        test(list);

        ArrayList<? extends Comparable> list1= new ArrayList<>();

        ArrayList<Number> numbers = new ArrayList<>();
        //numbers = list;

    }


    public static void test(ArrayList<? extends Comparable> list){

    }


    //Java Generics Wildcards
    //Java Generics Upper Bounded Wildcard
    public static double sum1(List<Number> list){     //make it same name as sum it explains erasure
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    //Java Generics Unbounded Wildcard
    public static void printData(List<?> list){
        for(Object obj : list){
            System.out.print(obj + "::");
        }
    }


    public static void sum2(List<? super Number> list){
        list.add(3);
        //list.add("sa");
    }
}
