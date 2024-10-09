package main;

import users.Admin;
import users.Customer;
import rooms.Room;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data Login - Admin dan Customer yang terdaftar
        Admin admin = new Admin("Admin 1", "admin", "admin123");
        Customer customer1 = new Customer("John Doe", "john", "john123");
        Customer customer2 = new Customer("Jane Doe", "jane", "jane123");
        Customer customer3 = new Customer("Rizky", "rizky", "123");

        System.out.println("Selamat datang di Sistem Reservasi Hotel");
        System.out.println("Silakan login");

        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(admin.getUsername()) && inputPassword.equals(admin.getPassword())) {
            // Admin Menu
            System.out.println("Login berhasil. Selamat datang, Admin!");
            adminMenu(scanner, admin);
        } else if (inputUsername.equals(customer1.getUsername()) && inputPassword.equals(customer1.getPassword())) {
            // Customer 1 Menu
            System.out.println("Login berhasil. Selamat datang, " + customer1.getUsername() + "!");
            customerMenu(scanner, customer1);
        } else if (inputUsername.equals(customer2.getUsername()) && inputPassword.equals(customer2.getPassword())) {
            // Customer 2 Menu
            System.out.println("Login berhasil. Selamat datang, " + customer2.getUsername() + "!");
            customerMenu(scanner, customer2);
        } else if (inputUsername.equals(customer3.getUsername()) && inputPassword.equals(customer3.getPassword())) {
            // Customer 3 Menu
            System.out.println("Login berhasil. Selamat datang, " + customer3.getUsername() + "!");
            customerMenu(scanner, customer3);
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
        }

        scanner.close();
    }

    // Menu untuk Customer
    public static void customerMenu(Scanner scanner, Customer customer) {
        // Tampilkan semua kamar dengan statusnya
        System.out.println("Daftar Kamar Hotel:");
        viewAllRooms();

        // Menu customer setelah melihat daftar kamar
        System.out.println("Pilih aksi Anda:");
        System.out.println("1. Cek Ketersediaan Kamar");
        System.out.println("2. Pesan Kamar");
        System.out.println("3. Lihat Detail Pesanan");

        int customerAction = scanner.nextInt();

        switch (customerAction) {
            case 1:
                // Menampilkan semua kamar dengan status
                System.out.println("Daftar Kamar Hotel:");
                viewAllRooms();
                break;
            case 2:
                System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                int bookRoomNumber = scanner.nextInt();
                customer.bookRoom(bookRoomNumber);
                break;
            case 3:
                customer.viewBookingDetails();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    // Method untuk menampilkan semua kamar dan statusnya
    public static void viewAllRooms() {
        Hotel hotel = Hotel.getInstance();
        for (Room room : hotel.getAllRooms()) {
            System.out.println("Kamar " + room.getRoomNumber() + " - Tipe: " + room.getRoomType() + " - Status: " + (room.isAvailable() ? "Tersedia" : "Dipesan"));
        }
    }

    // Menu untuk Admin
    public static void adminMenu(Scanner scanner, Admin admin) {
        System.out.println("Pilih aksi Anda:");
        System.out.println("1. Cek Status Kamar");
        System.out.println("2. Lihat Semua Kamar");

        int adminAction = scanner.nextInt();

        switch (adminAction) {
            case 1:
                System.out.print("Masukkan nomor kamar yang ingin dicek: ");
                int checkRoomNumber = scanner.nextInt();
                admin.checkRoomStatus(checkRoomNumber);
                break;
            case 2:
                admin.viewAllRooms();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}
