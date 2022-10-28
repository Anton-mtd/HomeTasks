package com.skomorokhin.hibernateOne;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionfactory = new SessionFactoryUtils();
        sessionfactory.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionfactory);
            System.out.println("Берем объект из БД");
            Product product = productDao.findById(2l);
            System.out.println("Меняем объект");
            product.setPrice(1000);
            product.setTitle("SomethingNew");
            System.out.println("Возвращаем в БД");
            System.out.println(productDao.saveOrUpdate(product));
            System.out.println("Выводим все продукты");
            System.out.println(productDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionfactory.shutdown();
        }
    }
}
