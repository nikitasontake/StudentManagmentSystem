package org.jsp.task;

import java.util.HashMap;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class Task3_StudentManagementSystem{ 
		private static HashMap<Integer , StudentManagementSystem> stu = new HashMap<>();
		private static Scanner sc = new Scanner(System.in);
	  public static void main(String[] args) {	
		  int choice ;
		  do {
			  System.out.println("Student Management System.....");
			  System.out.println("1.Add Sudent \n2.Update Student \n3.Remove Student\n4.View Student\n5.View All Students \n6.Exit");
			  System.out.print("Enter Your choice : ");
			  choice = sc.nextInt();
			  switch (choice) {
			case 1: {
				addStudent();
				break;
			}
			case 2: {
				updateStudent();
				break;
			}
			case 3: {
				removeStudent();
				break;
			}
			case 4: {
				viewStudent();
				break;
			}
			case 5: {
				viewAllStudent();
				break;
			}
			case 6: {
				System.out.println("Exit Successfully...");
				break;
			} 
			default:
				System.out.println("Invalid Choice ! Please try again.");
			}
			  
		  }while(choice != 6);
          sc.close();
	}
	  //method to add a new Student 
	  private static void addStudent() {
		  System.out.print("Enter Student ID :");
		  int id = sc.nextInt();
		  sc.nextLine();
		  if(stu.containsKey(id)) {
			  System.out.println("student with this ID already exists !");
			  return;
		  }
		  System.out.print("Enter Student Name: ");
		  String name = sc.nextLine();
		  System.out.print("Enter Student Age: ");
		  int age = sc.nextInt();
		  System.out.print("Enter Student Grade: ");
		  String grade = sc.next();
		  System.out.print("Enter Student Address: ");
		  sc.nextLine();
		  String address = sc.nextLine();
		  StudentManagementSystem student = new StudentManagementSystem(id,name,age,grade,address);
		  stu.put(id, student);
		  System.out.println("Student Added Successfully....");
	  }
	  //to update student record
	  public static void updateStudent() {
		  System.out.print("Enter Student ID to update : ");
		  int id = sc.nextInt();
		  if(stu.containsKey(id)) {
			  sc.nextLine();
			  System.out.print("Enter Updated Name : ");
			  String name = sc.nextLine();
			  System.out.print("Enter Updated age : ");
			  int age = sc.nextInt();
			  sc.nextLine();
			  System.out.print("Enter Updated Grade : ");
			  String grade = sc.next();
			  System.out.print("Enter Updated Address: ");
			  sc.nextLine();
			  String address = sc.nextLine();
			  StudentManagementSystem student = stu.get(id);
			  student.setName(name);
			  student.setAge(age);
			  student.setGrade(grade);
			  student.setAddress(address);
			  System.out.println("Student Record Updated Successfully");  
		  }else {
			  System.err.println("Student With id "+id+" not found");
		  }
	  }
	  //remove a student record
	  public static void removeStudent() {
           System.out.print("Enter student id to remove :");	
           int id = sc.nextInt();
           if(stu.containsKey(id)) {
        	   stu.remove(id);
        	   System.out.println("Student Removed Successfully!");
           }else {
        	   System.err.println("Student with ID "+id+" not found");
           }
	  }
	  //view a student record
	  public static void viewStudent() {
		  System.out.print("Enter Student ID to view Record : ");
		  int id = sc.nextInt();
		  if(stu.containsKey(id)) {
			  StudentManagementSystem student = stu.get(id);
			  System.out.println(student);
		  }else {
			  System.out.println("Student with ID "+id+" not found");
		  }
			  
	  }
	  //display all student
	  public static void viewAllStudent() {
		  if(stu.isEmpty()) {
			  System.out.println("No Student Records Founds.");
		  }else {
			  for(StudentManagementSystem student : stu.values()) {
				  System.out.println(student);
				  System.out.println("----------------------------------------");
			  }
		  }
	  }
}


class  StudentManagementSystem{
    //student Management system
	private int id;
	private String name;
	private int age;
	private String grade;
	private String address;
	
	public StudentManagementSystem(int id,String name,int age,String grade,String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ID: "+id+", Name: "+name+", Age: "+age+",Grade: "+grade+", Address: "+address;
	}
}

