package lambdas;

public class BasicLambdas {

  public static void main(String[] args){

    // pre Java 8
    I i = new I() {
      @Override
      public void m() {
        System.out.println("I::m()");
      }
    };

    i.m();

    I lambdaI = () -> {
      System.out.println("Lambda version");
    };
    I lambdaI2 = () -> System.out.println("Lambda version2");
    lambdaI.m();
    lambdaI2.m();
  }
}
