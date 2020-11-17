package SetupDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CreateDatabase
{
  public static void main(String[] args) throws SQLException, IOException
  {
    //BEFORE YOU RUN THE THIS MAIN:
    //CREATE A NEW DATABASE IN PGADMIN NAME: projectsep3
    //CREATE A NEW LOGIN/GROUP ROLE: CREATE USER group2 WITH PASSWORD 'password';
    //AFTER THAT YOU CAN RUN THE MAIN

    String driver = "org.postgresql.Driver";

    DriverManager.registerDriver(new org.postgresql.Driver());

    String url = "jdbc:postgresql://localhost:5432/projectsep3";

    String user = "group2";
    String pw = "password";

    Connection connection = null;

    //magic. Something about loading the JDBC driver
    try
    {
      Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

    try
    {
      connection = DriverManager.getConnection(url, user, pw);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    String sql = "CREATE SCHEMA IF NOT EXISTS \"SEP3\" AUTHORIZATION group2;";
    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "GRANT ALL ON SCHEMA \"SEP3\" TO group2 WITH GRANT OPTION;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql =
        "\n" + "CREATE SEQUENCE IF NOT EXISTS \"SEP3\".product_productid_seq\n"
            + "    INCREMENT 1\n" + "    START 1\n" + "    MINVALUE 1\n"
            + "    MAXVALUE 2147483647\n" + "    CACHE 1;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER SEQUENCE \"SEP3\".product_productid_seq\n"
        + "    OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "\n"
        + "CREATE SEQUENCE IF NOT EXISTS \"SEP3\".employee_employeeid_seq\n"
        + "    INCREMENT 1\n" + "    START 2\n" + "    MINVALUE 1\n"
        + "    MAXVALUE 2147483647\n" + "    CACHE 1;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER SEQUENCE \"SEP3\".employee_employeeid_seq\n"
        + "    OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "\n"
        + "CREATE SEQUENCE IF NOT EXISTS \"SEP3\".customer_customerid_seq\n"
        + "    INCREMENT 1\n" + "    START 1\n" + "    MINVALUE 1\n"
        + "    MAXVALUE 2147483647\n" + "    CACHE 1;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER SEQUENCE \"SEP3\".customer_customerid_seq OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "\n"
        + "CREATE SEQUENCE IF NOT EXISTS \"SEP3\".transaction_transactionid_seq\n"
        + "    INCREMENT 1\n" + "    START 1\n" + "    MINVALUE 1\n"
        + "    MAXVALUE 2147483647\n" + "    CACHE 1;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER SEQUENCE \"SEP3\".transaction_transactionid_seq\n"
        + "    OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "\n"
        + "CREATE SEQUENCE IF NOT EXISTS \"SEP3\".feedback_feedbackid_seq\n"
        + "    INCREMENT 1\n" + "    START 1\n" + "    MINVALUE 1\n"
        + "    MAXVALUE 2147483647\n" + "    CACHE 1;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
/*
    sql = "CREATE DOMAIN \"SEP3\".d_string\n"
        + "    AS character varying(100);";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER DOMAIN \"SEP3\".d_string OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE DOMAIN  \"SEP3\".d_description\n"
        + "    AS character varying(300);";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER DOMAIN \"SEP3\".d_description OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE DOMAIN   \"SEP3\".d_price AS numeric(6,2);";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER DOMAIN \"SEP3\".d_price OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE DOMAIN   \"SEP3\".d_date AS date;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER DOMAIN \"SEP3\".d_date OWNER TO group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }*/

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".product\n" + "(\n"
        + "    productid integer NOT NULL DEFAULT nextval('\"SEP3\".product_productid_seq'::regclass),\n"
        + "    title \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    category \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    description \"SEP3\".d_description COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    price \"SEP3\".d_price NOT NULL,\n"
        + "    CONSTRAINT prodcut_pkey PRIMARY KEY (productid) \n" + ")\n"
        + "\n" + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".product OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".store\n" + "(\n"
        + "    storeid integer NOT NULL,\n"
        + "    address \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    contact \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    email \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    CONSTRAINT store_pkey PRIMARY KEY (storeid) ) \n"
        + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".store OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".employee\n" + "(\n"
        + "    employeeid integer NOT NULL DEFAULT nextval('\"SEP3\".employee_employeeid_seq'::regclass),\n"
        + "    name \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    email \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    address \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    contact \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    seclevel integer NOT NULL,\n"
        + "    positon \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    storeid integer NOT NULL,\n"
        + "    password \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    CONSTRAINT employee_pkey PRIMARY KEY (employeeid), \n"
        + "CONSTRAINT employee_storeid_fkey FOREIGN KEY (storeid)\n"
        + "REFERENCES \"SEP3\".store (storeid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION ) \n"
        + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".employee OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".customer\n" + "(\n"
        + "    customerid integer NOT NULL DEFAULT nextval('\"SEP3\".customer_customerid_seq'::regclass),\n"
        + "    name \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    email \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    password \"SEP3\".d_string COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    address \"SEP3\".d_string COLLATE pg_catalog.\"default\",\n"
        + "    phone \"SEP3\".d_string COLLATE pg_catalog.\"default\",\n"
        + "    birthday \"SEP3\".d_date NOT NULL,\n"
        + "    CONSTRAINT customer_pkey PRIMARY KEY (customerid) \n" + ")\n"
        + "\n" + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".customer OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".warehouse\n" + "(\n"
        + "    storeid integer NOT NULL ,\n"
        + "    productid integer NOT NULL ,\n"
        + "    quantity integer NOT NULL ,\n"
        + "    CONSTRAINT warehouse_pkey PRIMARY KEY (storeid),\n"
        + "CONSTRAINT warehouse_storeid_fkey FOREIGN KEY (storeid)\n"
        + "REFERENCES \"SEP3\".store (storeid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION, \n"

        + "CONSTRAINT warehouse_productid_fkey FOREIGN KEY (productid)\n"
        + "REFERENCES \"SEP3\".product (productid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION ) \n"
        + "\n" + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".warehouse OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".feedback\n" + "(\n"
        + "    feedbackid integer NOT NULL ,\n"
        + "    productid integer NOT NULL ,\n"
        + "    feedback \"SEP3\".d_description COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    CONSTRAINT feedback_pkey PRIMARY KEY (feedbackid),\n"
        + "CONSTRAINT feedback_productid_fkey FOREIGN KEY (productid)\n"
        + "REFERENCES \"SEP3\".product (productid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION ) \n"
        + "\n" + "TABLESPACE pg_default;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "ALTER TABLE \"SEP3\".feedback OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }


    /*File file = new File("C:\\Users\\Kevin\\IdeaProjects\\DatabaseServer\\src\\SetupDatabase\\images\\profilepc.jpg");
    FileInputStream fis = new FileInputStream(file);
    PreparedStatement ps = connection.prepareStatement("INSERT INTO \"SEP3\".productimages VALUES (?, ?)");
    ps.setString(1, file.getName());
    ps.setBinaryStream(2, fis, file.length());
    ps.executeUpdate();
    ps.close();
    fis.close();*/





    System.out.println("Database is done");

/*
        sql = "CREATE TABLE IF NOT EXISTS \"Students\".Nationality ("
            + "  CountryCode varchar(2) NOT NULL PRIMARY KEY,"
            + "  Country varchar(50) NOT NULL" + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "CREATE TABLE IF NOT EXISTS \"Students\".Nationality ("
                + "  CountryCode varchar(2) NOT NULL PRIMARY KEY,"
                + "  Country varchar(50) NOT NULL" + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "CREATE TABLE IF NOT EXISTS \"Students\".Student ("
                + "  StudyNumber int NOT NULL PRIMARY KEY,"
                + "  FirstName varchar(30) NOT NULL, "
                + "  LastName varchar(30) NOT NULL, "
                + "  CountryCode varchar(50) NOT NULL,"
                + "  FOREIGN KEY (CountryCode) REFERENCES \"Students\".Nationality(CountryCode)"
                + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql = "INSERT INTO \"Students\".Nationality (CountryCode, Country) "
                + "SELECT * FROM (SELECT ?, ?) AS tmp "
                + "WHERE NOT EXISTS (SELECT CountryCode FROM \"Students\".Nationality "
                + "WHERE CountryCode = ?) LIMIT 1;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(preparedSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addNationalityToDatabase(preparedStatement, "BG", "Bulgaria");
        addNationalityToDatabase(preparedStatement, "DK", "Denmark");
        addNationalityToDatabase(preparedStatement, "GR", "Greece");
        addNationalityToDatabase(preparedStatement, "HU", "Hungary");
        addNationalityToDatabase(preparedStatement, "IS", "Iceland");
        addNationalityToDatabase(preparedStatement, "LT", "Lithuania");
        addNationalityToDatabase(preparedStatement, "LV", "Latvia");
        addNationalityToDatabase(preparedStatement, "MD", "Moldova");
        addNationalityToDatabase(preparedStatement, "RO", "Romania");
        addNationalityToDatabase(preparedStatement, "SK", "Slovakia");
        addNationalityToDatabase(preparedStatement, "?", "Not listed");
        addNationalityToDatabase(preparedStatement, "AF", "Afghanistan");
        addNationalityToDatabase(preparedStatement, "CN", "China");
        addNationalityToDatabase(preparedStatement, "PL", "Poland");
        addNationalityToDatabase(preparedStatement, "CZ", "Czech Republic");

        sql = "INSERT INTO \"Students\".Student (StudyNumber, FirstName, LastName, CountryCode) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?) AS tmp "
                + "WHERE NOT EXISTS (SELECT StudyNumber FROM \"Students\".Student "
                + "WHERE StudyNumber = ?)  LIMIT 1;";

        PreparedStatement studentStatement = null;
        try {
            studentStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addStudentToDatabase(studentStatement, 240324, "Ana Maria", "Botea", "RO");
        addStudentToDatabase(studentStatement, 240324, "Ana Maria", "Botea", "RO");
        addStudentToDatabase(studentStatement, 189121, "Naweed", "Ashrafi", "AF");
        addStudentToDatabase(studentStatement, 239844, "Cristian", "Preda", "RO");
        addStudentToDatabase(studentStatement, 240246, "Martin", "Ivanov", "BG");
        addStudentToDatabase(studentStatement, 220759, "Martin", "Lyngroes", "DK");
        addStudentToDatabase(studentStatement, 240373, "Titas", "Jackus", "LT");
        addStudentToDatabase(studentStatement, 239835, "Lea", "Te-Maiharoa", "IS");
        addStudentToDatabase(studentStatement, 240160, "Miroslav", "Fratric", "SK");
        addStudentToDatabase(studentStatement, 240248, "Ophelia", "Zhang", "CN");
        addStudentToDatabase(studentStatement, 240074, "Georgi", "Stefanov", "BG");
        addStudentToDatabase(studentStatement, 240250, "Mads", "Kracht", "DK");
        addStudentToDatabase(studentStatement, 240344, "Mikkel", "Pedersen", "DK");
        addStudentToDatabase(studentStatement, 239859, "Konstantin", "Ivanov", "BG");
        addStudentToDatabase(studentStatement, 241933, "Magdalena", "Golofit", "PL");
        addStudentToDatabase(studentStatement, 218859, "Peter", "Gydesen", "DK");
        addStudentToDatabase(studentStatement, 239907, "Venelina", "Peeva", "BG");
        addStudentToDatabase(studentStatement, 240309, "Emilie", "Kuhn", "DK");
        addStudentToDatabase(studentStatement, 240124, "Stefani", "Ivanova", "BG");
        addStudentToDatabase(studentStatement, 240299, "Dragos", "Leahu", "RO");
        addStudentToDatabase(studentStatement, 240276, "Vladimir", "Stratanenco", "RO");
        addStudentToDatabase(studentStatement, 240353, "Andreas", "Rabouli", "DK");
        addStudentToDatabase(studentStatement, 240287, "Thinh", "Pham", "DK");
        addStudentToDatabase(studentStatement, 240245, "Delia", "Petrovici", "RO");
        addStudentToDatabase(studentStatement, 240071, "Ioana", "Bratulescu", "RO");
        addStudentToDatabase(studentStatement, 240001, "Daniel", "Borisov", "BG");
        addStudentToDatabase(studentStatement, 240354, "Mojtaba", "Suhrabi", "AF");
        addStudentToDatabase(studentStatement, 239918, "David", "Kuts", "HU");
        addStudentToDatabase(studentStatement, 240280, "Denis", "Hlinka", "SK");
        addStudentToDatabase(studentStatement, 240121, "Denis", "Drga", "SK");
        addStudentToDatabase(studentStatement, 239926, "Marek", "Dvo��ek", "CZ");
        addStudentToDatabase(studentStatement, 240076, "Jakub", "Tlach", "CZ");
        addStudentToDatabase(studentStatement, 240314, "Martin", "Krisko", "CZ");
        addStudentToDatabase(studentStatement, 239995, "Adam", "Minarik", "CZ");
        addStudentToDatabase(studentStatement, 241951, "Leonard", "Merva", "SK");
        addStudentToDatabase(studentStatement, 240256, "Adrian", "Raspopa", "RO");
        addStudentToDatabase(studentStatement, 240072, "Marius", "Ungurean", "RO");
        addStudentToDatabase(studentStatement, 240055, "Edoardo", "Nikolov", "BG");
        addStudentToDatabase(studentStatement, 240303, "Mario", "Burgov", "BG");
        addStudentToDatabase(studentStatement, 239996, "Andrei", "Caisim", "RO");
        addStudentToDatabase(studentStatement, 240190, "Marton", "Teperics", "HU");
        addStudentToDatabase(studentStatement, 240319, "Edi", "Trifonov", "BG");
        addStudentToDatabase(studentStatement, 239978, "Tamas", "Makai", "HU");

        // Check result:


        try {
            String querysql = "SELECT CountryCode, Country FROM \"Students\".Nationality ORDER BY CountryCode;";
            PreparedStatement queryStudenStatement = connection.prepareStatement(querysql);
            ResultSet resultSet = queryStudenStatement.executeQuery();

            ArrayList<Object[]> results = new ArrayList<Object[]>();

            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                results.add(row);
            }

            resultSet.close();
            queryStudenStatement.close();

            for (int i = 0; i < results.size(); i++) {
                Object[] row = results.get(i);
                String countryCode = row[0].toString();
                String country = row[1].toString();
                System.out.println(country + " (" + countryCode + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            String querysql2 = "SELECT StudyNumber, FirstName, LastName, "
                    + "Country FROM \"Students\".Student, \"Students\".Nationality "
                    + "WHERE Student.CountryCode = Nationality.CountryCode "
                    + "AND FirstName LIKE ? " + "ORDER BY FirstName, LastName;";

            PreparedStatement queryStudenStatement = connection.prepareStatement(querysql2);
            queryStudenStatement.setObject(1, "%");
            ResultSet resultSet = queryStudenStatement.executeQuery();

            ArrayList<Object[]> results = new ArrayList<Object[]>();
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                results.add(row);
            }
            resultSet.close();
            queryStudenStatement.close();

            for (int i = 0; i < results.size(); i++) {
                Object[] row = results.get(i);
                int studyNumber = Integer.parseInt(row[0].toString());
                String firstName = row[1].toString();
                String lastName = row[2].toString();
                String country = row[3].toString();
                System.out.println(firstName + " " + lastName + " (" + studyNumber
                        + ") - " + country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addStudentToDatabase(PreparedStatement studentStatement, int studentNum, String name, String lName, String code) {
        try {
            studentStatement.setInt(1, studentNum);
            studentStatement.setString(2, name);
            studentStatement.setString(3, lName);
            studentStatement.setString(4, code);
            studentStatement.setInt(5, studentNum);
            studentStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNationalityToDatabase(PreparedStatement preparedStatement, String code, String country) {
        try {
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

  }

}
