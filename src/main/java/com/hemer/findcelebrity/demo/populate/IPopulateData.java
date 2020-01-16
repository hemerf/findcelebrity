package com.hemer.findcelebrity.demo.populate;

import com.hemer.findcelebrity.demo.domain.Person;

import java.util.List;
import java.util.Map;

public interface IPopulateData {
    List<Person> getPersons();
    Map<Integer,List<Integer>> getRelations();
}
