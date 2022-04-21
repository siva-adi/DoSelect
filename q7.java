package assignments;
class Person{
	String name;
	String dateOfBirth;
	String email;
	public Person(String name, String dateOfBirth, String email){
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
	}
}
class Implementation3{
	public String validator(Person details)throws Exception{
		String[] s = details.dateOfBirth.split("-");
		if(Integer.parseInt(s[0])>2000 || Integer.parseInt(s[2])>2000)
			throw new InvalidDateException("date year must be less than 2000");
		String domainName= details.email.substring(details.email.indexOf('@'));
		if (!(domainName.equals("@doselect.com")))
			throw new InvalidEmailException("only @doselect.com domail email are accepted");
		return("valid details");
			
	}
	public String submitDetails(Person details)  {
		try {
		validator(details);
		}
		catch(InvalidDateException|InvalidEmailException e) {
			return("invalid details");
		}
		catch(Exception e) {
		return("other exception");
		}
		return("details submitted successfully");
	}
}
class InvalidDateException extends Exception{
	public InvalidDateException(String str) {
		super(str);
		System.out.println(str);
	}
}
class InvalidEmailException extends Exception{
	public InvalidEmailException(String str) {
		super(str);
		System.out.println(str);
	}
}
public class question7 {
	public static void main(String[] args) {
	Person data = new Person("Steve","12-02-1998","Steve12@doselect.com");
	Implementation3 obj = new Implementation3();
	try {
		String str = obj.validator(data);
		System.out.println(str);}
	catch(Exception e) {
		
	}
	String str1 = obj.submitDetails(data);
	System.out.println(str1);
	
}
}
