package ra.run;

import java.util.Scanner;

public class MusicManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-----------Music Management------------");
            System.out.println("-----------Danh mục------------");
            System.out.println("1. Quản lí ca sĩ");
            System.out.println("2. Quản lí bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    SingerManagement.menuSingerManagement();
                    break;
                case 2:
                    SongManagement.menuSongManagement();
                    break;
                case 3:
                    SearchManagement.menuSearch();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}
