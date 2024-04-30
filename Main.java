
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Conversor c1 = new Conversor();
        int escolha = 0;
        String[] menu = {
                "\nQual moeda você deseja converter: ",
                "1. BRL X USD",
                "2. BRL X EUR",
                "3. BRL X KWD",
                "4. BRL X ARS",
                "5. BRL X JPN",
                "6. BRL X CNY",
                "7. --SAIR--"
        };
        while (escolha!=7) {
            try {
                System.out.print("Menu Principal");

                for (int i = 0; i < menu.length; i++) {
                    System.out.print(menu[i] + "\n");
                }

                System.out.print("\nDigite sua escolha: ");
                escolha = sc.nextInt();
                if (escolha != 7&& escolha < 7) {
                    System.out.println("\nDigite a quantidade de BRL que você quer converter");
                    double qnt = sc.nextDouble();

                    System.out.printf("%.2f", c1.conversorDeMoeda(escolha, qnt));
                    System.out.println("");
                    Thread.sleep(3000);
                }if(escolha>7){
                    System.out.println("Digite uma opção válida");
                    Thread.sleep(3000);
                }
            }catch (InterruptedException | InputMismatchException e) {

                System.out.println("Digite uma opção válida");
                Thread.sleep(3000);
                sc.nextLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Saindo...");
        sc.close();
    }

}
