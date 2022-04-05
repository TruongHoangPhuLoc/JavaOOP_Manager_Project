package order;



import product.Product;
import product.ProductList;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetail {
    int productID;
    int quantity;
    int sum;
    OrderDetail()
    {
        this.productID = 0;
        this.quantity = 0;
    }

    public int getSum() {
        return sum;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private boolean validIDOfProduct(ProductList productList)
    {
        ArrayList<Product> listProductArrayList = productList.getProductArrayList();
        for(int i = 0;i<listProductArrayList.size();i++)
        {
            if(this.productID == listProductArrayList.get(i).getId())
            {
                return true;
            }
        }
        return false;
    }
    private boolean validQuantity(ProductList productList)
    {
        ArrayList<Product> listProductArrayList = productList.getProductArrayList();
        for(int i = 0;i<listProductArrayList.size();i++)
        {
            if(this.productID == listProductArrayList.get(i).getId())
            {
                if(this.quantity>listProductArrayList.get(i).getNumberOfRemains())
                {
                    return false;
                }
            }
        }
        return true;
    }
    private void decreaseNumberOfRemains(ProductList productList)
    {
        ArrayList<Product> productArrayList = productList.getProductArrayList();
        for(int i = 0;i<productArrayList.size();i++)
        {
            if(this.productID == productArrayList.get(i).getId())
            {
                if(productArrayList.get(i).getNumberOfRemains() !=0) {
                    int value = productArrayList.get(i).getNumberOfRemains();
                    int numberOfRemains = value - this.quantity;
                    productArrayList.get(i).setNumberOfRemains(numberOfRemains);
                }
            }
            if(productArrayList.get(i).getNumberOfRemains()==0)
            {
                productArrayList.remove(i);
                changeID(productArrayList,i);
            }
        }
    }
    private void changeID(ArrayList<Product> productArrayList,int index)
    {
        for(int i = productArrayList.size() -  1;i>=index;i--)
        {
            productArrayList.get(i).setId(productArrayList.get(i).getId()-1);
        }
    }
    private int calSum(ProductList productList)
    {
        int sum = 0;
        ArrayList<Product> productArrayList = productList.getProductArrayList();
        for(int i = 0;i<productArrayList.size();i++)
        {
            if(this.productID == productArrayList.get(i).getId())
            {
                sum+= this.quantity * productArrayList.get(i).getPrice();
            }
        }
        return sum;
    }
    public void inputOrderDetail()
    {
        Scanner sc = new Scanner(System.in);
        ProductList productList = new ProductList();
        productList.readProductListFromFile();
        System.out.println("------------------------------------");
        System.out.println("Danh sách sản phẩm");
        productList.outputProductList();
        System.out.println("------------------------------------");
       do {
           System.out.println("Nhập mã sản phẩm cần mua");
           this.productID = Integer.parseInt(sc.nextLine());
           if(!this.validIDOfProduct(productList))
           {
               System.out.println("Mã sản phẩm không hợp lệ, nhập lại");
           }
       }while(!this.validIDOfProduct(productList));

       do {
           System.out.println("Nhập số lượng cần mua");
           this.quantity = Integer.parseInt(sc.nextLine());
           if(!this.validQuantity(productList))
           {
               System.out.println("Số lượng còn lại của sản phẩm không đủ, vui lòng nhập lại");
           }
       }while (!this.validQuantity(productList));
       this.sum = calSum(productList);
       //update lại danh sách sản phẩm
       this.decreaseNumberOfRemains(productList);
       //ghi ra file
       productList.writeProductListToFile();
    }
    public void outputOrderDetail()
    {
        System.out.println("Mã sản phẩm cần mua: "+this.productID);
        System.out.println("Số lượng cần mua: "+this.quantity);
    }
}
