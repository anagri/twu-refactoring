package com.twu.refactoring.state;

public abstract class Direction {
    public static final Direction NORTH = new Direction() {
        @Override
        public Direction turnRight() {
            return EAST;
        }

        @Override
        public Direction turnLeft() {
            return WEST;
        }
    };
    public static final Direction SOUTH = new Direction() {
        @Override
        public Direction turnRight() {
            return WEST;
        }

        @Override
        public Direction turnLeft() {
            return EAST;
        }
    };
    public static final Direction EAST = new Direction() {
        @Override
        public Direction turnRight() {
            return SOUTH;
        }

        @Override
        public Direction turnLeft() {
            return NORTH;
        }
    };
    public static final Direction WEST = new Direction() {
        @Override
        public Direction turnRight() {
            return SOUTH;
        }

        @Override
        public Direction turnLeft() {
            return NORTH;
        }
    };

    private Direction() {
    }

    public abstract Direction turnRight();

    public abstract Direction turnLeft();
}
