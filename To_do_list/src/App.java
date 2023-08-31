import java.util.Scanner;

public class App {
    public static String[] model = new String[2];
    //public static ArrayList<String> model = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            viewShowTodoList();
        }
    }
    
    public static void viewShowTodoList() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("===== To-Do List =====");
        System.out.println("1. Tambahkan To-Do");
        System.out.println("2. ubah To-Do");
        System.out.println("3. Hapus To-Do");
        System.out.println("4. Keluar");
        System.out.println(" Pilih operasi (1/2/3/4): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        
    /*     if (choice == 1) {
            addTodo();
        } else if (choice == 2) {
            displayAllTodo();
        } else if (choice == 3) {
            editTodo();
        } else if (choice == 4) {
            deleteTodo();
        } else if (choice == 5) {
            exitProgram();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
         
*/
/* */
        switch (choice) {
            case 1:
                addTodo();
                break;
            case 2:
                editTodo();
                break;
            case 3:
                deleteTodo();
                break;
            case 4:
                exitProgram();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
/* */
    public static void addTodo() {
        System.out.print("Masukkan To-Do baru: ");
        String todo = scanner.nextLine();
        
        boolean isFull = true; // Inisialisasi dengan asumsi To-Do penuh
    
        for (int i = 0; i < model.length; i++) {
        //for (int i = 0; i < model.size(); i++) {
                if (model[i] == null) {
                model[i] = todo;
                System.out.println("Berhasil ditambahkan ke To-Do.");
                System.out.println("");
                displayAllTodo();
                return;
            }
        }
        if (isFull) {
            System.out.println("To-Do sudah penuh, tidak dapat menambahkan data ke To-Do.");
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
        scanner.nextLine(); 

        if (index >= 1 && index <= model.length && model[index - 1] != null) {
            System.out.print("Masukkan isi To-Do yang baru: ");
            String newTodo = scanner.nextLine();
            model[index - 1] = newTodo;
            System.out.println("To-Do berhasil diubah.");
            System.out.println(" ");
            displayAllTodo();
        } else {
            System.out.println("Nomor To-Do tidak valid.");
        }
    }

    public static void deleteTodo() {
        displayAllTodo();
        System.out.print("Pilih nomor To-Do yang akan dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index >= 1 && index <= model.length && model[index - 1] != null) {
            System.out.print("Anda yakin ingin menghapus To-Do ini? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("y")) {
                model[index - 1] = null;
                System.out.println("To-Do berhasil dihapus.");
            } else if (choice.equals("n")){
                System.out.println("Penghapusan To-Do dibatalkan.");
            }else {
                System.out.println("input tidak valid");
            }
        } else {
            System.out.println("Nomor To-Do tidak valid.");
        }displayAllTodo();
    }

    public static void exitProgram() {
        System.out.print("Keluar dari program? (y/n): ");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) {
            System.out.println("Terima kasih. Sampai jumpa!");
            System.exit(0);
        }else if (choice.equals("n")) {
          System.out.println("Aksi dibatalkan");
          System.out.println(" ");
        }else{
          System.out.println(" input tidak valid");
        }
    }
}
