package ru.skomorokhin.lesson7.HomeWork;

public class MyClassTest {

    private int a;
    private int b;

    @BeforeSuite
    public void init(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.printf("initialization with arguments a = %d; b = %d\n", a, b);
    }

    @Test(priority = 2)
    public void test1Sum() {
        System.out.println("test1Sum is result: " + (a + b));
    }

    @Test(priority = 4)
    public void test2Diff() {
        System.out.println("test2Diff is result: " + (a - b));
    }

    @Test(priority = 5)
    public void test3Multiply() {
        System.out.println("test3Multiply is result: " + (a * b));
    }

    @AfterSuite
    public void stop() {
        System.out.println("finish");
    }

}
