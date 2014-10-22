package de.th.wildau.im14.was.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.text.MessageFormat;

public class HashedPasswordGenerator {

	public static void generateHash(String password) {
		String hash = Hashing.sha256().hashString(password, Charsets.UTF_8)
				.toString();
		String output = MessageFormat.format("{0} hashed to: {1}", password,
				hash);
		System.out.println(output);
	}

	public static void main(String[] args) {
		generateHash("password");
	}
}
