package com.ea.marsRover.nasa.rover;

import com.ea.marsRover.nasa.domain.Position;
import com.ea.marsRover.nasa.domain.Command;
import com.ea.marsRover.nasa.domain.Coordinate;
import com.ea.marsRover.nasa.domain.Direction;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    public Position changePosition(Position position, Command command) {
        Direction direction = position.getDirection();
        Coordinate coordinate = position.getCoordinate();

        switch (command) {
            case L:
                direction = direction.turnLeft();
                break;
            case R:
                direction = direction.turnRight();
                break;
            case M:
                coordinate = coordinate.move(direction.moveX(), direction.moveY());
                break;
        }

        return new Position(coordinate, direction);
    }

}
