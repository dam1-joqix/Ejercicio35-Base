import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{
	private int i;
	private int j;
	private ControlJuego juego;
	private VentanaPrincipal ventana;
	private int pulsadas;
	public static int PULSACIONES_MAX=(ControlJuego.LADO_TABLERO*ControlJuego.LADO_TABLERO)-ControlJuego.MINAS_INICIALES;
	
	

	public ActionBoton(int i, int j, ControlJuego juego,VentanaPrincipal ventana) {
		this.i=i;
		this.j=j;
		this.juego=juego;
		this.ventana=ventana;
		this.pulsadas=0;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(juego.abrirCasilla(i, j)) {
			//se abre
			ventana.mostrarNumMinasAlrededor(i, j);
			ventana.actualizarPuntuacion();
			ventana.refrescarPantalla();
			if(pulsadas==PULSACIONES_MAX) {
				ventana.mostrarFinJuego(false);
			}
			
		}else {
			ventana.mostrarFinJuego(true);
		}
	}

}
