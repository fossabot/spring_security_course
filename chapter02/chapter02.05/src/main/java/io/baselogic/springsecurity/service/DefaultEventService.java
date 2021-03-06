package io.baselogic.springsecurity.service;

import io.baselogic.springsecurity.dao.EventDao;
import io.baselogic.springsecurity.dao.UserDao;
import io.baselogic.springsecurity.domain.AppUser;
import io.baselogic.springsecurity.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * A default implementation of {@link EventService} that delegates to {@link EventDao} and {@link UserDao}.
 *
 * @since chapter01.00
 * @author mickknutson
 *
 */
@Service
public class DefaultEventService implements EventService {

    private final EventDao eventDao;
    private final UserDao userDao;

    @Autowired
    public DefaultEventService(final @NotNull EventDao eventDao,
                               final @NotNull UserDao userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @Override
    public Event findEventById(Integer eventId) {
        return eventDao.findById(eventId);
    }

    @Override
    public List<Event> findEventByUser(Integer userId) {
        return eventDao.findByUser(userId);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventDao.findAll();
    }

    @Override
    public Integer createEvent(Event event) {
        return eventDao.save(event);
    }

    @Override
    public AppUser findUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<AppUser> findUsersByEmail(String partialEmail) {
        return userDao.findAllByEmail(partialEmail);
    }

    @Override
    public Integer createUser(AppUser appUser) {
        return userDao.save(appUser);
    }

} // The End...