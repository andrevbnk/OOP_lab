package JUnitTests;

import collection.Arr;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
/**
 * TestArr - JUnitTest кторый проверяет
 * класс-коллекцию Arr на наличие ошибок,
 * и корректность работы. Все методы класса
 * проверяют правильность работы методов
 * класса Arr.
 * @see Arr
 *
 * @autor Ekros
 * @version 1.0 09.03.2019
 *
 *
 * Запускать: правой кнопкой мыши -> Run 'TestArr'
 * */
public class TestArr extends JUnit4Builder{
    Arr<String> arr = new Arr<>();
    ArrayList<String> array = new ArrayList<>();
    String[] strings = {null, "", " ", "EGFE"};
    String mess = "Test Complete: ";
    String err = "Test faild: ";
    @Before
    public void rewrite(){
        arr.clear();
        for(int i = 0 ; i < strings.length; i++){
            arr.add(strings[i]);
            array.add(strings[i]);
        }
    }
    @Test
    public void testIsEmptyAndSize(){
        System.out.println(mess + "size |" + arr.size() + " isEmpty |" + arr.isEmpty());
    }
    @Test
    public void testAddAll(){
        arr.addAll(array);
        arr.addAll(0, array);
        arr.addAll(arr.size() - 1, array);
        arr.addAll(arr.size()/2, array);
        System.out.println(mess + "addAll");
    }
    @Test
    public void testRemove(){
        arr.remove(0);
        arr.remove(arr.size() - 1);
        arr.remove(arr.size()/2);
        System.out.println(mess + "remove");
    }
    @Test
    public void testRemoveAll(){
        arr.removeAll(array);
        if(arr.size() == 0){
            System.out.println(mess + "removeAll");
        }else{
            System.err.println(err + "removeAll " + "ArrSize: " + arr.size());
        }
    }
    @Test
    public void testRetainAll(){
        arr.add("test test test");
        arr.add("test test");
        arr.retainAll(array);
        if(!arr.toArray().equals(array.toArray())){
            System.out.println(mess + "retainAll");
        }else{
            System.err.println(err + "retainAll");
        }
    }
    @Test
    public void testContains(){
        boolean one = arr.contains(strings[0]);
        boolean two = arr.contains(strings[1]);
        boolean three = arr.contains(strings[2]);
        boolean four = arr.contains(strings[3]);
        boolean five = arr.contains("lol lol lol");
        if(one == two == three == four == true && !five){
            System.out.println(mess + "contains");
        }else{
            System.err.println(err + "contains");
        }
    }
    @Test
    public void testContainsAll(){
        if(arr.containsAll(array)){
            System.out.println(mess + "containsAll");
        }else{
            System.err.println(err + "containsAll");
        }
    }
    @Test
    public void testGet(){
        String one = arr.get(0);
        String two = arr.get(arr.size() - 1);
        String three = arr.get((int)Math.floor(arr.size()>>2));
        if(two.equals(strings[strings.length-1]) && three.equals("") && one == null){
            System.out.println(mess + "get");
        }else{
            System.err.println(err + "get");
        }
    }
    @Test
    public void testSet(){
        String test = arr.set(0, "");
        String test_2 = arr.get(0);
        if(test_2.equals("") && test == null){
            System.out.println(mess + "set");
        }else{
            System.err.println(err + "set");
        }
    }
    @Test
    public void testIterator(){
        Iterator<String> iter = arr.iterator();
        for(;iter.hasNext();){
            iter.next();
            iter.remove();
        }
        if(arr.size() == 0){
            System.out.println(mess + "iterator");
        }else{
            System.err.println(err + "iterator " + "ArrSize: " + arr.size());
        }
    }
    @Test
    public void testListIterator(){
        ListIterator<String> iter = arr.listIterator();
        for(;iter.hasNext();){
            iter.next();
            iter.remove();
        }
        boolean stageOne = false;
        if(arr.size() == 0) {
            stageOne = true;
        }
        rewrite();
        iter = arr.listIterator();
        for(;iter.hasNext();){
            iter.next();
        }
        for(;iter.hasPrevious();){
            iter.previous();
            iter.remove();
        }
        if(arr.size() == 0 && stageOne){
            System.out.println(mess + "listLterator");
        }else{
            System.err.println(err + "listIterator " + "ArrSize: " + arr.size() + " StageOne: " + stageOne);
        }
    }
}
