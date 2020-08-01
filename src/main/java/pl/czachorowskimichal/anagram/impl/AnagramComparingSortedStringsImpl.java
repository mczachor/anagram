package pl.czachorowskimichal.anagram.impl;

import java.util.Arrays;

public class AnagramComparingSortedStringsImpl extends AbstractAnagramImpl {

	@Override
	boolean executeAlgo(final String preparedA, final String preparedB) {
		final String aChars = this.getStringWithSortedChars(preparedA);
		final String bChars = this.getStringWithSortedChars(preparedB);

		return aChars.equals(bChars);
	}

	private String getStringWithSortedChars(final String string) {
		return Arrays.toString(string.chars().sorted().toArray());
	}
}
