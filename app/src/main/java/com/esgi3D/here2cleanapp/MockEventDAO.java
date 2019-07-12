package com.esgi3D.here2cleanapp;

import java.util.ArrayList;
import java.util.List;

public class MockEventDAO implements EventDAO {
    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        Event event1 = new Event();
        event1.setName("Nettoyage Plage");
        event1.setDesc("Ceci est une description");

        Event event2 = new Event();
        event2.setName("Nettoyage de lac");
        event2.setDesc("Ceci est une autre description");

        events.add(event1);
        events.add(event2);
        return events;
    }

    @Override
    public Event getEventById(int id) {
        Event event1 = new Event();
        event1.setName("Nettoyage Plage");
        return  event1;
    }
}
