package org.finra.jtaf.ewd.properties;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 * Created by kuoc on 7/19/2014.
 */
public class GUIPropertiesTest {

    @Test
    public void getPropertyValueTest() throws Exception{
        GUIProperties testClass = new GUIProperties();
        Assert.assertTrue(testClass.getPropertyValue("param2").equals("value2"));
        GUIProperties testClass2 = new GUIProperties("gui1.properties");
        Assert.assertTrue(testClass2.getPropertyValue("test2").equals("value2"));
        Assert.assertTrue(testClass2.getPropertyValue("testparams1","4","5","6").equals("firstparamis4andsecondparamis5andthirdparamis6"));
    }

    @Test
    public void getPropertyValueOrDefaultTest() throws Exception{
        GUIProperties testClass = new GUIProperties();
        Assert.assertTrue(testClass.getPropertyValueOrDefault("test default").equals("Default value"));
        Assert.assertTrue(testClass.getPropertyValueOrDefault("param1").equals("value1"));
        Assert.assertTrue(testClass.getPropertyValue("testparams2","4","5","6").equals("firstparamis4andsecondparamis5andthirdparamis6"));
    }

    @Test
    public void getPropertyValueAsListTest() throws Exception{
        GUIProperties testClass = new GUIProperties();
        List<String> temp = testClass.getPropertyValueAsList("array1",",","list2","list3");
        Assert.assertTrue(temp.get(0).equals("list1"));
        Assert.assertTrue(temp.get(1).equals("list2"));
        Assert.assertTrue(temp.get(2).equals("list3"));
        Assert.assertTrue(temp.get(3).equals("list4"));
    }

}
