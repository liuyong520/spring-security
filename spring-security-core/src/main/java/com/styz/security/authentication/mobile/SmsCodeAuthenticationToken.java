package com.styz.security.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * creat date:2019-07-16 10:43
 * author:xxydliuyss
 * note:
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken{
        private final Object principal;
//        private Object credentials;

        public SmsCodeAuthenticationToken(Object principal) {
            super((Collection)null);
            this.principal = principal;
            this.setAuthenticated(false);
        }

        public SmsCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
            super(authorities);
            this.principal = principal;
            super.setAuthenticated(true);
        }


    @Override
    public Object getCredentials() {
        return null;
    }

    public Object getPrincipal() {
            return this.principal;
        }

        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            if (isAuthenticated) {
                throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
            } else {
                super.setAuthenticated(false);
            }
        }

        public void eraseCredentials() {
            super.eraseCredentials();
        }
}

