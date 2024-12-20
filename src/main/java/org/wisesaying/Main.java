package org.wisesaying;

import java.util.Scanner;

public class Main {
    // 메뉴 출력 메소드
    public static void printMenu() {
        System.out.println("========== 명언 앱 ==========");
        System.out.println("[ 등록 / 삭제 / 수정 / 목록 / 종료 ]");
        System.out.print  ("명령 > ");
    }

    // 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();

        while(true) {
            printMenu();
            String cmd = sc.nextLine();

            // 등록 메뉴
            if(cmd.equals("등록")) {
                System.out.println("▶▶ 명언 등록 ◀◀");
                System.out.println("> 등록할 명언과 작가를 입력하세요.");
                app.addWiseSaying(app.inputWiseSaying());
            }

            // 목록 메뉴
            if(cmd.equals("목록")) {
                System.out.println("▶▶ 명언 목록 ◀◀");
                app.printAllWiseSaying();
            }

            // 삭제 메뉴
            if(cmd.startsWith("삭제")) {
                System.out.println("▶▶ 명언 삭제 ◀◀");
                app.deleteWiseSaying(cmd);
            }

            // 수정 메뉴
            if(cmd.startsWith("수정")) {
                System.out.println("▶▶ 명언 수정 ◀◀");
                WiseSaying targetWiseSaying = app.findTargetWiseSaying(cmd, "수정");
                if(targetWiseSaying != null) {
                    System.out.println("명언(기존): " + targetWiseSaying.getContent());
                    System.out.print("명언: ");
                    String newContent = sc.nextLine();
                    System.out.println("작가(기존): " + targetWiseSaying.getAuthor());
                    System.out.print("작가: ");
                    String newAuthor = sc.nextLine();
                    app.updateWiseSaying(cmd, newContent, newAuthor);
                }
            }

            // 종료 메뉴
            if(cmd.equals("종료")) {
                System.out.println("> 앱이 종료되었습니다.\n");
                break;
            }
        }

        sc.close();
    }
}