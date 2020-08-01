package pl.czachorowskimichal.anagram.impl;

public class AnagramCharsRemovingUsingStringBuilderImpl extends AbstractAnagramImpl {

	@Override
	boolean executeAlgo(final String preparedA, final String preparedB) {
		final StringBuilder result = new StringBuilder(preparedB);
		for (int i = 0; i < preparedA.length(); i++) {
			final char c = preparedA.charAt(i);
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
