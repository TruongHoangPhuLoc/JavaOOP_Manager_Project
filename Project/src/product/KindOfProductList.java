package product;

import java.io.*;
import java.util.ArrayList;

public class KindOfProductList {
    ArrayList<KindOfProduct>kindOfProductArrayList;
    public KindOfProductList()
    {
        this.kindOfProductArrayList = new ArrayList<KindOfProduct>();
    }

    public void setKindOfProductArrayList(ArrayList<KindOfProduct> kindOfProductArrayList) {
        this.kindOfProductArrayList = kindOfProductArrayList;
    }

    public ArrayList<KindOfProduct> getKindOfProductArrayList() {
        return kindOfProductArrayList;
    }
    public void writeProductListToFile()
    {

        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\product\\kindofproductlist");
            FileWriter fw = new FileWriter(f);

            for(int i = 0;i<this.kindOfProductArrayList.size();i++)
            {
              fw.write(this.kindOfProductArrayList.get(i).getID()+"\t");
              fw.write(this.kindOfProductArrayList.get(i).getNameOfKind()+"\t");
              fw.write("\n");
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error to write file" + ex);
        }
    }
    public void readKindOfProductListFromFile()
    {
        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\product\\kindofproductlist");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                String arr[] = new String[2];
                arr = line.split("\\t+");
                KindOfProduct kindOfProduct = new KindOfProduct();
                kindOfProduct.setId(Integer.parseInt(arr[0]));
                kindOfProduct.setNameOfKind(arr[1]);
                this.kindOfProductArrayList.add(kindOfProduct);
            }

            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Error to read file "+ex);
        }
    }
    public void insertKindOfProductToKindOfProductList(KindOfProduct kindOfProduct)
    {
        this.kindOfProductArrayList.add(kindOfProduct);
    }
    public void outputKindOfProductList()
    {
        for(int i = 0;i<this.kindOfProductArrayList.size();i++)
        {
            kindOfProductArrayList.get(i).outputKindOfProduct();
        }
    }
}

