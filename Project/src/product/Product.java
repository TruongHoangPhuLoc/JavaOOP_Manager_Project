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
        System.out.println("Danh sa??ch sa??n ph????m");
        productList.outputProductList();
        System.out.println("---------------------------------");
        System.out.println("Danh sa??ch loa??i sa??n ph????m");
        kindOfProductList.outputKindOfProductList();
        System.out.println("---------------------------------");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nh????p ID cu??a sa??n ph????m");
            this.id = Integer.parseInt(sc.nextLine());
            if(!this.validID(productList))
            {
                System.out.println("ID kh??ng h????p l????, nh????p la??i ID");
            }
        }while(!this.validID(productList));

        System.out.println("Nh????p T??n sa??n ph????m");
        this.nameOfProduct = sc.nextLine();
        System.out.println("Nh????p Gia?? cu??a sa??n ph????m");
        this.price = Integer.parseInt(sc.nextLine());
        System.out.println("Nh????p S???? l??????ng co??n la??i trong kho");
        this.numberOfRemains = Integer.parseInt(sc.nextLine());
        do{
            System.out.println("Nh????p ID cu??a loa??i sa??n ph????m");
            this.idOfKind = Integer.parseInt(sc.nextLine());
            if(!this.validIDKindOfProduct(kindOfProductList))
            {
                System.out.println("ID cu??a loa??i sa??n ph????m kh??ng h????p l????, vui lo??ng nh????p la??i");
            }
        }while(!this.validIDKindOfProduct(kindOfProductList));
    }
    public void outputProduct()
    {
        System.out.println("Ma?? sa??n ph????m: "+this.id);
        System.out.println("T??n sa??n ph????m: "+this.nameOfProduct);
        System.out.println("Gia?? cu??a sa??n ph????m: "+this.price);
        System.out.println("S???? l??????ng co??n la??i trong kho: "+this.numberOfRemains);
        System.out.println("Ma?? loa??i sa??n ph????m: "+this.idOfKind);
    }
}
