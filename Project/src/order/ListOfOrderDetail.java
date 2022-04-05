package order;


import java.util.ArrayList;
import java.util.Scanner;

public class ListOfOrderDetail {
    ArrayList<OrderDetail> orderDetailArrayList;
    ListOfOrderDetail()
    {
        this.orderDetailArrayList = new ArrayList<OrderDetail>();
    }

    public ArrayList<OrderDetail> getOrderDetailArrayList() {
        return orderDetailArrayList;
    }

    public void setOrderDetailArrayList(ArrayList<OrderDetail> orderDetailArrayList) {
        this.orderDetailArrayList = orderDetailArrayList;
    }

    public void insertListOfOrderDetail(OrderDetail orderDetail)
    {
        this.orderDetailArrayList.add(orderDetail);
    }
    public void inputListOfOrderDetail()
    {
        Scanner sc = new Scanner(System.in);
        OrderDetail orderDetail = new OrderDetail();
        String confirm;
        do {
            orderDetail.inputOrderDetail();
            this.orderDetailArrayList.add(orderDetail);
            System.out.println("Bạn có muốn nhập tiếp không?");
            System.out.println("Nhập không để dừng lại");
            confirm = sc.nextLine();
        }while(!confirm.equals("Không"));
    }
}
