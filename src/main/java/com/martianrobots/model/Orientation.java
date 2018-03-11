package com.martianrobots.model;

import static com.martianrobots.model.Position.position;

public enum Orientation {
    N(0, 1) {
        public Orientation turnLeft() {
            return W;
        }

        public Orientation turnRight() {
            return E;
        }
    }, S(0, -1) {
        public Orientation turnLeft() {
            return E;
        }

        public Orientation turnRight() {
            return W;
        }
    }, E(1, 0) {
        public Orientation turnLeft() {
            return N;
        }

        public Orientation turnRight() {
            return S;
        }
    }, W(-1, 0) {
        public Orientation turnLeft() {
            return S;
        }

        public Orientation turnRight() {
            return N;
        }
    };

    private final int xOffset;
    private final int yOffset;

    Orientation(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public abstract Orientation turnLeft();
    public abstract Orientation turnRight();

    public Position getPosition() {
        return position(xOffset, yOffset);
    }
}
