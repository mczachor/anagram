package pl.czachorowskimichal.anagram.impl;

import pl.czachorowskimichal.anagram.AlgosComparator;
import pl.czachorowskimichal.anagram.Anagram;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class AlgosComparatorImpl implements AlgosComparator {

	@Override
	public void measureExecutionTimes(
			final List<Anagram> algos, final int wordMinLength, final int wordMaxLength) {
		final Map<? extends Class<? extends Anagram>, ArrayList<Long>> result = this.getResultsMap(algos);
		this.executeComparision(algos, result, wordMinLength, wordMaxLength);
		this.printResults(result);
	}

	private void printResults(final Map<? extends Class<? extends Anagram>, ArrayList<Long>> result) {
		result.forEach((clazz, durations) -> {
			final double avg = durations.stream().mapToDouble(a -> a).average().getAsDouble();
			System.out.println("AVG for " + clazz.getSimpleName() + "=" + avg + " nanos");
		});
	}

	private void executeComparision(
			final List<Anagram> alogs, final Map<? extends Class<? extends Anagram>, ArrayList<Long>> result,
			final int wordMinLength, final int wordMaxLength) {
		for (int i = 0; i < 10000; i++) {
			this.executeSingleComparision(alogs, result, wordMinLength, wordMaxLength);
		}
	}

	private void executeSingleComparision(
			final List<Anagram> alogs, final Map<? extends Class<? extends Anagram>, ArrayList<Long>> result,
			final int wordMinLength, final int wordMaxLength) {
		final int count = RandomUtils.nextInt(wordMinLength, wordMaxLength);
		final RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z')
				.filteredBy(LETTERS)
				.build();
		final String a = generator.generate(count);
		final String b = generator.generate(count);

		alogs.forEach(algo -> {
			final long start = System.nanoTime();
			algo.isAnagram(a, b);
			final long end = System.nanoTime();
			final long duration = end - start;
			result.get(algo.getClass()).add(duration);
		});
	}

	private Map<? extends Class<? extends Anagram>, ArrayList<Long>> getResultsMap(
			final List<Anagram> alogs) {
		return alogs.stream()
				.map(Anagram::getClass)
				.collect(Collectors.toMap(clazz -> clazz, clazz -> new ArrayList<>()));
	}
}
