package text;
/**
 * Класс Type - от класса Type наследуются
 * все классы для работы с текстом.
 *
 * @author Ekros
 * @version 1.0 23.02.2019;
 * */
abstract class Type {
    //Тип содержимого
    protected final int SUMBOL = 0;
    protected final int WORD = 1;
    protected final int LINE = 2;
    protected final int TEXT = 3;
    protected abstract String get();
    /**
     * Возвращает тип содержимого
     * */
    protected abstract int getType();
}
