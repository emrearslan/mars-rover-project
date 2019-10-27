package com.ea.marsRover.nasa.domain;

public class Compass {

    public static class East implements Direction {

        public Direction turnLeft() {
            return new North();
        }

        public Direction turnRight() {
            return new South();
        }

        public int moveX() {
            return 1;
        }

        public int moveY() {
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof East);
        }

        public String toString() {
            return "E";
        }
    }

    public static class North implements Direction {

        public Direction turnLeft() {
            return new West();
        }

        public Direction turnRight() {
            return new East();
        }

        public int moveX() {
            return 0;
        }

        public int moveY() {
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof North);
        }

        public String toString() {
            return "N";
        }
    }

    public static class South implements Direction {

        public Direction turnLeft() {
            return new East();
        }

        public Direction turnRight() {
            return new West();
        }

        public int moveX() {
            return 0;
        }

        public int moveY() {
            return -1;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof South);
        }

        public String toString() {
            return "S";
        }
    }

    public static class West implements Direction {

        public Direction turnLeft() {
            return new South();
        }

        public Direction turnRight() {
            return new North();
        }

        public int moveX() {
            return -1;
        }

        public int moveY() {
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof West);
        }

        public String toString() {
            return "W";
        }
    }

}
