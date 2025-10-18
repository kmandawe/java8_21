package lvti;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTypeInference {

//  var z = 3;  // not allowed
//  static var a =3;  // not allowed

  { // init block
    var d = 4.5;
    d = 98.9;
//    d = "sss" // type cannot change
//    var x; // these 2 lines statment
//    x = 2; // needs to be one statement
  }

//  LocalVariableTypeInference(var x) { // not allowed
//
//  }

  LocalVariableTypeInference() {
    var i = 9;

//    var j = null; // null w/o cast not allowed
    var s = (String) null; // w/ casting will work
  }

  public static void main(String[] args){
    var x = 2;
    var y = 3.2;
    var t = "abc";

    m(1);
  }

//  public static void m(var x) {} // onot allowed

  public static void m(int x) {
    int a = 3, b = 4;
//    var c = 3, d = 4;
    var var = 9;

    List<String> ls = new ArrayList<>();
    ls.add("a");
    ls.add("b");
    ls.add("c");
    ls.removeIf( (var s) -> s.equals("a"));
    System.out.println(ls);
  }
}

//class var {}  // not allowed
//enum var {}   // not allowed
//interface var {}  // not allowed
