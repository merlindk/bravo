package negocio;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:46 PM
 */
public class Estado {

	private String ambito;
	private String descripcion;
	private String nombre;

	public Estado(){

	}

	public void finalize() throws Throwable {

	}
	public void esAmbitoGuardia(){

	}

	public void esAmbitoProgramacion(){

	}

	public void esAmbitoProgramacionGuardia(){

	}

	public void esEnCurso(){

	}

	public void esPendienteDeConfirmacion(){

	}

	public void esProgramada(){

	}

	public String getNombre(){
		return nombre;
	}
}//end Estado