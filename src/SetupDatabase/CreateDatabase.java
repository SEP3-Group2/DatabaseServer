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
    //BEFORE YOU RUN THIS MAIN:
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

    sql = "CREATE DOMAIN   \"SEP3\".d_price AS numeric(7,2);";

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
    }

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

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".feedback\n" + "(\n"
        + "    feedbackid integer NOT NULL DEFAULT nextval('\"SEP3\".feedback_feedbackid_seq'::regclass) ,\n"
        + "    productid integer NOT NULL ,\n"
        + "    feedback \"SEP3\".d_description COLLATE pg_catalog.\"default\" NOT NULL,\n"
        + "    customerid integer NOT NULL ,\n"
        + "    CONSTRAINT feedback_pkey PRIMARY KEY (feedbackid),\n"
        + "CONSTRAINT feedback_productid_fkey FOREIGN KEY (productid)\n"
        + "REFERENCES \"SEP3\".product (productid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION, \n"
        + "CONSTRAINT feedback_customerid_fkey FOREIGN KEY (customerid)\n"
        + "REFERENCES \"SEP3\".customer (customerid) MATCH SIMPLE\n"
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

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".transaction\n" + "(\n"
        + "    transactionid integer NOT NULL DEFAULT nextval('\"SEP3\".transaction_transactionid_seq'::regclass) ,\n"
        + "    customerid integer NOT NULL ,\n"
        + "    storeid integer NOT NULL ,\n"
        + "    date \"SEP3\".d_date NOT NULL,\n"
        + "    totalprice \"SEP3\".d_price NOT NULL,\n"
        + "    address \"SEP3\".d_string COLLATE pg_catalog.\"default\",\n"
        + "    deliverymethod \"SEP3\".d_string COLLATE pg_catalog.\"default\",\n"
        + "    CONSTRAINT transaction_pkey PRIMARY KEY (transactionid),\n"
        + "CONSTRAINT transaction_customerid_fkey FOREIGN KEY (customerid)\n"
        + "REFERENCES \"SEP3\".customer (customerid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION, \n"
        + "CONSTRAINT transaction_storeid_fkey FOREIGN KEY (storeid)\n"
        + "REFERENCES \"SEP3\".store (storeid) MATCH SIMPLE\n"
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

    sql = "ALTER TABLE \"SEP3\".transaction OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".transactionproduct\n" + "(\n"
        + "    transactionid integer NOT NULL,\n"
        + "    productid integer NOT NULL ,\n"
        + "    quantity integer NOT NULL ,\n"
        + "    CONSTRAINT transactionproduct_pkey PRIMARY KEY (transactionid,productid),\n"
        + "CONSTRAINT tp_productid_fkey FOREIGN KEY (productid)\n"
        + "REFERENCES \"SEP3\".product (productid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION, \n"
        + "CONSTRAINT tp_transactionid_fkey FOREIGN KEY (transactionid)\n"
        + "REFERENCES \"SEP3\".transaction (transactionid) MATCH SIMPLE\n"
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

    sql = "ALTER TABLE \"SEP3\".transactionproduct OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "CREATE TABLE IF NOT EXISTS \"SEP3\".warehouseproduct\n" + "(\n"
        + "    storeid integer NOT NULL,\n"
        + "    productid integer NOT NULL ,\n"
        + "    quantity integer NOT NULL ,\n"
        + "    CONSTRAINT wp_pkey PRIMARY KEY (storeid,productid),\n"
        + "CONSTRAINT wp_productid_fkey FOREIGN KEY (productid)\n"
        + "REFERENCES \"SEP3\".product (productid) MATCH SIMPLE\n"
        + "ON UPDATE NO ACTION ON DELETE NO ACTION, \n"
        + "CONSTRAINT wp_storeid_fkey FOREIGN KEY (storeid)\n"
        + "REFERENCES \"SEP3\".store (storeid) MATCH SIMPLE\n"
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

    sql = "ALTER TABLE \"SEP3\".warehouseproduct OWNER to group2;";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    sql = "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('PlayStation 4 Pro 1 TB','Console ','The PlayStation 4 Pro entertainment system delivers enhanced performance to make your gaming more enjoyable and lifelike. Experience amazing 4K UHD resolution and HDR technology in compatible games.','2989');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('PlayStation 5 (PS5)','Console ','PlayStation 5 (PS5) is your personal access to a very special next-generation gaming experience, where photorealistic ray-tracing graphics, near-instant loading times and great 3D sound are the new norm.','4199');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Xbox Series X 1 TB (black)','Console ','Achieve true 4K gaming with the Xbox Series X thanks to 12 teraflops of graphics processor power and 16 GB of graphics memory. Enjoy all kinds of content with the built-in Blu-ray player and backward compatibility with 4 generations of Xbox.','3899'); " +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Xbox One S 1 TB (white)','Console ','Jump straight into the game with the Xbox One S 1 TB, which has 4K UHD video, 4K Blu-ray player and 1 TB of space. It also supports great services Xbox Game Pass, Xbos Live Gold and Xbox Play Anywhere that offer fun for hours.','1497');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('PS5 DualSense Wireless Controller (White)','Console ','The PS5 DualSense wireless controller has an updated vibration system with haptic feedback technology, so you get a better sense of in-game actions, as well as adaptive triggers, so you can experience varying power and excitement at your fingertips.','699');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Cyberpunk 2077 - PS4','Game ','Cyberpunk 2077 is a story-driven role-playing game in an open world, which is staged in the classic pen and paper RPG universe - Cyberpunk 2020. You play a mercenary who earns a living, whose abilities, story choices and more are determined by you.','499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Marvel Spider-Man: Miles Morales (Playstation 5)','Game ','Experience the ascent of Miles Morale as the new hero masters amazing, explosive new powers and becomes his very own Spider-Man.','449');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Red Dead Redemption 2 - Xbox One','Game ','Red Dead Redemption 2 is a tale of life in America on the eve of the modern age from the creators of Grand Theft Auto V and the original Red Dead Redemption.','199');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Super Mario Party - Switch','Game ','Inspired by classic Mario Party style, the series comes out for the Nintendo Switch with new mini-games and fun control options with the Joy-Con hand controls.','449');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Borderlands 3 - Epic Games - PC Windows','Game ','The original shooter-looter returns, packing bazillions of guns and a mayhem-fueled adventure! Blast through new worlds & enemies and save your home from the most ruthless cult leaders in the galaxy.','129');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Asus Prime Z390-P motherboard','PC Component','Build a powerful workstation or gaming PC with the Asus Prime Z390-P motherboard. The motherboard supports 9th gen. Intel processors, dual AMD GPU setup, native USB 3.1 output, easier memory overclocking and faster M.2 SSD storage.','779');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('PNY GeForce RTX 2080 Super XLR8 OC 8G graphics card','PC Component','Give your gaming computer extra power with the PNY GeForce RTX 2080 Super XLR8 OC graphics card, which uses the innovative Turing GPU platform with 8GB of GDDR6 RAM to deliver photorealistic ray tracing in even the most demanding gaming and VR environments.','5399');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('PNY XLR8 DDR RAM 16 GB','PC Component','With PNY XLR8 DDR RAM 16 GB you can boost your computer with high frequency RAM. The special look fits well into any setup that is not focused on RGB lighting, and the heatsink ensures that the temperature is kept down.','449');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 860 EVO 2.5 \"SSD (1 TB)','PC Component','Increase the speed of your desktop or laptop with the fast and reliable Samsung 860 EVO 2.5 ”SATA SSD storage device. The device delivers faster read / write speeds while keeping your data secure with 256-bit AES encryption.','779');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Seagate BarraCuda 3.5 \"internal hard drive (4 TB)','PC Component','Upgrade your laptop with the internal Seagate BarraCuda 3.5 \"hard drive. The hard drive has 4 TB capacity and is connected via SATA 3 interface with up to 6 Gbps transfer speed.','599');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Acer Aspire 7 15.6\" Laptop (black)','Laptop ','This powerful Acer Aspire 7 15.6 \"laptop easily handles multimedia, advanced applications and games thanks to a 9th gen Intel Core processor, dedicated Nvidia graphics, fast SSD storage and a Full IPS HD.','5999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('HP Omen 0806 15.6\" Laptop Gaming Computer (Black)','Laptop ','This HP Omen 15.6 \"laptop gaming computer delivers the same performance as a desktop computer. It features powerful features such as high brightness, a 144 Hz Full HD IPS AMD FreeSync display and a stylish output.','8999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('MSI GF65 Thin 15.6\" Laptop Gaming Computer','Laptop ','Experience the latest high-quality gaming on the MSI GF65 Thin 15.6 \"gaming laptop, which offers excellent performance in a compact case. Cooler Booster Trinity + ensures efficient cooling.','9999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Asus ROG Zephyrus G14 14\" Laptop Gaming Computer (eclipse gray)','Laptop ','This Asus ROG Zephyrus G14 gaming computer delivers excellent performance in fast games in Full HD resolution with high frame rate. With the brand new AniMe Matrix, you can show off your creativity and put your personal touch on the back of the computer.','9499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Razer Blade Base 15.6 \"laptop','Laptop ','The Razer Blade Stealth 15.6 \"laptop lets you play wherever you want. With an i7 processor and an Nvidia GPU, this laptop has enough power to handle heavier tasks like streaming or video editing on the go.','9499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Microsoft Xbox Wireless controller (shock blue)','Console ','The Xbox Wireless controller has a modernized design with an updated hybrid D-pad for even more precise control of your movements. The controller also has textured handles for triggers, bumpers and a bag case for a safer grip.','599');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('DualShock 4 wireless controller for PS4 (red)','Console ','DualShock 4 wireless controller gives you full control and the opportunity to share your greatest moments with your friends.','599');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('JUMANJI: The Video Game - PS4','Game ','Go on an adventure in the action-packed game, Jumanji. The ultimate challenge for those who want to explore a new world. Play with up to three friends or AI teammates. Defeat enemies, clear your way through life-threatening traps and save the world.','159');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('NZXT H500i computer case (white)','PC Component','This NZXT H500i computer case is the perfect match for a computer builder. With its compact ATX form factor and sleek design, the case is every serious enthusiast dream.','739');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('MSI GS66 Stealth 15.6 \"laptop gaming computer (black)','Laptop ','Experience the latest high-quality gaming on the MSI GS66 Stealth 15.6 \"gaming laptop, which offers excellent performance in a compact case. Cooler Booster Trinity + ensures efficient cooling.','9999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 65\" Q60T 4K UHD QLED Smart-TV QE65Q60TAU','TV ','Get more out of your TV with this Samsung 65 \"Q60T 4K UHD Smart TV QE65Q60TAU when it comes to color and smart features. It features Quantum Dot technology and a powerful processor in a sleek design that delivers excellent picture and sound.','5555');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 55\" Q60T 4K UHD QLED Smart-TV QE55Q60TAU','TV ','Get more out of your TV with this Samsung 55 \"Q60T 4K UHD Smart TV QE55Q60TAU when it comes to colors and smart features. It features Quantum Dot technology and a powerful processor in a sleek design that delivers excellent picture and sound.','4444');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 43\" TU7172 4K UHD Smart TV UE43TU7172','TV ','This Samsung 43 \"TU7172 4K UHD Smart TV UE43TU7172 is a smart Crystal UHD TV with authentic 4K resolution with vibrant colors, deep black shades and sharp contrast. The TV is equipped with Tizen TV function for easy streaming.','3499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('TCL 32\" DD420 HD Ready LED TV 32DD420','TV ','Even a smaller television can give you the feel of a large screen. The TCL 32 \"HD Ready LED TV 32DD420 lets you enjoy your content without requiring much space.','1499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 32\" T5305 Full HD Smart TV UE32T5305','TV ','The compact Samsung 32 \"Full HD Smart TV UE32T5305 has Hyper Real engine, HDR and Micro Dimming Pro, so you can enjoy clear, vivid colors with deeper blacks and clearer white tones in clear Full HD quality. The device is an ideal solution as a TV number thaw.','2999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 58\" TU7175 4K UHD Smart-TV UE58TU7175','TV ','This Samsung 58 \"TU7175 4K UHD Smart TV UE58TU7175 is a smart Crystal UHD TV with authentic 4K resolution with vibrant colors, deep black shades and sharp contrast. The TV is equipped with Tizen TV function for easy streaming.','5999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('LG 32\" LM6300 Full HD Smart TV 32LM6300','TV ','Enjoy the content with the LG 32 \"Full HD Smart TV 32LM6300, which has delicate details and bright colors that will enrich the experience, whether you are watching a movie, streaming your favorite series or looking for viral videos.','3099');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 43\" Q67T 4K UHD QLED Smart-TV QE43Q67TAU','TV ','Get more out of your TV with this Samsung 43 \"Q67T 4K UHD Smart TV QE43Q67TAU when it comes to colors and smart features. It features Quantum Dot technology and a powerful processor in a sleek design that delivers excellent picture and sound.','4999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 43\" TU8505 4K UHD Smart-TV UE43TU8505','TV ','This Samsung 43 \"TU8505 4K UHD Smart TV UE43TU8505 with Crystal UHD and Dual LED with a wider color spectrum delivers authentic 4K resolution with vibrant colors and sharp contrast. The TV is equipped with the smart Tizen TV function.','4499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('TCL 40\" ES560 Full HD Smart TV 40ES560','TV ','Enjoy sharp and clean picture quality with vibrant colors and rich sound with the TCL 40 \"Full HD Smart TV 40ES560, which has Android TV 8.0 for easy access to all kinds of content.','2499');" +
    " INSERT INTO\"SEP3\".product (title,category,description,price) VALUES ('Philips 43\" PUS7505 4K UHD Smart TV 43PUS7505/12','TV ','With a Philips 43 \"4K UHD Smart TV 43PUS7505 / 12 you can experience breathtaking images filled with contrasts and deep colors. The TV has Dolby Atmos and Dolby Vision, HDR10 + for true-to-life colors and Saphi Smart TV for quick access to apps.','4999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung 43\" Q60T 4K UHD QLED Smart-TV QE43Q60TAU (2020)','TV ','Get more out of your TV with this Samsung 43 \"Q60T 4K UHD Smart TV QE43Q60TAU when it comes to color and smart features. It features Quantum Dot technology and a powerful processor in a sleek design that delivers excellent picture and sound.','3499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Chromecast (3. gen.)','Media Player','Connect Chromecast gen. 3 with your regular TV and open up a world full of entertainment. Stream thousands of videos or movies, millions of songs, play fun games or cast pictures from your smartphone or tablet.','320');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Apple TV 4K - 32 GB','Media Player','Stop watching TV at will and upgrade it to a new level and an active experience with superior picture quality in vivid colors. Apple TV 4K with unique tvOS operating system gives you games, movies, live streaming and more via the App Store.','1379');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('NVIDIA SHIELD TV Pro media and game streamer (16 GB)','Media Player','NVIDIA SHIELD TV Pro with enhanced remote control provides almost limitless possibilities with media and gaming streaming in excellent 4K HDR quality, clear sound and fast response with NVIDIA Tegra X1 + processor.','1699');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Chromecast Ultra','Media Player','Plug Chromecast Ultra into the HDMI port of your TV and cast content in 4K / UHD quality, stream thousands of videos or movies, millions of songs, try exciting games or cast images from your smartphone or tablet.','630');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Mission: Impossible - Fallout','Movie ','During a dangerous mission, ethan hunt (tom cruise) chooses to rescue his team instead of completing the mission.','34');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('First Man','Movie ','Oscar-winning director Damien Chazelle and star actor Ryan Gosling tell the fascinating story of the first manned mission to the moon, focusing on Neil Armstrong and the decade leading up to the historic Apollo 11 journey.','34');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('How To Train Your Dragon 2','Movie ','When hiccups and toothlessness discover a secret ice cave with wild dragons and a mysterious dragon trainer, they end up in the middle of a wild battle to save the future of humans and dragons.','34');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('300: Rise of an Empire','Movie ','The sequel to the blockbuster movie 300. In 300: Rise of an Empire, the action takes place 500 BC.','34');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Texas Chainsaw 3D ','Movie ','For many years, several people in the small town of Newt, Texas, had disappeared without a trace.','34');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Sonos One Gen 2 speaker','Speaker ','The Sonos One Gen 2 speaker can now be voice-controlled via the built-in Google Assistant. Enjoy a surprisingly rich sound and choose between voice or manual control. Get a powerful stereo system when you connect your Sonos One to other Sonos speakers.','1699');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('JBL Xtreme 2 Wireless Speaker','Speaker ','Experience powerful stereo sound and strong bass with the rugged yet portable JBL Xtreme 2 Wireless Speaker, which you can take with you anywhere and provide 15 hours of playing time on a single charge.','1111');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Sonos One SL speaker','Speaker ','The Sonos One SL speaker delivers surprisingly rich and powerful sound despite its compact design. Stream music wirelessly from your smartphone or create a powerful stereo system when you connect the speaker to other Sonos speakers.','1499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Yamaha speaker NS-555','Speaker ','Get quality and high performance with this sleek Yamaha NS-555 speaker. Thanks to several different unique technologies, you are guaranteed a clear and natural sound. The package includes one speaker.','1497');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Beko dishwasher EDDN28535X (steel)','Kitchen Appliance','Elegant, quiet and with great capacity. The Beko dishwasher EDDN28535X is a reliable companion when you want to do the dishes quickly.','5499');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Bosch washing machine WAT284E9SN','Kitchen Appliance','Bosch washing machine for 9 kg of clothes that washes your clothes in a fast, silent and efficient way. Energy class A+++.','4899');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Gram cooker CC56350V (white)','Kitchen Appliance','This Gram cooker CC56350V makes it easy to prepare delicious dishes with an oven capacity of 65 liters and 9 cooking functions as well as a ceramic hob with 4 cooking zones. The stove is easy to maintain thanks to the SteamClean self-cleaning feature.','2333');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Philips Avance Collection Airfryer XXL HD9650/90','Kitchen Appliance','Cook, fry or bake with no or very limited fat without compromising on taste and start living healthier with the Philips Avance Collection Airfryer XXL HD9650/90.','2222');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Philips electric kettle HD4646/20','Kitchen Appliance','The kettle has a capacity of 1.5 litres and is 2400 watts.','249');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Wilfa toaster TO-1B - black','Kitchen Appliance','Wilfa toaster with sturdy steel design. Enjoy freshly roasted bread for breakfast.','399');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Philips PowerLife Iron GC2998/80','Iron ','Effectively and easily iron all your clothes and textiles with Philips PowerLife iron GC2998/80. The powerful iron has a steam shot of 170 g/min, vertical steam function and switches off automatically.','499');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Tefal LinenCare Smart Protect Iron FV4981E0','Iron ','Perfectly ironed clothes without curls help you make a good impression, and thanks to Tefal LinenCare Smart Protect the steam ironing FV4981E0, ironing is made easier.','599');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Bosch SensorSecure iron TDA3024210 - blue','Iron ','Powerful steam iron from Bosch with advanced features, Auto Switch off and large water tank.','549');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Tefal LinenCare Turbo Pro Anti-Calc Iron FV5646E0','Iron ','Remove efficiently and safely all the folds in your clothes. Tefal LinenCare Turbo Pro Anti-Calc iron FV5646E0 comes with a powerful TurboBoost steam shot and a premium Durilim AirGlide Autoclean ironing plate.','899');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Matsui iron M120IR11E','Iron ','Easy-to-use Matsui steam iron with stainless steel iron.Easy-to-use Matsui steam iron with stainless steel iron.','99');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Logic iron 220IR20E','Iron ','With logic iron L220IR20E, the curls dont stand a chance. Its powerful steam shot handles even the most stubborn curls, and the anti-drip and anti-lime features keep your clothes clean and safe.','149');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Sony Alpha A6100 System Camera + 16-50 Mm F/3.5-5.6 Power Zoom Lens','Camera ','Sony Alpha A6100 system camera + 16-50 mm f/3.5-5.6 Power Zoom lens is a full package with lightning fast 0.02 AF, eye-AF in real time, real-time tracking and 24.2 MP CMOS Exmor sensor, delivering breathtaking 4K videos and images with sharp detail.','5999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Canon EOS 90D DSLR camera + EC-S 18-55 mm f/3.5-5.6 IS STM lens','Camera ','Connect wirelessly to control your Canon EOS 90D DSLR camera body, which includes a 15-55mm lens and features a 32.5MP APS-C CMOS sensor, which together with dual pixel CMOS AF delivers excellent, razor-sharp images and 4K videos.','9999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Canon EOS 200D DSLR camera+18-55mm IS STM lens black','Camera ','Take great high-quality photos and video with the Canon EOS 200D DSLR camera, which comes with an 18-55mm IS STM lens. The camera has a large 24.2 megapixel APS-C sensor, a convenient 3\" Vari-Angle display and Dual Pixel CMOS Autofocus.','5497');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Panasonic Lumix DC-G90 CSC Camera + G Vario 12-60mm f/3.5-5.6 lens','Camera ','The travel-friendly, weather-resistant Panasonic Lumix DC-G90 CSC camera with G Vario 12-60 mm lens lets you capture landscapes, cityscapes or portraits in crisp 20.3MP images or 4K videos you can watch on the 3\" free-angle OLED touchscreen.','8299');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('4K WiFi Action Camera with Large Accessory Set','Camera ','A 4K sports camera that comes with a lot of accessories like waterproof shell, camera frame and a variety of mounts and mounting for mounting on helmet, bike, wrist, etc.','655');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Polaroid analog camera','Camera ','Take great photos with the analog Polaroid Now camera, which has new autofocus and dual exposure for even sharper images. The analog camera has a convenient self-timer function and a rechargeable battery.','899');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('OnePlus 8 Pro smartphone 12/256GB','Phone ','The OnePlus 8 Pro smartphone features a 6.78\" Fluid AMOLED display, modern design and powerful 865 processor with 5G. The device supports 30W wireless charging and has IP68 water and dust resistant.','6199');" +
    " INSERT INTO\"SEP3\".product (title,category,description,price) VALUES ('iPhone 12 Pro - 5G smartphone 128GB','Phone ','This iPhone 12 Pro smartphone supports the new, lightning-fast 5G network. It features a sharp 12MP 3-dual rear camera and a powerful Apple A14 Bionic processor. It is also IP68 rated and has Ceramic Shield glass screen protection.','8899');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung Galaxy S10 Plus smartphone 8/128GB','Phone ','The Samsung Galaxy S10 Plus smartphone represents the new generation of mobile devices and offers a 6.4\" Infinity-O display, video recording in impressive 4K, triple rear camera, reverse wireless charging and more.','6799');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Samsung Galaxy Note20 Ultra 5G smartphone 12/256GB','Phone ','The Samsung Galaxy Note20 Ultra 5G smartphone has high-end features like a 120 Hz screen, an Exynos 990 processor with 5G. 108+12+12 MP camera with 50x Space Zoom and the iconic S Pen. Thanks to the IP68 assessment, the phone is protected from water and dust.','9999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('OnePlus North 5G smartphone 8/128GB','Phone ','This OnePlus North smartphone is a great device with a 6.44\" Optical AMOLED touchscreen, quad rear camera, dual selfie camera and Snapdragon 765G gaming processor with 5G. The 4100mAh battery supports Warp Charge 30T fast charging technology.','3299');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price) VALUES ('Motorola Edge 5G smartphone 6/128GB','Phone ','The Motorola Edge smartphone features a beautiful 6.7\" Endless Edge touchscreen with curved edges and a 64+16+8 MP rear camera with ToF sensor and Quad Pixel technology. It features a Snapdragon 765 processor with 5G capabilities.','3699');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('iPhone 11 64GB','Phone ','Capture the world around you as you take breathtaking photos and videos with your iPhone 11 smartphone, which features an Ultra Wide camera with exclusive light control and a true-to-life all-screen display that makes all content stand out.','5299');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Garmin Vivoactive 4S','Smart watch','The Garmin Vivoactive 4S smartwatch with GPS is a small fitness companion that always sits on your wrist. The watch offers activity and heart rate measurement, can show you notifications and SMSs from your smartphone. You can even wear it in the swimming pool','2399');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Apple Watch Series 3 ','Smart watch','Keep track of your health and increase your motivation with a bold playlist while playing sports. With the incomparable Apple Watch Series 3, which has a great design and sleek construction, this is possible.','1699');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Samsung Galaxy Watch 4G','Smart watch','This smart watch stores many intelligent features. With the Samsung Galaxy Watch, you can make calls on the go, track your fitness, stream music or pay for your shopping - and you dont have to lug around your phone.','1999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Samsung Galaxy Watch 3','Smart watch','The Samsung Galaxy Watch 3 smartwatch is a refined device that offers elegant design, activity and health tracking as well as perfect connections. Thanks to the 5ATM water resistance and the MIL-STD-810G military standard, it handles water and dust.','3799');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Garmin Vivoactive 3','Smart watch','The Garmin Vivoactive 3 GPS smartwatch comes in a stylish design with personalized dials to best suit your outfit or mood. It also lets you measure your daily activity and easily check all notifications directly on your wrist.','1399');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Apple AirPods (2019)','Headphones ','Ultra-compact and cordless. The new Apple AirPods wireless headphones sense when you touch them in your ears. You can control them via Siri voice control, and they have up to 24 hours of battery life with the included charger case.','1079');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Bose QuietComfort 35 QC35 II','Headphones ','Listen to superior quality music without interruption or hassle with wires with the Bose QuietComfort Wireless Headphones II, which feature active noise-canceling and Google Assistant, which gives you full control over the music with your voice.','1999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Marshall Major III','Headphones ','The wireless Marshall Major III on-ear headphones with the iconic font logo are modern classics with good sound and over 30 hours of cable-free service life.','499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Sony Wireless WH-1000XM3','Headphones ','The Sony Wireless Headphones WH-100XM3 sweep the predecessors off the track with a sleek, lightweight design and excellent noise insulation. 10 minutes of charging provides 5 hours of wireless use.','1399');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('JBL Tune500BT','Headphones ','The wireless JBL Tune500 on-ear headphones are an ideal plug-and-play solution for anyone who enjoys music on the go. Enjoy powerful JBL Pure Bass Sound, control Siri or Google Now, and fold them when youre not using them to fit in your bag.','399');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Jabra Elite 65t','Headphones ','The Jabra Elite 65t genuine wireless in-ear headphones provide the best experience when listening to music and receiving calls. It is thanks to unsurpassed modern technology that will put your everyday life in a new light.','799');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Beats Studio3','Headphones ','Beats Studio wireless headphones that are easy to connect to give you the beauty of crystal clear, wireless music in even noisy environments.','1399');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Ninebot MAX G30D','Electric scooter','Make a regular commute more fun with this Ninebot by Segway electric scooter MAX G30D, which has a range of 65 km and a speed of up to 20 km / h. This electric scooter has 10 ”wheels and practical LED lights.','6499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Xiaomi Essential Lite MI25702','Electric scooter','Whiz through the streets on this electric scooter Xiaomi Essential Lite MI25702, an easily foldable scooter with a maximum speed of 20 km / h, 20 km range, improved safety measures and a multifunctional dashboard.','2399');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('SoFlow S03','Electric scooter','Make your daily commute a little more fun with this SoFlow S03 electric scooter SOFLOW03. The compact but stable scooter is easy to store away thanks to the folding mechanism, and it can drive up to 20 km / h and has a range of 30 km on a full charge.','3499');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Hover-1 Eagle','Electric scooter','Go on a city trip with this Hover-1 Eagle scooter EUNDEGEBLK with a top speed of 20 km / h and a range of 11 km. With the electric brake, LED headlights, rear brake light, LCD screen and collapsible design, this scooter is both safe and comfortable.','2999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Ninebot Segway E22E','Electric scooter','Getting to and from school or working with this Ninebot by Segway KickScooter E22E has never been easier. It has a range of 22 km, a top speed of 20 km / h as well as LED lights on the front and rear brakes and thick, resilient wheels.','2999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Sand power SAC05C19E','Air Condtion','Keep the temperature in your home even and comfortable, even in the hot summer weather thanks to Sandstrøm air conditioning SAC05C19E with remote control and a timer. It also has an auto restart function as well as a handy LED screen.','2499');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Domair DOM100380','Air Condtion','Do not let the heat bother you - the mobile Domair air conditioning DOM100380 with remote control, timer and air flow of 300 m3 / h keeps your room cool, even on hot summer days. The unit can be used in rooms of up to 12 m2.','3999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Climadiff CLIMAA9K1','Air Condtion','Use the summer in a cooled environment with this Climadiff air conditioner CLIMAA9K1, which has a timer and 9,000 Btu / h capacity and cools rooms of up to 27 m2. The device also acts as a dehumidifier.','4999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Inventor 100448','Air Condtion','Resist the summer heat with the help of the portable Inventor air conditioner 100448. Its large cooling capacity, remote control and timer ensure that you can spend time in a cooled home. The practical handle and wheels make it easy to move around.','4999');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('DJI Mavic Air 2','Drones ','Explore the clouds with this DJI Mavic Air 2 drone and record beautiful flight videos. The drone is equipped with an improved 3-axis gimbal, 4K camera and a maximum speed of 68 km / h. It has a flight time of 34 minutes and a range of 10 km.','7999');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('DJI Mavic Mini','Drones ','The DJI Mavic Mini drone mimics the foldable design of its larger siblings in a compact construction of 249 g. It is equipped with a sling bar with 3 axes and 2.7K video recording. The drone can fly for 30 minutes with a range of up to 2 km.','3090');" +
    " INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Ryze Tello','Drones ','Have unlimited fun and take cool pictures and videos with the small but lively Tello drone from Ryze. Whether you are outside, at work or at home, you can take off with the drone and experience the world from above.','1199');" +
    "INSERT INTO \"SEP3\".product (title,category,description,price)VALUES ('Denver DRO-170','Drones ','Impress your friends with flight demonstrations with this smart Denver drone DRO-170. The drone has a flight time of up to 7 minutes. Operate the drone with a special hand-mounted controller. The drone has a hold-height function.','299');";

    try
    {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    System.out.println("Database is done");

  }

}
