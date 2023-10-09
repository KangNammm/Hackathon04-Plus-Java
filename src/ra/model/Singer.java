package ra.model;

import java.util.Scanner;

public class Singer {
    private int singleId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;
    private static int count = 1;
    Scanner scanner = new Scanner(System.in);

    public Singer(){
        this.singleId = Singer.count++;
    }

    public Singer(String singerName, int age, String nationality, boolean gender, String genre) {
        this.singleId = Singer.count++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingleId() {
        return singleId;
    }

    public void setSingleId(int singleId) {
        this.singleId = singleId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputSinger(Scanner scanner){
        System.out.println("--------Thêm mới ca sĩ----------");

        while (true){
            System.out.println("Nhập tên ca sĩ : ");
            String name = scanner.nextLine();
            if (name.trim().length() > 1){
                this.singerName = name;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập tuổi : ");
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age > 0){
                break;
            }
        }
        while (true){
            System.out.println("Nhập quốc tịch : ");
            String national = scanner.nextLine();
            if (national.trim().length() > 1){
                this.nationality = national;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập giới tính : (true/false) ");
            this.gender = Boolean.parseBoolean(scanner.nextLine());
            break;
        }

        while (true){
            System.out.println("Nhập thể loại : ");
            String genres = scanner.nextLine();
            if (genres.trim().length() > 1){
                this.genre = genres;
                break;
            }
            System.out.println("Không được để trống");
        }
    }
    public void displaySinger(){
        System.out.println(
                          "Id: " + this.singleId+ "; \n"
                        + "Tên ca sĩ: " + this.singerName + "; \n"
                        + "Tuổi: " + this.age + "; \n"
                        + "Quốc tịch: " + this.nationality + "; \n"
                        + "Giới tính: " + (this.gender ? "Nam":"Nữ") + "; \n"
                        + "Thể loại: " + this.genre + "; \n"
        );
    }
}
