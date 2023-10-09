package ra.run;

import ra.model.Song;

import java.util.Scanner;

public class SongManagement {
    static Song[] songs = new Song[50];
    static int index = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void menuSongManagement() {
        int choice;
        do {
            System.out.println("------------Song Management------------");
            System.out.println("-----------Danh mục------------");
            System.out.println("1. Thêm mới bài hát");
            System.out.println("2. Hiển thị tất cả bài hát");
            System.out.println("3. Thay đổi thông tin bài hát theo id");
            System.out.println("4. Xóa ca sĩ theo id");
            System.out.println("5. Trở về");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSong();
                    break;
                case 2:
                    showAllSong();
                    break;
                case 3:
                    editSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    return;
            }
        }while (true);


    }

    private static void addSong() {
        Song song = new Song();
        song.inputSong(scanner);

        songs[index++] = song;
        System.out.println("--------Thêm mới bài hát thành công----------");
    }

    private static void showAllSong() {
        System.out.println("----------Danh sách tất cả bài hát------------");
        for (int i = 0; i < index; i++) {
            songs[i].displaySong();
        }
        System.out.println("-----------------");
    }

    private static void editSong() {
        System.out.println("Hãy nhập id bài hát cần sửa : ");
        String  editSongId = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (songs[i].getSongId().equals(editSongId)){
                System.out.println("Thông tin bạn muốn sửa : ");
                songs[i].displaySong();
                songs[i].inputSong(scanner);
                System.out.println("------Đã cập nhật thông tin bài hát thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy bài hát với id vừa nhập");
    }

    private static void deleteSong() {
        System.out.println("Hãy nhập id bài hát cần xóa : ");
        String  deleteSongId = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (songs[i].getSongId().equals(deleteSongId)){
                for (int j = i; j < index; j++) {
                    songs[j] = songs[j + 1];
                }
                index--;
                System.out.println("----Đã xóa bài hát thành công------");
                return;
            }
        }
        System.out.println("Không tìm thấy bài hát với id vừa nhập");
    }
}
