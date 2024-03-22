package Pegas.listener;

import org.springframework.context.ApplicationEvent;

public class Entity extends ApplicationEvent {
    private AccessType accessType;
    public Entity(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
