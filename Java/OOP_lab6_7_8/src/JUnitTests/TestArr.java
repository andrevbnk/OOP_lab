package JUnitTests;

import collection.Arr;
import org.junit.Assert;
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
        Assert.assertEquals(4, arr.size());
        Assert.assertFalse(String.valueOf(arr.isEmpty()), false);
    }
    @Test
    public void testAddAll(){
        arr.addAll(array);
        arr.addAll(0, array);
        arr.addAll(arr.size() - 1, array);
        arr.addAll(arr.size()/2, array);
        Assert.assertEquals(20, arr.size());
//        System.out.println("ArrSize: " + arr.size());
    }
    @Test
    public void testRemove(){
        arr.remove(0);
        arr.remove(arr.size() - 1);
        arr.remove(arr.size()/2);
        Assert.assertEquals(1, arr.size());
//        System.out.println("ArrSize: " + arr.size());
    }
    @Test
    public void testRemoveAll(){
        arr.removeAll(array);
        Assert.assertEquals(0, arr.size());
    }
    @Test
    public void testRetainAll(){
        arr.add("test test test");
        arr.add("test test");
        arr.retainAll(array);
        Assert.assertNotEquals(arr.toArray(), array.toArray());
    }
    @Test
    public void testContains(){
        boolean one = arr.contains(strings[0]);
        boolean two = arr.contains(strings[1]);
        boolean three = arr.contains(strings[2]);
        boolean four = arr.contains(strings[3]);
        boolean five = arr.contains("lol lol lol");
        Assert.assertTrue(String.valueOf(one), true);
        Assert.assertTrue(String.valueOf(two), true);
        Assert.assertTrue(String.valueOf(three), true);
        Assert.assertTrue(String.valueOf(four), true);
        Assert.assertFalse(String.valueOf(five), false);
    }
    @Test
    public void testContainsAll(){
        Assert.assertTrue(String.valueOf(arr.containsAll(array)), true);
    }
    @Test
    public void testGet(){
        String one = arr.get(0);
        String two = arr.get(arr.size() - 1);
        String three = arr.get((int)Math.floor(arr.size()>>2));
        Assert.assertEquals(strings[strings.length-1], two);
        Assert.assertEquals("", three);
        Assert.assertNull(null, one);
    }
    @Test
    public void testSet(){
        String test = arr.set(0, "");
        String test_2 = arr.get(0);
        Assert.assertEquals("", test_2);
        Assert.assertNull(null, test);
    }
    @Test
    public void testIterator(){
        Iterator<String> iter = arr.iterator();
        for(;iter.hasNext();){
            iter.next();
            iter.remove();
        }
        Assert.assertEquals(0, arr.size());

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
        String str = "";
        if(iter.hasPrevious()){
            str = iter.previous();
            iter.remove();

        }
        Assert.assertFalse(String.valueOf(arr.contains(str)), false);

        for(;iter.hasPrevious();){
            iter.previous();
            iter.remove();
        }

        Assert.assertEquals(0, arr.size());
        Assert.assertTrue(String.valueOf(true), stageOne);
    }
}
