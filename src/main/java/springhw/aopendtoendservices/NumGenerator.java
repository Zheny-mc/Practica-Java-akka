package springhw.aopendtoendservices;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("idNumGen")
public class NumGenerator {
	Random r = new Random();
		
	public double getSqrtSum() {
		double f=0; int x=0, n=5, s=3, time=1;
		for (int i=0; i<s;i++) {
			try {Thread.sleep(time);} catch (InterruptedException e) {}
			x=r.nextInt(n);		
			if (x<=0) throw new ArithmeticException ("Neg root expression");
		    f=f+Math.sqrt(x);		 
		} return f;
}}