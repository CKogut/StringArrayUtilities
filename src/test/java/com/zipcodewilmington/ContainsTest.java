package com.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

public class ContainsTest {

    @Test
    //?
    public void testContains() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        for (String s : array) {
            boolean outcome = StringArrayUtils.contains(array, s);
            Assert.assertTrue(outcome);
        }
    }


}
