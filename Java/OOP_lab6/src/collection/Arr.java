package collection;

import java.util.*;
/**
 * Arr - класс коллекция, реализует
 * интерфейс List, сохраняет данные
 * в двусвязный список, содержит адрес
 * первого и последнего элемента, адресс
 * в данном случае это класс Elem который
 * содержит адреса предыдущего или следующего
 * элемента, а так-же сами данные.
 * @see Elem
 *
 * @author Ekros
 * @version 1.5 25.03.2019
 *
 *
 * P.S Тут могут быть баги!
 * */
public class Arr<E> implements List<E> {


    private int size = 0;    //размер массива

    private Elem<E> first;   //адрес первого элемента
    private Elem<E> last;    //адрес второго элемента

    public Arr(){}

    public Arr(E e){
        add(e);
    }

    public Arr(Collection<? extends E> c){
        addAll(c);
    }


    /*Возвращает длинну массива*/
    @Override
    public int size() {
        return size;
    }
    /*
    * Возвращает true если массив пустой,
    * тоесть first == last == null;
    * */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверка на вхождение обьекта в коллекцию
     *
     * @param o передаваемый обьект
     * */
    @Override
    public boolean contains(Object o) {
        if(o == null){
            for(int i = 0; i < size; i++){
                if(get(i) == null){
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                E t = get(i);
                if (t != null) {
                    if (t.equals(o)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
    * Проверяет объект на вхождение в массив,
    * и если он есть возвращает его индекс, в
    * инном случае возвращает -1;
    *
    * @param o передаваевый обьект
    * */
    public int containsIndex(Object o) {
        for(int i = 0; i < size; i++){
            E e = get(i);
            if(e != null) {
                if (e.equals(o)) {
                    return i;
                }
            }else{
                if(o == null){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    /*
    * Преобразует данные в обычный массив объектов.
    * */
    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        for(int i = 0; i < size; i++){
            obj[i] = get(i);
        }
        return obj;
    }

    /**
     * Преобразует и записывает данные в переданный массив.
     * Возвращает переданный массив до изменения.
     * Если размер передаваемого массива меньше размера коллекции
     * запись не произойдет.
     *
     * @param a передаваевый массив для записи
     * */
    @Override
    public <E1> E1[] toArray(E1[] a) {
        E1[] old = a;

        if(a.length <= size) {
            a = (E1[]) Arrays.copyOf(toArray(), size, a.getClass());
        }else{
            Iterator iter = iterator();
            for(int i = 0;iter.hasNext(); i++){
                a[i] = (E1) iter.next();
            }
            a[size] = null;
        }
        return old;
    }
    /*
    * Записывает данные в конец массива.
    * */
    @Override
    public boolean add(E e) {
        Elem<E> elem = new Elem<>();
        elem.setT(e);
        size++;

        if(first == null){
            first = elem;
            first.setNext(null);
            first.setPrevious(null);
            last = first;
            return true;
        }else{
            if(first.equals(last)){
                last = elem;
                first.setNext(last);
                last.setPrevious(first);
                last.setNext(null);
                return true;
            }
            elem.setPrevious(last);
            last.setNext(elem);
            last = elem;
        }
        return true;
    }
    /*
    * Удаляет переданный объект из массива если он есть.
    * */
    @Override
    public boolean remove(Object o) {
        if(isEmpty()){
            return false;
        }
        int index = containsIndex(o);
        if(index != -1){
            if(index == 0){
                if(first.getNext() == null){
                    first = null;
                    size--;
                    return true;
                }
                first = first.getNext();
                first.setPrevious(null);
                size--;
                return true;
            }
            if(index == size-1){
                last = last.getPrevious();
                last.setNext(null);
                size--;
                return true;
            }
            Elem e = getElem(index);
            e.getPrevious().setNext(e.getNext());
            e.getNext().setPrevious(e.getPrevious());
            size--;
            return true;

        }
        return false;
    }
    /*
    * Возвращает true если все элементы переданной коллекции,
    * присутствуют и в нашем массиве.
    * */
    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] obj = c.toArray();
        for(int i = 0; i < obj.length; i++){
            if(!contains(obj[i])){
                return false;
            }
        }
        return true;
    }
    /*
    * Добавляет все элементы переданной коллекции в конец.
    * */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c == null){
            throw new NullPointerException("param c == null");
        }
        Object obg[] = c.toArray();
        for(int i = 0; i < obg.length; i++){
            add((E)obg[i]);
        }
        return true;
    }
    /*
    * Добавляет все объекты переданной коллекции в место index.
     * */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object obg[] = c.toArray();
        for(int i = 0; i < obg.length; i++){
            add(index, (E)obg[i]);
            index++;
        }
        return true;
    }
    /*
    * Удаляет все элементы из массива, которые есть и в массиве
    * и в переданной коллекции.
    * */
    @Override
    public boolean removeAll(Collection<?> c) {
        Object obj[] = c.toArray();
        for(int i = 0;i < obj.length;i++){
            if(contains(obj[i])) {
                remove(obj[i]);
            }
        }
        return true;
    }
    /*
     * Удаляет все объекты из массива, которые присутствуют в массиве
     * и отсутствуют в переданной коллекции.
     * */
    @Override
    public boolean retainAll(Collection<?> c) {
            for (int i = 0; i < size; i++) {
                if(!c.contains(get(i))) {
                    remove(get(i));
                    i--;
                }
            }
        return true;
    }
    //очищает коллекцию
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    //Возвращает элемент по индексу
    @Override
    public E get(int index) {
        return getElem(index).getT();
    }
    /**
     * Помещает объект в определенное место.
     * @param index место в которое нужно поместить объект
     * @param element передаваемый объект
     * */
    @Override
    public E set(int index, E element) {
        E old = getElem(index).getT();
        getElem(index).setT(element);
        return old;
    }

    /**
     * Возвращает єкземпляр класса Elem
     * @see Elem
     * @param index индекс объекта
     *
     * @throws IndexOutOfBoundsException если index
     * меньше нуля или больше размера коллекции.
     * */
    private Elem<E> getElem(int index){
        if(isEmpty()){
            return null;
        }
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index <= size - index){
            Elem<E> now = first;
            for(int i = 0; i < index; i++){
                now = now.getNext();
            }
            return now;
        }else{
            Elem<E> now = last;
            for(int i = size - 1; i > index; i--){
                now = now.getPrevious();
            }
            return now;
        }
    }

    //Добавляет массив єлементов в конец.
    public void add(E[] e){
        for(int i = 0; i < e.length; i++){
            add(e[i]);
        }
    }
    //Добавляет массив єлементов в определенное место.
    public void add(int index, E[] e){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i < e.length; i++){
            add(index, e[i]);
            index++;
        }
    }
    /**
     * Добавляет объект в определенное место
     *
     * @param index индекс объекта
     * @param element передаваевый объект
     * @throws IndexOutOfBoundsException если index
     * меньше нуля или больше размера коллекции.
     * */
    @Override
    public void add(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Elem<E> elem = new Elem<>();
        elem.setT(element);
        size++;
        if(first == null){
            first = elem;
            first.setNext(null);
            first.setPrevious(null);
            last = first;
        }else{
            if(index <= size - index){
                Elem<E> now = first;
                for(int i = 0; i < index - 1; i++){
                    now = now.getNext();
                }
                elem.setPrevious(now.getPrevious());
                elem.setNext(now);
                if(now.getPrevious() != null) {
                    now.getPrevious().setNext(elem);
                }
                now.setPrevious(elem);
            }else{
                Elem<E> now = last;
                for(int i = size - 1; i > index + 1; i--){
                    now = now.getPrevious();
                }
                elem.setPrevious(now.getPrevious());
                elem.setNext(now);
                now.getPrevious().setNext(elem);
                now.setPrevious(elem);
            }
        }
    }
    /**
     * Удаляет объект по индексом index
     * @param index индекс объекта
     *
     * @throws IndexOutOfBoundsException если index
     * меньше нуля или больше размера коллекции.
     * */
    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Elem<E> rem = getElem(index);
        if(index == 0 && index == size-1){
            first = null;
            last = null;
            size--;
            return rem.getT();
        }
        if(index == 0){
            first = first.getNext();
            first.setPrevious(null);
            size--;
            return rem.getT();
        }
        if(index == size-1){
            last.getPrevious().setNext(null);
            last = last.getPrevious();
            size--;
            return rem.getT();
        }
        if(rem.getPrevious() == null){
            rem.getNext().setPrevious(null);
            return rem.getT();
        }
        rem.getPrevious().setNext(rem.getNext());
        rem.getNext().setPrevious(rem.getPrevious());
        size--;
        return rem.getT();

    }
    //Возвращает индекс первого вхождения объекта
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
    //Возвращает индекс последнего вхождения объекта
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--) {
                if (get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = size-1; i >= 0; i--) {
                if (o.equals(get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIter(index);
    }
    /**
     * Возвращает часть коллекции от fromIndex до to Index
     *
     * @throws IndexOutOfBoundsException
     * */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex >= size){
            throw new IndexOutOfBoundsException();
        }
        Arr<E> arr = new Arr<>();
        for(int i = fromIndex; i < toIndex; i++){
            arr.add(get(i));
        }
        return arr;
    }

    class Iter implements Iterator<E>{
        Elem cursor = first;
        Elem lastRet = null;// index of next element to return
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            if(cursor.getNext() != null) {
                cursor = cursor.getNext();
            }else{
                cursor = null;
            }
            return (E) lastRet.getT();
        }

        @Override
        public void remove() {
            Arr.this.remove(lastRet.getT());
        }
    }
    /*
    * class Iter implements Iterator<E>{
        int cursor = -1;       // index of next element to return
        @Override
        public boolean hasNext() {
            return cursor+1 < size;
        }

        @Override
        public E next() {
            cursor++;
            return get(cursor);
        }

        @Override
        public void remove() {
            Arr.this.remove(cursor);
            cursor--;
        }
    }
    * */
    class ListIter implements ListIterator<E>{
        ListIter(int index){
            if(index > size || index < 0){
                throw new IndexOutOfBoundsException();
            }
            next = first;
            for(int i = 0; i < index; i++){
                next = next.getNext();
            }
            if(next.getPrevious() != null){
                prev = next.getPrevious();
                last = prev;
            }
            this.index = index;
        }
        int index;
        Elem<E> next;
        Elem<E> prev;
        Elem<E> last;
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            prev = next;
            next = next.getNext();
            last = prev;
            return last.getT();
        }

        @Override
        public boolean hasPrevious() {
            return prev != null;
        }

        @Override
        public E previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            next = prev;
            prev = prev.getPrevious();
            last = next;
            index--;
            return last.getT();
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            if (last == null) {
                throw new NullPointerException();
            }
            Arr.this.remove(last.getT());
            if(prev != null) {
                if (prev.equals(last)) {
                    if(prev.getPrevious() != null){
                        prev = prev.getPrevious();
                    }else{
                        prev = null;
                    }
                    last = prev;
                    if(next != null){
                        next.setPrevious(prev);
                    }
                }
            }
            if(next != null){
                if(next == last){
                    if(next.getNext() != null) {
                        next = next.getNext();
                    }else{
                        next = null;
                    }
                    last = next;
                    if (prev != null) {
                        prev.setNext(next);
                    }
                }
            }
        }

        @Override
        public void set(E e) {
            last.setT(e);
        }

        @Override
        public void add(E e) {
            if(last.equals(prev)){

            }
        }
    }
    /**
     * Класс Elem хранит передаваемый объект,
     * а так же ссылки на следующий и предыдущий
     * объект в двусвязном списке.
     * */
    class Elem<E> {
        private Elem next;
        private Elem previous;
        private E t;

        public Elem(){
            next = null;
            previous = null;
        }

        public Elem(Elem next){
            this.next = next;
            this.previous = null;
        }

        public Elem getNext() {
            return next;
        }

        public void setNext(Elem next) {
            this.next = next;
        }

        public Elem getPrevious() {
            return previous;
        }

        public void setPrevious(Elem previous) {
            this.previous = previous;
        }
        public E getT() {
            return t;
        }

        public void setT(E t) {
            this.t = t;
        }
    }

}




/*class ListIter implements ListIterator<E>{
    ListIter(int index){
        next = index;
        prev = next - 1;
    }
    int next;
    int prev;
    int last;
    @Override
    public boolean hasNext() {
        return next < size;
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        prev = next;
        next++;
        last = prev;
        return get(prev);
    }

    @Override
    public boolean hasPrevious() {
        return prev > -1;
    }

    @Override
    public E previous() {
        if(!hasPrevious()){
            throw new NoSuchElementException();
        }
        next = prev;
        prev--;
        last = next;
        return get(next);
    }

    @Override
    public int nextIndex() {
        return next;
    }

    @Override
    public int previousIndex() {
        return prev;
    }

    @Override
    public void remove() {
        Arr.this.remove(last);
        if(last == prev){
            prev--;
            last--;
            next--;
        }
    }

    @Override
    public void set(E e) {
        Arr.this.set(last, e);
    }

    @Override
    public void add(E e) {
        Arr.this.add(last, e);
    }
}*/