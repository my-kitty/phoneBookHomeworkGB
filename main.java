// import javax.swing.text.AbstractDocument.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * main
 */
public class main {
	public static HashMap<String, List> hesh = new HashMap<>();
	public static Scanner input = new Scanner(System.in,"ibm866");


	public static void main(String[] args){
		// Сontact content = new Сontact();
		
		hesh.put("Дима", List.of(List.of("+7 (924) 345 19-95","+7 (924) 345 19-96"),"30.04.1995"));
		hesh.put("Оксана", List.of(List.of("+7 (924) 345 19-95"),"30.04.1995"));
		hesh.put("Кирилл", List.of(List.of("+7 (924) 345 19-95"),""));

		

		while (true) {
			System.out.print("Введите команду: ");
			String comand = input.nextLine();

			if (comand.equals("/help")){contactHelp();} // Справочник
			else if (comand.equals("/stop")) break; // Остоновить цыкл
			else if (comand.equals("/show")){
				//--------------------------------------
				comandShow();
			} // Просмотреть
			else if (comand.equals("/add")){  
				System.out.println(
				"\nДобовление нового контакта q(Завершить)\n" + 
				"----------------------------------");
				comandAdd();
			}  // Добавить
			else if (comand.equals("/adit")){
				System.out.println(
				"\nРедактирывание контакта q(Завершить)\n" + 
				"----------------------------------");
				comandAdd();
			} // Ридактирывать
			else if (comand.equals("/del")){
				System.out.println(
				"\nУдаление контакта q(Завершить)\n" + 
				"----------------------------------");
				comandRemove();
			}  // Удалить
			
			
			else { contactHelpError(); }
		}


	}

	// del
	public static void comandRemove(){

		System.out.print(" - > Имя контакта: ");
		String nema = input.nextLine();
		if (nema.equals("q")){
			System.out.println("---------------------------------- \n");
		} else if (hesh.containsKey(nema)){
			hesh.remove(nema);
			System.out.println(" Контакт "+ nema + " успешно удалён \n ---------------------------------- \n");
			comandRemove();
		} else {
			System.out.println(" Контактов с именем [ " + nema + " ]" +
			" не существует \n "+ 
			"---------------------------------- \n" );
			comandRemove();
		}

	}



	// show
	public static void comandShow(){

		// System.out.println(hesh);

		System.out.println(
			" Ведите Имя(контакти) или *(Все) или q(Завершить)\n"+ 
			" ----------------------------------");
		System.out.print(" -> Ввод: ");
		String kod = input.nextLine();
		if (kod.equals("q")){
			System.out.println("---------------------------------- \n");
		} else if (kod.equals("*")) {

			for (Entry<String, List> i : hesh.entrySet()) {
				System.out.println("\n Контакт: " + i.getKey());
				System.out.println("----------------------------------");
				
				List list = (List) i.getValue().get(0);
	
				for(int j = 0; j < list.size(); j++){
					System.out.println(" Телефон [" + (j + 1) +"]: " + list.get(j));
				}
				
				if(!i.getValue().get(1).equals("")){
					System.out.println(" День рождения: " + i.getValue().get(1));
				}
				System.out.println("---------------------------------- \n");
			}
			System.out.println();
			comandShow();
		} else if (hesh.containsKey(kod)){

			System.out.println("\n Контакт: " + kod);
			System.out.println("----------------------------------");
			List list2 = (List) hesh.get(kod).get(0);
			for(int j = 0; j < list2.size(); j++){
				System.out.println(" Телефон [" + (j + 1) +"]: " + list2.get(j));
			}

			if(!hesh.get(kod).get(1).equals("")){
				System.out.println(" День рождения: " + hesh.get(kod).get(1));
			}
			System.out.println("---------------------------------- \n");
			
			comandShow();
		} else {
			System.out.println(" Контактов с именем [ " + kod + " ]" +
			" не существует \n "+ 
			"---------------------------------- \n" );
			comandShow();
		}
		

	}
	

	// add
	@SuppressWarnings("unchecked")
	public static void comandAdd(){
		System.out.print(" -> Имя контакта: ");
		String name = input.nextLine();
		ArrayList phons = new ArrayList<>();

		int i = 0;

		while (true) {
			if(i%3 == 0 || i == 0){
				System.out.println(" Напоминание для завершение добовления \n номиров, введите символ q");
			}
			System.out.print(" -> Телефон: ");
			String stringPhons = input.nextLine();
			if (stringPhons.equals("q")){ break; }

			boolean bol = stringPhons.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{2}[- .]?\\d{2}$");
			if (bol){
				i++;
				phons.add(stringPhons);
			} else{
				System.out.println( 
				"\n Формат номера телефона введён неверно \n" +
				" Пример 1: +0 (000) 000 00-00 \n" +
				" Пример 2: +00000000000 \n" + 
				" Повторите попытку");
			}
		
		}

		String Birthday = "";
		while (true) {
			
			System.out.print(" -> День рождения: ");
			Birthday = input.nextLine();
			if (Birthday.equals("q")) {Birthday = "";break;}
			if(Birthday.matches("^\\d{1,2}[- .]\\d{1,2}[- .]\\d{2,4}$")){
				break;
			} else{
				System.out.println(
				" Формат даты указан неверно \n " +
				" Пример 00.00.0000 или 00-00-00 \n"+
				" Введите q чтобы не добовлять день рождение \n"+
				" Повторите попытку");
			}
		}

		hesh.put(name, List.of( phons,Birthday));
		System.out.println(
			"Контакт " + name + " успешно добавлен \n"+
			"----------------------------------"
		);
	}

	// help
	public static void contactHelp() {
		
		String string = "\n" + 
		"/help -> Справочник команд \n" +
		"/stop -> Завершить работу  \n" +
		"/show -> Просмотреть список контактов \n" +
		"/add  -> Добавить новый контакт \n" +
		"/adit -> Редактирывать контакт \n" +
		"/del  -> Удалить контакт \n";
		System.out.println(string);
	}






	// Друггие введённые символы
	public static void contactHelpError() {
		String string = "\n" +
		"Данной команды не существует \n" +
		"Воспользуйтесь командой /help \n";
		System.out.println(string);
	}


}