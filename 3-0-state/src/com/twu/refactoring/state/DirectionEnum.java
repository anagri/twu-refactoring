package com.twu.refactoring.state;

public enum DirectionEnum {
    NORTH {
        @Override
        public DirectionEnum right() {
            return EAST;
        }

        @Override
        public DirectionEnum left() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public DirectionEnum right() {
            return WEST;
        }

        @Override
        public DirectionEnum left() {
            return EAST;
        }
    },
    EAST {
        @Override
        public DirectionEnum right() {
            return SOUTH;
        }

        @Override
        public DirectionEnum left() {
            return NORTH;
        }

    },
    WEST {
        @Override
        public DirectionEnum right() {
            return NORTH;
        }

        @Override
        public DirectionEnum left() {
            return SOUTH;
        }
    };

    public abstract DirectionEnum left();

    public abstract DirectionEnum right();
}
