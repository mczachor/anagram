package pl.czachorowskimichal.anagram.impl;

import org.apache.commons.lang3.StringUtils;
import pl.czachorowskimichal.anagram.Anagram;

abstract class AbstractAnagramImpl implements Anagram {

	@Override
	public boolean isAnagram(final String a, final String b) {
		if (StringUtils.isEmpty(a)) {
			return false;
		}
		if (StringUtils.isEmpty(b)) {
			return false;
		}

		final String preparedA = this.prepareString(a);
		final String preparedB = this.prepareString(b);

		if (preparedA.length() != preparedB.length()) {
			return false;
		}

		return this.executeAlgo(preparedA, preparedB);
	}

	abstract boolean executeAlgo(final String preparedA, final String preparedB);

	private String prepareString(final String string) {
		return string.replaceAll("\\s", "").toLowerCase();
	}
}
