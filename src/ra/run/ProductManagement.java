package ra.run;

import ra.bussinessImpl.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm \n" +
                    "7. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManagement.addProduct(scanner, productList);
                    break;
                case 2:
                    productManagement.displayProduct(productList);
                    break;
                case 3:
                    productManagement.sortProduct(productList);
                    break;
                case 4:
                    productManagement.deleteProduct(scanner, productList);
                    break;
                case 5:
                    productManagement.searchProductByName(scanner, productList);
                    break;
                case 6:
                    productManagement.changeProductStatus(scanner, productList);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Vui lòng nhập từ 1 đến 7");
            }
        } while (true);
    }

    //Thay đổi trạng thái của sản phẩm theo mã sản phẩm
    public void changeProductStatus(Scanner scanner, List<Product> productList) {
        System.out.println("Nhập mã sản phẩm cần tìm");
        int idProduct = Integer.parseInt(scanner.nextLine());
        //kiểm tra tồn tại của sản phẩm
        boolean isExist = productList.stream().anyMatch(product -> product.getProductId() == idProduct);
        if (isExist) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductId() == idProduct) {
                    productList.get(i).setProductStatus(!productList.get(i).isProductStatus());
                }
            }
            System.out.println("Thay đổi trạng thái sản phẩm thành công");
        } else {
            System.out.println("Sản phẩm không tồn tại");
        }
    }

    //Tìm kiếm sản phẩm theo tên sản phẩm
    public void searchProductByName(Scanner scanner, List<Product> productList) {
        System.out.println("Nhập tên sản phẩm cần tìm");
        String searchName = scanner.nextLine();
        //kiểm tra tồn tại của sản phẩm
        boolean isExist = productList.stream().anyMatch(product -> product.getProductName().equalsIgnoreCase(searchName));
        if (isExist) {
            System.out.println("Danh sách sản phẩm cần tìm :");
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductName().equalsIgnoreCase(searchName)) {
                    productList.get(i).displayData();
                }
            }
        } else {
            System.out.println("Không có sản phẩm cần tìm");
        }
    }

    //Xóa sản phẩm theo mã sản phẩm
    public void deleteProduct(Scanner scanner, List<Product> productList) {
        System.out.println("Nhập mã sản phẩm muốn xóa");
        int deleteIdProduct = Integer.parseInt(scanner.nextLine());
        //kiểm tra tồn tại của sản phẩm
        boolean isExist = productList.stream().anyMatch(product -> product.getProductId() == deleteIdProduct);
        if (isExist) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductId() == deleteIdProduct) {
                    productList.remove(productList.get(i));
                }
            }
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Sản phẩm không tồn tại");
        }
    }

    //Sắp xếp sản phẩm theo lợi nhuận tăng dần
    private void sortProduct(List<Product> productList) {
        Collections.sort(productList);
        System.out.println("Đã sắp xếp theo lợi nhuận tăng dần");
        displayProduct(productList);
    }

    //Hiển thị thông tin các sản phẩm
    public void displayProduct(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
        } else {
            System.out.println("===== Danh sách sản phẩm =====");
            productList.forEach(Product::displayData);
            System.out.println("==============================");
        }
    }

    //Nhập số sản phẩm và nhập thông tin sản phẩm
    public void addProduct(Scanner scanner, List<Product> productList) {
        System.out.println("Nhập số sản phẩm cần nhập thông tin");
        int numberOfProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfProduct; i++) {
            Product newProduct = new Product();
            newProduct.inputData();
            productList.add(newProduct);
        }
    }
}
