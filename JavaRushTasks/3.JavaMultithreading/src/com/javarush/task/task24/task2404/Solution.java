package com.javarush.task.task24.task2404;

/*
Рефакторинг Rectangle
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        System.out.println(castToHasHeight(rectangle));
        System.out.println(castToHasWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(castToHasHeight(rectangle.castToHasHeight()));
        System.out.println(castToHasWidth(rectangle.castToHasWidth()));
    }

    public static HasHeight castToHasHeight(final Rectangle rectangle) {
        return new HasHeight() {
            @Override
            public double getHeight() {
                return Math.abs(rectangle.point1.getY() - rectangle.point2.getY());
            }
        };
    }

    public static HasWidth castToHasWidth(final Rectangle rectangle) {
       return new HasWidth() {
           @Override
           public double getWidth() {
               return Math.abs(rectangle.point1.getX() - rectangle.point2.getX());
           }
       };
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public Rectangle castToHasHeight() {
            return this;
        }

        public Rectangle castToHasWidth() {
            return this;
        }
    }
}
