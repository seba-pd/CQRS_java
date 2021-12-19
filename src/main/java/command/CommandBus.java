package command;

public interface CommandBus {

    void execute(Command command);
}
