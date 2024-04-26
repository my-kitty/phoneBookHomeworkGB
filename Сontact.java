import java.util.ArrayList;
import java.util.List;



public class Сontact {
	private String name;
	private List<String> phons = new ArrayList<>();
	private String birthday;



	public void setName(String name){ this.name = name;	}
	public void setPhons(List<String> phons){	this.phons = phons;	}
	public void setBirthday(String birthday){	this.birthday = birthday;	}

	public void setPhoneBook(
		String name,
		List<String> phons,
		String birthday
	 ){
		this.name = name;
		this.phons = phons;
		this.birthday = birthday;
	}

	public String contactName(){
		return this.name;
	}


	public String listParamsContat(){
		return 
		"name:" + name + "|" +
		"phons:" + phons + "|" +
		"birthday:" + birthday + "\n";
	}

	// public List contactAdd(){
	// 	return 
	// }

	public void contactHelp() {
		
		String string = "\n" + 
		"/help -> Справочник команд \n" +
		"/stop -> Завершить работу  \n" +
		"/show -> Просмотреть список контактов \n" +
		"/add  -> Добавить новый контакт \n" +
		"/adit -> Редактирывать контакт \n" +
		"/del  -> Удалить контакт \n" +
		"/read -> Чтение из файла \n" +
		"/save -> Сохранить контакты в фаил \n";
		System.out.println(string);

	}

	public void contactHelpError() {
		String string = "\n" +
		"Данной команды не существует \n" +
		"Воспользуйтесь командой /help \n";
		System.out.println(string);
	}


	public String toString() {
		return " { \n" +
						"  name = '" + name + '\'' + "\n" +
						"  phons = '" + phons + '\'' + "\n" +
						"  birthday = '" + birthday + '\'' + "\n" +
						'}';
	}
}
