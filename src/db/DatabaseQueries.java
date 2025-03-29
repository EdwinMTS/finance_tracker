package db;

public class DatabaseQueries {
    public static final String CREATE_tbl_Colors = "CREATE TABLE IF NOT EXISTS tbl_Colors (nKey INTEGER PRIMARY KEY AUTOINCREMENT, sColor TEXT);";
    public static final String CREATE_tbl_Category = "CREATE TABLE IF NOT EXISTS tbl_Category (nKey INTEGER PRIMARY KEY AUTOINCREMENT, sName TEXT, nColorLink INTEGER, FOREIGN KEY (nColorLink) REFERENCES tbl_Colors(nKey));";
    public static final String CREATE_tbl_Transactions = "CREATE TABLE IF NOT EXISTS tbl_Transactions (nKey INTEGER PRIMARY KEY AUTOINCREMENT, rAmount REAL, sDescription TEXT, nCategoryLink INTEGER, FOREIGN KEY (nCategoryLink) REFERENCES tbl_Category(nKey));";
    public static final String[] createTableArray = new String[]{CREATE_tbl_Colors, CREATE_tbl_Category, CREATE_tbl_Transactions};
}
