package pl.czachorowskimichal.anagram.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramCharsRemovingUsingStringBuilderImplTest extends AbstractAnagramTest {

	@BeforeEach
	void setUp() {
		this.anagram = new AnagramCharsRemovingUsingStringBuilderImpl();
	}

	@Test
	void isAnagram() {
		this.testIsAnagram();
	}
}