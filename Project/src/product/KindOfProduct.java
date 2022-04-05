package product;

import java.util.ArrayList;
import java.util.Scanner;

public class KindOfProduct {

    private int id;
    private String nameOfKind;
    public KindOfProduct()
    {
        this.nameOfKind = "";
        this.id = 0;
    }
    KindOfProduct(String name)
    {
        this.nameOfKind = name;
    }
    public int getID()
    {
        return this.id;
    }
    public String getNameOfKind()
    {
        return this.nameOfKind;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfKind(String nameOfKind) {
        this.nameOfKind = nameOfKind;
    }
    private boolean validID(KindOfProductList kindOfProductList)
    {
        ArrayList<KindOfProduct> kindOfProductArrayList = kindOfProductList.getKindOfProductArrayList();
        for(int i = 0;i<kindOfProductArrayList.size();i++)
        {
            if(this.id == kindOfProductArrayList.get(i).getID())
            {
                return false;
            }
        }
        return true;
    }
    public void inputKindOfProduct()
    {
        KindOfProductList kindOfProductList = new KindOfProductList();
        kindOfProductList.readKindOfProductListFromFile();
        System.out.println("-------------------------------------");
        System.out.println("Danh sách các loại sản phẩm");
        kindOfProductList.outputKindOfProductList();
        System.out.println("--------------------------------------");
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhập mã loại sản phẩm");
            this.id = Integer.parseInt(sc.nextLine());
            if(!this.validID(kindOfProductList))
            {
                System.out.println("Mã loại sản phẩm không hợp lệ, nhập lại");
            }
        }while(!this.validID(kindOfProductList));
        System.out.println("Nhập tên loại sản phẩm");
        this.nameOfKind = sc.nextLine();
    }
    public void outputKindOfProduct()
    {
        System.out.println("Mã loại sản phẩm: "+this.id);
        System.out.println("Tên loại sản phẩm: "+this.nameOfKind);
    }
}
