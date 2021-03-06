package axon.core;

import axon.core.command.RegisterUserCommand;
import axon.core.event.UserRegisteredEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import java.util.UUID;

public class User extends AbstractAnnotatedAggregateRoot<UUID> {
    private UUID uuid;

    @CommandHandler
    public User(RegisterUserCommand registerUserCommand) {
        UUID uuid = registerUserCommand.getUuid();

        UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent(uuid);
        apply(userRegisteredEvent);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getEmailAddress() {
        throw new UnsupportedOperationException();
    }

    @EventSourcingHandler
    public void userRegistered(UserRegisteredEvent userRegisteredEvent) {
        this.uuid = userRegisteredEvent.getUuid();
    }
}
