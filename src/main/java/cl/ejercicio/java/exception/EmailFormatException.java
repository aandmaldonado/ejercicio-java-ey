package cl.ejercicio.java.exception;

public class EmailFormatException extends Exception {

	private static final long serialVersionUID = 7382770577561284219L;
	private String mensaje;

    public EmailFormatException(String msg) {
        super(msg);
        this.setMensaje(msg);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}