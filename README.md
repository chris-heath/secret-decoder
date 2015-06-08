# secret-decoder

A Secret encapsulates a function that accepts a single integer parameter and returns an integer.  Secret is a given but you don't know it's implementation. In Java or a language of your choice, write an application that determines if Secret is an additive function secret(x+y) = secret(x) + secret(y) for all combinations of prime numbers less than N where N is also given.


## Index

* [Assumptions](#assumptions)
* [How It Works](#how-it-works)
* [Contributors](#contributors)
* [Analysis](#analysis)

## Assumptions
Based on the stated problem, there are multiple way this can be interpreted.  Here are two that came to me:
* Assumption 1:  
  N is given,  
  x+y = N,  
  f(N) = f(x+y) = f(x) + f(y),  
  both x and y are prime numbers where x < N and y < N  
* Assumption 2:  
  N is given,  
  x+y can equal whatever (does not have to equal N),  
  f(x+y) = f(x) + f(y),  
  both x and y are prime numbers where x < N and y < N,   

## How It Works
### Command Line

Check out the secret-decoder git repo.  This is a Maven Eclipse project which can either be imported into Eclipse or compile/package via Maven directly from the trunk.

```bash
# clone git repo
git clone https://github.com/chris-heath/secret-decoder.git

# go to trunk 
cd secret-decoder

# compile and package jar
mvn compile package

## Test assumption 2 : Decoder2
java -jar target/SecretDecoder-0.0.1-SNAPSHOT-jar-with-dependencies.jar
Input value for N: 10
0 [main] INFO main.java.com.cheath.Decoder2  - N is 10.  There are 4 prime numbers less than 10
2 [main] INFO main.java.com.cheath.Decoder2  - ____________________________________
20 [main] INFO main.java.com.cheath.Decoder2  - shhh...decoding this secret.........
21 [main] INFO main.java.com.cheath.Decoder2  - psstt... Secret is an Additive function where f(x+y) = f(x) + f(y) for all prime numbers less than N

## Test assumption 1 : Decoder1
java -cp target/SecretDecoder-0.0.1-SNAPSHOT-jar-with-dependencies.jar main.java.com.cheath.Decoder1
Input value for N: 10
0 [main] INFO main.java.com.cheath.Decoder1  - secret(N) for N = 10 returns 10
2 [main] INFO main.java.com.cheath.Decoder1  - search depth for N is 5
17 [main] INFO main.java.com.cheath.Decoder1  - ____________________________________
17 [main] INFO main.java.com.cheath.Decoder1  - shhh...decoding this secret.........
18 [main] INFO main.java.com.cheath.Decoder1  - x+y=N where x and y are prime numbers 3 and 7
18 [main] INFO main.java.com.cheath.Decoder1  - x+y=N where x and y are prime numbers 5 and 5
18 [main] INFO main.java.com.cheath.Decoder1  - psstt... Secret is an Additive function where f(N) = f(x+y) = f(x) + f(y) for only all prime numbers less than N

```
## Analysis
For either of these two assumptions and implementations, the runtime performance becomes increasingly worse as N gets larger.  For large N values, there could be ways to speed things up by possibly taking advantage of multi-threading, or by using random sampling where our sample size is large enough to make a conclusion with high confidence.

I chose Java for this implementation simply because it was easiest for me to code in a small amount of time, and also because Java has a simple BitSet API which I used in my Sieve of Eratosthenes implementation.

## Contributors

* Chris Heath






