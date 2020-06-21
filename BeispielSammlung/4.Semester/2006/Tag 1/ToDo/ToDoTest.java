/**
 * 
 */
package fh_vie.ac.at.Vorbereitung.Einheit1;

/**
 * @author Clemens Klee<br>
 * Erstellt am 22.02.2006<br>
 * Version 1.0
 */
public class ToDoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToDo t = new ToDo("ToDo-Bsp implementieren",22,2,2006);
		//t.print();
		ToDoList todos = new ToDoList();
		todos.addToDo(t);
		todos.addToDo(new ToDo("ToDo-Bsp testen",23,2,2006));
		todos.addToDo(new ToDo("ToDo-Bsp einchecken",24,2,2006));
		//todos.removeToDo("todo-bsp testen");
		//todos.printToDo(22,2,2006);
		//todos.faelligafter(22,2,2006);
		todos.printList();
		
	}

}
