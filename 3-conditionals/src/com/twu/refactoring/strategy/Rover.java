package com.twu.refactoring.strategy;

public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position navigate(String instructions) {
        for (char command : instructions.toCharArray()) {
            if(command == 'M') {
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }
            if(command == 'L') {
                switch (direction) {
                    case 'N':
                        direction = 'W';
                        break;
                    case 'S':
                        direction = 'E';
                        break;
                    case 'E':
                        direction = 'N';
                        break;
                    case 'W':
                        direction = 'S';
                        break;
                }
            }
            if(command == 'R') {
                switch (direction) {
                    case 'N':
                        direction = 'E';
                        break;
                    case 'S':
                        direction = 'W';
                        break;
                    case 'E':
                        direction = 'N';
                        break;
                    case 'W':
                        direction = 'S';
                        break;
                }
            }
        }
        return new Position(x, y, direction);
    }
}
