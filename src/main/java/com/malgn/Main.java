package com.malgn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NoSuchFileException {
		Map<String, String> map = new HashMap<>();
		//String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\data.csv";
		//InputStream dataInputStream = ClassLoader.getSystemResourceAsStream("data.csv");
		InputStream dataInputStream = Main.class.getClassLoader().getResourceAsStream("data.csv");
		try (
			//BufferedReader reader = new BufferedReader(new FileReader(filePath))
			BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream))
		) {
			String str;
			while ((str = reader.readLine()) != null) {
				String[] tmp = str.split(",");
				if (tmp.length >= 2) {
					String name = tmp[0].trim();
					String object = tmp[1].trim();
					map.put(name, object);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("data.csv 파일을 찾을 수 없습니다.");
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("name:");
		String s_name = scanner.next();
		String s_object = map.get(s_name);
		if (s_object != null) {
			System.out.println("object = " + s_object);
		} else {
			System.out.println("null");
		}
	}
}