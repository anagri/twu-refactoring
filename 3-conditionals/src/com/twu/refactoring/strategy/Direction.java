package com.twu.refactoring.strategy;

public enum Direction {
    NORTH {
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }
    },
    EAST {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }

    },
    WEST {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    };

    public abstract Direction left();

    public abstract Direction right();
}
