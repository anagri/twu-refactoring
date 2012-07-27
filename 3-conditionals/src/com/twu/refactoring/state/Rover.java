package com.twu.refactoring.state;

public class Rover {
    private Position position;

    public Rover(int x, int y, Direction direction) {
        position = new Position(x, y, direction);
    }

    public Position navigate(String instructions) {
        for (char command : instructions.toCharArray()) {
            if(command == 'M') {
                position = position.moveForward();
            }
            if(command == 'L') {
                position = position.turnLeft();
            }
            if(command == 'R') {
                position = position.turnRight();
            }
        }
        return position;
    }
}