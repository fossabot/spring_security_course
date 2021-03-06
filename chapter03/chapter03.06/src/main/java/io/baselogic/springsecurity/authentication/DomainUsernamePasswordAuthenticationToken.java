package io.baselogic.springsecurity.authentication;

import io.baselogic.springsecurity.domain.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * The DomainUsernamePasswordAuthenticationToken class
 *
 * @author mickknutson
 * @since chapter03.06
 */
public final class DomainUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private final String domain;

    /**
     * used for attempting authentication
     * @param principal
     * @param credentials
     * @param domain
     */
    public DomainUsernamePasswordAuthenticationToken(final String principal,
                                                     final String credentials,
                                                     final String domain) {
        super(principal, credentials);
        this.domain = domain;
    }

    /**
     * used for returning to Spring Security after being authenticated
     * @param principal
     * @param credentials
     * @param domain
     * @param authorities
     */
    public DomainUsernamePasswordAuthenticationToken(final AppUser principal,
                                                     final String credentials,
                                                     final String domain,
                                                     final Collection<GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    private static final long serialVersionUID = -31538870746127783L;

} // The End...
