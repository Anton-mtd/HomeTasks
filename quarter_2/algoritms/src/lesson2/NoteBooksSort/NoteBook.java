package lesson2.NoteBooksSort;

import java.util.Random;

public class NoteBook implements Comparable<NoteBook> {

    private int price;
    private int memoryGB;
    private FirmProducers firmProducer;
    private int indexForFirmProducer;

    private final Random random = new Random();

    public NoteBook() {
        setPrice();
        setMemory();
        indexForFirmProducer = random.nextInt(5) + 1;
        switch (indexForFirmProducer) {
            case 1 -> firmProducer = FirmProducers.Lenovo;
            case 2 -> firmProducer = FirmProducers.Asus;
            case 3 -> firmProducer = FirmProducers.MacNote;
            case 4 -> firmProducer = FirmProducers.Acer;
            case 5 -> firmProducer = FirmProducers.Xiaomi;
        }
    }

    private void setMemory() {
        int minMemory = 4;
        int maxMemory = 24;
        int stepMemory = 4;
        memoryGB = minMemory + random.nextInt((maxMemory - minMemory) / stepMemory + 1) * stepMemory;
    }

    private void setPrice() {
        int minPrice = 500;
        int maxPrice = 2000;
        int stepPrice = 50;
        price = 500 + random.nextInt(((maxPrice - minPrice) / stepPrice) + 1) * stepPrice;
    }

    public int getPrice() {
        return price;
    }

    public int getMemoryGB() {
        return memoryGB;
    }

    public int getIndexForFirmProducer() {
        return indexForFirmProducer;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "price=" + price +
                ", memoryGB=" + memoryGB +
                ", firmProducer=" + firmProducer +
                '}';
    }


    @Override
    public int compareTo(NoteBook noteBook) {
        if (this.getPrice() > noteBook.getPrice()) {
            return 1;
        } else if (this.getPrice() < noteBook.getPrice()) {
            return -1;
        } else {
            return (Integer.compare(getMemoryGB(), noteBook.getMemoryGB()) == 0) ?
                    Integer.compare(getIndexForFirmProducer(), noteBook.getIndexForFirmProducer()) :
                    Integer.compare(getMemoryGB(), noteBook.getMemoryGB());
        }
    }

}
