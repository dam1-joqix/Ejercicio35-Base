import java.util.ArrayList;
import java.util.Random;

/**
 * Clase gestora del tablero de juego.
 * Guarda una matriz de enteros representado el tablero.
 * Si hay una mina en una posición guarda el número -1
 * Si no hay una mina, se guarda cuántas minas hay alrededor.
 * Almacena la puntuación de la partida
 * @author jesusredondogarcia
 *
 */
public class ControlJuego {
	
	private final static int MINA = -1;
	final int MINAS_INICIALES = 20;
	final int LADO_TABLERO = 10;

	private int [][] tablero;
	private int puntuacion;
	
	
	public ControlJuego() {
		//Creamos el tablero:
		tablero = new int[LADO_TABLERO][LADO_TABLERO];
		
		//Inicializamos una nueva partida
		inicializarPartida();
	}
	
	
	/**Método para generar un nuevo tablero de partida:
	 * @pre: La estructura tablero debe existir. 
	 * @post: Al final el tablero se habrá inicializado con tantas minas como marque la variable MINAS_INICIALES. 
	 * 			El resto de posiciones que no son minas guardan en el entero cuántas minas hay alrededor de la celda
	 */
	public void inicializarPartida(){
		Random rd=new Random();
		int[]x=new int[MINAS_INICIALES];//posicion x de las minas
		int[]y=new int[MINAS_INICIALES];//posici�n y de las minas
		/*
		 * Le damos posiciones aleatorias a las minas
		 */
		for (int i = 0; i < x.length; i++) {
			x[i]=rd.nextInt(LADO_TABLERO);
			y[i]=rd.nextInt(LADO_TABLERO);
		}
		/**
		 * si la posici�n de una mina coincide con otra se cambia la segunda
		 */
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if((x[i]==x[j])&&(y[i]==y[j])) {
					x[j]=rd.nextInt(LADO_TABLERO);
					y[j]=rd.nextInt(LADO_TABLERO);
				}
			}
		}
		/**
		 * Pintamos las minas en el tablero
		 */
		for (int i = 0; i < y.length; i++) {
			tablero[x[i]][y[i]]=MINA;
		}
		/**
		 * Recorremos el tablero para calcular las minas adjuntas
		 */
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				/*
				 * Si la posici�n no es una mina
				 * Se le asigna el valor de las minas alrededor
				 */
				if(tablero[i][j]!=MINA) {
					tablero[i][j]=calculoMinasAdjuntas(i, j);
				}
			}
		}
	}
	
	/**C�lculo de las minas adjuntas:
	 * Para calcular el número de minas tenemos que tener en cuenta que no nos salimos nunca del tablero.
	 * Por lo tanto, como mucho la i y la j valdrán LADO_TABLERO-1.
	 * Por lo tanto, como mucho la i y la j valdrán como poco 0.
	 * @param i: posición verticalmente de la casilla a rellenar
	 * @param j: posición horizontalmente de la casilla a rellenar
	 * @return : El número de minas que hay alrededor de la casilla [i][j]
	 **/
	private int calculoMinasAdjuntas(int i, int j){
		int minasAlrededor=0;
		if(i==0) {
			//esta a la izquierda
			if(j==0) {
				//aqui estaria en la esquina superior izquierda
			}else {
				if(j==LADO_TABLERO-1) {
					//esquina inferior izquierda
				}else {
					//j no es ni arriba ni abajo
				}
			}
		}else {
			if(i==LADO_TABLERO-1) {
				//esta a la derecha
				if(j==0) {
					//aqui estaria en la esquina superior derecha
				}else {
					if(j==LADO_TABLERO-1) {
						//esquina inferior derecha
					}else {
						//j no es ni arriba ni abajo
					}
			}
		}
		return minasAlrededor;
	}
	
	/**
	 * M�todo que nos permite 
	 * @pre : La casilla nunca debe haber sido abierta antes, no es controlado por el GestorJuego. Por lo tanto siempre sumaremos puntos
	 * @param i: posición verticalmente de la casilla a abrir
	 * @param j: posición horizontalmente de la casilla a abrir
	 * @return : Verdadero si no ha explotado una mina. Falso en caso contrario.
	 */
	public boolean abrirCasilla(int i, int j){

	}
	
	
	
	/**
	 * Método que checkea si se ha terminado el juego porque se han abierto todas las casillas.
	 * @return Devuelve verdadero si se han abierto todas las celdas que no son minas.
	 **/
	public boolean esFinJuego(){
	}
	
	
	/**
	 * Método que pinta por pantalla toda la información del tablero, se utiliza para depurar
	 */
	public void depurarTablero(){
		System.out.println("---------TABLERO--------------");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("\nPuntuación: "+puntuacion);
	}

	/**
	 * Método que se utiliza para obtener las minas que hay alrededor de una celda
	 * @pre : El tablero tiene que estar ya inicializado, por lo tanto no hace falta calcularlo, símplemente consultarlo
	 * @param i : posición vertical de la celda.
	 * @param j : posición horizontal de la cela.
	 * @return Un entero que representa el número de minas alrededor de la celda
	 */
	public int getMinasAlrededor(int i, int j) {
	}

	/**
	 * Método que devuelve la puntuación actual
	 * @return Un entero con la puntuación actual
	 */
	public int getPuntuacion() {
	}
	
}
