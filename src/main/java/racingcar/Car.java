package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void proceed() {
        this.position += 1;
    }

    public String showProceedBar(){
        String bar = "";
        for (int i =0; i< this.position; i++){
            bar += "-";
        }

        return bar;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
