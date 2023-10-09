package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class SearchManagement {
    static Scanner scanner = new Scanner(System.in);
    static Song[] songs = new Song[50];
    static Singer[]singers = new Singer[50];
    static int currentIndex = 0;
    public static void menuSearch() {



        int choice;
        do {
            System.out.println("------------Search Management------------");
            System.out.println("-----------Danh mục------------");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2. Hiển thị tất cả bài hát");
            System.out.println("3. Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("4. .Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("5. Trở về");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên bài hát : ");
                    String searchValue = scanner.nextLine();
                    System.out.println("Kết quả tìm kiếm : ");
                    boolean check = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (songs[i].getSongName().contains(searchValue)){
                            songs[i].displaySong();
                            System.out.println();
                            check = true;
                        }
                    }
                    if (!check){
                        System.out.println("Không có thông tin về bài hát bạn tìm kiếm");
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên ca sĩ : ");
                    String value = scanner.nextLine();
                    System.out.println("Kết quả tìm kiếm : ");
                    boolean checkvalue = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (singers[i].getSingerName().contains(value){
                            singers[i].displaySinger();
                            System.out.println();
                            checkvalue = true;
                        }
                    }
                    if (!checkvalue){
                        System.out.println("Không có thông tin về bài hát bạn tìm kiếm");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }while (true);
    }
}
