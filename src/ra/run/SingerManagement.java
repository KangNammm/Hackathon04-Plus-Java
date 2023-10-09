package ra.run;

import ra.model.Singer;

import java.util.Scanner;

public class SingerManagement {
    public static Singer[] singers = new Singer[100];
    static {
        singers[0] = new Singer("Hoàng Dũng", 27,"Việt Nam", true,"Pop Ballad");
        singers[1] = new Singer("Trung Quân Idol", 31,"Việt Nam", true,"Pop Ballad, Ballad");
        singers[2] = new Singer("Orange", 27,"Việt Nam", false,"R&B");
    }
    public static int currentIndex = 3;
    static Scanner scanner = new Scanner(System.in);
    public static void menuSingerManagement() {
        int choice;
        do {
            System.out.println("------------Singer Management------------");
            System.out.println("-----------Danh mục------------");
            System.out.println("1. Thêm mới ca sĩ");
            System.out.println("2. Hiển thị tất cả ca sĩ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo id");
            System.out.println("4. Xóa ca sĩ theo id");
            System.out.println("5. Trở về");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSinger();
                    break;
                case 2:
                    showAllSinger();
                    break;
                case 3:
                    editSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    return;
            }
        }while (true);

    }

    private static void addSinger() {
        Singer singer = new Singer();
        singer.inputSinger(scanner);

        singers[currentIndex++] = singer;
        System.out.println("---------Thêm mới ca sĩ thành công----------");
    }

    private static void showAllSinger() {
        System.out.println("---------Danh sách tất cả ca sĩ-----------");
        for (int i = 0; i < currentIndex; i++) {
            singers[i].displaySinger();
        }
        System.out.println("-----------------");
    }

    private static void editSinger() {
        System.out.println("Hãy nhập id của ca sĩ cần sửa : ");
        int editId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (singers[i].getSingleId() == editId){
                System.out.println("Thông tin ca sĩ mà bạn muốn sửa : ");
                singers[i].displaySinger();
                singers[i].inputSinger(scanner);
                System.out.println("---------Đã cập nhật thông tin ca sĩ---------");
                return;
            }
        }
        System.out.println("-----Không tìm thấy ca sĩ với id vừa nhập-----");
    }

    private static void deleteSinger() {
        System.out.println("Nhập id ca sĩ cần xóa : ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (singers[i].getSingleId() == deleteId){
                for (int j = i; j < currentIndex; j++) {
                    singers[j] = singers[j + 1];
                }
                currentIndex--;
                System.out.println("---------Đã xóa ca sĩ thành công---------");
                return;
            }
        }
        System.out.println("-----Không tìm thấy ca sĩ với id vừa nhập-----");
    }
}
