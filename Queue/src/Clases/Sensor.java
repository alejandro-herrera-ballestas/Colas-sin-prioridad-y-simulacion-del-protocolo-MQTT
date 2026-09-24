/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public enum Sensor {
    S01("Temperatura", "iot/sensor01/temperatura"),
    S02("Humedad", "iot/sensor02/humedad"),
    S03("Nivel de agua", "iot/sensor03/nivel");
    
    private final String tipoMedicion;
    private final String topic;

    private Sensor(String tipoMedicion, String topic) {
        this.tipoMedicion = tipoMedicion;
        this.topic = topic;
    }

    public String getTipoMedicion() {return tipoMedicion;}
    public String getTopic() {return topic;}
    
}
