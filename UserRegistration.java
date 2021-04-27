package com.regularexpression;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserRegistrationProgram {
	// UC-1: validating FirstName and if patten matches method returns true otherwise it returns false.
	public static boolean validateFirstName(String firstName) {
		return Pattern.matches("^[A-Z]{1}[a-z]{2,}", firstName);
	}
    
	// UC-2: validating LastName if patten matches method returns true otherwise it returns false.
	public static boolean validateLastName(String lastName) {
		return Pattern.matches("^[A-Z]{1}[a-z]{2,}", lastName);
	}
    
	// UC-3 & 9: validating Email
	public static String validateEmail(String email) {
		if(Pattern.matches("^(?!\\.)[A-Za-z0-9]+([._%+-]?[0-9])*@[A-Za-z0-9-]+\\.[a-zA-Z]{2,}(\\.[A-Za-z]{2,})?$",email)) {
		     return "valid";
		}
		else {
		     return "invalid";
		}
	}
    
	// UC-4:User's Phone Number Country Code should start with 91.and Phone-Number has at least 10 numbers.
	public static boolean validatePhoneNumber(String phoneNumber) {
		return Pattern.matches("^[91]{2}[0-9]{10}",phoneNumber);
	}
    
	// UC-5: validating password
	public static boolean validatePassWord(String passWord) {
         // Rules: minimum 8 characters ,at least 1 upper-case , at least 1 numeric,at least 1 special char.
	     return Pattern.matches("(?=.[A-Z])(?=.[a-z])(?=.[0-9])(?=.[-+!@#$%^&*()]).{8,}", passWord);
	}
    
	//UC-6: All types of email
	//adding email to array-list 
	public static void addToEmailList(String emails) {
		//  Add  email data here.So In generics String has taken.Now arrayList Object can accepts only String data.
		ArrayList<String> email = new ArrayList<String>();
		// add is a default method in an ArrayList and used to add elements to the ArrayList.
                email.add(emails);
                // size() method returns total number of emails present inside the ArrayList.
		for(int i=0;i<email.size();i++) {
			System.out.println(email.get(i)+": "+validateEmail(email.get(i)));
		}
	}
    
	//Main method
	public static void main(String[] args) {
		String firstName = "Vinay";
		String lastName = "Naik";
		long phoneNumber = 9591626394L;
		String passWord = "Anap9P#lesL@d65ef";
                //validateFirstName is a static method.. so can call directly from main method.Object creation is not needed.
		System.out.println("First name: "+validateFirstName(firstName));
		//validateLastName is a static method.. so can call directly from main method.Object creation is not needed.
		System.out.println("Last name: "+validateLastName(lastName));
                //validatePhoneNumber is a static method.. so can call directly from main method.Object creation is not needed.
		System.out.println("phone numbar: "+validatePhoneNumber(Long.toString(phoneNumber)));
		//validatePassword is a static method.. so can call directly from main method.Object creation is not needed.
		System.out.println("password: "+validatePassWord(passWord));

		//valid emails
		addToEmailList("abc@gmail.com");
		addToEmailList("abc-100@gmail.com");
		addToEmailList("abc.100@gmail.com");
		addToEmailList("abc-100@Abc.com");
		addToEmailList("abc-100@Abc.net");
		addToEmailList("abc.100@Abc.com.au");
		addToEmailList("abc@1.com");
		addToEmailList("abc@gmail.com.com");
		addToEmailList("abc+100@yahoo.com");
        
		//invalid emails
		addToEmailList("abc@.com.my");
		addToEmailList("abc123@gmail.a");
		addToEmailList("abc123@.com");
		addToEmailList("abc123@.com.com");
		addToEmailList(".abc@Abc.com");
		addToEmailList("abc()*@gmail.com");
		addToEmailList("abc@%*.com");
		addToEmailList("abc..2002@gmail.com");
		addToEmailList("abc.@gmail.com");
		addToEmailList("abc@abc@gmail.com");
		addToEmailList("abc@gmail.com.1a");
   }
}
