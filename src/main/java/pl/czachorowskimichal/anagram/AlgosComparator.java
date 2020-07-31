package pl.czachorowskimichal.anagram;

import java.util.List;

public interface AlgosComparator {

	void measureExecutionTimes(List<Anagram> algos, final int wordMinLength, final int wordMaxLength);

}
