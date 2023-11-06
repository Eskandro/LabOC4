import java.io.*;
import java.util.Scanner;

public class Consumer {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            scanner.nextLine();
            System.out.println("Процесс потребитель");
            scanner.nextLine();
            System.out.println("P(SРазрЧт)");
            outerLoop:
            while (true) {
                File file = new File("SРазрЧт");
                try {
                    Scanner scan = new Scanner(file);
                    FileWriter writer = new FileWriter(file, false);

                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        if (line.equals("1")) {
                            writer.write("0");

                            writer.close();
                            scan.close();

                            System.out.println("Процесс заблокирован");
                            break outerLoop;
                        } else if (line.equals("0")){
                            System.out.println("Ожидание на семафоре");
                            scanner.nextLine();
                            writer.close();
                            scan.close();

                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            scanner.nextLine();
            System.out.println("P(SВзИскл)");
            outerLoop:
            while (true) {
                File file = new File("SВзИскл");
                try {
                    Scanner scan = new Scanner(file);
                    FileWriter writer = new FileWriter(file, false);

                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        if (line.equals("1")) {
                            writer.write("0");
                            writer.close();
                            scan.close();

                            System.out.println("Процесс заблокирован");
                            break outerLoop;
                        } else {
                            System.out.println("Ожидание на семафоре");
                            scanner.nextLine();
                            writer.close();
                            scan.close();

                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.nextLine();
                System.out.println("Вход в крит участок");
                scanner.nextLine();
                System.out.println("Выход из крит участка");
                scanner.nextLine();

                System.out.println("V(SВзИскл)");
            }
            outerLoop:
            while (true) {
                File file = new File("SВзИскл");
                try {
                    Scanner scan = new Scanner(file);
                    FileWriter writer = new FileWriter(file, false);


                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        if (line.equals("0")) {
                            writer.write("1");
                            writer.close();
                            scan.close();

                            System.out.println("Процесс разблокирован");
                            break outerLoop;
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.nextLine();
            }
            System.out.println("V(SРазрЗап)");
            outerLoop:
            while (true) {
                File file = new File("SРазрЗап");
                try {
                    Scanner scan = new Scanner(file);
                    FileWriter writer = new FileWriter(file, false);

                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        if (line.equals("0")) {
                            writer.write("1");
                            writer.close();
                            scan.close();

                            System.out.println("Процесс разблокирован");
                            break outerLoop;
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
