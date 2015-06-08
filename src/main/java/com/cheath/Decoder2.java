package main.java.com.cheath;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import static main.java.com.cheath.PrimeNumberUtil.getPrimesUnderN;

/**
 * Decoder class that determines if a method, which is encapsulated within a Secret object, is an
 * Additive function where f(x+y) = f(x) + f(y) for all combinations of prime numbers less 
 * than a given N.
 * 
 * Assumption 2:  x+y does not have to equal N, x < N, y < N
 * 
 * @author cheath
 *
 */
public class Decoder2 {
	private int limit;
	private Secret secret;
	static final Logger logger = Logger.getLogger(Decoder2.class);
	
	Decoder2(int input, Secret secret){
		this.limit = input;
		this.secret = secret;
	}
	
	private void run(){
		Boolean isAdditiveFunction;
		int x, y;
		
		List<Integer> primesUnderN = getPrimesUnderN(limit);//Arrays.asList(2,3,5,7,13);
		
		logger.info("N is "+limit+".  There "+(primesUnderN.size()==1?"is ":"are ")+primesUnderN.size()+ 
				" prime number"+(primesUnderN.size()==1?"":"s")+" less than "+limit);
		
		logger.info("____________________________________");
		logger.info("shhh...decoding this secret.........");
		
		for(int i=0;i<primesUnderN.size();i++){
			x=primesUnderN.get(i);
			for(int j=i;j<primesUnderN.size();j++){
				y=primesUnderN.get(j);
				//logger.info("checking x="+x+" and y="+y);
				isAdditiveFunction = (secret.secret(x+y) == (secret.secret(x)+secret.secret(y)));
				
				if(!isAdditiveFunction){
					logger.info("Secret is not an Additive function where "
							+ "f(x+y) = f(x) + f(y) for all prime numbers less than N = "+limit);
					return;
				}
			}
		}
		logger.info("psstt... Secret is an Additive function where "
				+ "f(x+y) = f(x) + f(y) for all prime numbers less than N");
	}
	
	public static void main(String args[]){
		// basic configuration for log4j
		BasicConfigurator.configure();
		
		try{
			System.out.print("Input value for N: ");
			int input = Integer.parseInt(new Scanner(System.in).next());
			
			if(3 > input){
				// we're assuming the input is a natural number greater than 2 since it is the first prime
				logger.error("Input value is not a natural number greater than 2.");
			}
			else{
				Secret secret = new Secret();
				Decoder2 secretDecoder = new Decoder2(input, secret);
				secretDecoder.run();
			}
		}catch (ArrayIndexOutOfBoundsException e){
			logger.info("Input value was not supplied.");
		}catch(NumberFormatException e){
			logger.error("Input value is not an integer.");
		}catch (Exception e){
			logger.error("Wow, this secret was too tough for us to crack!", e);
		}
	}
}
