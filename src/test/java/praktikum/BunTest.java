package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class BunTest {
    @Test
    public void getNameTest() {
        String randomName = RandomStringUtils.randomAlphabetic(new Random().nextInt(10));
        Bun bun = new Bun(randomName, 1.5f);
        Assert.assertEquals(randomName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Random rand = new Random();
        float randomPrice = rand.nextFloat();
        Bun bun = new Bun("", randomPrice);
        Assert.assertEquals(randomPrice, bun.getPrice(), 0);
    }
}
