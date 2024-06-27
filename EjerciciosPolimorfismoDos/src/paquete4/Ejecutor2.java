/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {
    // Un proceso para ingresar por teclado

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc, opc2;
        String nombre, nombreCentro;
        double cuotaB, iva, agua, luz, adicional, amplificacion, sillas;
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        System.out.println("Ingrese el nombre del Centro Comercial");
        nombreCentro = sc.nextLine();
        System.out.println("Ingrese el numero de locales a ingresar: ");
        opc = sc.nextInt();
        for (int i = 0; i < opc; i++) {
            System.out.println("[1] Ingresar Local Comida");
            System.out.println("[2] Ingresar Local Comercial");
            System.out.println("[3] Ingresar Local Sesiones");
            opc2 = sc.nextInt();
            sc.nextLine();
            switch (opc2) {
                case 1:
                    System.out.println("Ingrese nombre de el Arrendatario");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el valor de la Cuota Base");
                    cuotaB = sc.nextDouble();
                    System.out.println("Ingrese el valor de IVA");
                    iva = sc.nextDouble();
                    System.out.println("Ingrese el valor del Agua");
                    agua = sc.nextDouble();
                    System.out.println("Ingrese el valor de la Luz");
                    luz = sc.nextDouble();
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                            nombre, cuotaB);
                    arriendoComida.establecerIva(iva); // en porcentaje
                    arriendoComida.establecerValorAgua(agua); // en $
                    arriendoComida.establecerValorLuz(luz); // en $
                    listaArriendos.add(arriendoComida);
                    break;
                case 2:
                    System.out.println("Ingrese nombre de el Arrendatario");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el valor de la Cuota Base");
                    cuotaB = sc.nextDouble();
                    System.out.println("Ingrese el valor Adicional a pagar");
                    adicional = sc.nextDouble();
                    ArriendoLocalComercial arriendoComercial
                            = new ArriendoLocalComercial(nombre, cuotaB);
                    arriendoComercial.establecerNombreArrendatario(nombre);
                    arriendoComercial.establecerValorAdicionalFijo(adicional);
                    listaArriendos.add(arriendoComercial);
                    break;
                case 3:
                    System.out.println("Ingrese nombre de el Arrendatario");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el valor de la Cuota Base");
                    cuotaB = sc.nextDouble();
                    System.out.println("Ingrese el costo de Alquilar las sillas");
                    sillas = sc.nextDouble();
                    System.out.println("Ingrese el costo de la Amplificacion");
                    amplificacion = sc.nextDouble();
                    ArriendoLocalSesiones arriendoSesiones
                            = new ArriendoLocalSesiones(nombre, cuotaB);
                    arriendoSesiones.establecerValorAmplificacion(amplificacion);
                    arriendoSesiones.establecerValorSillas(sillas);
                    listaArriendos.add(arriendoSesiones);

            }

        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial(nombreCentro,listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
