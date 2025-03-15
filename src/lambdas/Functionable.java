package lambdas;

public interface Functionable<T, R> {
  public R apply(T t);
}
