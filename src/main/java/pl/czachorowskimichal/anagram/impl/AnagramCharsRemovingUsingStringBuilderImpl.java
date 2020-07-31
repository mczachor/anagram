package pl.czachorowskimichal.anagram.impl;

import pl.czachorowskimichal.anagram.Anagram;
import org.apache.commons.lang3.StringUtils;

public class AnagramCharsRemovingUsingStringBuilderImpl implements Anagram {

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

		final StringBuilder result = new StringBuilder(b.toLowerCase());
		final String aLowerCase = a.toLowerCase();
		for (int i = 0; i < aLowerCase.length(); i++) {
			final char c = aLowerCase.charAt(i);
			final int indexToRemove = result.indexOf(String.valueOf(c));
			if (indexToRemove == -1) {
				return false;
			} else {
				result.deleteCharAt(indexToRemove);
			}

		}

		return result.length() == 0;
	}
}
