package modul10n2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
		//Feu una matriu que contingui algunes cadenes de text y numeros
		List<String> llistaMixta = Arrays.asList("Hola", "vamos alla", "Com estem", "2", "33", "855", "8", "6", "5648", "7", "Eoeoe", "Eoeoa");
		
		//Ordeneu-lo per: longitud (de més curta a més llarga) 
		
		Collections.sort(llistaMixta, (s1, s2) -> s1.length() - s2.length());
		
		System.out.println("De més curta a més llarga " + llistaMixta);
		
		//longitud inversa (de  més llarga a més curta) 
		
		Collections.sort(llistaMixta, (s1, s2) -> s2.length() - s1.length());
		
		System.out.println("De més llarga a més curta " + llistaMixta);
		
		//alfabèticament
		
		Collections.sort(llistaMixta, (s1, s2) -> s1.compareTo(s2));
		
		System.out.println("Ordre alfabètic " + llistaMixta);
		
		//Les cadenes que contenen "e" primer, tota la resta en segon lloc
		
		ArrayList<String> llista2 = ordenarCondicional(llistaMixta, s -> s.contains("e"));
		
		System.out.println("Primer strings que continguin la e " + llista2);
		
		//Modifica tots els elements de la matriu per canviar els caracters “a” a “4” 
		
		ArrayList<String> llista3 = new ArrayList();
		
		llistaMixta.forEach(s -> {
			llista3.add(s.replace("a", "4"));
		});
		System.out.println("Les as son 4s " + llista3);
		
		//Mostra només els elements que siguin 100% numerics
		
		ArrayList<String> llista4 = new ArrayList();
		
		llistaMixta.forEach(s -> {
			try {
				Integer.parseInt(s);
				llista4.add(s);
				
			}catch (NumberFormatException e) {
				
			}
			
		});
		System.out.println("només 100% numèrics " + llista4);
		
		/*Crea una Functional Interface que continga un mètode abstracte operacio (), 
		 * que retorne un valor float; injecta a la interfície creada mitjançant una lambda el cos del mètode, 
		 * de manera que pugis transformar la operació a una suma, resta, multiplicació i divisio. */
		
		OperacioLambda op = (num1, num2) -> num1 * num2;
		
		System.out.println(op.operacio(1f, 3.4f));
		
		op = (num1, num2) -> num1 / num2;
		
		System.out.println(op.operacio(4f, 2f));
		
		op = (num1, num2) -> num1 + num2;
		
		System.out.println(op.operacio(4f, 2f));
		
		op = (num1, num2) -> num1 - num2;
		
		System.out.println(op.operacio(4f, 2f));

	}
	
	private static ArrayList<String> ordenarCondicional(List<String> llista, Predicate<String> pred) {
		ArrayList<String> llistaAux = new ArrayList<>(llista);
		ArrayList<String> llista2 = new ArrayList();
		//ArrayList<Foo> newList = new ArrayList<>(srcCollection);
		for (String s:llista) {
			if(pred.test(s)){
				llista2.add(s);
				llistaAux.remove(llistaAux.indexOf(s));
			}
		}
		
		llista2.addAll(llistaAux);
		return llista2;
	}

}
