public class App {
    public static String[] model = new String[30];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
  
    public static void main(String[] args) {
      viewShowTodoList();
    }
  
    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
      System.out.println("TODOLIST");
      for (var i = 0; i < model.length; i++) {
        var todo = model[i];
        var no = i + 1;
  
        if (todo != null) {
          System.out.println(no + ". " + todo);
        }
      }
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
      // cek apakah model penuh?
      var isFull = true;
      for (int i = 0; i < model.length; i++) {
        if (model[i] == null) {
          // model masih ada yang kosong
          isFull = false;
          break;
        }
      }
  
      // jika penuh, kita resize ukuran array 2x lipat
      if (isFull) {
        var temp = model;
        model = new String[model.length * 2];
  
        for (int i = 0; i < temp.length; i++) {
          model[i] = temp[i];
        }
      }
  
      // tambahkan ke posisi yang data array nya NULL
      for (var i = 0; i < model.length; i++) {
        if (model[i] == null) {
          model[i] = todo;
          break;
        }
      }
    }
  /**
   * 
   * mengubah to do list
   */
  public static boolean editTodoList(int number, String newTodo) {
    if (number > 0 && number <= model.length) {
        model[number - 1] = newTodo;
        return true;
    }
    return false;
}


    /**
     * Mehapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
      if ((number - 1) >= model.length) {
        return false;
      } else if (model[number - 1] == null) {
        return false;
      } else {
        for (int i = (number - 1); i < model.length; i++) {
          if (i == (model.length - 1)) {
            model[i] = null;
          } else {
            model[i] = model[i + 1];
          }
        }
        return true;
      }
    }
  
    public static String input(String info) {
      System.out.print(info + " : ");
      String data = scanner.nextLine();
      return data;
    }
  

  
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
      while (true) {
        showTodoList();
  
        System.out.println("MENU : ");
        System.out.println("1. Tambah");
        System.out.println("2. Ubah");
        System.out.println("3. Keluar");
        System.out.println("x. Keluar");
  
        var input = input("Pilih");
  
        if (input.equals("1")) {
          viewAddTodoList();
        }else if (input.equals("2")) {
          viewEditTodoList();
        }else if (input.equals("3")) {
          viewRemoveTodoList();
        } else if (input.equals("x")) {
          break;
        } else {
          System.out.println("Pilihan tidak dimengerti");
        }
      }
    }
  

  
    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList() {
      System.out.println("MENAMBAH TODOLIST");
  
      var todo = input("Todo (x Jika Batal)");
  
      if (todo.equals("x")) {
        // batal
      } else {
        addTodoList(todo);
      }
    }
  
    public static void viewEditTodoList() {
      System.out.println("MENGUBAH TODOLIST");
  
      var number = input("Nomor yang Diubah (x Jika Batal)");
  
      if (number.equals("x")) {
          // batal
      } else {
          int todoIndex = Integer.parseInt(number);
          if (todoIndex > 0 && todoIndex <= model.length && model[todoIndex - 1] != null) {
              String newTodo = input("Masukkan Perubahan: ");
              editTodoList(todoIndex, newTodo);
          } else {
              System.out.println("Nomor tidak valid atau todolist tidak ada.");
          }
      }
  }
  
  
    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList() {
      System.out.println("MENGHAPUS TODOLIST");
  
      var number = input("Nomor yang Dihapus (x Jika Batal)");
  
      if (number.equals("x")) {
        // batal
      } else {
        boolean success = removeTodoList(Integer.valueOf(number));
        if (!success) {
          System.out.println("Gagal menghapus todolist : " + number);
        }
      }
    }
  
}

    
