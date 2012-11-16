package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/*Klauzula jest w postaci Horna wtedy i tylko wte-
*dy, gdy co najwy¿ej jeden litera³ w tej klauzuli jest pozytywny (niezanegowany).
*
*Wszystkim zmiennym ustalamy fa³sz/
*reprezentacja formul
*reprezentacja bazy wiedzy
*reprezentacja tagowania
*
*a ^ b -> c 
*T -> a
*T -> b
*c -> T   ?C
*/
import java.util.HashMap;


//zbior nazw zmiennych (prawda, falsz, q , r )....


public class Main {

	//wypisanie listy klauzul
			static private void wypiszK(ArrayList<String> arrayList){
			      if (arrayList.isEmpty() == true){
			      System.out.println("zbior kluzul jest pusty");
			      }
			      else{
			          for (int i = 0; i<arrayList.size(); i++){
			        	  System.out.println("k("+i+")" +arrayList.get(i)+"");
			          }
			          }

			  }

			//wypisanie listy klauzul
			static private String getK(ArrayList<String> arrayList){
				String k ="";
			      if (arrayList.isEmpty() == true){
			      System.out.println("");
			      }
			      else{
			          for (int i = 0; i<arrayList.size(); i++){
			        	  k = arrayList.get(i);
			          }
			          }
			      return k;
			  }
		
			//sprawdzanie listy klauzul
			static private boolean sprawdzK( ArrayList<String> arrayList, int tag ){
			    boolean status = false;
			    
				if (arrayList.isEmpty() == true){
			      return status;
			      }
			      else{
			          for (int i = 0; i<arrayList.size(); i++){
			        	  if ( tag == 1){
			        		  status = true;
			        	  }
			        	  else{
			        		  status = false;
			        	  }
			          }
			          }
return status;
			  }
			  
			
			
	public static void main( String args[]){
		
		Klauzule k1 = new Klauzule();
		Klauzule k2 = new Klauzule();
		Klauzule k3 = new Klauzule();
		Klauzule k4 = new Klauzule();
		Klauzule k5 = new Klauzule();
		
		//t
		k1.wynik ="t";
		k1.tag = 0;
		//s
		k2.wynik ="s";
		k2.tag = 0;
		//q->t
		k3.wynik ="q";
		k3.war_list.add("t");
		k3.tag = 0;
		//r->s
		k4.wynik ="r";
		k4.war_list.add("s");
		k4.tag = 0;
		//p->q,r
		k5.wynik ="p";
		k5.war_list.add("q");
		k5.war_list.add("r");
		k5.tag = 0;
		
		
		// baza wiedzy
		HashMap<String, Klauzule> hm = new HashMap();
		
		hm.put(k1.wynik, k1);
		hm.put(k2.wynik, k2);
		hm.put(k3.wynik, k3);
		hm.put(k4.wynik, k4);
		hm.put(k5.wynik, k5);
		// Get a set of the entries
		Set set = hm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
		// Display elements
		while(i.hasNext()) {
		Map.Entry me = (Map.Entry)i.next();
		} 
		
		System.out.println("== Baza wiedzy == ");
		String tmp_k = null;
		boolean spelnialne = false;
		int licznik_tag = 0;
		
		for(Klauzule k:hm.values())
		{
		
		  //System.out.println("Wynik: "+k.getWynik() +" Klauzula:  "+k.getWar_list()+ " TAG: " + k.getTag());
		 
		 //!krok 1 oznaczamy spe³nione struktury, z pust¹ list¹ warunków, zmieniamy tag na 1
		  if(k.getWar_list().isEmpty()){
			  k.setTag(1);	  
		  }
	
		  wypiszK(k.getWar_list());
		  
		  tmp_k = getK(k.getWar_list());
		 
		  //!krok 2 jezeli lista klauzul jest otagowana, to otaguj wynik 1
		  if(!(k.getWar_list().isEmpty())){
			  if(sprawdzK(k.getWar_list(), hm.get(tmp_k).tag)==true){
				  k.setTag(1);
			  }
			  else{
				  System.out.println("FA£SZ");
			  }

		  }
		  System.out.println("Wynik: "+k.getWynik() +" Klauzula:  "+k.getWar_list()+ " TAG: " + k.getTag());
		 
		 if(k.getTag() == 1){licznik_tag++;}
		 
		}
		
		//!krok 3 podaj wynik
		if(licznik_tag == hm.size()){
			System.out.println("spe³nialna");
		}else{System.out.println("niespe³nialna");}
	

		
		
		
		
		
	}

	
		  


}


