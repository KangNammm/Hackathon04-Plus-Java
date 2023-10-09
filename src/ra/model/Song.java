package ra.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static ra.run.SingerManagement.currentIndex;
import static ra.run.SingerManagement.singers;

public class Song {
    Scanner scanner = new Scanner(System.in);
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createDate;
    private boolean songStatus;
    private static int ramdomId = 0;
    private String validateId(){
        ramdomId++;
        return "S" + String.format("%03d", ramdomId);
    }
    public Song(){
        this.songId = validateId();
        this.createDate = new Date();
    }

    public Song(String songId, String songName, String descriptions,Singer singer, String songWriter, boolean songStatus) {
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createDate = new Date();
        this.songStatus = songStatus;
        this.songId = validateId();
    }
    public String getSongId() {
        return songId;
    }
    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
    public void inputSong(Scanner scanner){
        System.out.println("---------Thêm mới bài hát-----------");

        while (true){
            System.out.println("Nhập tên bài hát : ");
            String name = scanner.nextLine();
            if (name.trim().length() > 1){
                this.songName = name;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập mô tả bài hát : ");
            String des = scanner.nextLine();
            if (des.trim().length() > 1){
                this.descriptions = des;
                break;
            }
            System.out.println("Không được để trống");
        }
        System.out.println("Danh sách các ca sĩ : ");
        for (int i = 0; i < currentIndex; i++) {
            singers[i].displaySinger();
        }
        System.out.println("Mời nhập id ca sĩ để lựa chọn : ");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        for (int i = 0; i < currentIndex; i++) {
            check = true;
            if (choice == singers[i].getSingleId()){
               this.singer = singers[i];
               break;
            }else {
                check = false;
            }
        }if (check == false){
            System.out.println("Không tìm thấy ca sĩ này. Mời nhập thêm ca sĩ");
        }

        while (true){
            System.out.println("Nhập tác giả : ");
            String writter = scanner.nextLine();
            if (writter.trim().length() > 1){
                this.songWriter = writter;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập trạng thái : (true/false) ");
            this.songStatus = Boolean.parseBoolean(scanner.nextLine());
            break;
        }
    }
    public void displaySong(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(
                "Id: " + this.songId + "; \n"
                        + "Tên bài hát: " + this.songName+ "; \n"
                        + "Mô tả: " + this.descriptions + "; \n"
                        + "Ca sĩ: " + this.singer.getSingerName() + "; \n"
                        + "Sáng tác: " + this.songWriter + "; \n"
                        + "Trạng thái: " + (this.songStatus ? "Đang phát hành":"Chưa phát hành") + "; \n"
                        + "Ngày tạo: " + this.createDate + "; \n"
        );
    }
}
