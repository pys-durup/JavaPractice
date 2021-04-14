package practice.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02_Stream {
    public static void main(String[] args) throws IOException {

        // 난수 무한 스트림 생성
        IntStream intStream = new Random().ints(1, 10);
        // limit 으로 제한 걸기
        intStream.limit(10).forEach(i -> System.out.println(i));


        // 난수 유한 스트림 생성
        IntStream intStream2 = new Random().ints(10, 1, 10);
        intStream2.forEach(i -> System.out.println(i));


        // 특정 범위의 정수
        IntStream intStream3 = IntStream.range(1, 5);
        intStream3.forEach(i -> System.out.print(i));

        // 람다식 (무한 스트림)
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        evenStream.limit(10).forEach(n -> System.out.print(n + " "));

        // 람다식 (무한 스트림)
        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(10).forEach(n -> System.out.print(n));

        // 파일 목록 스트림
        Path path = Paths.get("\\Users\\YSPark");
        System.out.println(path.toAbsolutePath());
        Stream<Path> pathStream = Files.list(path);
        pathStream.forEach(n -> System.out.println(n));



    }
}

