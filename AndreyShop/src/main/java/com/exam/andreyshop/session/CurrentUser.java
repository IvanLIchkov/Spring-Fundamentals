package com.exam.andreyshop.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;

    public Long getId() {
        return id;
    }

    public void login(Long id) {
        this.id = id;
    }

    public void logout(){
        this.id = null;
    }
}
