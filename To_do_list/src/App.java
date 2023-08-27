import java.util.Scanner;

public class App {
    public static String[] model = new String[100];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {viewShowTodoList();}
    }

    public static void viewShowTodoList() {
      System.out.println(" ");
      System.out.println(" ");
        System.out.println("===== To-Do List =====");
        System.out.println("1. Tambahkan To-Do");
        System.out.println("2. Tampilkan To-Do");
        System.out.println("3. ubah To-Do");
        System.out.println("4. Hapus To-Do");
        System.out.println("5. Keluar");
        System.out.print("Pilih operasi (1/2/3/4/5): ");
        System.out.println(" ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        switch (choice) {
            case 1:
                addTodo();
                break;
            case 2:
                displayAllTodo();
                break;
            case 3:
                editTodo();
                break;
            case 4:
                deleteTodo();
                break;
            case 5:
                exitProgram();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public static void addTodo() {
        System.out.print("Masukkan To-Do baru: ");
        String todo = scanner.nextLine();
        
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                System.out.println("Berhasil ditambahkan ke To-Do.");
                break;
            }
        }
    }
    public static void displayAllTodo() {
        System.out.println("===== Seluruh To-Do =====");
        for (int i = 0; i < model.length; i++) {
            if (model[i] != null) {
                System.out.println((i + 1) + ". " + model[i]);
            }
        }
    }

    public static void editTodo() {
        displayAllTodo();
        System.out.print("Pilih nomor To-Do yang akan diubah: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        if (index >= 1 && index <= model.length && model[index - 1] != null) {
            System.out.print("Masukkan isi To-Do yang baru: ");
            String newTodo = scanner.nextLine();
            model[index - 1] = newTodo;
            System.out.println("To-Do berhasil diubah.");
        } else {
            System.out.println("Nomor To-Do tidak valid.");
        }
    }

    public static void deleteTodo() {
        displayAllTodo();
        System.out.print("Pilih nomor To-Do yang akan dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        if (index >= 1 && index <= model.length && model[index - 1] != null) {
            model[index - 1] = null;
            System.out.println("To-Do berhasil dihapus.");
        } else {
            System.out.println("Nomor To-Do tidak valid.");
        }
    }

    public static void exitProgram() {
        System.out.print("Keluar dari program? (y/n): ");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) {
            System.out.println("Terima kasih. Sampai jumpa!");
            System.exit(0);
        }else if (choice.equals("n")) {
          System.out.println("Aksi dibatalkan");
        }else{
          System.out.println(" input tidak valid");
        }
    }
}
