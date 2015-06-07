package main.java.com.cheath;

/**
 * Sample black box Secret which can be replaced with any other implementation
 * 
 * Note: Replacement secret must contain empty parameter constructor and a method called
 * secret which accept an integer and return an integer 
 *
 * @author cheath
 *
 */
public class Secret {
	public int secret(int value){
		return value;
	}
}
