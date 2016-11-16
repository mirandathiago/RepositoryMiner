package org.repositoryminer.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class StringUtils {

	public static String encodeToSHA1(String input){
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static long encodeToCRC32(String input) {
		byte bytes[] = input.getBytes();
		Checksum checksum = new CRC32();
		checksum.update(bytes, 0, bytes.length);
		return checksum.getValue();
	}
	
	public static int countNonEmptyLines(String text) {
		int lines = 0;
		
		Scanner scanner = new Scanner(text);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  if (!line.trim().equals("")) {
			  lines++;
		  }
		}
		scanner.close();

		return lines;
	}
	
}