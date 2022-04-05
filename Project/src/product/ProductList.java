package product;

import java.io.*;
import java.util.ArrayList;

public class ProductList {
    ArrayList<Product>productArrayList;
    public ProductList()
    {
        this.productArrayList = new ArrayList<Product>();
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
    public void writeProductListToFile()
    {

        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\product\\productlist");
            FileWriter fw = new FileWriter(f);

            for(int i = 0;i<this.productArrayList.size();i++)
            {
                fw.write(this.productArrayList.get(i).getId()+"\t");
                fw.write(this.productArrayList.get(i).getNameOfProduct()+"\t");
                fw.write(this.productArrayList.get(i).getPrice()+"\t");
                fw.write(this.productArrayList.get(i).getNumberOfRemains()+"\t");
                fw.write(this.productArrayList.get(i).getIdOfKind()+"\t");
                fw.write("\n");
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error to write file" + ex);
        }
    }
    public void readProductListFromFile()
    {
        try {

            File f = new File("C:\\Users\\truon\\IdeaProjects\\Project\\src\\product\\productlist");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                String arr[] = new String[5];
                arr = line.split("\\t+");
                Product product = new Product();
                product.setId(Integer.parseInt(arr[0]));
                product.setNameOfProduct(arr[1]);
                product.setPrice(Integer.parseInt(arr[2]));
                product.setNumberOfRemains(Integer.parseInt(arr[3]));
                product.setIdOfKind(Integer.parseInt(arr[4]));
                this.productArrayList.add(product);
            }

            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Error to read file "+ex);
        }
    }
    public void outputProductList()
    {
        for(int i = 0;i<this.productArrayList.size();i++)
            this.productArrayList.get(i).outputProduct();
    }
    public void insertProductToProductList(Product product)
    {
        this.productArrayList.add(product);
    }

}

