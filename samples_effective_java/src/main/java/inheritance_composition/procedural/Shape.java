package inheritance_composition.procedural;

public class Shape {

    public static final String CIRCLE = "CIRCLE";
    public static final String RECTANGLE = "RECTANGLE";
    private String type;
    private int radius;
    private int height;
    private int weight;

    private Shape(ShapeBuilder builder){
        this.type = builder.type;
        this.radius = builder.radius;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static class ShapeBuilder{
        private String type;
        private int radius;
        private int height;
        private int weight;
        public ShapeBuilder(String type){
            this.type = type;
        }
        public ShapeBuilder setRadius(int radius){
            this.radius = radius;
            return this;
        }

        public ShapeBuilder setHeight(int height){
            this.height = height;
            return this;
        }

        public ShapeBuilder setWeight(int weight){
            this.weight = weight;
            return this;
        }

        public Shape build(){
            return new Shape(this);
        }
    }

    public double getArea() {
        switch (type) {
            case CIRCLE:
                return radius * radius * Math.PI;
            case RECTANGLE:
                return height * weight;
        }
        return 0;
    }

    public double getPerimeter() {
        switch (type) {
            case CIRCLE:
                return 2 * radius * Math.PI;
            case RECTANGLE:
                return (height + weight) * 2;
        }
        return 0;
    }

    public String getName(){
        return type;
    }
}
