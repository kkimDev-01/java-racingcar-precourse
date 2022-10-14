package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        //TODO : cars input verification
        if (!(cars.indexOf(",") > 0 && cars.indexOf(",", cars.indexOf(",")+1) >0)){
            System.out.println("[ERROR] 쉼표 입력이 부족합니다");
            throw new IllegalArgumentException("[ERROR] 쉼표 입력이 부족합니다");
        }

        String[] carArr = cars.split(",");
        List<Car> carList = new ArrayList<>();


        for (int i = 0; i<3; i++){
            if (carArr[i].length() > 5){
                System.out.println("[ERROR] 5글자를 초과합니다");
                throw new IllegalArgumentException("[ERROR] 5글자를 초과합니다");
            }

            carList.add(new Car(carArr[i]));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String time = Console.readLine();
        //TODO : time input verification
        try {
            int intTime = Integer.parseInt(time);
        }
        catch (Exception e){
            System.out.println("[ERROR] 회수는 정수를 입력해야 합니다.");
            throw new IllegalArgumentException("[ERROR] 회수는 정수를 입력해야 합니다.");
        }

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i<Integer.parseInt(time); i++){
            String printRes = "";
            for (int j =0; j<3; j++){
                oneCarRace(carList.get(j));
                printRes += (carList.get(j).getName() + " : " + carList.get(j).showProceedBar() + "\n");
            }

            System.out.println(printRes);

        }


        //TODO : 최종 우승자 print
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                if (c1.getPosition() > c2.getPosition()) {
                    return -1;
                } else if (c1.getPosition() < c2.getPosition()) {
                    return 1;
                }
                return 0;
            }
        });

        int twoOrMore = 0;
        for (int i = 1; i<3; i++){
            if (carList.get(0).getPosition() == carList.get(i).getPosition()){
                twoOrMore += 1;
            }
            else {
                break;
            }
        }

        String winner = carList.get(0).getName();

        for (int i =1; i <= twoOrMore; i++){
            winner += ", " + carList.get(i).getName();
        }

        System.out.print(String.format("최종 우승자 : %s", winner));


    }

    private static void oneCarRace(Car car) {
        if ( Randoms.pickNumberInRange(0,9) >= 4 ){
            car.proceed();
        }
    }
}
