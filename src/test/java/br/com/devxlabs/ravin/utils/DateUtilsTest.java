package br.com.devxlabs.ravin.utils;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateUtilsTest {

    
    @Test
    public void testConvertStringToDate() {
        String dateString = "23031996";
        Date date = DateUtils.stringToDate(dateString);

        // String stringDate = DateUtils.formatDate(date);

        // Assert.assertTrue(stringDate == "");

        // Assert.assertThrows( DateUtils.stringToDate(dateString), ParseException.class);
        
    }
}
