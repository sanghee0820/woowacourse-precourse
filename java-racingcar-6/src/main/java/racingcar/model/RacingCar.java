package racingcar.model;

public class RacingCar {
    private final String name;
    private Integer position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(){
        this.position++;
    }

    @Override
    public String toString() {
        return this.name
                + " : "
                + "-".repeat(Math.max(0, this.position));
    }
}
