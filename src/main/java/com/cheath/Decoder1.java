package main.java.com.cheath;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import static main.java.com.cheath.PrimeNumberUtil.xyBothPrime;

/**
 * Decoder class that determines if a method, which is encapsulated within a Secret object, is an
 * Additive function where f(x+y) = f(x) + f(y) for all combinations of prime numbers less 
 * than a given N.
 * 
 * Assumption 1:  x+y = N, f(N) = f(x+y) = f(x) + f(y)
 * 
 * @author cheath
 *
 */
public class Decoder1 {
	private int limit;
	private Secret secret;
	static final Logger logger = Logger.getLogger(Decoder1.class);
	
	Decoder1(int input, Secret secret){
		this.limit = input;
		this.secret = secret;
	}
	
	private void run(){
		int returnValue = secret.secret(limit);
		int search_depth = (int) Math.ceil(limit/2);
		int xyValid = 0;
		Boolean isAdditiveFunction, bothPrime;
		
		logger.info("secret(N) for N = "+limit+" returns "+returnValue);
		logger.info("search depth for N is "+search_depth);
		logger.info("____________________________________");
		logger.info("shhh...decoding this secret.........");
		
		for(int i=1;i<=search_depth;i++){
			//logger.debug("checking x="+(limit-i) +" and y="+i);
			isAdditiveFunction = (returnValue == (secret.secret((limit-i))+secret.secret(i)));
			bothPrime = xyBothPrime(i,limit-i);
			if(!isAdditiveFunction && bothPrime){
				
			// If the Additive Function should only be true two prime numbers 
//			if((isAdditiveFunction && !bothPrime) || 
//					(!isAdditiveFunction && bothPrime)){
				
				logger.info("Secret is not an Additive function where f(N) "
						+ "= f(x+y) = f(x) + f(y) for all prime numbers less than N");
				return;
			}else if(bothPrime){
				logger.info("x+y=N where x and y are prime numbers "+i+" and "+(limit-i));
				xyValid++;
			}
		}
		
		if(xyValid > 0)
			logger.info("psstt... Secret is an Additive function where f(N) "
				+ "= f(x+y) = f(x) + f(y) for only all prime numbers less than N");
		else
			logger.info("psstt... There are no values for x and y where x+y=N and both are "
					+ "prime numbers less than N");
	}
		
	public static void main(String args[]){
		// basic configuration for log4j
		BasicConfigurator.configure();
		
		try{
			if(args.length < 1){
			}
			int input = Integer.parseInt(args[0]);
			
			if(3 > input){
				// we're assuming the input is a natural number greater than 2 since it is the first prime
				logger.error("Input value is not a natural number greater than 2.");
			}
			else{
				Secret secret = new Secret();
				Decoder1 secretDecoder = new Decoder1(input, secret);
				secretDecoder.run();
			}
		}catch (ArrayIndexOutOfBoundsException e){
			logger.info("Input value was not supplied.");
		}catch(NumberFormatException e){
			logger.error("Input value is not an integer");
		}catch (Exception e){
			logger.error("Wow, this secret was too tough for us to crack!", e);
		}
	}
}
