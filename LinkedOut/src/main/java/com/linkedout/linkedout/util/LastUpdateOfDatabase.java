package com.linkedout.linkedout.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("lastUpdate")
@SessionScope
public class LastUpdateOfDatabase {

    private LocalDateTime lastUpdate;

    public LastUpdateOfDatabase(){
        this.lastUpdate = LocalDateTime.now();
    }

    public String getLastUpdate() {
        return this.lastUpdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
