package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestScienceService {

    @Test
    public void testCalculateForce() {
        Assert.assertEquals(20.0, ScienceService.calculateForce("4", "5"), 0);
    }

    @Test
    public void testCalculateForceInvalidInput() {
        Assert.assertThrows(NumberFormatException.class, () -> ScienceService.calculateForce("4", "invalid"));
    }
}
