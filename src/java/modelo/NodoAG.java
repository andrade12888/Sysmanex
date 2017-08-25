package modelo;

public class NodoAG {
	private int id;
        private String dato;
	private NodoAG hijo;
	private NodoAG hermano;

	public NodoAG(int id, String dato,NodoAG hijo, NodoAG hermano) {
		this.id = id;
                this.dato = dato;
		this.hijo = hijo;
		this.hermano = hermano;
	}
	
	public NodoAG(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

	public void setId(int id) {
		this.id = id;
	}

	public NodoAG getHijo() {
		return hijo;
	}

	public void setHijo(NodoAG hijo) {
		this.hijo = hijo;
	}

	public NodoAG getHermano() {
		return hermano;
	}

	public void setHermano(NodoAG hermano) {
		this.hermano = hermano;
	}

	@Override
	public String toString() {
		return "NodoAG [id=" + id + ", hijo=" + hijo + ", hermano=" + hermano + "]";
	}

}
