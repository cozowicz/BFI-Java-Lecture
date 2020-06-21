/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit1;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Clemens Klee<br>
 * Erstellt am 22.02.2006<br>
 * Version 1.0
 */
public class ToDoList {
	private ToDo[] todos = new ToDo[100];
	private int anzToDos = 0;
	
	public boolean addToDo(ToDo t){
		if(anzToDos < todos.length){
			todos[anzToDos]=t;
			anzToDos++;
				return true;
		}
		else{
			return false;
		}
	}
	
	public boolean removeToDo(String aufgabe){
		for(int i = 0;i<anzToDos;i++){
			if(todos[i].getAufgabe().equalsIgnoreCase(aufgabe)){
				todos[i] = null;
				for(int j = i;j<anzToDos;j++){
					todos[j]=todos[j+1];
				}
				anzToDos--;
				return true;
			}
		}
		return false;
	}
	
	public void printToDo(int day, int month, int year){
		GregorianCalendar cal = new GregorianCalendar(year,month-1,day);
		Date d = cal.getTime();
		boolean found = false;
		
		for(int i = 0;i<anzToDos;i++){
			if(todos[i].getFaelligkeitsdatum().compareTo(d) == 0){
				todos[i].print();
				System.out.println();
				found = true;
			}
		}
		if(found == false){
			System.out.println("Kein ToDo am "+day+"."+month+"."+year+" fällig");
		}
	}
	
	public void faelligafter(int day, int month, int year){
		GregorianCalendar cal = new GregorianCalendar(year,month-1,day);
		
		System.out.println("Fällig nach dem "+day+"."+month+"."+year+":");
		boolean found = false;
		for(int i = 0;i< anzToDos;i++){
			if(todos[i].getFaelligkeitsdatum().after(cal.getTime())){
				todos[i].print();
				System.out.println();
				found = true;
			}
		}
		if(found = false){
			System.out.println("Nach dem "+day+"."+month+"."+year+" sind keine ToDo's fällig");
		}
	}
	
	public void printList(){
		System.out.println("ToDo's");
		System.out.println("----------------------");
		for(int i = 0;i<anzToDos;i++){
			todos[i].print();
			System.out.println();
		}
	}
}
