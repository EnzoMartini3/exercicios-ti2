package exercicio01;

import java.util.*;

class somardoisnumero {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int n1,n2,soma;
		
		//ler variaveis
		System.out.println("Digite um numero");
		n1=sc.nextInt();
		System.out.println("Digite outro numero");
		n2=sc.nextInt();

		//somar
		soma=n1+n2;
		
		//mostrar soma
		System.out.println("Soma:"+ soma);
	}

}
