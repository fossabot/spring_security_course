package io.baselogic.springsecurity.service;

import io.baselogic.springsecurity.dao.EventDao;
import io.baselogic.springsecurity.dao.UserDao;
import io.baselogic.springsecurity.domain.AppUser;
import io.baselogic.springsecurity.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * A default implementation of {@link EventService} that delegates to {@link EventDao} and {@link UserDao}.
 *
 * @author mickknutson
 *
 * @since chapter01.00
 * @since chapter03.02 adding {@link UserDetailsManager} userDetailsManager
 * @since chapter03.03 removed {@link UserDetailsManager} userDetailsManager
 * @since chapter04.03 added jdbcOperations.update for appUsers_authorities
 *
 */
@Service
public class DefaultEventService implements EventService {

    private final EventDao eventDao;
    private final UserDao userDao;
    private final String customCreateUserAuthoritiesSql;

    private final JdbcOperations jdbcOperations;

    @Autowired
    public DefaultEventService(final @NotNull EventDao eventDao,
                               final @NotNull UserDao userDao,
                               final @NotNull @Qualifier("customCreateUserAuthoritiesSql") String customCreateUserAuthoritiesSql,
                               final @NotNull JdbcOperations jdbcOperations) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.customCreateUserAuthoritiesSql = customCreateUserAuthoritiesSql;
        this.jdbcOperations = jdbcOperations;
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
    public Integer createUser(final AppUser appUser) {
        int userId = userDao.save(appUser);
        jdbcOperations.update(customCreateUserAuthoritiesSql, userId, "ROLE_USER");
        return userId;
    }

} // The End...