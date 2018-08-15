package com.test.spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.official.App;
import com.official.entity.Subject;
import com.official.service.subject.SubjectService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class SpringTest {

	@Autowired
	private SubjectService subjectService;

	@Test
	public void page() {

		for (int index = 0; index < 5; index++) {

			Subject search = new Subject();
			search.setPage(index);
			search.setRows(20);
			System.out.println("----------- Page[" + index + "]---------------\n\n");

			List<Subject> subjects = subjectService.list(search);

			for (Subject s : subjects) {
				System.out.println(s);
			}

			System.out.println();
			System.out.println();
			System.out.println();
		}
	}

}
