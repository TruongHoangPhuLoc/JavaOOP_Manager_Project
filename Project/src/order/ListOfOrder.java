package order;

import product.Product;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListOfOrder {
    ArrayList<Order> orderArrayList;
    public ListOfOrder()
    {
        this.orderArrayList = new ArrayList<Order>();
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }
    public void outputListOfOrder()
    {
        for(int i = 0;i<this.orderArrayList.size();i++)
        {
            this.orderArrayList.get(i).outputOrder();
        }
    }
    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }
    public void writeOrderListToFile()
    {

        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\order\\listoforder");
            FileWriter fw = new FileWriter(f);

            for(int i = 0;i<this.orderArrayList.size();i++)
            {
                fw.write(orderArrayList.get(i).getName()+"\t");
                fw.write(orderArrayList.get(i).getDate()+"\t");
                fw.write(orderArrayList.get(i).getTotal()+"\t");
                fw.write("\n");
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error to write file" + ex);
        }
    }
    public void readListOfOrdersFromFile()
    {
        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\order\\listoforder");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                String arr[] = new String[3];
                arr = line.split("\\t+");
                Order order = new Order();
                order.setName(arr[0]);
                order.setDate(arr[1]);
                order.setTotal(Integer.parseInt(arr[2]));
                this.orderArrayList.add(order);
            }

            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Error to read file "+ex);
        }
    }
    public void insertToListOfOrder(Order order)
    {
        this.orderArrayList.add(order);
    }
}
