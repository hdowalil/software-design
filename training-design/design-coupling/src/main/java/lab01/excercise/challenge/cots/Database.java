package lab01.excercise.challenge.cots;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	static List<Person> data;

	static {
		data = new ArrayList<>();
		data.add(new Person(1,"Tyler","Durden",1970,Month.AUGUST,22,"Paper Street","537",19808,"Bradford"));
		data.add(new Person(2,"Marla","Singer",1974,Month.OCTOBER,17,"Paper Street","537",19808,"Bradford"));
		data.add(new Person(3,"Robert","Paulsen",1971,Month.JULY,12,"Paper Street","537",19808,"Bradford"));
		data.add(new Person(4,"Richard","Chelser",1968,Month.JANUARY,6,"Elm Street","12/1",48201,"Detroit"));
		data.add(new Person(5,"Brandon","Walsh",1969,Month.AUGUST,28,"Wilshire Boulevard","815",90210,"Beverly Hills"));
	}
	
}
