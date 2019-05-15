package com.dijouxdamien.here2cleanapp;

import java.util.List;

public interface EventDAO {
    public List<Event> getAllEvents();
    public Event getEventById(int id);
}
