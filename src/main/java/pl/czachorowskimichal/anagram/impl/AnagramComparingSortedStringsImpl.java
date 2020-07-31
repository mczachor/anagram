package pl.czachorowskimichal.anagram.impl;

import pl.czachorowskimichal.anagram.Anagram;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class AnagramComparingSortedStringsImpl implements Anagram {

	@Override
	public boolean isAnagram(final String a, final String b) {
		if (StringUtils.isEmpty(a)) {
			return false;
		}
		if (StringUtils.isEmpty(b)) {
			return false;
		}
		if (a.length() != b.length()) {
			return false;
		}
		final String aChars = this.getStringWithSortedChars(a.toLowerCase());
		final String bChars = this.getStringWithSortedChars(b.toLowerCase());

		return aChars.equals(bChars);
	}

	private String getStringWithSortedChars(final String a) {
		return Arrays.toString(a.chars().sorted().toArray());
	}
}
