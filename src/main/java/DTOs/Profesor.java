package DTOs;

public class Profesor {

    public String nombreProfe;
    public String especialidad;

    public Profesor(String nombreProfe, String especialidad) {
        this.nombreProfe = nombreProfe;
        this.especialidad = especialidad;
    }

    public Profesor() {
    }

    public String getNombreProfe() {
        return nombreProfe;
    }

    public void setNombreProfe(String nombreProfe) {
        this.nombreProfe = nombreProfe;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
