package com.odde.simplepersistence;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DataStoreTest {


    private DataStore ds;

    @Before
    public void setUp() throws Exception {
        ds = DataStore.getDataStoreInstance(true);
    }

    @Test
    public void repository_starts_without_objects(){
        assertEquals(0, ds.getKeys().size());
    }

    @Test
    public void datastore_can_store_a_simple_string(){
        ds.addObject("thisString","wow");
        assertEquals("wow",ds.getObject("thisString"));
    }
    @Test
    public void datastore_instances_return_same_thing(){
        DataStore dsAdd = DataStore.getDataStoreInstance();
        dsAdd.addObject("thisString","wow");
        DataStore dsGet = DataStore.getDataStoreInstance();
        assertEquals("wow",dsGet.getObject("thisString"));
    }
    @Test
    public void complex_object_survives_across_instances(){
        DataStore dsAdd = DataStore.getDataStoreInstance();
        ComplexThing thing = new ComplexThing();
        dsAdd.addObject("complexThing",thing);
        thing.setName("bob");
        DataStore dsGet = DataStore.getDataStoreInstance();
        ComplexThing thingUpdated = (ComplexThing) dsGet.getObject("complexThing");
        assertEquals("bob", thingUpdated.getName());


    }
    @Test
    public void no_key_does_something_good(){
       Object item =  ds.getObject("notHere");
       assertEquals(null,item);
    }
//    @Test
//    public void try_to_reproduce_comodification(){
//        ds.addObject("thing1", new Item("thing1",3,3));
//        ds.addObject("thing2", new Item("thing2",3,3));
//        ds.addObject("thing3", new Item("thing3",3,3));
//        ds.addObject("thing3", new Item("thing4",3,3));
//        ds.addObject("thing3", new Item("thing5",3,3));
//        List<Object> itemList = ds.getObjectList();
//        Iterator<Object> itemIterator = itemList.listIterator();
//        while( itemIterator.hasNext()){
//            Item item = (Item) itemIterator.next();
//            item.updateQuality(4);
//        }
//
//        Iterator<Object> newItemIterator = itemList.listIterator();
//        while (newItemIterator.hasNext()){
//            Item item = (Item) newItemIterator.next();
//            item.updateSellIn(2);
//        }
//        Item item = (Item) itemList.get(0);
//        assertEquals(4, item.quality);
//        assertEquals(2,item.sellIn);
//    }
//    @Test
//    public void data_store_can_reset_the_internal_dataStore_and_start_with_no_items(){
//        ds.addObject("thing1", new Item("thing1",3,3));
//        ds.addObject("thing2", new Item("thing2",3,3));
//        ds.addObject("thing3", new Item("thing3",3,3));
//        ds.addObject("thing4", new Item("thing4",3,3));
//        ds.addObject("thing5", new Item("thing5",3,3));
//        List<Object> itemList = ds.getObjectList();
//        Iterator<Object> itemIterator = itemList.listIterator();
//        while( itemIterator.hasNext()){
//            Item item = (Item) itemIterator.next();
//            item.updateQuality(4);
//        }
//
//        Iterator<Object> newItemIterator = itemList.listIterator();
//        while (newItemIterator.hasNext()){
//            Item item = (Item) newItemIterator.next();
//            item.updateSellIn(2);
//        }
//        Item item = (Item) itemList.get(0);
//        assertEquals(4, item.quality);
//        assertEquals(2,item.sellIn);
//        DataStore dsRead = DataStore.getDataStoreInstance(false);
//        Item thing5 = (Item) dsRead.getObject("thing5");
//        assertEquals(2, thing5.sellIn);
//    }
    @Test
    public void the_application_can_be_set_to_a_future_date(){
        LocalDate today = LocalDate.now();
        assertEquals(today.toString(), ds.getToday());
        Long oneDay = Long.valueOf(1);
        LocalDate tomorrow = today.plusDays(oneDay);
        ds.setCurrentDate(tomorrow);
        assertEquals(tomorrow.toString(),ds.getToday());
    }

    @Test
    public void clearing_the_datastore_resets_date(){
        LocalDate today = LocalDate.now();
        assertEquals(today.toString(), ds.getToday());
        Long oneDay = Long.valueOf(1);
        LocalDate tomorrow = today.plusDays(oneDay);
        ds.setCurrentDate(tomorrow);
        DataStore.resetDataStore();
        assertEquals(today.toString(),ds.getToday());

    }
    private class ComplexThing{
        private String name;
        public List<String> data = new ArrayList<>();
        public ComplexThing(){
            data = new ArrayList<>(Arrays.asList("a","b","c"));
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

}
