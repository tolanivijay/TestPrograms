package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class FileWriter {

	private static BufferedWriter writer;

	private static final String diskPath = "C:\\test\\students.csv";

	public static void main(String[] args) {
		prepareWriter();
		writeToFile();
		System.out.println("Created file");
	}

	public static void writeToFile() {

		IntStream.range(1, 500000).forEach(e -> writeToFile(e));
	}

	private static void writeToFile(Integer n) {
		try {
			String stud = getStudentString(n);
			writer.write(stud);
			writer.newLine();
		} catch (Exception e) {
			System.out.println("Exception writting to file " + e);
		}
	}

	private static String getStudentString(Integer no) {
		return "name" + no + "," + no % 70 + "," + (no * 47) % 50000;
	}

	private static void writeStudents() {

	}

	private static void prepareWriter() {
		File file = new File(diskPath);
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			writer = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception preparing writer");
		}
	}

}
