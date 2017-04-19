package packet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import view.MyWindow;

public class Main {
	
	// identification number | name | surname | index | year of study | number of group
	public static void createFileForStudents(String nameOfFile, int numberOfStudents, String[] names, String[] surnames, String markOfStudyProgram, int yearOfRegistration, int yearOfStudy, int sizeOfGroup) {
		markOfStudyProgram = markOfStudyProgram.toUpperCase();
		
		PrintWriter pw = null;
		try {
			Random randomGenerator = new Random();
			pw = new PrintWriter(new FileWriter(nameOfFile));
			
			
			
			int[] array_int = new int[13];
			int x = -1;
			int randomInt = -1;
			String randomName = "|||||";
			String randomSurname = "|||||";
			int groupOfStudent = 0;
			
			pw.print("# identification number | name | surname | index | year of study | number of group\n\n");
			
			for (int i = 0; i < numberOfStudents; i++) {
				
				for (int j = 0; j < 13; j++) { // in loop, it creates identification number (random)
					if (j == 0 ) x = 3;
					else if (j == 2) x = 2;
					else if (j == 3) {
						if (randomInt == 0) x = 10;
						else x = 3;
					}
					else x = 10;
					 randomInt = randomGenerator.nextInt(x);
					 if ((j== 1 || j==3) && array_int[j-1] == 0 && randomInt == 0) randomInt = 1; 
					 else if (j == 3 && array_int[j] == 2 && array_int[j-1] == 0 && array_int[j-2] == 9 && array_int[j-3] == 2) array_int[j-2] = 8;
					 array_int[j] = randomInt;
				}
				
				randomName = names[randomGenerator.nextInt(names.length)];
				randomSurname = surnames[randomGenerator.nextInt(surnames.length)];
				
				if (i % sizeOfGroup == 0) groupOfStudent++;
				
				pw.printf("%d%d%d%d%d%d%d%d%d%d%d%d%d, %s, %s, %s%d/%d, %d, %d\n", array_int[0],array_int[1], array_int[2], array_int[3], 9, 9, 6,array_int[4],array_int[5],array_int[6],array_int[7],array_int[8],array_int[9], randomName, randomSurname, markOfStudyProgram, i+1, yearOfRegistration, yearOfStudy, groupOfStudent);
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		pw.close();
		
		System.out.println("\nFile for students, is created!\n");

	}
	
	
	public static void main(String[] args) {
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);
		
		//Example invitation of function creatFileForStudent
		
		/*
		String nameOfFile = "file/studenti.txt";
		String[] names = new String[] {"Dunja", "Vasilije", "Sara", "Strahinja", "Mina", "Lazar", "Lana", "Bogdan", "Lena", "Milos", "Nevena", "Stefan", "Jelena", "Dusan", "Masa", "Aleksandar", "Nadja", "Mihajlo", "Neda", "Danilo", "Mila", "Andrej", "Dragana", "Nemanja", "Marija", "Nikola", "Jovana", "Jovan", "Milica", "Savo", "Selena", "Jovo", "Stasa", "Sergej", "Irena", "Nikola", "Marija", "Marko"};
		String[] surnames = new String[] {"Radivojevic", "Lukic", "Miletic", "Nikolic", "Ivic", "Mijatovic", "Jelcic", "Topolic", "Mihic", "Popovic", "Lazic", "Marjanovic", "Nedovic", "Bogdanovic", "Teodosic", "Jokic", "Stankovic", "Vranic", "Malesevic", "Peric", "Zimonjic", "Djokovic", "Tipsarevic", "Dabovic", "Preletacevic", "Vucic", "Dacic", "Tadic", "Jankovic", "Jeremic", "Markovic", "Cubrilovic"};
		String markOfStudyProgram = "PR";
		int yearOfRegistration = 2015;
		int yearOfStudy = 2;
		int sizeOfGroup = 15;
		
		createFileForStudents(nameOfFile, 180, names, surnames, markOfStudyProgram, yearOfRegistration, yearOfStudy, sizeOfGroup);
		*/
	}

}
