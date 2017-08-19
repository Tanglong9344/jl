package java_lamda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 管道源
 * @author 唐龙
 */

public class AggregateStreamTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		//管道源是集合
		System.out.println("管道源是集合：");
		heros
		.stream()
		.forEach(h->System.out.println(h.name));
		//管道源是数组
		System.out.println("管道源是数组：");
		Hero hs[] = heros.toArray(new Hero[heros.size()]);
		Arrays.stream(hs)
		.forEach(h->System.out.println(h.name));
	}
}
