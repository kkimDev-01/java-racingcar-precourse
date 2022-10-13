package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        //TODO : cars input verification

        String[] carArr = cars.split(",");
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i<3; i++){
            carList.add(new Car(carArr[i]));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String time = Console.readLine();
        //TODO : time input verification

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i<5; i++){
            for (int j =0; j<3; j++){
                oneCarRace(carList.get(i));
                System.out.println(carList.get(i).getName() + " : "+ carList.get(i).showProceedBar());
            }



        }

        //TODO : 최종 우승자 print

    }

    private static void oneCarRace(Car car) {
        if ( Randoms.pickNumberInRange(0,9) >= 4 ){
            car.proceed();
        }
    }
}
