import java.util.ArrayList;
import java.util.Random;

public class Random_Number {
    int selectNum;
    Random random = new Random();
    ArrayList<Integer> computerNumList = new ArrayList<Integer>();
    ArrayList<Integer> randomNumber = new ArrayList<Integer>();

    Random_Number(int selectNum) {
        this.selectNum = selectNum;
        for (int i=0; i<=9; i++) {
            this.randomNumber.add(i);
        }
        System.out.println("컴퓨터가 " + selectNum + "자리의 랜덤숫자를 생성합니다.");
    }

    ArrayList<Integer> createNum() {
        System.out.println("생성중");
        for (int i=0; i<selectNum; ) {
            int j = 10 - i;
            int randomNum = random.nextInt(j);
            computerNumList.add(randomNumber.get(randomNum));
            randomNumber.remove(randomNum);
            i++;
        }
        return computerNumList;
    }
}
