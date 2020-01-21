package bootstrap;

import code.Passcode;

import java.util.stream.IntStream;

public class Day4 {

    private static void day1() {
        System.out.println(IntStream.range(246515, 739105).boxed().map(Object::toString).map(Passcode::new).filter(Passcode::isValidForDay1).count());
    }

    private static void day2() {
        System.out.println(IntStream.range(246515, 739105).boxed().map(Object::toString).map(Passcode::new).filter(Passcode::isValidForDay2).count());
    }

    public static void main(String[] args) {
        day1();
        day2();
    }
}
