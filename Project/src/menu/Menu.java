package menu;

import order.ListOfOrder;
import order.Order;
import product.KindOfProduct;
import product.KindOfProductList;
import product.Product;
import product.ProductList;

import java.util.Scanner;

public class Menu implements InterfaceOfMenu{
    String title;
    ProductList productList;
    KindOfProductList kindOfProductList;
    ListOfOrder listOfOrder;
    public Menu()
    {
        this.title = "";
        this.kindOfProductList = new KindOfProductList();
        this.productList = new ProductList();
    }
    public Menu(String title)
    {
        this.title = title;
        this.productList = new ProductList();
        this.kindOfProductList = new KindOfProductList();
        this.listOfOrder = new ListOfOrder();
    }

    public void insertProduct()
    {
        this.productList.readProductListFromFile();
        Product product = new Product();
        product.inputProduct();
        this.productList.insertProductToProductList(product);
        this.productList.writeProductListToFile();
        System.out.println("---------------------------");
        System.out.println("Thêm thành công, danh sách sản phẩm");
        this.kindOfProductList.outputKindOfProductList();
        System.out.println("----------------------------");
    }
    public void insertKindOfProduct()
    {
        this.kindOfProductList.readKindOfProductListFromFile();
        KindOfProduct kindOfProduct = new KindOfProduct();
        kindOfProduct.inputKindOfProduct();
        this.kindOfProductList.insertKindOfProductToKindOfProductList(kindOfProduct);
        this.kindOfProductList.writeProductListToFile();
        System.out.println("---------------------------");
        System.out.println("Thêm thành công, danh sách loại sản phẩm");
        this.kindOfProductList.outputKindOfProductList();
        System.out.println("----------------------------");

    }
    public void insertfOrder()
    {
        this.listOfOrder.readListOfOrdersFromFile();
        Order order = new Order();
        order.inputOrder();
        this.listOfOrder.insertToListOfOrder(order);
        this.listOfOrder.writeOrderListToFile();
        System.out.println("---------------------------");
        System.out.println("Thêm thành công, danh sách hóa đơn");
        this.listOfOrder.outputListOfOrder();
        System.out.println("----------------------------");
    }
    private void renderMenu()
    {
        System.out.println("1:Thêm sản phẩm");
        System.out.println("2:Thêm loại sản phẩm");
        System.out.println("3:Thêm hóa đơn");
        System.out.println("Nhập -1 để thoát");
    }
    public void main()
    {
        while(true) {
            try {
                System.out.println(this.title);
                int n;
                Scanner sc = new Scanner(System.in);
                do {
                    renderMenu();
                    System.out.println("Nhập lựa chọn");
                    n = Integer.parseInt(sc.nextLine());
                    switch (n) {
                        case (1):
                            this.insertProduct();
                            break;
                        case (2):
                            this.insertKindOfProduct();
                            break;
                        case (3):
                            this.insertfOrder();
                            break;
                        default:
                            break;
                    }
                } while (n != -1);
                break;
            }catch (Exception e){
                System.out.println("Invalid, try again");
            }
        }
    }
}
