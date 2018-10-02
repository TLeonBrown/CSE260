//Tian Brown, 111597217

import java.io.*;
import java.util.*;
public class DirectorySize {
	
	public long getSize(File directory) {
		Queue<File> q = new LinkedList<>();
		long directoryLength = 0;
		
		q.add(directory);
		
		while(!q.isEmpty()) {
			File subdir = q.poll();
			if (subdir.isDirectory()) {
				for(File f : subdir.listFiles()) {
					q.add(f);
					directoryLength += f.length();
				}
			}
			else if (subdir.isFile()) {
				directoryLength += subdir.length();
			}
		}
		return directoryLength;
	}

	
}
