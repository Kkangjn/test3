import java.util.ArrayList;

public class Compare {
    Compare(){

    }

    String compareNum(ArrayList<Integer> computerNumList, ArrayList<Integer> userNumList){
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userNumList.size(); i++) {
            int checkUserNum = userNumList.get(i);
            for (int j = 0; j < computerNumList.size(); j++) {
                int checkComputerNum = computerNumList.get(j);
                if (checkComputerNum == checkUserNum) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                } else {
                    continue;
                }
            }
        }
        if (strike == userNumList.size()) {
            System.out.println("정답입니다.");
            return (strike+"S");
        } else {
            System.out.println(ball + "B" + strike + "S");
            return (ball + "B" + strike + "S");
        }
    }
}
