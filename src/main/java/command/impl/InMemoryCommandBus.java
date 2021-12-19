package command.impl;

import command.Command;
import command.CommandBus;
import command.CommandHandler;

import java.util.LinkedList;
import java.util.Map;

public class InMemoryCommandBus implements CommandBus {

    private final Map<String, CommandHandler> handlerMap;
    private final LinkedList<Command> commandQueue;
    private Boolean isHandling = false;

    public InMemoryCommandBus(Map<String, CommandHandler> mappedCommand, LinkedList<Command> commandQueue) {
        this.handlerMap = mappedCommand;
        this.commandQueue = commandQueue;
    }

    @Override
    public void execute(Command command) {

        commandQueue.add(command);

        if(isHandling){
            return;
        }

       while(!commandQueue.isEmpty()){
           isHandling = true;
           Command c = commandQueue.poll();
           String handlerName = c.getClass().getName();
           handlerMap.get(handlerName).handle(c);
       }
       isHandling = false;
    }
}
