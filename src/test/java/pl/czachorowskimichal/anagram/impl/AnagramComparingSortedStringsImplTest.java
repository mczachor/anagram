package pl.czachorowskimichal.anagram.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramComparingSortedStringsImplTest extends AbstractAnagramTest {

	@BeforeEach
	void setUp() {
		this.anagram = new AnagramComparingSortedStringsImpl();
	}

	@Test
	void isAnagram() {
		this.testIsAnagram();
	}
}