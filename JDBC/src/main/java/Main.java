public class Main {
    public static void main(String[] args) {
        DBConnection dataBase = DBConnection.getDBConnection();
        DBService dbService = new DBService(dataBase);
//        dbService.createTablesForHomework();
        dbService.task1();
        dbService.task2();
        dbService.task3();
        dbService.task4();
        dataBase.close();
    }
}
