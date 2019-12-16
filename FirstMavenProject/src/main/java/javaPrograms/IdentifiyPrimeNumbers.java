package javaPrograms;

public class IdentifiyPrimeNumbers {

	public static void main(String[] args) {
		
	//int n = 29; 
	int j = 0;
	//int k = 1;
	
	for(int n=3; n<=100; n++) {
		
		//k=n;
	
		for(int i = 1; i<=n/2;i++) {
			if(n % i==0) {
			System.out.println();
			}
			else {
				System.out.println("Is a Prime Number " + n);
				break;
		}
		
		}
	}	
	}
}

