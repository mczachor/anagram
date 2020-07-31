package pl.czachorowskimichal.anagram.impl;

import pl.czachorowskimichal.anagram.Anagram;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AnagramHashMapImpl implements Anagram {

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

		final Map<Character, Integer> aChars = this.getCharsOccurrencesB(a.toLowerCase());
		final Map<Character, Integer> bChars = this.getCharsOccurrencesB(b.toLowerCase());

		return aChars.equals(bChars);
	}

	private Map<Character, Integer> getCharsOccurrencesB(final String a) {
		final Map<Character, Integer> occurrences = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {
			final char c = a.charAt(i);
			Integer quantity = occurrences.getOrDefault(c, 0);
			quantity++;
			occurrences.put(c, quantity);
		}
		return occurrences;
	}
}
