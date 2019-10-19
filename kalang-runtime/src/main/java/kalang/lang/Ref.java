package kalang.lang;

/**
 * @author KasonYang
 */
public class Ref<T> {

    private T value;

    public Ref() {
    }

    public Ref(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

}
