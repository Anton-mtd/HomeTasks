package ru.skomorokhin.client.model;

import ru.skomorokhin.clientserver.Command;

public interface ReadCommandListener {

    void processReceivedCommand(Command command);

}
