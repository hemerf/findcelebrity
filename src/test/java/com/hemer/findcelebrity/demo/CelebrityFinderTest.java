package com.hemer.findcelebrity.demo;

import com.hemer.findcelebrity.demo.domain.CelebrityFinder;
import com.hemer.findcelebrity.demo.domain.Person;
import com.hemer.findcelebrity.demo.populate.IPopulateData;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CelebrityFinderTest {

    @Test
    public void findCelebrity(){
        List<Person> persons = new ArrayList<Person>();
        Person hemer = new Person(1,"Hemer");
        Person viky = new Person(2,"Viky");
        Person any = new Person(3,"Any");

        persons.add(hemer);
        persons.add(viky);
        persons.add(any);

        //relationships
        Map<Integer,List<Integer>> relationships = new HashMap<Integer,List<Integer>>();
        relationships.put(hemer.getId(), new ArrayList<>());
        relationships.put(viky.getId(), Arrays.asList(hemer.getId()));
        relationships.put(any.getId(), Arrays.asList(hemer.getId()));

        CelebrityFinder celebrityFinder = new CelebrityFinder(new IPopulateData() {
            @Override
            public List<Person> getPersons() {
                return persons;
            }

            @Override
            public Map<Integer, List<Integer>> getRelations() {
                return relationships;
            }
        });

        List<Person> celebritys = celebrityFinder.findCelebrity();

        assertEquals(celebritys.size(),1);
        assertEquals(hemer,celebritys.get(0));
    }

    @Test
    public void noneCelebrity(){
        List<Person> persons = new ArrayList<Person>();
        Person hemer = new Person(1,"Hemer");
        Person viky = new Person(2,"Viky");
        Person any = new Person(3,"Any");
        Person claudia = new Person(4,"Claudia");

        persons.add(hemer);
        persons.add(viky);
        persons.add(any);
        persons.add(claudia);

        //relationships
        Map<Integer,List<Integer>> relationships = new HashMap<Integer,List<Integer>>();
        relationships.put(hemer.getId(), new ArrayList<>());
        relationships.put(viky.getId(), Arrays.asList(hemer.getId(),any.getId()));
        relationships.put(any.getId(), Arrays.asList(hemer.getId()));
        relationships.put(claudia.getId(), new ArrayList<>());

        CelebrityFinder celebrityFinder = new CelebrityFinder(new IPopulateData() {
            @Override
            public List<Person> getPersons() {
                return persons;
            }

            @Override
            public Map<Integer, List<Integer>> getRelations() {
                return relationships;
            }
        });

        List<Person> celebritys = celebrityFinder.findCelebrity();

        assertEquals(celebritys.size(),0);
    }
}
