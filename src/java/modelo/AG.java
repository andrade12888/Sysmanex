package modelo;

public class AG {

    private NodoAG raiz;

    public NodoAG getRaiz() {
        return raiz;
    }

    public AG(NodoAG raiz) {
        this.raiz = raiz;
    }

    public int cantHojas() {
        return cantHojasRec(raiz);
    }

    private int cantHojasRec(NodoAG nodo) {
        if (nodo == null) {
            return 0;
        } else {
            if (nodo.getHijo() == null) {
                return 1 + cantHojasRec(nodo.getHermano());
            } else {
                return cantHojasRec(nodo.getHijo()) + cantHojasRec(nodo.getHermano());
            }
        }
    }

    public int cantNodos() {
        return cantNodosRec(raiz);
    }

    private int cantNodosRec(NodoAG nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return 1 + cantNodosRec(nodo.getHijo()) + cantNodosRec(nodo.getHermano());
        }
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoAG nodo) {
        if (nodo == null) {
            return -1; // o 0!
        } else {
            return Math.max(alturaRec(nodo.getHermano()), 1 + alturaRec(nodo.getHijo()));
        }
    }

    public NodoAG buscar(int id) {
        return buscarRec(id, raiz);
    }

    private NodoAG buscarRec(int id, NodoAG nodo) {
        if (nodo == null) {
            return null;
        } else {
            if (nodo.getId() == id) {
                return nodo;
            } else {
                NodoAG resPH = buscarRec(id, nodo.getHijo());
                if (resPH != null) {
                    return resPH;
                } else {
                    return buscarRec(id, nodo.getHermano());
                }
            }
        }
    }

    public void insertarVago(int padre, int id, String dato) {
        NodoAG nodoPadre = buscar(padre);
        nodoPadre.setHijo(new NodoAG(id, dato, null, nodoPadre.getHijo()));
    }

    public void insertar(int padre, int id, String dato) {
        insertarRec(padre, id, dato, raiz);
    }

    private boolean insertarRec(int padre, int id, String dato, NodoAG nodo) {
        if (nodo == null) {
            return false;
        } else {
            if (nodo.getId() == padre) {
                nodo.setHijo(new NodoAG(id, dato, null, nodo.getHijo()));
                return true;
            } else {
                boolean inserte = insertarRec(padre, id, dato, nodo.getHijo());
                if (!inserte) {
                    inserte = insertarRec(padre, id, dato, nodo.getHermano());
                }
                return inserte;
            }
        }
    }

    public String mostrar() {
        String lista = "";
        if (raiz == null) {
            lista = "<ul><li>Huvo un error</li></ul>";
        } else {
            lista = mostrarRec(raiz);
        }
        return lista;
    }

    private String entidadDescripcionTipo(int id) {
        String proviene = "";
        Persona unaPersona = new Persona();
        unaPersona.BuscarPersonaPorId(id);
        if (unaPersona.getCiPersona() != null) {
            proviene = unaPersona.getNombrePersona() + " " + unaPersona.getApellidoPersona();
        } else {
            UnidadArmada unaUnidad = new UnidadArmada();
            unaUnidad.BuscarUnidadEntidadId(id);
            proviene = unaUnidad.getSigla();
        }
        return proviene;
    }
    
    

    private String mostrarRec(NodoAG nodo) {
        if (nodo == null) {
            return "";
        } else {
            if (nodo.getHijo() != null && nodo.getHermano() != null) {
                String entidad = entidadDescripcionTipo(nodo.getId());
                return "<li>" + entidad + " - " + nodo.getId() + "<ul>" + mostrarRec(nodo.getHijo()) + "</ul>" + mostrarRec(nodo.getHermano()) + "</li>";
            } else {
                if (nodo.getHijo() != null) {
                    String entidad = entidadDescripcionTipo(nodo.getId());
                    return "<ul><li>" + entidad + " - " + nodo.getId() + "<ul>" + mostrarRec(nodo.getHijo()) + "</ul>";
                } else {
                    String entidad = entidadDescripcionTipo(nodo.getId());
                    return "<li>" + entidad + " - " + nodo.getId() + "</li>" + mostrarRec(nodo.getHermano());
                }

            }
        }

    }
}
//private String mostrarRec(NodoAG nodo) {
//        if (nodo == null) {
//            return "";
//        } else {
//            if (nodo.getHijo() != null && nodo.getHermano() != null) {
//                String entidad = entidadDescripcionTipo(nodo.getId());
//                return "<li>" + entidad + " - " + nodo.getDato() + "<ul>" + mostrarRec(nodo.getHijo()) + "</ul></li>" + mostrarRec(nodo.getHermano()) + "</ul>";
//            } else {
//                if (nodo.getHijo() != null) {
//                    String entidad = entidadDescripcionTipo(nodo.getId());
//                    return "<ul><li>" + entidad + " - " + nodo.getDato() + "<ul>" + mostrarRec(nodo.getHijo()) + "</li></ul>";
//                } else {
//                    String entidad = entidadDescripcionTipo(nodo.getId());
//                    return "<li>" + entidad + " - " + nodo.getDato() + "</li>" + mostrarRec(nodo.getHermano());
//                }
//
//            }
//        }
//
//    }