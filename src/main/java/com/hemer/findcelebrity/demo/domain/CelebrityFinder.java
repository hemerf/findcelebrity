package com.hemer.findcelebrity.demo.domain;

import com.hemer.findcelebrity.demo.populate.IPopulateData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CelebrityFinder {
     private List<Person> persons;
     private Map<Integer,List<Integer>> relationships;

     public CelebrityFinder(IPopulateData populateData){
         this.persons =  populateData.getPersons();
         this.relationships = populateData.getRelations();
     }

     public List<Person> findCelebrity(){
         return persons.stream().filter(p -> getPeopleKnow(p) == persons.size()-1 && doesntKnowAnybody(p) ).collect(Collectors.toList());
     }

    private int getPeopleKnow(Person p) {
         AtomicInteger personsKnow = new AtomicInteger();

         relationships.entrySet().forEach(entry -> {
            if(entry.getValue().contains(p.getId())){
                personsKnow.getAndIncrement();
            }
        });

        log(" getPeolpeKnow("+p+"): "+personsKnow.get());

        return personsKnow.get();
    }

    private boolean doesntKnowAnybody(Person p) {
        if( relationships.get(p.getId()).size() == 0 ){
            log(" doesntKnowAnybody("+p+") true");
            return true;
        }
        log(" doesntKnowAnybody("+p+") false");
        return false;
    }

    public void log(String data){
        System.out.println(data);
    }

}