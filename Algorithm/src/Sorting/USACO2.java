package Sorting;
import java.util.*;
import java.io.*;
public class USACO2 {
	static class Student implements Comparable <Student>{
		String name;
		double GPA;
		int h;
		public Student(String n, String[] a){
			name = n;
			int gradePoints = 0;
			for(int i = 0; i < a.length; i++){
				String[] temp = a[i].split("");
				if(temp[0].equals("A"))
					gradePoints += 4 * Integer.parseInt(temp[1]);
				else if(temp[0].equals("B"))
					gradePoints += 3 * Integer.parseInt(temp[1]);
				else if(temp[0].equals("C"))
					gradePoints += 2 * Integer.parseInt(temp[1]);
				else if(temp[0].equals("D"))
					gradePoints += 1 * Integer.parseInt(temp[1]);
				h+=Integer.parseInt(temp[1]);
			}
			GPA = (double)gradePoints / (double)h;
		}
		public int compareTo(Student that){
			if(this.GPA < that.GPA)
				return -1;
			else if(this.GPA > that.GPA)
				return 1;
			else{
				if(this.h<that.h)
					return -1;
				else if(this.h>that.h)
					return 1;
				else
					return 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("WhatisThis"));
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++){
			String school = sc.nextLine();
			int num = Integer.parseInt(sc.nextLine());
			Student[] a = new Student[num];
			for(int j = 0; j < num; j++){
				String[]temp = sc.nextLine().split(":");
				a[j] = new Student(temp[0], temp[1].split(","));
			}
			Arrays.sort(a);
			System.out.println(school + " = " + a[a.length-1].name);
		}
		sc.close();
	}
}