package modelo;

public class NodoAG {
	private int id;
        private String dato;
	private NodoAG pH;
	private NodoAG sH;

	public NodoAG(int id, String dato,NodoAG pH, NodoAG sH) {
		this.id = id;
                this.dato = dato;
		this.pH = pH;
		this.sH = sH;
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

	public NodoAG getPH() {
		return pH;
	}

	public void setPH(NodoAG pH) {
		this.pH = pH;
	}

	public NodoAG getSH() {
		return sH;
	}

	public void setsH(NodoAG sH) {
		this.sH = sH;
	}

	@Override
	public String toString() {
		return "NodoAG [id=" + id + ", pH=" + pH + ", sH=" + sH + "]";
	}

}
