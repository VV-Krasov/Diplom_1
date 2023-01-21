package praktikum;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class BunGenerator {
    public static Bun createRandom()
    {
        return new Bun(RandomStringUtils.randomAlphabetic(1, 15), new Random().nextFloat());
    }
}
