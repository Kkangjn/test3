import java.util.ArrayList;
import java.util.Scanner;

public class User_Number {
    int selectNum;
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> userNumList = new ArrayList<Integer>();
    User_Number(int selectNum){
        this.selectNum = selectNum;
        System.out.println("0~9사이의 숫자를 입력하세요");
    }

    ArrayList<Integer> inputNum (){
        createUserNum:
        for (int i = 1; i<=selectNum; ) {
            System.out.println(i+"번째 숫자를 입력하세요");
            int userNum = sc.nextInt();

            if (userNum>=10){
                System.out.println("잘못된 입력입니다.");
                continue createUserNum;
            }

            for (int j : userNumList) {
                if (j == userNum) {
                    System.out.println("중복된 값입니다.");
                    continue createUserNum;
                }
            }
            userNumList.add(userNum);
            i++;
        }
        return userNumList;
    }
}
