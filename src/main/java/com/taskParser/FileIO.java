package com.taskParser;

import java.io.File;
import java.io.FilenameFilter;

public class FileIO {
	public void listDataFiles(File filePath) {
		System.out.println(filePath);
		File[] allFiles = filePath.listFiles(new FilenameFilter() {
			public boolean accept(File pathname, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".txt");
			}
		});
		for (int i = 0; i < allFiles.length; i++) {
			System.out.println(allFiles[i]);
		}
		
	}
}
