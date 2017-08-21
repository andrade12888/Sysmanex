package modelo;

public class AG {
	private NodoAG raiz;
	
	public NodoAG getRaiz() {
		return raiz;
	}

	public AG(NodoAG raiz) {
		this.raiz = raiz;
	}

	public int cantHojas()
	{
		return cantHojasRec(raiz);
	}

	private int cantHojasRec(NodoAG nodo) {
		if(nodo == null)
			return 0;
		else
		{
			if(nodo.getPH()==null)
				return 1 + cantHojasRec(nodo.getSH());
			else
				return cantHojasRec(nodo.getPH()) + cantHojasRec(nodo.getSH());
		}
	}	
	
	public int cantNodos(){
		return cantNodosRec(raiz);
	}

	private int cantNodosRec(NodoAG nodo) {
		if(nodo == null)
			return 0;
		else
			return 1 + cantNodosRec(nodo.getPH()) + cantNodosRec(nodo.getSH());
	}
	
	public int altura(){
		return alturaRec(raiz);
	}

	private int alturaRec(NodoAG nodo) {
		if(nodo == null)
			return -1; // o 0!
		else
			return Math.max(alturaRec(nodo.getSH()), 1 + alturaRec(nodo.getPH()));
	}
	
	public NodoAG buscar(int id)
	{
		return buscarRec(id,raiz);
	}

	private NodoAG buscarRec(int id, NodoAG nodo) {
		if(nodo==null)
			return null;
		else{
			if(nodo.getId()==id)
				return nodo;
			else{
				NodoAG resPH = buscarRec(id,nodo.getPH());
				if(resPH != null)
					return resPH;
				else
					return buscarRec(id,nodo.getSH());
			}
		}
	}
	
	public void insertarVago(int padre, int id, String dato)
	{
		NodoAG nodoPadre = buscar(padre);
		nodoPadre.setPH(new NodoAG(id,dato,null,nodoPadre.getPH()));
	}
	
	public void insertar(int padre, int id,String dato)
	{
		insertarRec(padre, id,dato, raiz);
	}

	private boolean insertarRec(int padre,  int id, String dato, NodoAG nodo) {
		if(nodo==null)
			return false;
		else{
			if(nodo.getId()==padre){
				nodo.setPH(new NodoAG(id,dato,null, nodo.getPH()));
				return true;
			}else{
				boolean inserte = insertarRec(padre,id,dato,nodo.getPH());
				if(!inserte)
					inserte = insertarRec(padre,id,dato,nodo.getSH());
				return inserte;
			}
		}
	}
}
