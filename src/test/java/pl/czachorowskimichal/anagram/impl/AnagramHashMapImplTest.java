package pl.czachorowskimichal.anagram.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramHashMapImplTest extends AbstractAnagramTest {

	@BeforeEach
	void setUp() {
		this.anagram = new AnagramHashMapImpl();
	}

	@Test
	void isAnagram() {
		this.testIsAnagram();
	}
}