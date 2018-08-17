package com.test.sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.official.entity.Subject;

public class ShuffleTest {

	@Test
	public void testName() throws Exception {

		List<Subject> list = new ArrayList<>();

		for (int index = 0; index < 20; index++) {
			Subject sub = new Subject();
			sub.setId(index);

			list.add(sub);
		}
		long start = System.currentTimeMillis();
		List<Subject> after = shuffle(list);
		long end = System.currentTimeMillis();

		System.out.println("spend: " + (end - start));

		for (Subject s : after) {
			System.out.println(s.getId());
		}

	}

	private static Random random = new Random();
	private <T> List<T> shuffle(List<T> subjects) {
		if (null == subjects || subjects.isEmpty()) {
			return Collections.emptyList();
		}

		int size = subjects.size();
		List<T> list = new ArrayList<T>(size);
		Set<Integer> set = new HashSet<Integer>();

		while (set.size() < size) {
			int randomIndex = random.nextInt(size);
			if (set.add(randomIndex)) {
				list.add(subjects.get(randomIndex));
			}
		}
		return list;
	}
}
