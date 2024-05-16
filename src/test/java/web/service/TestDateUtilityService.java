package web.service;

import org.junit.Assert;
import org.junit.Test;
import java.time.format.DateTimeParseException;

public class TestDateUtilityService {

    @Test
    public void testDateAfter() {
        Assert.assertEquals("2024-05-15", DateUtilityService.dateAfter("2024-05-14"));
    }

    @Test
    public void testDateBefore() {
        Assert.assertEquals("2024-05-13", DateUtilityService.dateBefore("2024-05-14"));
    }

    @Test
    public void testDateAfterInvalidInput() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateUtilityService.dateAfter("invalid-date"));
    }

    @Test
    public void testDateBeforeInvalidInput() {
        Assert.assertThrows(DateTimeParseException.class, () -> DateUtilityService.dateBefore("invalid-date"));
    }
}
