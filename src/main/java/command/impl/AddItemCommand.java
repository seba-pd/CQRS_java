package command.impl;

import command.Command;

import java.util.UUID;

public class AddItemCommand implements Command {

    private  UUID id;
    private  String name;

    public AddItemCommand(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
