import java.util.Scanner;

public class Student{
	//Attributes
	//Non-static variables
	private String name;
	private int studentID;
	private int age;
	private char grade;
	//Static variables
	public static int totalStudents;
	public static Student[] studentList = new Student[100]; 
	//Constructors
	public Student(String name, int studentID, int age, char grade){
		this.name = name;
		this.studentID = studentID;
		this.age = age;
		this.grade = grade;
	}

	//instance method for adding student
	public void addStudents(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the student's name");
		name = scanner.next();
		System.out.println("Enter the student's ID");
		studentID = scanner.nextInt();
		System.out.println("Enter the student's age");
		age = scanner.nextInt();
		System.out.println("Enter the student's grade");
		grade = scanner.next().charAt(0);

		studentList[totalStudents] = new Student(name, studentID, age, grade);
        totalStudents++;
	}

	//static method for updating studnet information
	public static void updateStudents(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the id of the student you want to update");
		int updateChoice = scanner.nextInt();
		for(int i=0; i<totalStudents; i++){
			if(updateChoice == studentList[i].studentID){
				System.out.println("Enter 1 to edit the name, 2 to edit the id, 3 to edit the age, 4 to edit the grade for the student " + studentList[i].name);
				int editChoice = scanner.nextInt();
				if(editChoice == 1){
					System.out.println("Enter the new name: ");
					String newName = scanner.next();
					studentList[i].name = newName;
					System.out.println("Student name updated successfully");
				}else if(editChoice == 2){
					System.out.println("Enter the new id: ");
					int newStudentID = scanner.nextInt();
					studentList[i].studentID = newStudentID;
					System.out.println("Student id updated successfully");
				}else if(editChoice == 3){
					System.out.println("Enter the new age: ");
					int newAge = scanner.nextInt();
					studentList[i].age = newAge;
					System.out.println("Student age updated successfully");
				}else if(editChoice == 4){
					System.out.println("Enter the new grade: ");
					char newGrade = scanner.next().charAt(0);
					studentList[i].grade = newGrade;
					System.out.println("Student grade updated successfully");
				}
			}
		}
	}

	//static method for viewing students
	public static void viewStudents(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the id of the student you want to view");
		int idChoice = scanner.nextInt();
		for(int i=0; i<totalStudents; i++){
			if(idChoice == studentList[i].studentID){
				System.out.println("Student name: " + studentList[i].name);
				System.out.println("Student id: " + studentList[i].studentID);
				System.out.println("Student age: " + studentList[i].age);
				System.out.println("Student grade: " + studentList[i].grade);
			}
		}
	}

	//static method for exiting the program
	public static void exitProgram(){
		System.out.println("Thank you for using this system. Exiting..");
	}
	
	//main method
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println(" ");
		System.out.println("Welcome to this Student Management system.");
	    System.out.println("************************************");
		do{

	        System.out.println(" ");
	        System.out.println("Enter 1 to add new students");
	        System.out.println("Enter 2 to update student information");
	        System.out.println("Enter 3 to view student details");
	        System.out.println("Enter 0 to exit");
	        System.out.println("Your choice: ");

	        choice = scanner.nextInt();

	        switch(choice){
	        case 1:
	        	Student child1 = new Student("", 0, 0, ' ');
	        	child1.addStudents();
	        	System.out.println("Thank you for adding a student.");
	        	System.out.println("Total students: " + totalStudents);
	        	System.out.println("************************************");
	        	System.out.println(" ");
	        	break;
	        case 2:
	        	Student.updateStudents();
	        	break;
	        case 3:
	        	Student.viewStudents();
	        	break;
	        case 0:
	        	Student.exitProgram();
	        	break;
	        default:
	        	System.out.println("Please enter a number between 0 and 3");
	        }
    }while(choice != 0);
        scanner.close();
        }
	}