/*public class example {
    class Person  { //thuộc package person
-          Định nghĩa 5 thuộc tính
-          Method khái báo public
-          Constructor 0 tham số và 5 tham số
-          Getters/Setters (nếu chương trình có sử dụng)
-          Hàm input()
-          Hàm output()
-          Xuất ra 1 dòng bao gồm tất cả thông tin của đối tượng có canh lề
-          Dùng cú pháp sau để canh lề: System.out.format(“%-20s”, var): canh trái
-          Hàm toString()
-          Trả về chuỗi bao gồm các thông tin của Person cách nhau dấu phẩy (,)
* class PersonList { //thuộc package person
-          Định nghĩa 1 biến danh sách kiểu ArrayList<Person>: sv đặt tên biến tùy ý
-          Constructor 0 tham số: khởi tạo biến danh sách
-          Phương thức add(Person p): add đối tượng Person vào danh sách
-          Phương thức ouput(): xuất danh sách ra màn hình
-          Phương thức saveToFile(boolean append): ghi danh sách xuống file Persons.txt đặt tại thư mục hiện hành. Các thông tin của 1 đối tượng là 1 dòng cách nhau dấu phẩy (,)
-          Phương thức addFromFile(): đọc dữ liệu từ file và add vào danh sách
        }

* Class Main { //thuộc package main
            public static void main(String[] args) {
                Menu menu = new Menu("Bài tập cuối kỳ môn OOP-Java");
                PersonList personList = new PersonList();

                menu.add("1. Nhập sản phẩm ");
                menu.add("2. Nhập loại sản phẩm");
                menu.add("3. Xuất hóa đơn, tổng tiền");
                menu.add("4. Exit");
                while (true){
                    menu.display();
                    int choice = menu.getChoice();
                    switch (choice){
                        case 1:
                            personList.addNewPerson();
                            break;
                        case 2:
                            personList.outputFromFile();
                            break;
                        case 3:
                            xuất hóa đơn, tổng tiền;
                            break;
                        case 4:
                            System.out.println("Have a nice day!");
                            return;
                    }
                }//end while
            }
        }
    }
}*/
