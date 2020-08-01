package pl.czachorowskimichal.anagram.impl;

import pl.czachorowskimichal.anagram.Anagram;
import org.junit.jupiter.api.Assertions;

abstract class AbstractAnagramTest {

	protected Anagram anagram;

	protected void testIsAnagram() {
		Assertions.assertFalse(this.anagram.isAnagram("", null));
		Assertions.assertFalse(this.anagram.isAnagram("", "assad"));
		Assertions.assertFalse(this.anagram.isAnagram(null, "assad"));

		Assertions.assertFalse(this.anagram.isAnagram("asd", null));
		Assertions.assertFalse(this.anagram.isAnagram(null, "asd"));
		Assertions.assertFalse(this.anagram.isAnagram("asd", "sd"));
		Assertions.assertFalse(this.anagram.isAnagram("adsa", "asdasd"));
		Assertions.assertFalse(this.anagram.isAnagram("adad", "aaad"));
		Assertions.assertFalse(this.anagram.isAnagram("ADad", "aaad"));

		Assertions.assertTrue(this.anagram.isAnagram("asd", "sda"));
		Assertions.assertTrue(this.anagram.isAnagram("a sd", "sda"));
		Assertions.assertTrue(this.anagram.isAnagram("Asd", "sda"));
		Assertions.assertTrue(this.anagram.isAnagram("As d", "sda"));
		Assertions.assertTrue(this.anagram.isAnagram("Asd ", "sda"));
		Assertions.assertTrue(this.anagram.isAnagram("asd", "Sda"));
		Assertions.assertTrue(this.anagram.isAnagram("asd", "S da"));
		Assertions.assertTrue(this.anagram.isAnagram("asd", "SdA"));
		Assertions.assertTrue(this.anagram.isAnagram("asd", "s d a"));
	}
}