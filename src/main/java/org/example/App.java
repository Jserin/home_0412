package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    //클래스 안에 변수 선언해줘야 사용가능
    private final Scanner sc;
    // 왜 Wisesaying이어야만 get이 되는거지 // Wisesaying을 저장하는 리스트 안에서 가져와야해서?
    List<Wisesaying> wiseSaying = new ArrayList<>();
    HashMap<String, String > params = new HashMap<>();

    // App이 실행되면 바로 sc를 변수로 가져올 수 있도록 생성자 작성
    App(Scanner sc) {
        this.sc = sc;
    }

    // 명언앱 시작
    public void run() {
        // 최초 한 번만 앱 메세지 출력
        System.out.println("== 명언 앱 ==");
        // 명언 번호 생성
        long id = 0;




        // 종료 명령을 받을 때까지 계속 실행하고 종료쓰면 종료
        while (true) {
            System.out.println("명령) ");
            // 입력받은 값을 command 명령 변수에 저장 trim은 공백 발생 시 삭제
            String command = sc.nextLine().trim();


            // 명령이 '종료'면 앱 종료
            if (command.equals("종료")) {
                System.out.println("종료합니다.");
                return;
            } else if (command.equals("등록")) {
                // 반복시 id 증가
                id++;
                // 명령과 작가 입력 받고 각 변수에 저장
                System.out.println("명언 : ");
                String content = sc.nextLine().trim();
                System.out.println("작가 : ");
                String author = sc.nextLine().trim();

                System.out.println(id + "번 명언이 등록되었습니다.");

                // 엔티티에 저장하고 리스트에 등록
                Wisesaying wisesaying = new Wisesaying(id, content, author);
                wiseSaying.add(wisesaying);
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(30));

                for (int i = wiseSaying.size() - 1; i >= 0; i--) {
                    Wisesaying wisesaying = wiseSaying.get(i);
                    System.out.printf("%d / %s / %s\n", wisesaying.getId(), wisesaying.getAuthor(), wisesaying.getContent() );

                }

                System.out.println("등록된 명언 수 : " + wiseSaying.size());
            } else if (command.startsWith("삭제")) {
                //커맨드가 '삭제'로 시작하면 실행
                // id 값을 추출하는 메소드 작성
                // 삭제?id=1&id=2 에서 ?기준으로 둘로 나눈 배열 생성
                String[] commandBits = command.split("\\?", 2); // ["삭제", "id=1&id=2"]
                String actionCode = commandBits[0]; // [삭제]

                // 만약 삭제 뒤로 아이디 값 없으면 중지
                if (commandBits.length == 1) continue;

                String[] paramBits = commandBits[1].split("&"); //[id=1, id=2]

                for (int i = 0; i < paramBits.length; i++) {
                    String[] bits = paramBits[i].split("=", 2);
                    String key = bits[0];
                    String value = bits[1];

                    params.put(key, value);
                }

                System.out.println(params);

                //0412 해시맵에 저장하는 것까지 구현

            }
        }
    }
}
