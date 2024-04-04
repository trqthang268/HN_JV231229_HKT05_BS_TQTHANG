package ra.bussinessImpl;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct,Comparable<Product> {
   private int productId;
   private String productName;
   private String title;
   private String descriptions;
   private float importPrice;
   private float exportPrice;
   private float interest;
   private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm");
        this.productId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm");
        this.title = scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập giá nhập");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá xuất");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        this.interest = getExportPrice()-getImportPrice();
        System.out.println("Nhập trạng thái sản phẩm (true/false)");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.printf("|Mã sản phẩm : %d | Tên sản phẩm : %s | Tiêu đề : %s | Mô tả : %s |\n",productId,productName,title,descriptions);
        System.out.printf("|Giá nhập : %f | Giá xuất : %f | Lợi nhuận : %f | Trạng thái : %b |\n",importPrice,exportPrice,interest,productStatus);
    }


    @Override
    public int compareTo(Product o) {
        return (int) (this.interest - o.interest);
    }
}
