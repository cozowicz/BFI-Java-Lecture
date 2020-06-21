/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit3;
import java.util.*;

/**
 * @author Clemens Klee<br>
 * Erstellt am 16.03.2006<br>
 * Version 1.0
 */
public class DVDRekorder {
	private int maxkapinmin;
	//private ArrayList sendungen;
	private ArrayList<Sendung> sendungen;
	public DVDRekorder(int maxkapinmin){
		this.maxkapinmin = maxkapinmin;
		//sendungen = new ArrayList(maxkapinmin);
		sendungen = new ArrayList<Sendung>(maxkapinmin);
	}
	
	public void addSendung(Sendung s){
		int beginZeitinMinuten = s.getBeginStunde()*60+s.getBeginMinute();
		int endzeitinMinuten = s.getEndStunde()*60+s.getEndMinute();
		
		boolean overlap = false;
		
		for(Sendung s1 : sendungen){
			
			int s1_beginZeitinMinuten = s1.getBeginStunde()*60+s1.getBeginMinute();
			int s1_endZeitinMinuten = s1.getEndStunde()*60+s1.getEndMinute();
			
			if((beginZeitinMinuten >= s1_beginZeitinMinuten && 
					beginZeitinMinuten <= s1_endZeitinMinuten)||
					endzeitinMinuten>=s1_beginZeitinMinuten && 
					endzeitinMinuten<=s1_endZeitinMinuten){
				overlap = true;
				}
			}
		
		if(overlap == false && s.getDauer()<(maxkapinmin-getDauer())){
				sendungen.add(s);
		}
	}
	
	public int getDauer(){
		int dauer=0;
		
		for(Sendung s : sendungen){
			dauer = dauer + s.getDauer();
		}
		return dauer;
	}
	
	public void insertSendung(Sendung s,int index){
		sendungen.add(index,s);
	}
	
	public void print(){
		//for(int i = 0;i<sendungen.size();i++){
			//Sendung s = (Sendung)sendungen.get(i);
			//Sendung s = sendungen.get(i);
//			if(s instanceof Film){
//				Film f = (Film)s;
//				System.out.println("Titel: "+f.getTitel()+", Dauer: "+f.getDauer()+", Darsteller: "+f.getHauptdarsteller());
//				
//			}
//			else{
//				System.out.println("Titel: "+s.getTitel()+", Dauer: "+s.getDauer());
//			}
//		}
		//falls mit Generics, sonst obiges verwenden
		for(Sendung s : sendungen){
			System.out.println(s.toString());
		}
	}
}
