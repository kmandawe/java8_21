import instance_main.HelloWorld;
import instance_main.Other;

int x = 5;

void main(){
  System.out.println( "Hello! From unnamed class!!!");
  showX();
  new Other().test();
}
void showX(){
  System.out.println(x);
}

class SomeOtherClass{
}
