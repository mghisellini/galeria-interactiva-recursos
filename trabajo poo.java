
import java.util.Scanner; 
public class trabajo_poo {
Scanner sc = new Scanner(System.in);

// Ejercicio 1: Multiplicar matrices public void multiplicarMatrices() {
System.out.print("Filas A: "); int fa = sc.nextInt(); System.out.print("Columnas A: "); int ca = sc.nextInt(); System.out.print("Filas B: "); int fb = sc.nextInt(); System.out.print("Columnas B: "); int cb = sc.nextInt();
if (ca != fb) { System.out.println("No se pueden multiplicar."); return; }

int[][] A = new int[fa][ca];
int[][] B = new int[fb][cb];
int[][] C = new int[fa][cb];

for (int i = 0; i < fa; i++)
for (int j = 0; j < ca; j++) { System.out.print("A[" + i + "][" + j + "]: "); A[i][j] = sc.nextInt(); }

for (int i = 0; i < fb; i++)
for (int j = 0; j < cb; j++) { System.out.print("B[" + i + "][" + j + "]: "); B[i][j] = sc.nextInt(); }

for (int i = 0; i < fa; i++)
for (int j = 0; j < cb; j++)
for (int k = 0; k < ca; k++) C[i][j] += A[i][k] * B[k][j];

System.out.println("Resultado:"); for (int i = 0; i < fa; i++) {
for (int j = 0; j < cb; j++) System.out.print(C[i][j] + " "); System.out.println();
}
}

// Ejercicio 2: Suma del cuadrado de la diagonal principal public void sumaDiagonalPrincipal() {
System.out.print("Orden de la matriz: "); int n = sc.nextInt();
int[][] m = new int[n][n]; int suma = 0;

for (int i = 0; i < n; i++)
for (int j = 0; j < n; j++) { System.out.print("[" + i + "][" + j + "]: "); m[i][j] = sc.nextInt(); }

for (int i = 0; i < n; i++) suma += m[i][i] * m[i][i]; System.out.println("Suma = " + suma);
}

// Ejercicio 3: Matriz transpuesta public void matrizTranspuesta() {
System.out.print("Filas: "); int f = sc.nextInt(); System.out.print("Columnas: "); int c = sc.nextInt();
int[][] m = new int[f][c];

for (int i = 0; i < f; i++)
for (int j = 0; j < c; j++) { System.out.print("[" + i + "][" + j + "]: "); m[i][j] = sc.nextInt(); }

System.out.println("Transpuesta:"); for (int j = 0; j < c; j++) {
for (int i = 0; i < f; i++) System.out.print(m[i][j] + " "); System.out.println();
}
}

// Ejercicio 4: Moda public void moda() {
System.out.print("Cantidad de elementos: "); int n = sc.nextInt();
int[] v = new int[n];
for (int i = 0; i < n; i++) { System.out.print("Elemento " + (i + 1) + ": "); v[i] = sc.nextInt(); }

int moda = v[0], max = 0;
for (int i = 0; i < n; i++) { int cont = 0;
for (int j = 0; j < n; j++) if (v[i] == v[j]) cont++;
if (cont > max) { max = cont; moda = v[i]; }
}
System.out.println("Moda = " + moda);
}

// Ejercicio 5: Diferencia exacta entre dos fechas public void diferenciaFechas() {
int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
System.out.println("Fecha 1");
int d1 = sc.nextInt(), m1 = sc.nextInt(), a1 = sc.nextInt(); System.out.println("Fecha 2");
int d2 = sc.nextInt(), m2 = sc.nextInt(), a2 = sc.nextInt();

if (d2 < d1) { d2 += diasMes[m2 - 2 < 0 ? 11 : m2 - 2]; m2--; } if (m2 < m1) { m2 += 12; a2--; }

int dias = d2 - d1; int meses = m2 - m1; int anos = a2 - a1;
System.out.println(anos + " años, " + meses + " meses y " + dias + " días");
}

// Ejercicio 6: Validar cedula dominicana public void validarCedula() {
System.out.print("Cedula (11 digitos, sin guiones): "); String c = sc.next();
if (c.length() != 11) { System.out.println("Debe tener 11 digitos."); return; }

int[] pesos = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0};
int suma = 0;
for (int i = 0; i < 11; i++) {
int p = (c.charAt(i) - '0') * pesos[i]; if (p >= 10) p = p / 10 + p % 10;
suma += p;
}
System.out.println(suma % 10 == 0 ? "Cedula VALIDA." : "Cedula INVALIDA.");
}
// Ejercicio 7: Monto en letras (sobrecargado: entero y con centavos)

String[] unidades = {"", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE",
"DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE"};

String[] decenas = {
"", "", "VEINTI", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"
           };
 String[] centenas = {"", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS",
"SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS"
};

private String convertirGrupo(int n)
{ if (n == 100) return "CIEN"; String t = "";
int cen = n / 100, resto = n % 100;
if (cen > 0) t += centenas[cen] + " "; if (resto > 0) {
if (resto < 20) t += unidades[resto];
else if (resto < 30) t += "VEINTI" + unidades[resto - 20]; else {
t += decenas[resto / 10];
if (resto % 10 > 0) t += " Y " + unidades[resto % 10];
}
}
return t.trim();
}

private String numeroALetras(long n) {
 if (n == 0) 
return "CERO";

long miles = n / 1000, resto = n % 1000; String t = "";
if (miles == 1) t += "MIL ";
else if (miles > 1) t += convertirGrupo((int) miles) + " MIL "; if (resto > 0) t += convertirGrupo((int) resto);
return t.trim();
}

public String montoEnLetras(int monto) {
return numeroALetras(monto) + (monto == 1 ? " PESO" : " PESOS") + " CON 00/100";
}

public String montoEnLetras(double monto) { long entero = (long) monto;
int centavos = (int) Math.round((monto - entero) * 100); if (centavos == 100) { centavos = 0; entero++; }
String t = numeroALetras(entero) + (entero == 1 ? " PESO" : " PESOS");
if (centavos > 0) t += " CON " + numeroALetras(centavos) + (centavos == 1 ? " CENTAVO" : " CENTAVOS"); else t += " CON 00/100";
return t;
}

public void montoEnLetrasPorTeclado() { System.out.print("Monto (ej. 161250.15): "); String e = sc.next();
System.out.println(e.contains(".") ? montoEnLetras(Double.parseDouble(e)) : montoEnLetras(Integer.parseInt(e)));
}

// Ejercicio 8: Minimo comun multiplo
private long mcd(long a, long b){ return b == 0 ? a : mcd(b, a % b); }

public void mcm() { System.out.print("Cuantos numeros: "); int n = sc.nextInt();
long[] num = new long[n];
for (int i = 0; i < n; i++) { System.out.print("Numero " + (i + 1) + ": "); num[i] = sc.nextLong(); }