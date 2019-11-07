package com.ea.marsRover.nasa.rover;

import com.ea.marsRover.message.MessageService;
import com.ea.marsRover.nasa.domain.Command;
import com.ea.marsRover.nasa.domain.Coordinate;
import com.ea.marsRover.nasa.domain.Position;
import com.ea.marsRover.nasa.domain.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoverService {

    @Autowired
    private PositionService positionService;

    @Autowired
    private MessageService messageService;

    public Position explore(Rover rover) {
        if (rover == null) {
            throw new IllegalArgumentException(messageService
                    .getMessage("message.general.object.notNull", new Object[]{Rover.class}));
        }

        Position position = rover.getPosition();
        Coordinate plateau = rover.getPlateau();

        if (!CollectionUtils.isEmpty(rover.getCommands())) {
            for (Command command : rover.getCommands()) {
                if (!position.isMovable(plateau)) {
                    position.setRip(true);
                    return position;
                }

                position = positionService.changePosition(position, command);
            }
        }

        return position;
    }

    public List<Position> explores(List<Rover> rovers) {
        if (CollectionUtils.isEmpty(rovers)) {
            throw new IllegalArgumentException(messageService.getMessage("message.rovers.notNullorEmpty", null));
        }

        List<Position> positions = new ArrayList<>();

        if (!CollectionUtils.isEmpty(rovers)) {
            for (Rover rover : rovers) {
                positions.add(explore(rover));
            }
        }

        return positions;
    }

}
