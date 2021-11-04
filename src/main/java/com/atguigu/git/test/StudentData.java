package com.atguigu.git.test;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentData {
	
	public static List<Student> getList() {
		List<Student> list = new ArrayList<>(); // ???????
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("student.txt"), "GBK"));
			String line = bufferedReader.readLine();
			while (line != null) {
				// ???????????????
				//System.out.println(line);
				String[] array = line.split(",");
				Student student = new Student(  Integer.parseInt(array[0]), // id
												array[1],  // name
												Integer.parseInt(array[2]), // grade 
												Double.parseDouble(array[3])); // score
				list.add(student);
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception e2) {
				}
			}
		}
		
		// ????????
		for (Student student : list) {
			System.out.println(student);
		}
		
		System.out.println("*************************************************");
		
		return list;
	}
	
	public static void main(String[] args) {
		
		List<Student> list = getList();
		
		//???3??????м??????, ????????, ??????2??3????.
		List<Student> list3 = new ArrayList<>();
		for (Student student : list) {
			if (student.getGrade() == 3) {
				list3.add(student);
			}
		}
		
		// ???????????????????????????
		Comparator<Student> comparator = new Comparator<Student>() {
			// ??????????????????
			@Override
			public int compare(Student s1, Student s2) {
				return (int)(s1.getScore() - s2.getScore());
			}
			
			
		};
		
		Collections.sort(list3, comparator);
		
		Collections.reverse(list3);
		
		// ???м??????
		List<Student> list32 = new ArrayList<>();
		
		for (Student student : list3) {
			if (student.getScore() < 60) {
				list32.add(student);
			}
		}
		
		List<Student> list33 = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			if (i < list32.size()) {
				list33.add(list32.get(i));
			}
		}
		
		// ????list33
		for (Student student : list33) {
			System.out.println(student);
		}
		
	}
}
