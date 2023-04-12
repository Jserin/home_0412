package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 실행화면에서 입력 받는 값을 스캔하고 저장하는 변수 선언
        Scanner sc = new Scanner(System.in);

        // 프로그램 몸통 따로 클래스 만듦 입력받은 sc를 변수로 받아야 사용됨
        // 클래스 처음 가져오는 거니까 new!!!!!!!!!!!!!!!!!!!!!!!!
        new App(sc).run();

        //스캐너 종료
        sc.close();
    }
}
