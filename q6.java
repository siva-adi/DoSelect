package doselect_prob_6;

public class Credentials {
	String userName;
	String password;
public Credentials(String userName,String password)
{
	this.userName = userName;
	this.password=password;
	
}
}
package doselect_prob_6;

public class LengthMismatchException extends Exception{
	public LengthMismatchException(String str) {
		super(str);
	}

}
package doselect_prob_6;

public class MissingCharacterException extends Exception{
	public MissingCharacterException(String str) {
		super(str);
	}

}
package doselect_prob_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Implementation {
	public String passwordValidator(Credentials details) throws MissingCharacterException,LengthMismatchException{
		 String passcheck ="^(?=.*[0-9])"
                 + "(?=.*[a-z])(?=.*[A-Z])"
                 + "(?=.*[@#$%^&+=])"
                 + "(?=\\S+$).{8,20}$";
		 Pattern p = Pattern.compile(passcheck);
		 Matcher m = p.matcher(details.password);
		 boolean n = m.matches();
			if(!n) {
				throw new MissingCharacterException("password must contain at least one special character, at least one upper case alphabet, at least one lower case alphabet, and at least one digit ");
			}
			else if( details.password.length() < 8 ||  details.password.length() >40)
			{
				throw new LengthMismatchException("length of the password is not between 8 to 40");
			}
			else
				return "valid password";
		
		
	}
	public String signUp(Credentials details) throws Exception{
		
		try {
			passwordValidator(details);
			
		}
		catch(MissingCharacterException  e1)
		{
			return "invalid password" ;
		}
		catch(LengthMismatchException  e2)
		{
			return "invalid password" ;
		}
		catch(Exception e3)
		{
			return "other exception" ;
		}
		return	"signup successfully";
		
		
		
	}
    

}
package doselect_prob_6;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Implementation obj = new Implementation();
		String out= obj.passwordValidator(new Credentials("Steve", "Akjsdhhj@1"));
		String out1=obj.signUp(new Credentials("Bob", "jsdhJS12*&$1"));
         System.out.println(out);
         System.out.println(out1);
		
	}

}
