package axon.core.steam;

import axon.core.infrastructure.steam.SteamGateway;
import axon.core.user.event.GameBoughtEvent;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.springframework.beans.factory.annotation.Autowired;

public class SteamRegistrationSaga extends AbstractAnnotatedSaga {
    private transient SteamGateway steamGateway;

    @Autowired
    public void setSteamGateway(SteamGateway steamGateway) {
        this.steamGateway = steamGateway;
    }

    public void handle(GameBoughtEvent gameBoughtEvent) {
        throw new UnsupportedOperationException();
    }

    //TODO Implement and Complete
}
