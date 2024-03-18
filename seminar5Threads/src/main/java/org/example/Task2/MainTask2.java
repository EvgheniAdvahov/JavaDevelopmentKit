package org.example.Task2;

/*
В рамках выполнения задачи необходимо:
    Создайте два потока A и B.
    Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
    (true в состояние false и наоборот).
    Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
    с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит switcher
    в состояние false.
    Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */
public class MainTask2 {
    // Можно сделать с атомарными переменными
    static volatile boolean switcher = false;
    static volatile boolean work = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (work) {
                switcher = !switcher;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread1 = new Thread(() ->{
            int a = 100;
            while (a > 0){
                if (switcher){
                    System.out.println(a--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            work = !work;
        });

        thread.start();
        thread1.start();

    }

}
