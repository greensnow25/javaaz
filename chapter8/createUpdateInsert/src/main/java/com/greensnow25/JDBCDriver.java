package com.greensnow25;

import javax.xml.ws.Service;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;
import java.util.ServiceLoader;

/**
 * Public class JDBSDriver.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.08.2017.
 */
public class JDBCDriver {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/greensnow25";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "tcrfylth";
        try

        {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение

            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            Statement statement = null;

            statement = connection.createStatement();
            //Выполним запрос
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM my_contacts where my_contacts.gender = 'M'");
            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать
            //метод next() , с помощью которого переходим к следующему элементу
            System.out.println("Выводим statement");
            while (result1.next()) {
                String nam = result1.getString("first_name");
                System.out.println(nam);
            }
        } catch (Exception e) {

        }
    }
}
