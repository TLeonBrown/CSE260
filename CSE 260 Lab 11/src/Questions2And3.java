import java.util.*;

class Person {
	public enum Sex {MALE, FEMALE
	}
	
	String name;
	Date birthday;
	Sex gender;
	String emailAddress;
	int age;
	
	public Person(String name, Sex gender) {
		this.name = name;
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	public Sex getGender () {
		return gender;
	}
	
	
}
public class Questions2And3 {
		
	
	public static void trim (List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			String str = l.get(i);
			str.trim();
		}
	}
	
	

	
	public static void main (String [] args) {
		List<String> l = new ArrayList<String>();
		
		l.add("   e   ");
		trim(l);
		System.out.println(l);
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Fodor", Person.Sex.MALE));	
		people.add(new Person("Bachmair", Person.Sex.MALE));
		
		people.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE)
			.forEach(p -> System.out.println(p.getGender()));
	}

}
