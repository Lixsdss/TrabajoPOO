package servicio;

import Dominio.Curso;
import java.util.ArrayList;

public class ServicioCurso {
    private Curso[] curso;
    public static int ind=0;
    public ServicioCurso(){
        curso = new Curso[10];
    }
    
    public boolean agregarCurso(Curso curs){
        for(int i=0;i < curso.length;i++){
            if(curso[i] != null){
                curso[i]=curs;
                ind++;
                return true;
            }
        }
        return false;
    }
    public boolean eliminarCurso(int id){
          for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null && curso[i].getId()== id) {
                curso[i] = null;
                ind--;
                return true;
            }
        }    
        return false;
    }
     public Curso buscarAlumno(int id){
         for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null && curso[i].getId() == id) {
                return curso[i];
            }
        }
        return null;
    }
    public boolean ModificarEstudiante(Curso est, int id){
            for (int i = 0; i < curso.length; i++) {
                if (curso[i] != null && curso[i].getId() == id) {
                    curso[i] = est;
                    return true;
                }
            }
        return false;
    }
     
}
