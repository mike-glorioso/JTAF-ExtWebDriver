package org.finra.jtaf.ewd.properties;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 * Created by kuoc on 7/19/2014.
 */
public class GUIHierarchyConcatenationPropertiesTest {

    @Test
    // testing function String getPropertyValue(String[] propertyNames, String... parameters)
    public void getPropertyValueTest() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] keys = {"1","y","a","r","r","a"};
        Assert.assertTrue(testClass.getPropertyValue(keys).equals("list1,{0},{1},list4"));
        Assert.assertTrue(testClass.getPropertyValue(keys,"aaa","bbb").equals("list1,aaa,bbb,list4"));
    }

    @Test
    // testing function String getPropertyValue(String[] propertyNames)
    public void getPropertyValueTestWithPropertiesArrayOnly() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] keys2 = {"st2","te"};
        Assert.assertTrue(testClass.getPropertyValue(keys2).equals("value2"));
        
    }

    @Test
    // testing function String getPropertyValue(String propertyName)
    public void getPropertyValueTestWithOnePropertyOnly() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        Assert.assertTrue(testClass.getPropertyValue("test2").equals("value2"));
    }

    @Test
    // testing String getPropertyValue(String key, Object[] parameters)
    public void getPropertyValueTestWithParamObjectArray() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] params = {"hello","world"};
        Assert.assertTrue(testClass.getPropertyValue("array1",params).equals("list1,hello,world,list4"));
        
    }

    @Test
    // testing String getPropertyValue(String key, String... parameters)
    public void getPropertyValueTestWithSingleKeyAndParamOption() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        Assert.assertTrue(testClass.getPropertyValue("array1","hello","world").equals("list1,hello,world,list4"));
        
    }

    @Test
    //testing List<String> getPropertyValueAsList(String[] propertyNames, String delimiter, String... parameters)
    public void getPropertyValueAsListTest() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] keys = {"1","y","a","r","r","a"};
        List<String> temp = testClass.getPropertyValueAsList(keys,",","list2","list3");
        Assert.assertTrue(temp.get(0).equals("list1"));
        Assert.assertTrue(temp.get(1).equals("list2"));
        Assert.assertTrue(temp.get(2).equals("list3"));
        Assert.assertTrue(temp.get(3).equals("list4"));
    }

    @Test
    // testing List<String> getPropertyValueAsList(String[] propertyNames, String delimiter)
    public void getPropertyValueAsListTestWithPropertiesArrayOnly() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] keys = {"2","y","a","r","r","a"};
        List<String> temp = testClass.getPropertyValueAsList(keys,",");
        Assert.assertTrue(temp.get(0).equals("alist1"));
        Assert.assertTrue(temp.get(1).equals("0"));
        Assert.assertTrue(temp.get(2).equals("1"));
        Assert.assertTrue(temp.get(3).equals("alist4"));
    }

    @Test
    // testing List<String> getPropertyValueAsList(String propertyName, String delimiter)
    public void getPropertyValueAsListTestWithOnePropertyOnly() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        List<String> temp = testClass.getPropertyValueAsList("array2",",");
        Assert.assertTrue(temp.get(0).equals("alist1"));
        Assert.assertTrue(temp.get(1).equals("0"));
        Assert.assertTrue(temp.get(2).equals("1"));
        Assert.assertTrue(temp.get(3).equals("alist4"));
    }

    @Test
    // testing List<String> getPropertyValueAsList(String key,String delimiter, Object[] parameters)
    public void getPropertyValueAsListTestWithParamObjectArray() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        String[] params = {"hello","world"};
        List<String> temp = testClass.getPropertyValueAsList("array1",",",params);
        Assert.assertTrue(temp.get(0).equals("list1"));
        Assert.assertTrue(temp.get(1).equals("hello"));
        Assert.assertTrue(temp.get(2).equals("world"));
        Assert.assertTrue(temp.get(3).equals("list4"));
    }

    @Test
    // testing List<String> getPropertyValueAsList(String key, String delimiter, String... parameters)
    public void getPropertyValueAsListTestWithSingleKeyAndParamOption() throws Exception{
        GUIHierarchyConcatenationProperties testClass = new GUIHierarchyConcatenationProperties("gui.properties","gui1.properties");
        List<String> temp = testClass.getPropertyValueAsList("array1",",","aaa","bb");
        Assert.assertTrue(temp.get(0).equals("list1"));
        Assert.assertTrue(temp.get(1).equals("aaa"));
        Assert.assertTrue(temp.get(2).equals("bb"));
        Assert.assertTrue(temp.get(3).equals("list4"));
    }
}
