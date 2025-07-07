package principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 7){
            String monedaObjetivo = null;
            String monedaBase = null;

            ConversorMoneda.escribirMenu();
            opcion = teclado.nextInt();
            System.out.println("Ingrese el valor que desea convertir: ");
            double valor = teclado.nextDouble();
            switch(opcion){
                case 1:
                    realizarCalculo("USD","ARS",valor);
                    break;
                case 2:
                    realizarCalculo("ARS","USD",valor);
                    break;
                case 3:
                    realizarCalculo("USD","BRL",valor);
                    break;
                case 4:
                    realizarCalculo("BRL","USD",valor);
                    break;
                case 5:
                    realizarCalculo("USD","COP",valor);
                    break;
                case 6:
                    realizarCalculo("COP","USD",valor);
                    break;

            }

        }

    }

    private static void realizarCalculo(String monedaBase,String monedaObjetivo, double valor){

        ConversorMoneda conversorMoneda = new ConversorMoneda();
        Moneda moneda= conversorMoneda.convertir(monedaBase,monedaObjetivo,valor);
        System.out.println("El valor "+valor+" " +
                "["+moneda.base_code()+"] Corresponde al valor final de =>>> "
                +moneda.conversion_result()+" ["+moneda.target_code()+"]");
    }
}
