public class Person {


private int age;
private String name;



public Person (String name1, int age1) {
name = name1;
age = age1;

}


public int getAge(){
return age;

}


public String getName(){
return name;
}

public void incrementAge(){
age++;
}


public String toString(){

return (name + " is " + age + " years old." );
}

}
