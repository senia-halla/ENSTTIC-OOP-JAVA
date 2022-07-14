import java.lang.*;
import java.text.ParseException;
class Person{
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName){
		setFirstName(firstName);
		setLastName(lastName);
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public void setAge(int age) throws IllegalArgumentException{
		if(age<15){
			throw new IllegalArgumentException("Interdit au moins de 15 ans");
		}
		this.age = age;
	}

	public void setAge(String value) throws ParseException, IllegalArgumentException{
		try{
			int age = Integer.parseInt(value);
			setAge(age);
		} catch(NumberFormatException e){
			throw new ParseException("La valeur fournie est invalide", 28/*ligne dans laquel l'erreur a eu lieu*/);
		}
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}
	
	public int getAge(){
		return age;
	}	

	public String toString(){
		//StringBuilder permet de construire une chaine de caractere
		//constructeur de chaine de caractere 
		StringBuilder sb = new StringBuilder();

		sb.append("Prenom : "+getFirstName()+"\n");
		sb.append("Nom : "+getLastName()+"\n");
		sb.append("Age : "+getAge()+"\n");
		
		return sb.toString();
	}
}

public class PersonDriverException{
	public static void main(String[] args){
		Person person = new Person("Halla","Senia");

		try{

			person.setAge("13");
			System.out.println(person);

		} catch(IllegalArgumentException e){

			//System.out.println(e.getMessage());
			System.err.println(e.getMessage());

		}catch(ParseException e){

			System.err.println(e.getMessage());

		}

		// multi-catch 
		try{

			person.setAge("13");
			System.out.println(person);

		} catch(IllegalArgumentException | ParseException e){

			System.err.println(e.getMessage());

		}
	}
}