package pl.czachorowskimichal.anagram.impl;

import java.util.HashMap;
import java.util.Map;

public class AnagramHashMapImpl extends AbstractAnagramImpl {

	@Override
	boolean executeAlgo(final String preparedA, final String preparedB) {
		final Map<Character, Integer> aChars = this.getCharsOccurrences(preparedA);
		final Map<Character, Integer> bChars = this.getCharsOccurrences(preparedB);

		return aChars.equals(bChars);
	}

	private Map<Character, Integer> getCharsOccurrences(final String a) {
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
