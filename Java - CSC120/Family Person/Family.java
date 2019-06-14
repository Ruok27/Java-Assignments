public class Family {
//======================================================================================
private Person[] People;
private int numberOfPeople;


//---------------------------------------------------------------------------------------
public Family(){
numberOfPeople = 0;
People = new Person[10];
}

//---------------------------------------------------------------------------------------
public int getNumberOfPeople(){
return numberOfPeople;
}

//---------------------------------------------------------------------------------------
public boolean addPerson(String name, int age){

if (numberOfPeople < 10) {

People[numberOfPeople] = new Person(name, age);
numberOfPeople++;
return true;
} else
 return false;
}
//---------------------------------------------------------------------------------------
public void birthday(String name){

for (int index = 0; index < numberOfPeople; index++)

if (name.equals(People[index].getName()))
People[index].incrementAge();
}
//---------------------------------------------------------------------------------------
public int getTotalAge(){

int totalAge = 0;


for (int i = 0;  i < numberOfPeople; i++){
totalAge +=  People[i].getAge();

}

return totalAge;


}
//---------------------------------------------------------------------------------------

public void display(){
for (int i = 0; i < numberOfPeople; i++){
System.out.println(People[i]);

}


}




}



