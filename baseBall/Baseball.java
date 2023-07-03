import java.util.*;

public class Baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selectNum;

        do {
            System.out.println("3~9 사이 값을 입력하세요!");
            System.out.print("숫자 입력 :");
            selectNum = sc.nextInt();
            if (selectNum < 3 || selectNum > 9) {
                System.out.println("범위를 초과했습니다.");
            }
        } while (selectNum < 3 || selectNum > 9);

        Random_Number randomNumber = new Random_Number(selectNum);
        ArrayList<Integer> computerNumList = randomNumber.createNum();
        System.out.println("컴퓨터가 숫자 생성 완료! 답을 맞춰보세요!");
        int tryNum = 0;
        String result;

        do {
            User_Number userNumber = new User_Number(selectNum);
            ArrayList<Integer> userNumList = userNumber.inputNum();

            System.out.println(tryNum + 1 + "번째 시도: " + userNumList.toString());
            Compare compareNum = new Compare();
            result = compareNum.compareNum(computerNumList, userNumList);
            tryNum++;
        } while (!(Objects.equals(result, selectNum + "S")));
        System.out.println(tryNum + "번만에 맞히셨습니다!");
        System.out.println("게임을 종료합니다.");

    }
}

// 숫자 범위 확인
//            if (number==9){
//                System.out.println("9가 출력됐습니다.");
//                break;
//            }
//            if (number==0){
//                System.out.println("0이 출력됐습니다.");
//                break;
//            }
//  -> random.nextInt(9) 0~8만 생성됨 -> 10으로 수정
//  배열에 저장 할 예정

// 항상 같은 순서로 출력되는지 확인
//        System.out.println(computerNumList.toString());
//        System.out.println(computerNumList.toString());
//        System.out.println(computerNumList.toString());
//        System.out.println(computerNumList.toString());
// 같은값 확인 완료 중복 추가 할 예정


// 중복 확인 추가!
//        for (int i=0;i<=2;i++){
//            computerNumList.add(random.nextInt(10));
//        }
// 수정
//        createComputerNum: // Label 생성
//        for (int i=0;i<=2;){ // 증가함수? i++를 for 문 안으로 이동
//          int randomNum = random.nextInt(10);
//              for (int j: computerNumList){
//                  if (j==randomNum){
//                      continue createComputerNum; // Label continue -> 중첩 for 문에서 바깥의 for 문 continue;
//                  }
//              }
//          computerNumList.add(randomNum);
//          i++; // for 문 안에서 증가
//        }
// 1.Label 생성 2.Label continue -> 중첩 for 문에서 바깥의 for 문 continue; 3.증가함수? i++를 for 문 안으로 이동 4.for 문 안에서 증가 -> 증복값이 나오면 같은 i에서 한번 더 진행하기 위함

// 같은 방식으로 사람 숫자 입력받기
//    createUserNum:
//        for(int i=0; i<computerNumList.size(); ){
//            int userNum = sc.nextInt();
//            for (int j: userNumList){
//                if (j==userNum){
//                    System.out.println("중복된 값입니다.");
//                    continue createUserNum;
//                }
//            }
//            userNumList.add(userNum);
//            i++;
//        }
// 만들다가 생각난건데 같은 값이 나오면 중첩 for 문을 break; 해버리고 다시 생성하는 방식으로 하면 될까? -> 다시 중첩 검사를 못함  ->기각

// 값 비교 생성
//        int strike = 0;
//        int ball = 0;
//        for (int i=0; i<userNumList.size(); i++){
//            int checkUserNum = userNumList.get(i);
//            for (int j=0; j<computerNumList.size(); j++){
//                int checkComputerNum = computerNumList.get(j);
//                if(checkComputerNum == checkUserNum){
//                    if(i==j){
//                        strike++;
//                    }else {
//                        ball++;
//                    }
//                }else {
//                    continue;
//                }
//            }
//        }
//        if(strike==3){
//            System.out.println("정답입니다.");
//        }else {
//            System.out.println(ball + "B" + strike + "S");
//        }
// 벌써 코드가 더러움
// 값비교를 유저 입력 안으로 넣어서, 같은 컴퓨터 숫자 안에서 여러번 입력받을수있게 만들어야함

// 사람 입력과 비교를 새로운 for 문으로 감쌌음
//        replay:
//        for (int x=0;x>=0;x++) {
//          ~~~~~~~~~~~~~~~~
//            if (strike == 3) {
//                System.out.println("정답입니다.");
//                break replay;
//            } else {
//                System.out.println(ball + "B" + strike + "S");
//                continue replay;
//            }
//        }
// 몇번만에 맞췄는지 횟수 추가를 안함

// replay: for 문에 x를 통해 구현함 -> x를 바로 써서 1번째로 출력받고싶어서 for(int x=1; ..) 로 수정

// 기타 출력 문구 추가

// 지금 구현 상태에서 만약 컴퓨터가 난수 생성에서 같은 값만 출력한다면 문제가 생김
// -> 순서가 없는 set 을 이용, set 의 index 를 0 ~ 9 로 생성하고 하나씩 뽑아서 생성하는 방식 선택
//        HashSet<Integer> randomNumber = new HashSet<Integer>();
//        for (int i=0; i<=9; i++) {
//            randomNumber.add(i);
//        }
//        Iterator<Integer> iterator = randomNumber.iterator();
//
//        createComputerNum:
//        for (int i=0;i<=2;){
//            int randomNum = iterator.next();
//            computerNumList.add(randomNum);
//            i++;
//        }
// 순서가 없다했는데, 항상 0, 1, 2 가 출력됨 -> 일부터 섞지는 않는듯함 아니면 숫자로 받아서 순서가 생긴걸지도?
// -> List 로 바꾸고 0~9 저장, 난수 생성을 통해 0~9 에서 하나 랜덤으로 선택하고 선택된 숫자를 get 으로 입력받고, remove 로 삭제해야겠음

//        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
//        for (int i=0; i<=9; i++) {
//            randomNumber.add(i);
//        }
//
//        createComputerNum:
//        for (int i=0;i<=2;){
//            int randomNum = random.nextInt(10);
//            computerNumList.add(randomNumber.get(randomNum));
//            randomNumber.remove(randomNum);
//            i++;
//        }
//        System.out.println(computerNumList.toString());
//        System.out.println("컴퓨터가 숫자 생성 완료! 답을 맞춰보세요!");
// 한번씩 범위 오류가 발생함(ArrayIndexOutOfBoundsException) -> 예상) 첫 반복은 문제 없지만, 두 번째 반복부터는 ArrayList의 크기가 10보다 작아짐 --> 두번째 바퀴 부터는 9를 못받음, 세번째 바퀴에는 8, 9 를 못받음
// -> random 의 범위를 10이 아닌 변수로 받아서 10 -> 9 -> 8 로 줄어들게 만듬

// 수정완료!
//        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
//        for (int i=0; i<=9; i++) {
//            randomNumber.add(i);
//        }
//
//        for (int i=0;i<=2;){
//            int j = 10-i;
//            int randomNum = random.nextInt(j);
//            computerNumList.add(randomNumber.get(randomNum));
//            randomNumber.remove(randomNum);
//            i++;
//        }
//        System.out.println(computerNumList.toString());
//        System.out.println("컴퓨터가 숫자 생성 완료! 답을 맞춰보세요!");
// 유저가 10이상의 수를 입력하거나 정수가 아닌 다른 타입을 입력하는 경우 예외 처리를 해줘야 함
// -> 10이상의 정수는 if 문으로 간단하게 처리 할 수 있지만 다른 타입은 컴파일에러가 발생 -> 따로 예외 처리를 해줘야 하는데 생각이 안남 --> 4주차 학습 후에 다시 시도

// class 를 나눈뒤 메서드를 사용해서 main 을 깔끔하게 사용하고싶음, 바꾸는 김에 자리수도 추가하고싶음!
// 1. class main - 생성할 자리수 입력, 시도한 횟수 체크
// - 1. Scanner 로 자리수 받기 selectNum
// - 2. 자리수로 난수생성.method 실행
// - 3. for 문 안에서 유저입력.method, 비교하기.method 반복 횟수를 try 에 입력받아서 체크
// - 4. 기타 문구 출력
// 2. class 난수생성 - method1 난수생성 및 중복검사
// - 1. 생성자에 매개변수 selectNum 을 받고 this. 을 이용해서 클래스에 자리수 저장
// - 2. selecNum 만큼 난수생성, 만들어 놓은 코드 일부수정!
// 3. class 유저입력 - method1 유저입력 및 오류검사
//   3.1 아직 4주차를 못들어서 오류를 예외처리 하지않고, 입력을 String 으로 받은 뒤 강제형변환을 하려했으나 마찬가지 일듯! -> 예외처리를 받아야함
// - 1,2. 난수생성과 동일!
// 4. class 비교하기 - method1 난수와 입력값 비교
// - 1,2 난수생성과 동일!
// 완성! -> 좀 아쉬움
// main 은 앞단에서 필요한부분만(출력, 입력받기) 남겨두고싶음!

//[송룸메] [오후 6:50] 이건 그냥 평범한 의견인데 system out 모아서 GameUiManager라고 클래스 빼보는건 어떰
//[송룸메] [오후 6:51] .start()하면 시스템 주루룩 나오고 인풋 받고
//.end()하면 스코어랑 게임종료 시스템 주루룩 나오고
//[송룸메] [오후 6:51] 그러면 public간 데이터 이동이 어찌 되는지 감 잡힐듯
//[송룸메] [오후 6:51] 그리고 지저분한 system out을 합칠 수 있음
//[송룸메] [오후 6:55] 안내문 생성을 별도의 장소에서 독립적으로 함으로서 기획자한테 일을 넘길 수 있게 되는거임

// x번째 시도 ; [0,1,2] -> 012 로 바꾸기
//    public String toString() {
//        Iterator<E> it = iterator();
//        if (! it.hasNext())
//            return "[]";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('[');
//
//        for (;;) {
//            E e = it.next();
//            sb.append(e == this ? "(this Collection)" : e);
//            if (! it.hasNext())
//                return sb.append(']').toString();
//            sb.append(',').append(' ');
//        }
//    }
// toString 을 오버라이드해서 리스트변수명.toString() -> 리스트의 값들을 , , , 나열하고 [] 감싸준다.([0,1,2]) -> []와 , 를 없애주려고 했으나 잘안됨
// -> 어디가 잘안되는가? .toString() 매개변수가 없는데 어떻게 Arraylist의 인덱스를 조회하는가? -> 생성할때 리스트를 저장하는 부분이 있을거다 -> 생성자를 못찾겠음
// -> Iterator<E> it = iterator(); 이부분 해석이 안됨

// 돌아와서 ArrayList를 꼭 써야하는가? ArrayList의 메서드들을 살펴본 결과 지금 수준에서는 굳이 필요하지 않다!
// -> ArrayList를 그냥 int[]로 변경하자!
