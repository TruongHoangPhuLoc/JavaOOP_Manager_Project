package order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Order {
    String name;
    String date;
    int total;
    public Order()
    {
        this.name = "";
        this.date = "";
        this.total = 0;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }


    private int total(ListOfOrderDetail listOfOrderDetail)
    {
        int sum = 0;
        ArrayList<OrderDetail> orderDetailArrayList = listOfOrderDetail.getOrderDetailArrayList();
        for(int i = 0;i<orderDetailArrayList.size();i++)
        {
            sum += orderDetailArrayList.get(i).getSum();
        }
        return sum;
    }
    public void inputOrder()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        this.name = sc.nextLine();
        //Nhập danh mục cần mua
        ListOfOrderDetail listOfOrderDetail = new ListOfOrderDetail();
        listOfOrderDetail.inputListOfOrderDetail();
        this.total = this.total(listOfOrderDetail);
        Date today = Calendar.getInstance().getTime();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.date = format.format(today);
    }
    public void inputOrder2()
    {
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        Date today = Calendar.getInstance().getTime();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.date = format.format(today);

    }
    public void outputOrder()
    {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(this.name);
        System.out.println(this.date);
        System.out.println(this.total);
    }
}
