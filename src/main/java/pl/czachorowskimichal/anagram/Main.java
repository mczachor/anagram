package pl.czachorowskimichal.anagram;

import pl.czachorowskimichal.anagram.impl.AlgosComparatorImpl;
import pl.czachorowskimichal.anagram.impl.AnagramCharsRemovingUsingStringBuilderImpl;
import pl.czachorowskimichal.anagram.impl.AnagramComparingSortedStringsImpl;
import pl.czachorowskimichal.anagram.impl.AnagramHashMapImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(final String[] args) {
		final List<Anagram> anagramAlgos = new ArrayList<>();
		anagramAlgos.add(new AnagramCharsRemovingUsingStringBuilderImpl());
		anagramAlgos.add(new AnagramHashMapImpl());
		anagramAlgos.add(new AnagramComparingSortedStringsImpl());

		final AlgosComparator alosComparator = new AlgosComparatorImpl();


		System.out.println("For random words with length between 3 and 10");
		alosComparator.measureExecutionTimes(anagramAlgos, 3, 10);

		System.out.println("For random words with length between 5 and 15");
		alosComparator.measureExecutionTimes(anagramAlgos, 5, 15);

		System.out.println("For random words with length between 15 and 100");
		alosComparator.measureExecutionTimes(anagramAlgos, 15, 100);

		System.out.println("For random words with length between 1000 and 2000");
		alosComparator.measureExecutionTimes(anagramAlgos, 1000, 2000);
	}

}
