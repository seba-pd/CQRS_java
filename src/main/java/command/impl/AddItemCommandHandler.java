package command.impl;

import command.Command;
import command.CommandHandler;
import command.ItemWriteRepository;
import domain.Item;

public class AddItemCommandHandler implements CommandHandler {

    private final ItemWriteRepository itemWriteRepository;

    public AddItemCommandHandler(ItemWriteRepository itemWriteRepository) {
        this.itemWriteRepository = itemWriteRepository;
    }

    @Override
    public void handle(Command command) {
        var handledCommand = (AddItemCommand) command;
        itemWriteRepository.addItem(new Item(handledCommand.getId(), handledCommand.getName()));
    }
}
