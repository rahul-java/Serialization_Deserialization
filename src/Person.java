import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * JVM assign a serialVersionUID to the .class file
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	String email;
	String pwd;
	//transient String pwd;
	
	//transient will not participate in serialization 
	//it will ignore the pwd . it sensitive data that why it is declare as a transient
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
	}




	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
	 Person person = new Person();
	 person.id=10;
	 person.name="Raju";
	 person.email="raju@gmail.com";
	 person.pwd="raju@123";
	 
	 //the process of converting java object into file is called serialization
	 //the process of converting java object into bits and bytes and store into a file is called serialization
	 
	 System.out.println("===========Serialization Started================");
	 
	//FileOutputStream  fos=new FileOutputStream("person.ser");
	FileOutputStream  fos=new FileOutputStream("person.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(person);
	oos.flush();
	oos.close();
	
	 System.out.println("===========Serialization Closed================");
	 
	 
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	//the process of converting file data into java object is called De-serialization
	 
	 System.out.println("===========De-Serialization Started================");
	 
	 FileInputStream fis = new FileInputStream("person.txt");
	 ObjectInputStream ois = new ObjectInputStream(fis);
	Person p=(Person)ois.readObject();
	ois.close();
	
	System.out.println(p.id +" ::: "+p.name);
	System.out.println(p);  //Person [id=10, name=Raju, email=raju@gmail.com, pwd=raju@123]
	 
	 System.out.println("===========De-Serialization Closed================");
	
	}
}
