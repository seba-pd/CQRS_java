package api;

import command.impl.AddItemCommand;
import command.CommandBus;

import java.util.UUID;


public class ItemController {

    private final CommandBus commandBus;

    public ItemController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public void addItem(UUID id, String name){
        commandBus.execute(new AddItemCommand(id, name));
    }
}
