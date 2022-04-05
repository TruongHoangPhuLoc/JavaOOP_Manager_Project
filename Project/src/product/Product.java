package product;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private int id;
    private String nameOfProduct;
    private int price;
    private int numberOfRemains;
    private int idOfKind;
    public Product()
    {
        this.id = 0;
        this.idOfKind = 0;
        this.nameOfProduct = "";
        this.numberOfRemains = 0;
        this.price = 0;
    }
    Product(int id, String nameOfProduct, int price, int numberOfRemains, int idOfKind)
    {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.numberOfRemains = numberOfRemains;
        this.idOfKind = idOfKind;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdOfKind(int idOfKind) {
        this.idOfKind = idOfKind;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setNumberOfRemains(int numberOfRemains) {
        this.numberOfRemains = numberOfRemains;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getIdOfKind() {
        return idOfKind;
    }

    public int getNumberOfRemains() {
        return numberOfRemains;
    }

    public int getPrice() {
        return price;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }
    private boolean validID(ProductList productList)
    {
        ArrayList<Product> productArrayList = productList.getProductArrayList();
        for(int i = 0;i<productArrayList.size();i++)
        {
            if(this.id == productArrayList.get(i).getId())
            {
                return false;
            }
        }
        return true;
    }
    private boolean validIDKindOfProduct(KindOfProductList kindOfProductList)
    {
        ArrayList<KindOfProduct> kindOfProductArrayList = kindOfProductList.getKindOfProductArrayList();
        for(int i = 0;i<kindOfProductArrayList.size();i++)
        {
            if(this.idOfKind == kindOfProductArrayList.get(i).getID())
            {
                return true;
            }
        }
        return false;
    }

    public void inputProduct()
    {
        ProductList productList = new ProductList();
        productList.readProductListFromFile();
        KindOfProductList kindOfProductList = new KindOfProductList();
        kindOfProductList.readKindOfProductListFromFile();
        System.out.println("---------------------------------");
        System.out.println("Danh sách sản phẩm");
        productList.outputProductList();
        System.out.println("---------------------------------");
        System.out.println("Danh sách loại sản phẩm");
        kindOfProductList.outputKindOfProductList();
        System.out.println("---------------------------------");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập ID của sản phẩm");
            this.id = Integer.parseInt(sc.nextLine());
            if(!this.validID(productList))
            {
                System.out.println("ID không hợp lệ, nhập lại ID");
            }
        }while(!this.validID(productList));

        System.out.println("Nhập Tên sản phẩm");
        this.nameOfProduct = sc.nextLine();
        System.out.println("Nhập Giá của sản phẩm");
        this.price = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập Số lượng còn lại trong kho");
        this.numberOfRemains = Integer.parseInt(sc.nextLine());
        do{
            System.out.println("Nhập ID của loại sản phẩm");
            this.idOfKind = Integer.parseInt(sc.nextLine());
            if(!this.validIDKindOfProduct(kindOfProductList))
            {
                System.out.println("ID của loại sản phẩm không hợp lệ, vui lòng nhập lại");
            }
        }while(!this.validIDKindOfProduct(kindOfProductList));
    }
    public void outputProduct()
    {
        System.out.println("Mã sản phẩm: "+this.id);
        System.out.println("Tên sản phẩm: "+this.nameOfProduct);
        System.out.println("Giá của sản phẩm: "+this.price);
        System.out.println("Số lượng còn lại trong kho: "+this.numberOfRemains);
        System.out.println("Mã loại sản phẩm: "+this.idOfKind);
    }
}
