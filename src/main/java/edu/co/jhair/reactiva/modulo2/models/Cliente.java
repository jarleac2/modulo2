package edu.co.jhair.reactiva.modulo2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Integer id;
    private Integer idTipoDocumento;
    private String numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private Boolean activo;

    @Override
    public String toString() {
        return "{" +
                "'id':" + id +
                ", 'idTipoDocumento':'" + idTipoDocumento + '\'' +
                ", 'numeroIdentificacion':" + numeroIdentificacion +
                ", 'nombre':" + nombre +
                ", 'apellido':" + apellido +
                ", 'telefono':" + telefono +
                ", 'correo':" + correo +
                ", 'activo':" + activo +
                '}';
    }
}
