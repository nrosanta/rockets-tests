package com.testingfly.lc;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static void main(String[] args) {
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		System.out.println("Unique emails: " + numUniqueEmails1(emails));

	}

	public static int numUniqueEmails(String[] emails) {
		if (emails.length == 0 || emails == null)
			return 0;
		Set<String> emailSet = new HashSet<>();
		for (int i = 0; i < emails.length; i++) {
			if (emails[i].contains("@"))
				emailSet.add(emails[i].replace(".", "").replaceAll("\\+.*(?=@)", "") + emails[i].split("@")[1]);
		}
		return emailSet.size();
	}

	public static int numUniqueEmails1(String[] emails) {
		if (emails.length == 0 || emails == null)
			return 0;
		Set<String> emailSet = new HashSet<>();
		for (int i = 0; i < emails.length; i++) {
			emailSet.add(emails[i].replace(".", "").split("\\+")[0] + emails[i].split("@")[1]);
		}
		return emailSet.size();
	}

}
